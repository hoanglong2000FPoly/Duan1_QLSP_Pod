package Repositories;

import DomainModels.TheLoaiSanPham;
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
public class TheLoaiSanPhamDAO {

    public String themTheLoai(TheLoaiSanPham tl) {
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            Transaction tran = ss.getTransaction();
            tran.begin();
            try {
                ss.save(tl);
                tran.commit();
            } catch (Exception e) {
                tran.rollback();
                return "Không thành công";
            }
            return "Thêm thành công";
        }
    }

    public String suaTheLoai(TheLoaiSanPham tl) {
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            Transaction tran = ss.getTransaction();
            tran.begin();
            try {
                ss.update(tl);
                tran.commit();
            } catch (Exception e) {
                tran.rollback();
                return "Không thành công";
            }
            return "Sửa thành công";
        }
    }

    public String voHieuHoaTheLoai(TheLoaiSanPham tl) {
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            Transaction tran = ss.getTransaction();
            tran.begin();
            try {
                ss.update(tl);
                tran.commit();
            } catch (Exception e) {
                tran.rollback();
                return "Không thành công";
            }
            return "Vô hiệu hóa thành công";
        }
    }

    public List<TheLoaiSanPham> listTheLoai() {
        List<TheLoaiSanPham> list;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = " from TheLoaiSanPham where TrangThai = 0";
            TypedQuery<TheLoaiSanPham> qr = ss.createQuery(sql, TheLoaiSanPham.class);
            list = qr.getResultList();
        }
        return list;
    }
    
        public List<TheLoaiSanPham> listTheLoaiAll() {
        List<TheLoaiSanPham> list;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = " from TheLoaiSanPham";
            TypedQuery<TheLoaiSanPham> qr = ss.createQuery(sql, TheLoaiSanPham.class);
            list = qr.getResultList();
        }
        return list;
    }

    public String tenTheLoai(String matheloai) {
        String name;
        try ( Session ss = HibernateUltis.getSessionFactory().openSession()) {
            String sql = "select TenTheLoai from TheLoaiSanPham where MaTheLoai =: masp";
            Query qr = ss.createQuery(sql);
            qr.setParameter("masp", matheloai);
            name = String.valueOf(qr.getSingleResult());
        }
        return name;
    }

}
