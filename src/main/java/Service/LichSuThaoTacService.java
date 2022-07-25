/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.LichSuThaoTac;
import Repositories.LichSuThaoTacDAO;

import ViewModels.LichSuThaoTacView;
import java.util.List;

public class LichSuThaoTacService {

    LichSuThaoTacDAO lsDAO = new LichSuThaoTacDAO();
    
    public void insertLichSu(LichSuThaoTacView ls1) {
        LichSuThaoTac ls = new LichSuThaoTac(ls1.getSTT(),ls1.getMaNhanVien(), ls1.getThaoTac(),
                ls1.getChiTiet(), ls1.getThoiGianThaoTac(), ls1.getViTriThaoTac(), ls1.getGiaTriCu(), ls1.getGiaTriMoi());
        lsDAO.insertLichSu(ls);
    }
    public List<LichSuThaoTac> listThaoTac(){
        return lsDAO.listThaoTac();
    }
    
}
