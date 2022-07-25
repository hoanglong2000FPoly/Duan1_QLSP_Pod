/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultilities;

/**
 *
 * @author Dell
 */
public class GiaTriMoi {
    private String tensanpham;
    
    private int giatrimoi;

    public GiaTriMoi() {
    }

    public GiaTriMoi(String tensanpham, int giatrimoi) {
        this.tensanpham = tensanpham;
        this.giatrimoi = giatrimoi;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public int getGiatrimoi() {
        return giatrimoi;
    }

    public void setGiatrimoi(int giatrimoi) {
        this.giatrimoi = giatrimoi;
    }
    
    
}
