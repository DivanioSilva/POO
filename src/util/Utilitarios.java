/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author dcsilva
 */
public class Utilitarios {

    public static Date conversorData(int dia, int mes, int ano) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yy");
//        String dateInString = "31-08-1982";
            String dateInString = dia + "-" + mes + "-" + ano;
            date = sdf.parse(dateInString);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar a data!");
        }
        return date;
    }

    public static String conversarDateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String format = formatter.format(date);
        return format;
    }
}
