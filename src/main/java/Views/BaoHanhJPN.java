/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.BaoHanh;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import DomainModels.SanPham;
import Service.BaoHanhService;
import Service.KhachHangService;
import Service.NhanVienService;
import Service.SanPhamService;
import javax.swing.table.DefaultTableModel;
import ViewModels.BaoHanhView;
import java.util.Date;
import DomainModels.TheLoaiSanPham;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author T460
 */
public class BaoHanhJPN extends javax.swing.JPanel {

    NhanVienService nhanVienService;
     BaoHanhService baoHanhService;
     KhachHangService khachHangService;
     SanPhamService sanPhamService;
    DefaultTableModel _deDefaultTableModel;
    public BaoHanhJPN(String user) {
        
        initComponents();
        
        nhanVienService = new NhanVienService();
        baoHanhService = new BaoHanhService();
        khachHangService = new KhachHangService();
        sanPhamService = new SanPhamService();
        _deDefaultTableModel = new DefaultTableModel();
        cbcTensp(sanPhamService.listSanPham());
        cbcTennv(nhanVienService.listNhanVien());
        cbcTenKH(khachHangService.getList());
        loadTable(baoHanhService.getList());
        loadTableVoHieuHoa(baoHanhService.getList());

    }
    
     BaoHanhView guiData(){
        Date date1 = null;
        TheLoaiSanPham theLoai = new TheLoaiSanPham();
     
        SanPham sanpham = new SanPham(String.valueOf(cbc_tensanpham.getSelectedItem()), "",1, date1, "", 1, 1, 1, "", "","", theLoai, 0);
         KhachHang kh = new KhachHang(Integer.parseInt(String.valueOf(cbc_tenkhachhang.getSelectedItem())), "", 1, "", "");
      //   NhanVien nv = new NhanVien(String.valueOf(cbc_tennhanvien.getSelectedItem()), "", "", date1, 1, "", "", "", 1);
        NhanVien nv = new NhanVien(String.valueOf(cbc_tennhanvien.getSelectedItem()), "", "", date1, 1, "", "", "", 0,0);
         return new BaoHanhView(txt_mabaohanh.getText(), date.getDate(), txt_mota.getText(), sanpham, kh, nv,0);
    }  
      BaoHanhView guiDataVoHieuHoa(){
        Date date1 = null;
        TheLoaiSanPham theLoai = new TheLoaiSanPham();
     
        SanPham sanpham = new SanPham(String.valueOf(cbc_tensanpham.getSelectedItem()), "",1, date1, "", 1, 1, 1, "", "","", theLoai, 0);
         KhachHang kh = new KhachHang(Integer.parseInt(String.valueOf(cbc_tenkhachhang.getSelectedItem())), "", 1, "", "");
      //   NhanVien nv = new NhanVien(String.valueOf(cbc_tennhanvien.getSelectedItem()), "", "", date1, 1, "", "", "", 1);
        NhanVien nv = new NhanVien(String.valueOf(cbc_tennhanvien.getSelectedItem()), "", "", date1, 1, "", "", "", 0,0);
         return new BaoHanhView(txt_mabaohanh.getText(), date.getDate(), txt_mota.getText(), sanpham, kh, nv,1);
    }  
   
    
    public void loadTable(List<BaoHanh> _list){
        _deDefaultTableModel = (DefaultTableModel) tbl_baohanh.getModel();
        _deDefaultTableModel.setRowCount(0);
        for (BaoHanh x : _list) {  
         //   _deDefaultTableModel.addRow(new Object[]{x.getMaBaoHanh(),x.getNgayMua(),x.getMoTa(),nameSp(x.getMaSanPham().getMaSanPham()),nameKH(x.getMaKhachHang().getMaKhachHang()),nameNV(x.getMaNhanVien().getMaNhanVien())});
        _deDefaultTableModel.addRow(new Object[]{x.getMaBaoHanh(),x.getNgayMua(),x.getMoTa(),x.getMaSanPham().getMaSanPham(),x.getMaKhachHang().getMaKhachHang(),x.getMaNhanVien().getMaNhanVien()});
        }
    }
      public void loadTableVoHieuHoa(List<BaoHanh> _list){
        _deDefaultTableModel = (DefaultTableModel) tbl_vohieuhoa.getModel();
        _deDefaultTableModel.setRowCount(0);
        for (BaoHanh x : _list) {  
         //   _deDefaultTableModel.addRow(new Object[]{x.getMaBaoHanh(),x.getNgayMua(),x.getMoTa(),nameSp(x.getMaSanPham().getMaSanPham()),nameKH(x.getMaKhachHang().getMaKhachHang()),nameNV(x.getMaNhanVien().getMaNhanVien())});
        _deDefaultTableModel.addRow(new Object[]{x.getMaBaoHanh(),x.getNgayMua(),x.getMoTa(),x.getMaSanPham().getMaSanPham(),x.getMaKhachHang().getMaKhachHang(),x.getMaNhanVien().getMaNhanVien()});
        }
    }
    void cbcTensp(List<SanPham> sp){
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        for (SanPham x : sp) {
        //   boxModel.addElement(nameSp(x.getMaSanPham()));
        boxModel.addElement(x.getMaSanPham());
        }
        cbc_tensanpham.setModel(boxModel);
    }
    
