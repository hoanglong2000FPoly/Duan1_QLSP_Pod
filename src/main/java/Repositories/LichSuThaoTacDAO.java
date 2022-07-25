/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.LichSuThaoTac;
import Ultilities.HibernateUltis;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class LichSuThaoTacDAO {
    
    public void insertLichSu(LichSuThaoTac ls){
        try(Session ss = HibernateUltis.getSessionFactory().openSession()){
            Transaction tran = ss.getTransaction();
            tran.begin();
            try {
                ss.save(ls);
                tran.commit();
            } catch (Exception e) {
                System.out.println("Lỗi");
                tran.rollback();
            }
        }
    }
    
    public List<LichSuThaoTac> listThaoTac(){
        List<LichSuThaoTac> list;
          try(Session ss = HibernateUltis.getSessionFactory().openSession()){
              String sql = "select x from LichSuThaoTac x";
              TypedQuery<LichSuThaoTac> qr = ss.createQuery(sql);
              list = qr.getResultList();
          }
          return list;
          
    }
    
}
