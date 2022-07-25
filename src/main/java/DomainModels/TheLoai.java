/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "TheLoaiSanPham")
public class TheLoai implements Serializable {

    @Id
    private String MaTheLoai;
    @Column(name = "TenTheLoai")
    private String TenTheLoai;
    private int TrangThai;
    public TheLoai() {
    }

    public TheLoai(String MaTheLoai, String TenTheLoai, int TrangThai) {
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
