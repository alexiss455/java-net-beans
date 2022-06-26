/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;         
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;

/**
 *
 * @author 2020
 */
public class addprod extends javax.swing.JFrame {

    
    
    public addprod() {
        initComponents();
        
        combo();
    }
    
     Connection con;
     PreparedStatement pst;
     ResultSet rs;
     SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtid1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtbarcode = new javax.swing.JTextField();
        txtpname = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txtdesc = new javax.swing.JTextField();
        txtq = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        combocat = new javax.swing.JComboBox<>();
        txtdate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        txtid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(null);
        setPreferredSize(new java.awt.Dimension(443, 578));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 957, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbarcode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtbarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbarcodeActionPerformed(evt);
            }
        });
        txtbarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbarcodeKeyTyped(evt);
            }
        });
        jPanel3.add(txtbarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 248, 33));

        txtpname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel3.add(txtpname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 248, 33));

        txtprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpriceKeyTyped(evt);
            }
        });
        jPanel3.add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 248, 33));

        txtdesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel3.add(txtdesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 248, 33));

        txtq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtqKeyTyped(evt);
            }
        });
        jPanel3.add(txtq, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 248, 33));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Barcode #");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 105, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("ProductName");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 105, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Decription");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 105, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Price");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 105, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Quantity");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 105, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Category");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 105, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Expiration Date");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 105, 26));

        jButton5.setBackground(new java.awt.Color(64, 64, 64));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("ADD PRODUCT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 172, 50));

        combocat.setBorder(null);
        combocat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocatActionPerformed(evt);
            }
        });
        jPanel3.add(combocat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 248, 34));

        txtdate.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 248, 31));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 400, 400));

        jLabel10.setBackground(new java.awt.Color(0, 176, 240));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 50, 70));

        jLabel9.setBackground(new java.awt.Color(0, 176, 240));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText(" ADD PRODUCT");
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 100));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    public void addp(){ //Function to add new product
        try {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");

                String  barcode = txtbarcode.getText();
                String  pname = txtpname.getText();
                String  desc = txtdesc.getText();
                String  price = txtprice.getText();
                String  qt = txtq.getText();
                String catt = combocat.getSelectedItem().toString();
                String  date1 = date.format(txtdate.getDate());

                if (barcode.isEmpty() || pname.isEmpty() || desc.isEmpty() || price.isEmpty() ||qt.isEmpty() || catt.isEmpty() || date1.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Fill the Blank.","Error", JOptionPane.ERROR_MESSAGE);
                
                }else{

                userRegister(barcode,pname,desc,price,qt,catt,date1);
                product thread = new product();
                thread.list();
                this.setVisible(false);
                }

           } catch (ClassNotFoundException ex) {
                    Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
                }
                } catch (Exception e) {
                }

            }
   
    public void combo(){    //To get all category into combobox
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            pst = con.prepareStatement("select category from category");

            rs = pst.executeQuery();  

            while(rs.next()){

            String cat = rs.getString("category");
            combocat.addItem(cat);

            }

       } catch (ClassNotFoundException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
     public void searchbarcode(){
     
       String bcode = txtbarcode.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
        pst = con.prepareStatement("select * from product_table where barcode = ?");
        
        pst.setString(1,bcode);   
        rs = pst.executeQuery();  
        
        if (rs.next() == true)
        {
            JOptionPane.showMessageDialog(this,"Barcode already existed!", "Already used", JOptionPane.INFORMATION_MESSAGE);
            txtbarcode.setText("");
            txtbarcode.requestFocus();
        }else{
            addp();
                }
          
   } catch (ClassNotFoundException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        searchbarcode();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid1ActionPerformed

    private void combocatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocatActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_combocatActionPerformed

    private void txtpriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpriceKeyTyped
        char c= evt.getKeyChar();
        if (!(Character.isDigit(c) || (c ==KeyEvent.VK_ENTER) || c==KeyEvent.VK_DELETE)){

            evt.consume();
        }
    }//GEN-LAST:event_txtpriceKeyTyped

    private void txtqKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqKeyTyped
        char c= evt.getKeyChar();
        if (!(Character.isDigit(c) || (c ==KeyEvent.VK_ENTER) || c==KeyEvent.VK_DELETE)){

            evt.consume();
        }
    }//GEN-LAST:event_txtqKeyTyped

    private void txtbarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbarcodeActionPerformed

    private void txtbarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbarcodeKeyTyped
        char c= evt.getKeyChar();
        if (!(Character.isDigit(c) || (c ==KeyEvent.VK_ENTER) || c==KeyEvent.VK_DELETE)){

            evt.consume();
        }
    }//GEN-LAST:event_txtbarcodeKeyTyped

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
            java.util.logging.Logger.getLogger(addprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addprod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combocat;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtbarcode;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtdesc;
    private javax.swing.JTextField txtid1;
    private javax.swing.JTextField txtpname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtq;
    // End of variables declaration//GEN-END:variables
    private void userRegister(String barcode, String pname, String desc, String price, String qt, String catt, String date1) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            
            String qwery = ("insert into product_table(barcode,pname,description,price,qty,category,expiration) values (?,?,?,?,?,?,?)");
            
            PreparedStatement pstm = con.prepareStatement(qwery);
            pstm.setString(1,barcode);
            pstm.setString(2,pname);
            pstm.setString(3,desc);
            pstm.setString(4,price);
            pstm.setString(5,qt);
            pstm.setString(6,catt);
            pstm.setString(7,date1);
            pstm.execute();
            
            JOptionPane.showMessageDialog(this, "Product added!", "Added!", JOptionPane.INFORMATION_MESSAGE);
            
            
            txtid1.setText("");
            txtbarcode.setText("");
            txtpname.setText("");
            txtdesc.setText(""); 
            txtprice.setText(""); 
            txtq.setText(""); 
            
        } catch (ClassNotFoundException ex1) {
            Logger.getLogger(addprod.class.getName()).log(Level.SEVERE, null, ex1);
        }
     
}

}


       
    
        
        
        
    

