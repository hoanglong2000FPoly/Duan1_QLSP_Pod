/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import DomainModels.TheLoaiSanPham;
import Repositories.TheLoaiSanPhamDAO;
import Service.LichSuThaoTacService;
import Service.TheLoaiSanPhamService;
import Ultilities.Ulti;
import ViewModels.LichSuThaoTacView;
import ViewModels.TheLoaiSanPhamView;
import com.google.gson.Gson;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class ThemNhanhTheLoai extends javax.swing.JFrame {

    TheLoaiSanPhamService tl = new TheLoaiSanPhamService();
    DefaultTableModel tablemodel = new DefaultTableModel();
    Gson gson = new Gson();
    LichSuThaoTacService lsform = new LichSuThaoTacService();
    Ultilities.Ulti ulti = new Ulti();
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    TheLoaiSanPhamDAO tlDao = new TheLoaiSanPhamDAO();
    /**
     * Creates new form ThemNhanTheLoai
     */
    private String user;

    public ThemNhanhTheLoai(String user) {
        initComponents();
        this.user = user;
    }

    private ThemNhanhTheLoai() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        btnThem = new javax.swing.JButton();
        txtMaTheLoai = new javax.swing.JTextField();
        txtTenTheLoai = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã thể loại :");

        jLabel2.setText("Tên thể loại :");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaTheLoai)
                            .addComponent(txtTenTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))
                    .addComponent(btnThem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtMaTheLoai.getText().isBlank() || txtTenTheLoai.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ dữ liệu");
            return;
        }
        JOptionPane.showMessageDialog(this, tl.themTheLoai(guiData()));
        loadTable(listTheLoai());
        lichSuThem();
 

        this.dispose();

       

    }//GEN-LAST:event_btnThemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemNhanhTheLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemNhanhTheLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemNhanhTheLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemNhanhTheLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemNhanhTheLoai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtMaTheLoai;
    private javax.swing.JTextField txtTenTheLoai;
    // End of variables declaration//GEN-END:variables
}