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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;
import javax.swing.table.TableModel;
/**
 *
 * @author alex
 */
public class updateprod extends javax.swing.JFrame {

    
    
    public updateprod() {
        initComponents();
        txtid1.setVisible(true);
        txtbarcode.setEditable(false);
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
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtsearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
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
        combocat = new javax.swing.JComboBox<>();
        txtdate = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();

        txtid1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(643, 575));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(0, 176, 240));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText(" UPDATE PRODUCT");
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        jPanel2.setBackground(new java.awt.Color(143, 170, 220));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsearch.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtsearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtsearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
        });
        jPanel2.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("BARCODE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 60, 22));

        jButton3.setBackground(new java.awt.Color(64, 64, 64));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\SearchImg2.png")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 140, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 190, 460));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbarcode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
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

        combocat.setBorder(null);
        combocat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocatActionPerformed(evt);
            }
        });
        jPanel3.add(combocat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 248, 34));

        txtdate.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 248, 31));

        jButton4.setBackground(new java.awt.Color(64, 64, 64));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("UPDATE PRODUCT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 160, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 400, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        
    }//GEN-LAST:event_txtsearchActionPerformed

    public void combo(){ //Funtion to get category into combobox
    
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
    
    
    private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)  //Code for search when keypress txtsearch
        {
            String search = txtsearch.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
                pst = con.prepareStatement("select * from product_table where barcode = ?");

                pst.setString(1,search);

                rs = pst.executeQuery();
                if (rs.next() == false)
                {
                    JOptionPane.showMessageDialog(this,"Product not Found!", "Not found", JOptionPane.WARNING_MESSAGE);
                    txtid1.setText("");
                    txtbarcode.setText("");
                    txtpname.setText("");
                    txtdesc.setText("");
                    txtprice.setText("");
                    txtq.setText("");
                    txtsearch.setText("");
                    combocat.setSelectedItem(0);
                }
                else
                {
                    String id1 = rs.getString("pid");
                    String  barcode = rs.getString("barcode");
                    String  pname = rs.getString("pname");
                    String  desc = rs.getString("description");
                    String  price = rs.getString("price");
                    String  qt = rs.getString("qty");
                    String  cat = rs.getString("category");
                    String  date = rs.getString("expiration");

                    txtid1.setText(id1.trim());
                    txtbarcode.setText(barcode.trim());
                    txtpname.setText(pname.trim());
                    txtdesc.setText(desc.trim());
                    txtprice.setText(price.trim());
                    txtq.setText(qt.trim());
                    combocat.setSelectedItem(cat);
                    ((JTextField)txtdate.getDateEditor().getUiComponent()).setText(date);
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
    }//GEN-LAST:event_txtsearchKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                                                                            // Search when btnsearch clicked
       String date = ((JTextField)txtdate.getDateEditor().getUiComponent()).getText();
       String search = txtsearch.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
        pst = con.prepareStatement("select * from product_table where barcode = ?");
        
         pst.setString(1,search);   
        rs = pst.executeQuery();  
        
        if (rs.next() == false)
        {
            JOptionPane.showMessageDialog(this,"Product not Found!", "Not found", JOptionPane.WARNING_MESSAGE);
                    txtid1.setText("");
                    txtbarcode.setText("");
                    txtpname.setText("");
                    txtdesc.setText("");
                    txtprice.setText("");
                    txtq.setText("");
                    txtsearch.setText("");
                    combocat.setSelectedItem(0);
        }
        else
        {
            
            String id1 = rs.getString("pid");
            String  barcode = rs.getString("barcode");
            String  pname = rs.getString("pname");
            String  desc = rs.getString("description");
            String  price = rs.getString("price");
            String  qt = rs.getString("qty");
            String  cat = rs.getString("category");
            date = rs.getString("expiration");
        
            txtid1.setText(id1.trim());
            txtbarcode.setText(barcode.trim());
            txtpname.setText(pname.trim());
            txtdesc.setText(desc.trim()); 
            txtprice.setText(price.trim()); 
            txtq.setText(qt.trim()); 
            combocat.setSelectedItem(cat.trim()); 
            ((JTextField)txtdate.getDateEditor().getUiComponent()).setText(date);
        }
        
   } catch (ClassNotFoundException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void combocatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocatActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_combocatActionPerformed

    
    public void update(){   //Function to update product
        try {
            try {
                String  id =  txtid1.getText();
                String  barcode = txtbarcode.getText();
                String  pname = txtpname.getText();
                String  desc = txtdesc.getText();
                String  price = txtprice.getText();
                String  qt = txtq.getText();
                String cat = combocat.getSelectedItem().toString(); 
                String  date1 = date.format(txtdate.getDate());
                Date date;
                date = txtdate.getDate();
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
                String sql1 = "update product_table set pid = '"+id+"', barcode = '"+barcode+"', pname = '"+pname+"', description = '"+desc+"', price = '"+price+"', qty = '"+qt+"', category = '"+cat+"', expiration = '"+date1+"' where pid = '"+id+"'";
                pst = con.prepareStatement(sql1);
                pst.execute();

                if (barcode.isEmpty() || pname.isEmpty() || desc.isEmpty() || price.isEmpty() ||qt.isEmpty() || cat.isEmpty()){

                    if (date == null){

                            }
                JOptionPane.showMessageDialog(null, "Fill the Blank.","Error", JOptionPane.ERROR_MESSAGE);
                }else{

               JOptionPane.showMessageDialog(this, "Updated successfully!", "Update success!", JOptionPane.INFORMATION_MESSAGE);
                }  
               // product pr = new product();
                prod p = new prod();
                 
            
                this.setVisible(false);
                    txtid1.setText("");
                    txtbarcode.setText("");
                    txtpname.setText("");
                    txtdesc.setText(""); 
                    txtprice.setText(""); 
                    txtq.setText(""); 
                    txtsearch.setText("");
                    combocat.setSelectedIndex(0);
     
   } catch (ClassNotFoundException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (Exception e) {
        }
    
    }
    
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        update();   // Call function update

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(updateprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateprod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combocat;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtbarcode;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtdesc;
    private javax.swing.JTextField txtid1;
    private javax.swing.JTextField txtpname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtq;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
