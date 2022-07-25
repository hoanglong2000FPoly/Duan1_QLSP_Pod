/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultilities;

import jakarta.mail.internet.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dell
 */
public class Ulti {
    
  public boolean checkSoFloat(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text.replace(".", ""));
        return matcher.matches();
    }
    public boolean checkSoInt(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text.replace("", ""));
        return matcher.matches();
    }

    public static boolean isConfirmed(String password) {
        Boolean leastOneUpperCase = false;
        Boolean leastOneLowerCase = false;
        Boolean leastOneDigit = false;
        Boolean oneSpecialCharacter = false;

        if (password.length() < 8) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                leastOneUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                leastOneLowerCase = true;
            } else if (Character.isDigit(c)) {
                leastOneDigit = true;
            }
        }

        return (leastOneUpperCase && leastOneLowerCase && leastOneDigit);
    }

    public String convertDatetoString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

//    public static toLowerCaseIfEmail(String string) {
//        try {
//            new InternetAddress(string, true);
//        } catch (AddressException e) {
//            return string;
//        }
//        int lastAt = string.lastIndexOf('@');
//        if (lastAt == -1
//                || string.lastIndexOf(']') > lastAt
//                || string.lastIndexOf(')' > lastAt)  {
//            return string;
//        }
//        return string.substring(0, lastAt) + string.substring(lastAt).toLowerCase();
//    }
    public boolean checkEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    public boolean checkSDT(String s) {
         // The given argument to compile() method
        // is regular expression. With the help of
        // regular expression we can validate mobile
        // number.
        // The number should be of 10 digits.
 
        // Creating a Pattern class object
        Pattern p = Pattern.compile("^\\d{10}$");
 
        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression for which
        // object of Matcher class is created
        Matcher m = p.matcher(s);
 
        // Returning boolean value
        return (m.matches());
    }
}
