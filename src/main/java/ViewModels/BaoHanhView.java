/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.KhachHang;
import DomainModels.NhanVien;
import DomainModels.SanPham;
import java.util.Date;

/**
 *
 * @author T460
 */
public class BaoHanhView {
   private String MaBaoHanh;
   private Date NgayMua;
   private  String MoTa;
 
  
  private SanPham MaSanPham;
 
  private KhachHang MaKhachHang;
  
  private NhanVien MaNhanVien;
  private int TrangThai;

    public BaoHanhView() {
    }

    public BaoHanhView(String MaBaoHanh, Date NgayMua, String MoTa, SanPham MaSanPham, KhachHang MaKhachHang, NhanVien MaNhanVien, int TrangThai) {
        this.MaBaoHanh = MaBaoHanh;
        this.NgayMua = NgayMua;
        this.MoTa = MoTa;
        this.MaSanPham = MaSanPham;
        this.MaKhachHang = MaKhachHang;
        this.MaNhanVien = MaNhanVien;
        this.TrangThai = TrangThai;
    }

    public String getMaBaoHanh() {
        return MaBaoHanh;
    }

    public void setMaBaoHanh(String MaBaoHanh) {
        this.MaBaoHanh = MaBaoHanh;
    }

    public Date getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(Date NgayMua) {
        this.NgayMua = NgayMua;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public SanPham getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(SanPham MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public KhachHang getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(KhachHang MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public NhanVien getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(NhanVien MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
   

   
}
