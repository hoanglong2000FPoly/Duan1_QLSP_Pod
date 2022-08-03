/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.TheLoaiSanPham;
import Repositories.TheLoaiSanPhamDAO;
import ViewModels.TheLoaiSanPhamView;
import java.util.List;

public class TheLoaiSanPhamService {

    TheLoaiSanPhamDAO tlDAO = new TheLoaiSanPhamDAO();

    public String themTheLoai(TheLoaiSanPhamView tl1) {
        TheLoaiSanPham tl = new TheLoaiSanPham(tl1.getMaTheLoai(), tl1.getTenTheLoai(), tl1.getTrangThai());
        return tlDAO.themTheLoai(tl);
    }

    public String suaTheLoai(TheLoaiSanPhamView tl1) {
        TheLoaiSanPham tl = new TheLoaiSanPham(tl1.getMaTheLoai(), tl1.getTenTheLoai(), tl1.getTrangThai());
        return tlDAO.suaTheLoai(tl);
    }

    public List<TheLoaiSanPham> listTheLoai() {
        return tlDAO.listTheLoai();
    }
    
        public List<TheLoaiSanPham> listTheLoaiAll() {
        return tlDAO.listTheLoaiAll();
    }

    public String voHieuHoaTheLoai(TheLoaiSanPhamView tl1) {
        TheLoaiSanPham tl = new TheLoaiSanPham(tl1.getMaTheLoai(), tl1.getTenTheLoai(), tl1.getTrangThai());
        return tlDAO.voHieuHoaTheLoai(tl);
    }

    public String tenTheloai(String tl1) {
        
        return tlDAO.tenTheLoai(tl1);
    }

}
