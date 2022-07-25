/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NhanVien;
import Ultilities.HibernateUti;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class NhanVienDAO {
    public List<NhanVien> getList(){
        List<NhanVien> nhanViens;
        try(Session session = HibernateUti.getSessionFactory().openSession()){
            TypedQuery<NhanVien> query = session.createQuery("select c from NhanVien c");
            nhanViens = query.getResultList();
        }
        return nhanViens;
    } 
}
