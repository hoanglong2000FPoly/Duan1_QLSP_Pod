/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultilities;

import jakarta.mail.internet.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class Ulti {
  public Date converStringToDate(String dateString) throws java.text.ParseException {
        Date date1 = null;

        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (Exception ex) {
            System.out.println("Phải nhập ngày sinh theo kiểu yyyy-MM-dd");

        }
        return date1;
    }
}
