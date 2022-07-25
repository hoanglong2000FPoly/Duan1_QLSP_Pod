/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import ViewModel.SanPhamView;
import java.util.List;
//import Repostory.ISanPhamTruyVan;
import Repositories.SanPhamDAO;
/**
 *
 * @author admin
 */
public class SanPhamService {
    SanPhamDAO iSanPhamTruyVan;
    public SanPhamService() {
        iSanPhamTruyVan = new SanPhamDAO();
    }
    
    public List getList() {
        return iSanPhamTruyVan.getList();
        
    }

    public String add(SanPhamView sp) {
        return iSanPhamTruyVan.save(new SanPham(sp.getMaSanPham(), 
                sp.getTenSanPham(), sp.getSoLuong(), sp.getNamSanXuat(), sp.getHangSanXuat(), sp.getGiaNhap(), sp.getGiaBan(), sp.getDungTich(), sp.getCongSuat(), sp.getPin(), sp.getMoTa(), sp.getMatheLoai(),sp.getTrangThai()));
    }

    public String edit(SanPhamView sp) {
        return iSanPhamTruyVan.update(new SanPham(sp.getMaSanPham(), 
                sp.getTenSanPham(), sp.getSoLuong(), sp.getNamSanXuat(), sp.getHangSanXuat(), sp.getGiaNhap(), sp.getGiaBan(), sp.getDungTich(), sp.getCongSuat(), sp.getPin(), sp.getMoTa(), sp.getMatheLoai(),sp.getTrangThai()));
    }
    
}
