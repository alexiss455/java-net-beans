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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author PabloFam
 */
public class expirationNotif extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    SimpleDateFormat sdate = new  SimpleDateFormat("yyyy-MM-dd");
    
    public expirationNotif() throws ParseException {
        initComponents();
      // list();
        dt();
        searchExp();
    }

   public void dt() throws ParseException{   //DATE CODE         
                                             //Set 5 days before expiration
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //set date
            String dd = sdf.format(d);
            String dateNow = String.valueOf(dd);
            lbldate1.setText(dd); 
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(dateNow));
            c.add(Calendar.DATE, 5);
            dateNow = sdf.format(c.getTime());
            lbldate2.setText(dateNow);
           
            
  
        }
   
  
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbldate2 = new javax.swing.JLabel();
        lbldate1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblexpNum = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(834, 555));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbldate2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbldate2.setText("Date2");
        getContentPane().add(lbldate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 560, 170, 50));

        lbldate1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbldate1.setText("Date1");
        getContentPane().add(lbldate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 560, 170, 50));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "Barcode", "Product Name", "Description", "Qty", "Price", "Category", "Expriation"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 790, 440));

        lblexpNum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblexpNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblexpNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 464, 200, 30));

        jLabel1.setBackground(new java.awt.Color(0, 176, 240));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" EXPIRATION BEFORE 5 DAYS");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         searchExp();
    }//GEN-LAST:event_formWindowOpened

     public void searchExp(){
        try{
            String sd1 = lbldate1.getText();
            String sd2 = lbldate2.getText();

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
                String date = "select barcode,pname,description,qty,price,category,expiration from product_table where expiration between '"+sd1+"' and '"+sd2+"' ORDER BY expiration ASC ";
                pst = con.prepareStatement(date);
                rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                
        }catch(Exception e){
        }
    
    }
     
     
     
     
  /*  public void list(){ //Show all data list in JTable
    int cc;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            String sql = "select pid,barcode,pname,description,qty,price,category,expiration from product_table";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
          
        } catch (Exception ex) {
            
        } finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                
            }
    
    }  
    }*/
    
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
            java.util.logging.Logger.getLogger(expirationNotif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(expirationNotif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(expirationNotif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(expirationNotif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new expirationNotif().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(expirationNotif.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbldate1;
    private javax.swing.JLabel lbldate2;
    private javax.swing.JLabel lblexpNum;
    // End of variables declaration//GEN-END:variables
}
