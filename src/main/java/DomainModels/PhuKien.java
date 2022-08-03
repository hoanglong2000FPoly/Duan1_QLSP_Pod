/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "PhuKien")
public class PhuKien implements Serializable {

    @Id
    private String MaPhuKien;
    private String TenPhuKien;
    private int SoLuong;
    private float GiaNhap;
    private float GiaBan;
    private String DienTro;
    @ManyToOne
    @JoinColumn(name = "MaSanPham")
    private SanPham MaSanPham;
    private int TrangThai;
    public PhuKien() {
    }

    public PhuKien(String MaPhuKien, String TenPhuKien, int SoLuong, float GiaNhap, float GiaBan, String DienTro, SanPham MaSanPham, int TrangThai) {
        this.MaPhuKien = MaPhuKien;
        this.TenPhuKien = TenPhuKien;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.DienTro = DienTro;
        this.MaSanPham = MaSanPham;
        this.TrangThai = TrangThai;
    }

    public String getMaPhuKien() {
        return MaPhuKien;
    }

    public void setMaPhuKien(String MaPhuKien) {
        this.MaPhuKien = MaPhuKien;
    }

    public String getTenPhuKien() {
        return TenPhuKien;
    }

    public void setTenPhuKien(String TenPhuKien) {
        this.TenPhuKien = TenPhuKien;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getDienTro() {
        return DienTro;
    }

    public void setDienTro(String DienTro) {
        this.DienTro = DienTro;
    }

    public SanPham getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(SanPham MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

   
}
