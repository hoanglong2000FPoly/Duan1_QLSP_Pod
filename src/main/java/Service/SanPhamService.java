/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.SanPham;
import Repositories.SanPhamDAO;
import ViewModels.SanPhamView;
import java.util.List;

/**
 *
 * @author Dell
 */
public class SanPhamService {

    SanPhamDAO spDao = new SanPhamDAO();

    public String themSanPham(SanPhamView sp1) {
        DomainModels.SanPham sp = new SanPham(sp1.getMaSanPham(), sp1.getTenSanPham(), sp1.getSoLuong(),
                sp1.getNamSanXuat(), sp1.getHangSanXuat(), sp1.getGiaNhap(), sp1.getGiaBan(), sp1.getDungTich(), sp1.getCongSuat(),
                sp1.getPin(), sp1.getMoTa(), sp1.getMaTheLoai(),sp1.getTrangThai());
        return spDao.themSanPham(sp);
    }

    public String suaSanPham(SanPhamView sp1) {
        DomainModels.SanPham sp = new SanPham(sp1.getMaSanPham(), sp1.getTenSanPham(), sp1.getSoLuong(),
                sp1.getNamSanXuat(), sp1.getHangSanXuat(), sp1.getGiaNhap(), sp1.getGiaBan(), sp1.getDungTich(), sp1.getCongSuat(),
                sp1.getPin(), sp1.getMoTa(), sp1.getMaTheLoai(),sp1.getTrangThai());
        return spDao.suaSanPham(sp);
    }
        public String voHieuHoaSanPham(SanPhamView sp1) {
        DomainModels.SanPham sp = new SanPham(sp1.getMaSanPham(), sp1.getTenSanPham(), sp1.getSoLuong(),
                sp1.getNamSanXuat(), sp1.getHangSanXuat(), sp1.getGiaNhap(), sp1.getGiaBan(), sp1.getDungTich(), sp1.getCongSuat(),
                sp1.getPin(), sp1.getMoTa(), sp1.getMaTheLoai(),sp1.getTrangThai());
        return spDao.voHieuHoaSanPham(sp);
    }

    public List<SanPham> listSanPham() {
        return spDao.listSanPham();
    }

    public String tenSanPham(String masp) {
        return spDao.tenSanPham(masp);
    }

    public int soLuongSanPham(String masp) {
        return spDao.soLuongSanPham(masp);
    }

    public String hangSanxuat(String masp) {

        return spDao.hangSanxuat(masp);
    }

    public float giaNhapSanPham(String masp) {
        return spDao.giaNhapSanPham(masp);
    }

    public float giaBanSanPham(String masp) {
        return spDao.giaBanSanPham(masp);
    }

    public float dungTich(String masp) {
        return spDao.dungTich(masp);
    }

    public String congSuat(String masp) {
        return spDao.congSuat(masp);
    }

    public String Pin(String masp) {
        return spDao.Pin(masp);
    }

    public String moTa(String masp) {
        return spDao.moTa(masp);
    }

}
