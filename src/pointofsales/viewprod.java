/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsales;

import java.awt.Color;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author alex
 */
public class viewprod extends javax.swing.JFrame {

    /**
     * Creates new form viewprod
     */
    public viewprod() {
        initComponents();
        list();
        
    }

     SimpleDateFormat sdate = new  SimpleDateFormat("yyyy-MM-dd");
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(980, 670));
        setMinimumSize(new java.awt.Dimension(980, 670));
        setPreferredSize(new java.awt.Dimension(980, 670));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(64, 64, 64));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 120, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TRANSCODE", "PRODNAME", "QUANTITY", "DATE", "TIME", "CASHIER"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 940, 450));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 170, 40));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 170, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        jButton2.setBackground(new java.awt.Color(64, 64, 64));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("FIND");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 80, 40));

        txtsearch.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        txtsearch.setForeground(new java.awt.Color(153, 153, 153));
        txtsearch.setText(" Search...");
        txtsearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtsearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtsearchFocusLost(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 240, 40));

        jLabel2.setBackground(new java.awt.Color(0, 174, 240));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" PURCHASED PRODUCTS");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 70));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

            setVisible(false);
            sales s = new sales();
            s.setVisible(true);
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
           search(); 
        } catch (Exception e) {
        }
        


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased


String tf = txtsearch.getText(); //Search all data base on type keywords on txtfield
            try{
                if(tf.matches("[A-Za-z0-9]") && tf.matches("^[0-9]+$")){
                    String query = "select invoiced,barcode,prodname,qty,date,time,cashier,status from invoiced WHERE invoiced ="+tf;
                    pst = con.prepareStatement(query);
                    rs = pst.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                }else{
                    String query = "select invoiced,barcode,prodname,qty,date,time,cashier,status from invoiced WHERE invoiced LIKE '%"+tf+"%' OR barcode LIKE '%"+tf+"%' OR prodname LIKE '%"+tf+"%' OR qty LIKE '%"+tf+"%' OR date LIKE '%"+tf+"%' OR time LIKE '%"+tf+"%' OR cashier LIKE '%"+tf+"%' OR status LIKE '%"+tf+"%'";
                    pst = con.prepareStatement(query);
                    rs = pst.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                    }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e);
            }finally{
                try{
                    if(pst!=null){
                        rs.close();
                        pst.close();
                    }
                }catch(Exception e){
                }
            }


        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchKeyReleased

    private void txtsearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsearchFocusGained

 if(txtsearch.getText().equals(" Search...")){   //Clear text when focus gained
            txtsearch.setText("");
            txtsearch.setForeground(new Color(0,0,0));
            txtsearch.setFont(new Font("Arial",Font.PLAIN,18));
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchFocusGained

    private void txtsearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsearchFocusLost

    if(txtsearch.getText().equals("")){          //Set text Search... when focus lost
            txtsearch.setText(" Search...");
            txtsearch.setForeground(new Color(153,153,153));
            txtsearch.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
        
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchFocusLost

    
     
    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    
    public void list(){
        try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            
           String sql = "select invoiced,barcode,prodname,qty,date,time,cashier,status from invoiced";
           pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           jTable1.setModel(DbUtils.resultSetToTableModel(rs));
  
        } catch (Exception ex) {
            
               } finally{
            try {      
                rs.close(); pst.close();    
            } catch (Exception e) {
            }
    }
    }
    
    
     public void search(){
    String  date1 = sdate.format(jDateChooser1.getDate());
    String  date2 = sdate.format(jDateChooser2.getDate());
    jDateChooser1.getDate();
    jDateChooser2.getDate();
    try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            String date = "select invoiced,barcode,prodname,qty,date,time,cashier,status from  invoiced where date between '"+date1+"' and '"+date2+"'";
            
            pst = con.prepareStatement(date);
            rs = pst.executeQuery();
           jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
           
           
        } catch (Exception e) {
        }
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewprod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}