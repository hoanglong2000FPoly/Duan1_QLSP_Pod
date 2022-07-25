/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class LichSuThaoTacView {
    
    private int STT;
      private String MaNhanVien;
    
    
    private String ThaoTac;
 
    private String ChiTiet;
    
    private Date ThoiGianThaoTac;
    
    private String ViTriThaoTac;
    
    private String GiaTriCu;
    
    private String GiaTriMoi;

    public LichSuThaoTacView() {
    }

    public LichSuThaoTacView(int STT, String MaNhanVien, String ThaoTac, String ChiTiet, Date ThoiGianThaoTac, String ViTriThaoTac, String GiaTriCu, String GiaTriMoi) {
        this.STT = STT;
        this.MaNhanVien = MaNhanVien;
        this.ThaoTac = ThaoTac;
        this.ChiTiet = ChiTiet;
        this.ThoiGianThaoTac = ThoiGianThaoTac;
        this.ViTriThaoTac = ViTriThaoTac;
        this.GiaTriCu = GiaTriCu;
        this.GiaTriMoi = GiaTriMoi;
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

    
    
    
}
