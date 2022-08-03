/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.BaoHanh;
import Repositories.BaoHanhDAO;
import ViewModels.BaoHanhView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T460
 */
public class BaoHanhService {
    BaoHanhDAO baoHanhDAO;

    public BaoHanhService() {
        baoHanhDAO = new BaoHanhDAO();
    }
    public List getList(){
        return  baoHanhDAO.getList();
    }
    public List getListVoHieuHoa(){
        return baoHanhDAO.getListVoHieuHoa();
    }
    public String add(BaoHanhView x){
        return baoHanhDAO.save(new BaoHanh(x.getMaBaoHanh(), x.getNgayMua(), x.getMoTa(), x.getMaSanPham(), x.getMaKhachHang(), x.getMaNhanVien(),x.getTrangThai()));
        
    }
     public String edit(BaoHanhView x){
        return baoHanhDAO.update(new BaoHanh(x.getMaBaoHanh(), x.getNgayMua(), x.getMoTa(), x.getMaSanPham(), x.getMaKhachHang(), x.getMaNhanVien(),x.getTrangThai()));
        
    }
    public String voHieuHoa(BaoHanhView x){
        return baoHanhDAO.voHieuHoa(new  BaoHanh(x.getMaBaoHanh(), x.getNgayMua(), x.getMoTa(), x.getMaSanPham(), x.getMaKhachHang(), x.getMaNhanVien(),x.getTrangThai()));
    }
     public List<BaoHanh> timkiem(String ma){
         List<BaoHanh> bh = new ArrayList<>();
         for (BaoHanh x : baoHanhDAO.getList()) {
             if(x.getMaBaoHanh().toLowerCase().contains(ma.toLowerCase())){
                 bh.add(x);
             }
         }
         return bh;
     }
    
}
