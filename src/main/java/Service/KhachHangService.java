/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.KhachHang;
import Repositories.KhachHangDAO;
import ViewModels.KhachHangView;
import java.util.List;

/**
 *
 * @author T460
 */
public class KhachHangService {
    KhachHangDAO khDAO;
    

    public KhachHangService() {
        khDAO = new KhachHangDAO();
    }
    public List getList(){
        return  khDAO.listKH();
    }
    public String themKhachHang(KhachHangView kh) {
        KhachHang kh1 = new KhachHang(kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(), kh.getEmail(), kh.getSDT());
        return khDAO.themKhachHang(kh1);
    }
    
    public String suaKhachHang(KhachHangView kh) {
        KhachHang kh1 = new KhachHang(kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(), kh.getEmail(), kh.getSDT());
        return khDAO.suaKhachHang(kh1);
    }
}
