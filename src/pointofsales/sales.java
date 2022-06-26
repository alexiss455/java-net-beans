/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsales;

import java.awt.Image;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import static pointofsales.menuforn.icon;
import static pointofsales.menuforn.img;
import static pointofsales.menuforn.imgScale;
import static pointofsales.menuforn.scaledIcon;

/**
 *
 * @author alex
 */
public class sales extends javax.swing.JFrame {

    /**
     * Creates new form sales
     */
    public sales() {
        initComponents();
        list();
        scaleImage();
       
    }
    
    
    
    public void scaleImage(){ //Method for make image fit to labels/btns
                    icon = new ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\FrmSalesHeaderWithLogo.png");
                    img = icon.getImage();
                    imgScale = img.getScaledInstance(lblsaleslogo.getWidth(), lblsaleslogo.getHeight(), Image.SCALE_SMOOTH);
                    scaledIcon = new ImageIcon(imgScale);
                    lblsaleslogo.setIcon(scaledIcon);   
     }
    
     SimpleDateFormat sdate = new  SimpleDateFormat("yyyy-MM-dd");
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    

    
    public void refreshTable() {
    
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblsaleslogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtreport = new javax.swing.JTextArea();
        Confrim = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtsales = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtdisc = new javax.swing.JLabel();
        lbldisc = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(979, 670));
        setMinimumSize(new java.awt.Dimension(979, 670));
        setPreferredSize(new java.awt.Dimension(979, 670));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblsaleslogo.setBackground(new java.awt.Color(0, 176, 240));
        lblsaleslogo.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\FrmSalesHeaderWithLogo.png")); // NOI18N
        lblsaleslogo.setOpaque(true);
        getContentPane().add(lblsaleslogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 100));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setBackground(new java.awt.Color(64, 64, 64));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("X");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 40, 30));

        txtreport.setColumns(20);
        txtreport.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        txtreport.setRows(5);
        jScrollPane2.setViewportView(txtreport);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 560, 380));

        Confrim.setBackground(new java.awt.Color(64, 64, 64));
        Confrim.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Confrim.setForeground(new java.awt.Color(255, 255, 255));
        Confrim.setText("Confirm");
        Confrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfrimActionPerformed(evt);
            }
        });
        jPanel1.add(Confrim, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SALES REPORT");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 4, 200, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 600, 470));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 210, 40));

        jButton1.setBackground(new java.awt.Color(64, 64, 64));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("FIND");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 79, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Quantity", "Pice", "Amount", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 680, 470));

        jPanel2.setBackground(new java.awt.Color(143, 170, 220));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("PRINT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 413, 260, 45));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 469, 260, 50));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\RefreshIcon.png")); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 63, 59));

        txtsales.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        txtsales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtsales.setText("00");
        txtsales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtsales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 109, 250, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TOTAL SALES");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 77, -1, 26));

        txtdisc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtdisc.setText("TOTAL DISCOUNT");
        jPanel2.add(txtdisc, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 173, -1, -1));

        lbldisc.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lbldisc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldisc.setText("00");
        lbldisc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbldisc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 213, 250, -1));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("PURCHASED PRODUCTS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 344, 260, 51));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 270, 530));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 200, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 30, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void search(){
    String  date1 = sdate.format(jDateChooser1.getDate());
    String  date2 = sdate.format(jDateChooser2.getDate());
    jDateChooser1.getDate();
    jDateChooser2.getDate();
    try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            String date = "select * from  sales where Date between '"+date1+"' and '"+date2+"'";
            
            pst = con.prepareStatement(date);
            rs = pst.executeQuery();
           jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
           
            double sum= 0;
            double sum2 = 0;
            DecimalFormat df = new DecimalFormat(".00");
            for(double i=0; i<jTable1.getRowCount();i++){
                sum =Double.parseDouble(jTable1.getValueAt((int) i, 1).toString())  + sum;
                sum2 =Double.parseDouble(jTable1.getValueAt((int) i, 2).toString())  + sum2;
               
            }
            txtsales.setText(String.valueOf(df.format(sum)));
                lbldisc.setText(String.valueOf(df.format(sum2)));
        } catch (Exception e) {
        }
        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
           search();
           jButton4.setEnabled(true);
        } catch (Exception e) {
        }

  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        menuforn s = new menuforn();
        s.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    
    public void report() throws PrinterException{

        try {
             
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String date1 = fmt.format(this.jDateChooser1.getDate());
        String date2 = fmt.format(this.jDateChooser2.getDate());

        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       
        String sale = txtsales.getText();
        String disc = lbldisc.getText();
        
        txtreport.setText(txtreport.getText()+"                                                \n");
        txtreport.setText(txtreport.getText()+"                        SALES REPORT                  \n");
        txtreport.setText(txtreport.getText()+"                                                \n");
        txtreport.setText(txtreport.getText()+"INVOICED#" + "  " + "TOTALAMOUNT" + "\t" + "DISCOUNT"+ "  " +"DATE "+"\t\t"+" STATUS "+"    \t"+" CASHIER "+ "\n");
        txtreport.setText(txtreport.getText()+"                                                \n");
        for (int i = 0; i<model.getRowCount();i++)
        {
            String a = (String)model.getValueAt(i,0).toString();
            String b = (String)model.getValueAt(i,1).toString();
            String c = (String)model.getValueAt(i,2).toString();
            String d = (String)model.getValueAt(i,3).toString();
            String e = (String)model.getValueAt(i,4).toString();  
            String f = (String)model.getValueAt(i,5).toString();
            txtreport.setText(txtreport.getText()+a+"   "+ b + "\t"+ c + "\t" + d + "\t" +e+ "\t" +f+"\n");
        }
            txtreport.setText(txtreport.getText() + "\n");
            txtreport.setText(txtreport.getText() + "\n");
            txtreport.setText(txtreport.getText() + "\n");
            txtreport.setText(txtreport.getText() + "\n");
            txtreport.setText(txtreport.getText() + "\n");
            txtreport.setText(txtreport.getText() + "TOTAL SALES: "+sale);
            txtreport.setText(txtreport.getText() + "\n");
            txtreport.setText(txtreport.getText() + "Sales Between DATE: "+date1+" - "+date2);
            txtreport.setText(txtreport.getText() + "\n");
            txtreport.setText(txtreport.getText() + "TOTAL DISCOUNT: "+disc);
            txtreport.setText(txtreport.getText() + "\n");
            txtreport.setText(txtreport.getText() + "Discount Between DATE: "+date1+" - "+date2);
            
          } catch (Exception e) {
        }  
}
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    list();
    jButton4.setEnabled(false);
    txtsales.setText("00");
    txtreport.setText("");
    lbldisc.setText("00");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
        try {
            jPanel1.show();
            report();
            
            // TODO add your handling code here:
        } catch (PrinterException ex) {
            Logger.getLogger(sales.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        this.setVisible(false);
        viewprod s = new viewprod();
        s.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ConfrimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfrimActionPerformed
        try {
            txtreport.print();
            jPanel1.hide();
            txtreport.setText("");
            jButton4.setEnabled(false);
            txtsales.setText("00");
            lbldisc.setText("00");
            // TODO add your handling code here:
        } catch (PrinterException ex) {
            Logger.getLogger(sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ConfrimActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        jPanel1.hide();
        jButton4.setEnabled(false);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
txtreport.setText("");
        jPanel1.hide(); 
    }//GEN-LAST:event_jButton6ActionPerformed
  
     public void list(){
        try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            
           String sql = "select * from sales";
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
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confrim;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbldisc;
    private javax.swing.JLabel lblsaleslogo;
    private javax.swing.JLabel txtdisc;
    private javax.swing.JTextArea txtreport;
    private javax.swing.JLabel txtsales;
    // End of variables declaration//GEN-END:variables
}
