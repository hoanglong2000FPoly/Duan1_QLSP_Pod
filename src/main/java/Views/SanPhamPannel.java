/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.TheLoaiSanPham;
import DomainModels.SanPham;
import Service.LichSuThaoTacService;
import Service.SanPhamService;
import Repositories.TheLoaiSanPhamDAO;
import Ultilities.ChiTiet;
import Ultilities.GiaTriMoi;
import Ultilities.HibernateUltis;
import Ultilities.Ulti;
import ViewModels.LichSuThaoTacView;
import ViewModels.SanPhamView;
import ViewModels.TheLoaiSanPhamView;
import com.google.gson.Gson;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author Dell
 */
public class SanPhamPannel extends javax.swing.JPanel {

    DefaultComboBoxModel model = new DefaultComboBoxModel();
    DefaultComboBoxModel model2 = new DefaultComboBoxModel();
    TheLoaiSanPhamDAO tlDao = new TheLoaiSanPhamDAO();
    DefaultTableModel tablemodel = new DefaultTableModel();
    SanPhamService spform = new SanPhamService();
    LichSuThaoTacService lsform = new LichSuThaoTacService();
    Ultilities.Ulti ulti = new Ulti();
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    Gson gson = new Gson();
    private String user;

    public SanPhamPannel(String user) {
        initComponents();
        setComboBox();
        setColumn();
        loadTable(listSanPham());

        this.user = user;

    }

    SanPhamView guiData() {
        TheLoaiSanPham sp = new TheLoaiSanPham(String.valueOf(cbxTheLoai.getSelectedItem()), tlDao.tenTheLoai(String.valueOf(cbxTheLoai.getSelectedItem())), 0);

        return new SanPhamView(txtMaSanPham.getText(),
                txtTenSanPham.getText(), Integer.parseInt(txtSoLuong.getText()), jdate.getDate(), txtHangSanXuat.getText(),
                Float.parseFloat(txtGiaNhap.getText()), Float.parseFloat(txtGiaBan.getText()), Float.parseFloat(txtDungTich.getText()), txtCongSuat.getText(), txtPin.getText(),
                txtMota.getText(), sp, 0);
    }

    SanPhamView guiDataVohieuHoa() {
        TheLoaiSanPham sp = new TheLoaiSanPham(String.valueOf(cbxTheLoai.getSelectedItem()), tlDao.tenTheLoai(String.valueOf(cbxTheLoai.getSelectedItem())), 0);

        return new SanPhamView(txtMaSanPham.getText(),
                txtTenSanPham.getText(), Integer.parseInt(txtSoLuong.getText()), jdate.getDate(), txtHangSanXuat.getText(),
                Float.parseFloat(txtGiaNhap.getText()), Float.parseFloat(txtGiaBan.getText()), Float.parseFloat(txtDungTich.getText()), txtCongSuat.getText(), txtPin.getText(),
                txtMota.getText(), sp, 1);
    }

    public List<SanPham> listSanPham() {
        return spform.listSanPham();
    }

    public void setComboBox() {
        List<TheLoaiSanPham> list = tlDao.listTheLoai();
        for (TheLoaiSanPham x : list) {
            model.addElement(x.getMaTheLoai());
        }
        cbxTheLoai.setModel(model);
    }

    public void lichSuThem() {
        LichSuThaoTacView ls = new LichSuThaoTacView();
        String chitiet = gson.toJson(guiData());
        ls.setMaNhanVien(user);
        ls.setChiTiet(chitiet);
        ls.setGiaTriMoi(chitiet);
        ls.setThaoTac("Thêm");
        ls.setThoiGianThaoTac(timestamp);
        ls.setViTriThaoTac("Sản phẩm");
        ls.setGiaTriCu("{}");
        ls.setSTT(0);
        lsform.insertLichSu(ls);

    }

    public void lichSuVoHieuHoa() {
        List<ChiTiet> list = new ArrayList<>();
        ChiTiet ct = new ChiTiet(txtTenSanPham.getText(), txtMaSanPham.getText());
        LichSuThaoTacView ls = new LichSuThaoTacView();
        String chitiet = gson.toJson(ct);
        ls.setMaNhanVien(user);
        ls.setChiTiet(chitiet);
        ls.setGiaTriMoi(chitiet);
        ls.setThaoTac("Vô hiệu hóa");
        ls.setThoiGianThaoTac(timestamp);
        ls.setViTriThaoTac("Sản phẩm");
        ls.setGiaTriCu(chitiet);
        ls.setSTT(0);
        lsform.insertLichSu(ls);

    }

