/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author admin
 */
public class TheLoaiView {

    private String MaTheLoai;
    private String TenTheLoai;

    public TheLoaiView() {
    }

    public TheLoaiView(String MaTheLoai, String TenTheLoai) {
        this.MaTheLoai = MaTheLoai;
        this.TenTheLoai = TenTheLoai;
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

}
