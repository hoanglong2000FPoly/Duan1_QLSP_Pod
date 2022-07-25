/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.BaoHanh;
import Ultilities.HibernateUti;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class BaoHanhDAO {
    public List<BaoHanh> getList(){
        List<BaoHanh> baoHanhs;
        try(Session session = HibernateUti.getSessionFactory().openSession()){
            TypedQuery<BaoHanh> query = session.createQuery("select c from BaoHanh c");
            baoHanhs = query.getResultList();
        }
        return baoHanhs;
    }
    public String save(BaoHanh bh){
        try(Session session = HibernateUti.getSessionFactory().openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(bh);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return "Không thành công";
            }
        }
        return "Thành công";
    }
    public String update(BaoHanh bh){
        try(Session session = HibernateUti.getSessionFactory().openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.update(bh);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return "Không thành công";
            }
        }
        return "Thành công";
    }
}
