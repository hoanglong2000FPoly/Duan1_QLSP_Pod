/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.KhachHang;
import Ultilities.HibernateUti;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class KhachHangDAO {
     public List<KhachHang> getList(){
        List<KhachHang> khachHangs;
        try(Session session = HibernateUti.getSessionFactory().openSession()){
            TypedQuery<KhachHang> query = session.createQuery("select c from KhachHang c");
            khachHangs = query.getResultList();
        }
        return khachHangs;
    } 
}
