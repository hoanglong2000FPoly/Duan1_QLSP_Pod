/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.BaoHanh;
import Ultilities.HibernateUltis;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author T460
 */
public class BaoHanhDAO {
    public List<BaoHanh> getList(){
        List<BaoHanh> listBaoHanhs;
        try(Session session = HibernateUltis.getSessionFactory().openSession()){
            TypedQuery<BaoHanh> query = session.createQuery("from BaoHanh where TrangThai = 0");
            listBaoHanhs = query.getResultList();
        }
        return listBaoHanhs;
    }
    
    public String save(BaoHanh bh){
        try(Session session = HibernateUltis.getSessionFactory().openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(bh);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return"That bai";
            }
        }
        return "Thanh cong";
    }
    public String update(BaoHanh bh){
        try(Session session = HibernateUltis.getSessionFactory().openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.update(bh);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return"That bai";
            }
        }
        return "Thanh cong";
    }
    public List<BaoHanh> getListVoHieuHoa(){
       List<BaoHanh> baoHanhs;
        try(Session session = HibernateUltis.getSessionFactory().openSession()){
            TypedQuery<BaoHanh> query = session.createQuery("from BaoHanh where TrangThai = 1");
            baoHanhs = query.getResultList();
        } 
        return baoHanhs;
    }
    public String voHieuHoa(BaoHanh bh){
         try(Session session = HibernateUltis.getSessionFactory().openSession()){
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
         return "Vô hiệu hóa thành công";
    }
    
    public Date Ngaymua(String mbh){
        Date date;
        try(Session s = HibernateUltis.getSessionFactory().openSession()){
            String sql = "Select NgayMua from BaoHanh where MaBaoHanh =: mbh";
            Query qr = s.createQuery(sql);
            qr.setParameter("mbh", mbh);
            date = (Date) qr.getSingleResult();
        }
        return date;
    }
    public String  Mota(String mbh){
        String mota;
        try(Session s = HibernateUltis.getSessionFactory().openSession()){
            String sql = "Select MoTa from BaoHanh where MaBaoHanh =: mbh";
            Query qr = s.createQuery(sql);
            qr.setParameter("mbh", mbh);
            mota =  (String) qr.getSingleResult();
        }
        return mota;
    }
    public String  Masp(String mbh){
        String msp;
        try(Session s = HibernateUltis.getSessionFactory().openSession()){
            String sql = "Select MaSanPham from BaoHanh where MaBaoHanh =: mbh";
            Query qr = s.createQuery(sql);
            qr.setParameter("mbh", mbh);
            msp =  (String) qr.getSingleResult();
        }
        return  msp;
    }
    public int  Makh(String mbh){
        int makh;
        try(Session s = HibernateUltis.getSessionFactory().openSession()){
            String sql = "Select MaKhachHang from BaoHanh where MaBaoHanh =: mbh";
            Query qr = s.createQuery(sql);
            qr.setParameter("mbh", mbh);
            makh =   (int) qr.getSingleResult();
        }
        return  makh;
    }
    public String  Manv(String mbh){
        String mnv;
        try(Session s = HibernateUltis.getSessionFactory().openSession()){
            String sql = "Select MaNhanVien from BaoHanh where MaBaoHanh =: mbh";
            Query qr = s.createQuery(sql);
            qr.setParameter("mbh", mbh);
            mnv =  (String) qr.getSingleResult();
        }
        return  mnv;
    }
}