    public void lichUp2() {
        LichSuThaoTacView ls = new LichSuThaoTacView();
        String chitiet = gson.toJson(guiData());
        TheLoaiSanPham sp = new TheLoaiSanPham(String.valueOf(cbxTheLoai.getSelectedItem()), tlDao.tenTheLoai(String.valueOf(cbxTheLoai.getSelectedItem())), 0);
        SanPhamView spview = new SanPhamView(txtMaSanPham.getText(), spform.tenSanPham(txtMaSanPham.getText()),
                spform.soLuongSanPham(txtMaSanPham.getText()), timestamp, spform.hangSanxuat(txtMaSanPham.getText()),
                spform.giaNhapSanPham(txtMaSanPham.getText()), spform.giaBanSanPham(txtMaSanPham.getText()),
                spform.dungTich(txtMaSanPham.getText()), spform.congSuat(txtMaSanPham.getText()), spform.Pin(txtMaSanPham.getText()),
                spform.moTa(txtMaSanPham.getText()), sp, 0);
        String giatricu = gson.toJson(spview);
        ls.setGiaTriCu(giatricu);
        ls.setMaNhanVien(user);
        ls.setChiTiet(chitiet);
        ls.setGiaTriMoi(chitiet);
        ls.setThaoTac("Sửa");
        ls.setThoiGianThaoTac(timestamp);
        ls.setViTriThaoTac("Sản phẩm");
        ls.setSTT(0);
        lsform.insertLichSu(ls);
    }

    public void setColumn() {
        String[] a = new String[]{"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Năm sản xuất", "Hãng sản xuất", "Giá nhập", "Giá bán", "Dung tích", "Công suất", "Pin", "Mô tả", "Mã thể loại"};
        tablemodel.setColumnIdentifiers(a);
        tblSanPham.setModel(tablemodel);
    }

