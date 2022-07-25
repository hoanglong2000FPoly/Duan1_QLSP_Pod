/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.BaoHanh;
import Repositories.BaoHanhDAO;
import ViewModel.BaoHanhView;
import java.util.List;

/**
 *
 * @author admin
 */
public class BaoHanhService {
    BaoHanhDAO baoHanhTruyVan;

    public BaoHanhService() {
        baoHanhTruyVan = new BaoHanhDAO();
    }
    public List getList(){
        return baoHanhTruyVan.getList();
    }
    public String add(BaoHanhView x){
        return baoHanhTruyVan.save(new BaoHanh(x.getMaBaoHanh(), x.getNgayMua(), x.getMoTa(), x.getMaSanPham(), x.getMaKhachHang(), x.getMaNhanVien(),x.getTrangThai()));
    }
     public String edit(BaoHanhView x){
        return baoHanhTruyVan.save(new BaoHanh(x.getMaBaoHanh(), x.getNgayMua(), x.getMoTa(), x.getMaSanPham(), x.getMaKhachHang(), x.getMaNhanVien(),x.getTrangThai()));
    }
    
}
