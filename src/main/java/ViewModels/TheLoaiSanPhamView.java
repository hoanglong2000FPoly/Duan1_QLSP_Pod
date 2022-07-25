/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Dell
 */
public class TheLoaiSanPhamView {

    private String MaTheLoai;
    private String TenTheLoai;
    private int TrangThai;

    public TheLoaiSanPhamView() {
    }

    public TheLoaiSanPhamView(String MaTheLoai, String TenTheLoai, int TrangThai) {
        this.MaTheLoai = MaTheLoai;
        this.TenTheLoai = TenTheLoai;
        this.TrangThai = TrangThai;
    }

    public String getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(String MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String TenTheLoai) {
        this.TenTheLoai = TenTheLoai;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

}
