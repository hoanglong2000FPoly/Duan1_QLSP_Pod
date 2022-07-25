/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NhanVien;
import Ultilities.HibernateUltis;
import ViewModels.NhanVienView;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dell
 */
public class NhanVienDAO {

    public String themNhanVien(NhanVien nv){
        try(Session ss = HibernateUltis.getSessionFactory().openSession()){
            Transaction tran = ss.getTransaction();
            tran.begin();
            try {
                ss.save(nv);
                tran.commit();
            } catch (Exception e) {
                tran.rollback();
                return "Thêm không thành công";
            }
        }
        return "Thêm thành công nhé!";

    }
        public String suaNhanVien(NhanVien nv){
        try(Session ss = HibernateUltis.getSessionFactory().openSession()){
            Transaction tran = ss.getTransaction();
            tran.begin();
            try {
                ss.update(nv);
                tran.commit();
            } catch (Exception e) {
                tran.rollback();
                return "Lỗi";
            }
        }
        return "Sửa thành công nhé!";

    }

    public  List<NhanVien> listNhanVien(){
        List<NhanVien> list;
        try(Session ss = HibernateUltis.getSessionFactory().openSession()){
            String sql = "select x from NhanVien x";
            TypedQuery<NhanVien> type = ss.createQuery(sql,NhanVien.class);
            list = type.getResultList();
        }
        return list;
    }

    public String passNhanVien(String user,String email){
          String pass = null;
        String err = null;
        try ( org.hibernate.Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String ten = "select MatKhau from NhanVien where MaNhanVien =: manhanvien and Email =:email ";
            Query qr = ss.createQuery(ten);
            qr.setParameter("manhanvien", user);
            qr.setParameter("email", email);
            pass = (String) qr.getSingleResult();
        } catch (Exception e) {
            err = "Rỗng";
            return err;
        }

        return pass;
    }
}
