/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.PhuKien;
import Ultilities.HibernateUltis;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class PhuKienDAO {
    public List<PhuKien> getList(){
       List<PhuKien> phuKiens;
        try(Session session = HibernateUltis.getSessionFactory().openSession()){
            TypedQuery<PhuKien> query = session.createQuery("from PhuKien where TrangThai = 0");
            phuKiens = query.getResultList();
        } 
        return phuKiens;
    }
    public List<PhuKien> getListVoHieuHoa(){
       List<PhuKien> phuKiens;
        try(Session session = HibernateUltis.getSessionFactory().openSession()){
            TypedQuery<PhuKien> query = session.createQuery("from PhuKien where TrangThai = 1");
            phuKiens = query.getResultList();
        } 
        return phuKiens;
    }
    public String save(PhuKien pk){
         try(Session session = HibernateUltis.getSessionFactory().openSession()){
             Transaction transaction = session.getTransaction();
             transaction.begin();
             try {
                 session.save(pk);
                 transaction.commit();
             } catch (Exception e) {
                 e.printStackTrace();
                 transaction.rollback();
                 return "Không thành công";
             }
         }
         return "Thêm thành công";
    }
    public String update(PhuKien pk){
         try(Session session = HibernateUltis.getSessionFactory().openSession()){
             Transaction transaction = session.getTransaction();
             transaction.begin();
             try {
                 session.update(pk);
                 transaction.commit();
             } catch (Exception e) {
                 e.printStackTrace();
                 transaction.rollback();
                 return "Không thành công";
             }
         }
         return "Sửa thành công";
    }
     public String voHieuHoa(PhuKien pk){
         try(Session session = HibernateUltis.getSessionFactory().openSession()){
             Transaction transaction = session.getTransaction();
             transaction.begin();
             try {
                 session.update(pk);
                 transaction.commit();
             } catch (Exception e) {
                 e.printStackTrace();
                 transaction.rollback();
                 return "Không thành công";
             }
         }
         return "Vô hiệu hóa thành công";
    }

}
