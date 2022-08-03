/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TheLoaiSanPham")
public class TheLoaiSanPham implements Serializable{
    @Id
    private String MaTheLoai;
    @Column
    private String TenTheLoai;
    @Column
    private int TrangThai;
    
   

    public TheLoaiSanPham(String MaTheLoai, String TenTheLoai, int TrangThai) {
        this.MaTheLoai = MaTheLoai;
        this.TenTheLoai = TenTheLoai;
        this.TrangThai = TrangThai;
    }

    public TheLoaiSanPham() {
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
