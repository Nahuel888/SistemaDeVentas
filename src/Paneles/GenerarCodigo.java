/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author nahuel
 */
public class GenerarCodigo {

    ResultSet rst;

    public int idMasUno(ResultSet rst) {

        int id = 0;
        try {
            while (rst.next()) {
                id = rst.getInt(1);
            }
            rst.close();
            id++;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return id;
    }

}
