/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "LichSuThaoTac")
public class LichSuThaoTac implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int STT;
    
    @Column
    private String MaNhanVien;
    
    @Column
    private String ThaoTac;
    @Column
    private String ChiTiet;
    @Column
    private Date ThoiGianThaoTac;
    @Column
    private String ViTriThaoTac;
    @Column
    private String GiaTriCu;
    @Column
    private String GiaTriMoi;

    public LichSuThaoTac() {
    }
    

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getThaoTac() {
        return ThaoTac;
    }

    public void setThaoTac(String ThaoTac) {
        this.ThaoTac = ThaoTac;
    }

    public String getChiTiet() {
        return ChiTiet;
    }

    public void setChiTiet(String ChiTiet) {
        this.ChiTiet = ChiTiet;
    }

    public Date getThoiGianThaoTac() {
        return ThoiGianThaoTac;
    }

    public void setThoiGianThaoTac(Date ThoiGianThaoTac) {
        this.ThoiGianThaoTac = ThoiGianThaoTac;
    }

    public String getViTriThaoTac() {
        return ViTriThaoTac;
    }

    public void setViTriThaoTac(String ViTriThaoTac) {
        this.ViTriThaoTac = ViTriThaoTac;
    }

    public String getGiaTriCu() {
        return GiaTriCu;
    }

    public void setGiaTriCu(String GiaTriCu) {
        this.GiaTriCu = GiaTriCu;
    }

    public String getGiaTriMoi() {
        return GiaTriMoi;
    }

    public void setGiaTriMoi(String GiaTriMoi) {
        this.GiaTriMoi = GiaTriMoi;
    }

    public LichSuThaoTac(int STT, String MaNhanVien, String ThaoTac, String ChiTiet, Date ThoiGianThaoTac, String ViTriThaoTac, String GiaTriCu, String GiaTriMoi) {
        this.STT = STT;
        this.MaNhanVien = MaNhanVien;
        this.ThaoTac = ThaoTac;
        this.ChiTiet = ChiTiet;
        this.ThoiGianThaoTac = ThoiGianThaoTac;
        this.ViTriThaoTac = ViTriThaoTac;
        this.GiaTriCu = GiaTriCu;
        this.GiaTriMoi = GiaTriMoi;
    }

    
    

    
}