/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author alex
 */
public class prod {

    
public void list(DefaultTableModel model, JTable jTable1){ //Set all data in Jtable from product_table
        model = (DefaultTableModel) jTable1.getModel();
    Connection con;
     PreparedStatement pst;
     ResultSet rs;
    
        try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            
            pst = con.prepareStatement("select pid,barcode,pname,description,qty,price,category,expiration from product_table");
            rs = pst.executeQuery(); 
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
}
