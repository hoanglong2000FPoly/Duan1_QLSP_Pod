/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.PhuKien;
import Repositories.PhuKienDAO;
import ViewModel.PhuKienView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class PhuKienService {
    PhuKienDAO kienTruyVan;

    public PhuKienService() {
        kienTruyVan = new PhuKienDAO();
    }
    
    public List getList(){
        return kienTruyVan.getList();
    }
    public List getListVoHieuHoa(){
        return kienTruyVan.getListVoHieuHoa();
    }
    
    public String add(PhuKienView x){
        return kienTruyVan.save(new PhuKien(x.getMaPhuKien(), x.getTenPhuKien(), x.getSoLuong(), x.getGiaNhap(), x.getGiaBan(), x.getDienTro(), x.getMaSanPham(),x.getTrangThai()));
    }
    
    public String edit(PhuKienView x){
        return kienTruyVan.update(new PhuKien(x.getMaPhuKien(), x.getTenPhuKien(), x.getSoLuong(), x.getGiaNhap(), x.getGiaBan(), x.getDienTro(), x.getMaSanPham(),x.getTrangThai()));
    }
    public String voHieuHoa(PhuKienView x){
        return kienTruyVan.voHieuHoa(new PhuKien(x.getMaPhuKien(), x.getTenPhuKien(), x.getSoLuong(), x.getGiaNhap(), x.getGiaBan(), x.getDienTro(), x.getMaSanPham(),x.getTrangThai()));
    }
    
    public List<PhuKien> timKiem(String ma){
        List<PhuKien> kiens = new ArrayList<>();
        for (PhuKien x : kienTruyVan.getList()) {
            if(x.getTenPhuKien().toLowerCase().contains(ma.toLowerCase())){
                kiens.add(x);
            }
        }
        return kiens;
    }
    
}
