/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.TheLoaiSanPham;
import Service.LichSuThaoTacService;
import Service.TheLoaiSanPhamService;
import Ultilities.ChiTiet;
import ViewModels.LichSuThaoTacView;
import ViewModels.TheLoaiSanPhamView;
import com.google.gson.Gson;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class TheLoaiSanPhamUserPannel extends javax.swing.JPanel {

    DefaultTableModel tablemodel = new DefaultTableModel();
    TheLoaiSanPhamService tl = new TheLoaiSanPhamService();
    Gson gson = new Gson();
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    LichSuThaoTacService lsform = new LichSuThaoTacService();
    private String user;

    public TheLoaiSanPhamUserPannel(String user) {
        initComponents();
        setColumn();
        loadTable(listTheLoai());
        this.user = user;
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnVoHieuHoa.setEnabled(false);
    }

    void setColumn() {
        String[] a = new String[]{"Mã thể loại", "Tên thể loại"};
        tablemodel.setColumnIdentifiers(a);
        tblTheLoai.setModel(tablemodel);
    }

    TheLoaiSanPhamView guiData() {
        return new TheLoaiSanPhamView(txtMaTheLoai.getText(), txtTenTheLoai.getText(), 0);
    }

    public List<TheLoaiSanPham> listTheLoai() {
        return tl.listTheLoai();
    }

    void loadTable(List<TheLoaiSanPham> list) {
        while (tablemodel.getRowCount() > 0) {
            tablemodel.removeRow(0);
        }
        for (TheLoaiSanPham x : list) {
            tablemodel.addRow(new Object[]{x.getMaTheLoai(), x.getTenTheLoai()});
        }
    }

    public void lichSuThem() {
        LichSuThaoTacView ls = new LichSuThaoTacView();
        String chitiet = gson.toJson(guiData());
        ls.setMaNhanVien(user);
        ls.setChiTiet(chitiet);
        ls.setGiaTriMoi(chitiet);
        ls.setThaoTac("Thêm");
        ls.setThoiGianThaoTac(timestamp);
        ls.setViTriThaoTac("Thể loại sản phẩm");
        ls.setGiaTriCu("{}");
        ls.setSTT(0);
        lsform.insertLichSu(ls);

    }
        public void lichSuVoHieuHoa() {
        List<ChiTiet> list = new ArrayList<>();
        ChiTiet ct = new ChiTiet(txtTenTheLoai.getText(), txtMaTheLoai.getText());
        LichSuThaoTacView ls = new LichSuThaoTacView();
        String chitiet = gson.toJson(ct);
        ls.setMaNhanVien(user);
        ls.setChiTiet(chitiet);
        ls.setGiaTriMoi(chitiet);
        ls.setThaoTac("Vô hiệu hóa");
        ls.setThoiGianThaoTac(timestamp);
        ls.setViTriThaoTac("Thể loại sản phẩm");
        ls.setGiaTriCu(chitiet);
        ls.setSTT(0);
        lsform.insertLichSu(ls);

    }
           public void lichUp2() {
        LichSuThaoTacView ls = new LichSuThaoTacView();
        String chitiet = gson.toJson(guiData());
        TheLoaiSanPham sp = new TheLoaiSanPham(txtMaTheLoai.getText(), tl.tenTheloai(txtMaTheLoai.getText()), 0);
        
        String giatricu = gson.toJson(sp);
        ls.setGiaTriCu(giatricu);
        ls.setMaNhanVien(user);
        ls.setChiTiet(chitiet);
        ls.setGiaTriMoi(chitiet);
        ls.setThaoTac("Sửa");
        ls.setThoiGianThaoTac(timestamp);
        ls.setViTriThaoTac("Thể loại sản phẩm");
        ls.setSTT(0);
        lsform.insertLichSu(ls);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTheLoai = new javax.swing.JTable();
        txtMaTheLoai = new javax.swing.JTextField();
        txtTenTheLoai = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnVoHieuHoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();

        jLabel1.setText("Mã thể loại :");

        jLabel2.setText("Tên thể loại :");

        tblTheLoai.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTheLoaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTheLoai);

        btnThem.setBackground(new java.awt.Color(51, 51, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(51, 51, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnVoHieuHoa.setBackground(new java.awt.Color(51, 51, 255));
        btnVoHieuHoa.setText("Vô hiệu hóa");
        btnVoHieuHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoHieuHoaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(51, 51, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaTheLoai)
                            .addComponent(txtTenTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVoHieuHoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(196, 196, 196))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnSua)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnVoHieuHoa)
                        .addGap(51, 51, 51)
                        .addComponent(btnLamMoi)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtMaTheLoai.getText().isBlank() || txtTenTheLoai.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ dữ liệu");
            return;
        }
        JOptionPane.showMessageDialog(this, tl.themTheLoai(guiData()));
        loadTable(listTheLoai());
        lichSuThem();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
           if (txtMaTheLoai.getText().isBlank() || txtTenTheLoai.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ dữ liệu");
            return;
        }
        lichUp2();
        JOptionPane.showMessageDialog(this, tl.suaTheLoai(guiData()));
        loadTable(listTheLoai());
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnVoHieuHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoHieuHoaActionPerformed
          if (txtMaTheLoai.getText().isBlank() || txtTenTheLoai.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã để vô hiệu hóa");
            return;
        }
        JOptionPane.showMessageDialog(this, tl.voHieuHoaTheLoai(new TheLoaiSanPhamView(txtMaTheLoai.getText(), txtTenTheLoai.getText(), 1)));
        loadTable(listTheLoai());
        lichSuVoHieuHoa();
    }//GEN-LAST:event_btnVoHieuHoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtMaTheLoai.setText("");
        txtTenTheLoai.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTheLoaiMouseClicked
        int a = tblTheLoai.getSelectedRow();
        TheLoaiSanPham tl = listTheLoai().get(a);
        txtMaTheLoai.setText(tl.getMaTheLoai());
        txtTenTheLoai.setText(tl.getTenTheLoai());
    }//GEN-LAST:event_tblTheLoaiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnVoHieuHoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTheLoai;
    private javax.swing.JTextField txtMaTheLoai;
    private javax.swing.JTextField txtTenTheLoai;
    // End of variables declaration//GEN-END:variables
}
