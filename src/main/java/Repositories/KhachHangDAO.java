/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.KhachHang;
import Ultilities.HibernateUltis;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author T460
 */
public class KhachHangDAO {
     public  List<KhachHang> listKH(){
        List<KhachHang> list;
        try(Session ss = HibernateUltis.getSessionFactory().openSession()){
            String sql = "select x from KhachHang x";
            TypedQuery<KhachHang> type = ss.createQuery(sql,KhachHang.class);
            list = type.getResultList();
        }
        return list;
    }
    
    public String themKhachHang(KhachHang kh){
        try(Session ss = HibernateUltis.getSessionFactory().openSession()){
            Transaction tran = ss.getTransaction();
            tran.begin();
            try {
                ss.save(kh);
                tran.commit();
            } catch (Exception e) {
                tran.rollback();
                return "Thêm không thành công";
            }
        }
        return "Thêm thành công nhé!";

    }
    
    public String suaKhachHang(KhachHang kh){
        try(Session ss = HibernateUltis.getSessionFactory().openSession()){
            Transaction tran = ss.getTransaction();
            tran.begin();
            try {
                ss.update(kh);
                tran.commit();
            } catch (Exception e) {
                tran.rollback();
                return "Sửa không thành công";
            }
        }
        return "Sửa thành công nhé!";

    }
}