    public void loadTable(List<SanPham> lst) {
        while (tablemodel.getRowCount() > 0) {
            tablemodel.removeRow(0);
        }
        for (SanPham x : lst) {
            tablemodel.addRow(new Object[]{x.getMaSanPham(), x.getTenSanPham(), x.getSoLuong(), x.getNamSanXuat(), x.getHangSanXuat(), x.getGiaNhap(), x.getGiaBan(), x.getDungTich(), x.getCongSuat(), x.getPin(), x.getMoTa(), x.getMaTheLoai().getMaTheLoai()});
        }
        tablemodel.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jdate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtHangSanXuat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDungTich = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCongSuat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPin = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMota = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnVoHieuHoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbxTheLoai = new javax.swing.JComboBox<>();
        btnThemTheLoai = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setText("Mã sản phẩm :");

        txtMaSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMaSanPhamMousePressed(evt);
            }
        });

        jLabel2.setText("Tên sản phẩm :");

        jLabel4.setText("Số lượng :");

        jLabel5.setText("Năm SX :");

        jLabel6.setText("Hãng SX :");

        txtHangSanXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtHangSanXuatMousePressed(evt);
            }
        });
        txtHangSanXuat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHangSanXuatKeyTyped(evt);
            }
        });

        jLabel3.setText("Giá bán :");

        jLabel8.setText("Dung tích :");

        jLabel9.setText("Công suất :");

        jLabel10.setText("Pin :");

        jLabel12.setText("Giá nhập :");

        jLabel11.setText("Mô tả :");

        txtMota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMotaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(51, 204, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(51, 204, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnVoHieuHoa.setBackground(new java.awt.Color(51, 255, 255));
        btnVoHieuHoa.setText("Vô hiệu hóa");
        btnVoHieuHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoHieuHoaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(51, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã thể loại :");

        cbxTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxTheLoaiMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbxTheLoaiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxTheLoaiMousePressed(evt);
            }
        });
        cbxTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTheLoaiActionPerformed(evt);
            }
        });

        btnThemTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemTheLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/add-icon.png"))); // NOI18N
        btnThemTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTheLoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(37, 37, 37)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtHangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(cbxTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnThemTheLoai)))))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(134, 134, 134)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel12)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addComponent(btnVoHieuHoa))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDungTich, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCongSuat, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(128, 128, 128)
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(207, 207, 207))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnThem))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnVoHieuHoa)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtDungTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSua)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtCongSuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addComponent(btnLamMoi)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemTheLoai)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel7)
                                .addComponent(cbxTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addGap(41, 41, 41)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (Float.parseFloat(txtGiaBan.getText()) <= 0 || Float.parseFloat(txtGiaNhap.getText()) <= 0 || Float.parseFloat(txtDungTich.getText()) <= 0
                || Integer.parseInt(txtSoLuong.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số");
            return;
        }

        try {
            JOptionPane.showMessageDialog(this, spform.themSanPham(guiData()));
            loadTable(listSanPham());
            lichSuThem();
        } catch (NumberFormatException ex) {
            Logger.getLogger(SanPhamPannel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Lỗi nhập");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (Float.parseFloat(txtGiaBan.getText()) <= 0 || Float.parseFloat(txtGiaNhap.getText()) <= 0 || Float.parseFloat(txtDungTich.getText()) <= 0
                || Integer.parseInt(txtSoLuong.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số");
            return;
        }
        try {
            lichUp2();
            JOptionPane.showMessageDialog(this, spform.suaSanPham(guiData()));
            loadTable(listSanPham());
        } catch (NumberFormatException ex) {
            Logger.getLogger(SanPhamPannel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Lỗi nhập");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnVoHieuHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoHieuHoaActionPerformed
        JOptionPane.showMessageDialog(this, spform.voHieuHoaSanPham(guiDataVohieuHoa()));
        loadTable(listSanPham());
        lichSuVoHieuHoa();
    }//GEN-LAST:event_btnVoHieuHoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtCongSuat.setText("");
        txtMaSanPham.setText("");
        txtTenSanPham.setText("");
        txtCongSuat.setText("");
        txtDungTich.setText("");
        txtGiaBan.setText("");
        txtGiaNhap.setText("");
        txtHangSanXuat.setText("");
        txtMota.setText("");
        txtPin.setText("");
        txtSoLuong.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtMotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMotaActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        loadTable(listSanPham());

    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if (txtTimKiem.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng tìm sản phẩm theo mã hoặc tên sản phẩm");
            return;
        }
        timKiem();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int a = tblSanPham.getSelectedRow();
        SanPham sp = listSanPham().get(a);
        txtMaSanPham.setText(sp.getMaSanPham());
        txtTenSanPham.setText(sp.getTenSanPham());
        txtCongSuat.setText(sp.getCongSuat());
        txtDungTich.setText(String.valueOf(sp.getDungTich()));
        txtGiaBan.setText(String.valueOf(sp.getGiaBan()));
        txtGiaNhap.setText(String.valueOf(sp.getGiaNhap()));
        txtHangSanXuat.setText(sp.getHangSanXuat());
        txtMota.setText(sp.getMoTa());
        txtPin.setText(sp.getPin());
        txtSoLuong.setText(String.valueOf(sp.getSoLuong()));
        jdate.setDate(sp.getNamSanXuat());
        cbxTheLoai.setSelectedItem(sp.getMaTheLoai().getMaTheLoai());
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnThemTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTheLoaiActionPerformed
        new ThemNhanhTheLoai(user).setVisible(true);


    }//GEN-LAST:event_btnThemTheLoaiActionPerformed

    private void cbxTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTheLoaiMouseClicked

    }//GEN-LAST:event_cbxTheLoaiMouseClicked

    private void txtHangSanXuatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHangSanXuatKeyTyped

    }//GEN-LAST:event_txtHangSanXuatKeyTyped

    private void cbxTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTheLoaiActionPerformed

    }//GEN-LAST:event_cbxTheLoaiActionPerformed

    private void cbxTheLoaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTheLoaiMousePressed

    }//GEN-LAST:event_cbxTheLoaiMousePressed

    private void txtHangSanXuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHangSanXuatMousePressed
 
    }//GEN-LAST:event_txtHangSanXuatMousePressed

    private void txtMaSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaSanPhamMousePressed
     
    }//GEN-LAST:event_txtMaSanPhamMousePressed

    private void cbxTheLoaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxTheLoaiMouseExited
        model.removeAllElements();
        setComboBox();
    }//GEN-LAST:event_cbxTheLoaiMouseExited

    public void timKiem() {
        while (tablemodel.getRowCount() > 0) {
            tablemodel.removeRow(0);
        }
        for (SanPham x : listSanPham()) {
            if (x.getMaSanPham().equals(txtTimKiem.getText()) || x.getTenSanPham().equals(txtTimKiem.getText())) {
                tablemodel.addRow(new Object[]{x.getMaSanPham(), x.getTenSanPham(), x.getSoLuong(), x.getNamSanXuat(), x.getHangSanXuat(), x.getGiaNhap(), x.getGiaBan(), x.getDungTich(), x.getCongSuat(), x.getPin(), x.getMoTa(), x.getMaTheLoai().getMaTheLoai()});
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemTheLoai;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnVoHieuHoa;
    private javax.swing.JComboBox<String> cbxTheLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdate;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtCongSuat;
    private javax.swing.JTextField txtDungTich;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHangSanXuat;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMota;
    private javax.swing.JTextField txtPin;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