    void cbcTennv(List<NhanVien> nv){
        DefaultComboBoxModel boxModel1 = new DefaultComboBoxModel();
        for (NhanVien x : nv) {
         //  boxModel1.addElement(nameNV(x.getMaNhanVien()));
         boxModel1.addElement(x.getMaNhanVien());
        }
        cbc_tennhanvien.setModel(boxModel1);
    }
    void cbcTenKH(List<KhachHang> kh){
        DefaultComboBoxModel boxModel2 = new DefaultComboBoxModel();
        for (KhachHang x : kh) {
           boxModel2.addElement(x.getMaKhachHang());
        }
        cbc_tenkhachhang.setModel(boxModel2);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_mabaohanh = new javax.swing.JTextField();
        date = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_mota = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbc_tensanpham = new javax.swing.JComboBox<>();
        cbc_tennhanvien = new javax.swing.JComboBox<>();
        cbc_tenkhachhang = new javax.swing.JComboBox<>();
        brn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_timkiem = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        btn_clear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tab2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_baohanh = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_vohieuhoa = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Bảo Hành");

        jLabel2.setText("Mã Bảo hành");

        jLabel4.setText("Ngày Mua");

        jLabel5.setText("Mô tả");

        txt_mota.setColumns(20);
        txt_mota.setRows(5);
        jScrollPane1.setViewportView(txt_mota);

        jLabel6.setText("Mã Sản Phẩm");

        jLabel7.setText("Mã Nhân Viên");

        jLabel8.setText("Mã Khách Hàng");

        cbc_tensanpham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbc_tennhanvien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbc_tenkhachhang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        brn_them.setText("Thêm");
        brn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jButton3.setText("Vô Hiệu Hóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btn_timkiem.setText("Tìm Kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tbl_baohanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Bảo Hành", "Ngày Mua", "Mô Tả", "Mã sản phẩm", "Mã Khách Hàng", "Mã Nhân Viên"
            }
        ));
        tbl_baohanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_baohanhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_baohanh);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane2)
                .addGap(219, 219, 219))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab2.addTab("Danh sách bảo hành", jPanel2);

        tbl_vohieuhoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Bảo Hành", "Ngày Mua", "Mô Tả", "Mã sản phẩm", "Mã Khách Hàng", "Mã Nhân Viên"
            }
        ));
        tbl_vohieuhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_vohieuhoaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_vohieuhoa);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab2.addTab("Danh sách hết hạn", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5)
                                            .addComponent(brn_them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(56, 56, 56)
                                                .addComponent(jButton3)
                                                .addGap(47, 47, 47)
                                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_mabaohanh, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(36, 36, 36)
                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbc_tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cbc_tennhanvien, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbc_tensanpham, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_mabaohanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbc_tensanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel7))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbc_tennhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbc_tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brn_them)
                    .addComponent(btn_sua)
                    .addComponent(jButton3)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear)
                    .addComponent(btn_timkiem))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(328, 328, 328))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        JOptionPane.showConfirmDialog(this, baoHanhService.edit(guiData()));
        loadTable(baoHanhService.getList());
    }//GEN-LAST:event_btn_suaActionPerformed

    private void tbl_baohanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_baohanhMouseClicked
       int index = tbl_baohanh.getSelectedRow();
       BaoHanh bh = (BaoHanh) baoHanhService.getList().get(index);
       txt_mabaohanh.setText(bh.getMaBaoHanh());
       txt_mota.setText(bh.getMoTa());
       cbc_tennhanvien.setSelectedItem(bh.getMaNhanVien());
       cbc_tenkhachhang.setSelectedItem(bh.getMaKhachHang());
       cbc_tensanpham.setSelectedItem(bh.getMaSanPham());
       date.setDate(bh.getNgayMua());
    }//GEN-LAST:event_tbl_baohanhMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
         txt_mabaohanh.setText("");
       txt_mota.setText("");
       cbc_tennhanvien.setSelectedIndex(0);
       cbc_tenkhachhang.setSelectedIndex(0);
       cbc_tensanpham.setSelectedIndex(0);
       date.setDate(null);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        if (txt_timkiem.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống ");
            return;
        }
        loadTable(baoHanhService.timkiem(txt_timkiem.getText()));
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void brn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brn_themActionPerformed
        if (txt_mabaohanh.getText().isBlank() || txt_mota.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Yêu cầu nhập đầy đủ thông tin ");
            return;
        }
        JOptionPane.showConfirmDialog(this, baoHanhService.add(guiData()));
        loadTable(baoHanhService.getList());
    }//GEN-LAST:event_brn_themActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         JOptionPane.showMessageDialog(this, baoHanhService.voHieuHoa(guiDataVoHieuHoa()));
        loadTable(baoHanhService.getList());
        loadTableVoHieuHoa(baoHanhService.getListVoHieuHoa());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_vohieuhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_vohieuhoaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_vohieuhoaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brn_them;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JComboBox<String> cbc_tenkhachhang;
    private javax.swing.JComboBox<String> cbc_tennhanvien;
    private javax.swing.JComboBox<String> cbc_tensanpham;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane tab2;
    private javax.swing.JTable tbl_baohanh;
    private javax.swing.JTable tbl_vohieuhoa;
    private javax.swing.JTextField txt_mabaohanh;
    private javax.swing.JTextArea txt_mota;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
