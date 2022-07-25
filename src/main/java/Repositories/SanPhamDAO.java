/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;


import DomainModels.SanPham;
import Ultilities.HibernateUltis;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dell
 */
public class SanPhamDAO {

    public String themSanPham(SanPham sp) {
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            Transaction tran = ss.getTransaction();
            tran.begin();
            try {
                ss.save(sp);
                tran.commit();
            } catch (Exception e) {
                tran.rollback();
                return "Thêm không thành công";
            }
        }
        return "Thêm thành công nhé!";
    }

    public String suaSanPham(SanPham sp) {
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            Transaction tran = ss.getTransaction();
            tran.begin();
            try {
                ss.update(sp);
                tran.commit();
            } catch (Exception e) {
                tran.rollback();
                return "Sửa không thành công";
            }
        }
        return "Sửa thành công nhé!";
    }
    
        public String voHieuHoaSanPham(SanPham sp) {
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            Transaction tran = ss.getTransaction();
            tran.begin();
            try {
                ss.update(sp);
                tran.commit();
            } catch (Exception e) {
                tran.rollback();
                return "Vô hiệu hóa thất bại";
            }
        }
        return "Vô hiệu hóa thành công sản phẩm có mã là " +sp.getMaSanPham();
    }

    public List<SanPham> listSanPham() {
        List<SanPham> list;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = "from  SanPham where TrangThai =0" ;
            TypedQuery<SanPham> type = ss.createQuery(sql,SanPham.class);
            
            list = type.getResultList();
        }
        return list;
    }

    public String tenSanPham(String masp) {
        String name;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = "select TenSanPham from SanPham where MaSanPham =: masp";
            Query qr = ss.createQuery(sql);
            qr.setParameter("masp", masp);
            name = String.valueOf(qr.getSingleResult());
        }
        return name;
    }

    public int soLuongSanPham(String masp) {
        int soluong;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = "select SoLuong from SanPham where MaSanPham =: masp";
            Query qr = ss.createQuery(sql);
            qr.setParameter("masp", masp);
            soluong = (int) qr.getSingleResult();
        }
        return soluong;
    }

    public String hangSanxuat(String masp) {
        String name;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = "select HangSanXuat from SanPham where MaSanPham =: masp";
            Query qr = ss.createQuery(sql);
            qr.setParameter("masp", masp);
            name = String.valueOf(qr.getSingleResult());
        }
        return name;
    }

    public float giaNhapSanPham(String masp) {
        float soluong;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = "select GiaNhap from SanPham where MaSanPham =: masp";
            Query qr = ss.createQuery(sql);
            qr.setParameter("masp", masp);
            soluong = (float) qr.getSingleResult();
        }
        return soluong;
    }

    public float giaBanSanPham(String masp) {
        float soluong;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = "select GiaBan from SanPham where MaSanPham =: masp";
            Query qr = ss.createQuery(sql);
            qr.setParameter("masp", masp);
            soluong = (float) qr.getSingleResult();
        }
        return soluong;
    }

    public float dungTich(String masp) {
        float soluong;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = "select DungTich from SanPham where MaSanPham =: masp";
            Query qr = ss.createQuery(sql);
            qr.setParameter("masp", masp);
            soluong = (float) qr.getSingleResult();
        }
        return soluong;
    }

    public String congSuat(String masp) {
        String name;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = "select CongSuat from SanPham where MaSanPham =: masp";
            Query qr = ss.createQuery(sql);
            qr.setParameter("masp", masp);
            name = String.valueOf(qr.getSingleResult());
        }
        return name;
    }

    public String Pin(String masp) {
        String name;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = "select Pin from SanPham where MaSanPham =: masp";
            Query qr = ss.createQuery(sql);
            qr.setParameter("masp", masp);
            name = String.valueOf(qr.getSingleResult());
        }
        return name;
    }

    public String moTa(String masp) {
        String name;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = "select MoTa from SanPham where MaSanPham =: masp";
            Query qr = ss.createQuery(sql);
            qr.setParameter("masp", masp);
            name = String.valueOf(qr.getSingleResult());
        }
        return name;
    }
  

}
