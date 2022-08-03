/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author T460
 */
@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaKhachHang;
    private String TenKhachHang;
    private int GioiTinh;
    private String Email;
    private String SDT;

    public KhachHang() {
    }

    public KhachHang(int MaKhachHang, String TenKhachHang, int GioiTinh, String Email, String SDT) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.GioiTinh = GioiTinh;
        this.Email = Email;
        this.SDT = SDT;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

}
