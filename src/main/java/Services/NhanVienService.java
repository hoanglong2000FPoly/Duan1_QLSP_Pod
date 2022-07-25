/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repositories.NhanVienDAO;
import java.util.List;

/**
 *
 * @author admin
 */
public class NhanVienService {
    NhanVienDAO nhanVienTruyVan;

    public NhanVienService() {
        nhanVienTruyVan = new NhanVienDAO();
    }
    public List getList(){
      return nhanVienTruyVan.getList();
    }
}
