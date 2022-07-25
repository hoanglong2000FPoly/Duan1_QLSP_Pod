/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import Ultilities.HibernateUti;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class SanPhamDAO {

    //@Override
    public List<SanPham> getList() {
        List<SanPham> sanPhams;
        try (Session session = HibernateUti.getSessionFactory().openSession()){
            TypedQuery<SanPham> query = session.createQuery("select c from SanPham c");
            sanPhams = query.getResultList();
        } 
        return sanPhams;
    }

    //@Override
    public String save(SanPham sp) {
        try (Session session = HibernateUti.getSessionFactory().openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(sp);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return "Không thành công";
            }
        } 
        return "Thêm thành công";
    }

    //@Override
    public String update(SanPham sp) {
        try (Session session = HibernateUti.getSessionFactory().openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.update(sp);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
               return "Không thành công";
            }
        } 
       return "Sửa thành công";
    }

    //@Override
    public String delete(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
