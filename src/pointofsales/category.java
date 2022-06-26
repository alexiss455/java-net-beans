/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsales;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author 2020
 */
public class category extends javax.swing.JFrame {

    /**
     * Creates new form category
     */
    public category() {
        initComponents();
        
      list();
    }

    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        btnadd2 = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        txtcat = new javax.swing.JTextField();
        txtdesc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(830, 665));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(143, 170, 220));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnadd2.setBackground(new java.awt.Color(64, 64, 64));
        btnadd2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnadd2.setForeground(new java.awt.Color(255, 255, 255));
        btnadd2.setText("UPDATE CATEGORY");
        btnadd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadd2ActionPerformed(evt);
            }
        });
        jPanel5.add(btnadd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, 70));

        btnadd.setBackground(new java.awt.Color(64, 64, 64));
        btnadd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setText("ADD CATEGORY");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel5.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 210, 70));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 240, 520));

        jPanel6.setBackground(new java.awt.Color(0, 176, 240));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 176, 240));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\Imgs\\CategoryIcon - BLUESMALL.jpg")); // NOI18N
        jLabel4.setOpaque(true);
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 90, 80));

        jLabel3.setBackground(new java.awt.Color(0, 176, 240));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText(" CATEGORY");
        jLabel3.setOpaque(true);
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 110));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 110));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category", "Description"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 310));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 540, 310));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtcat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcatActionPerformed(evt);
            }
        });
        jPanel8.add(txtcat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 264, 33));

        txtdesc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtdesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel8.add(txtdesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 264, 33));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Category");
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 112, 37));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Description");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 112, 37));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 530, 170));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 660, 79, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
   public void addp(){
        String  cat = txtcat.getText();
        String  desc = txtdesc.getText();
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            pst = con.prepareStatement("select * from category where category = ?");
        
            pst.setString(1,cat);   
            rs = pst.executeQuery(); 
            
            if(rs.next() == true){
                JOptionPane.showMessageDialog(this,"Category already existed!", "Try again!", JOptionPane.INFORMATION_MESSAGE);
                txtcat.setText("");
                txtdesc.setText("");
                txtcat.requestFocus();
            }
            else if (cat.isEmpty() || desc.isEmpty()){
                JOptionPane.showMessageDialog(this, "Fill the Blank.","Error", JOptionPane.ERROR_MESSAGE);
            }
            else{

            userRegister(cat,desc);
            list();
            }
           
   } catch (ClassNotFoundException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    
    
    public void list(){
    int cc;
        try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            
           String sql = "select * from category";
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
    
        
    }
    
    
    private void txtcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcatActionPerformed
        
    }//GEN-LAST:event_txtcatActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed

    addp();

    
    
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnadd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadd2ActionPerformed

    try {
        String cat = txtcat.getText();
        String desc = txtdesc.getText();
        String id = txtid.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
                String sql1 = "update category set category = ?, description = ? where idcat = ?";
                pst = con.prepareStatement(sql1);
                pst.setString(1, cat);
                pst.setString(2, desc);
                pst.setString(3, id);
                pst.execute();


                    txtcat.setText("");
                    txtdesc.setText("");

                    if (cat.isEmpty() || desc.isEmpty())
                    {
                         JOptionPane.showMessageDialog(this, "Cannot Update the Blank.","Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                     JOptionPane.showMessageDialog(this,"Updated successfully!", "Updated", JOptionPane.INFORMATION_MESSAGE);
                     list();
                    }
            } catch (ClassNotFoundException ex) {
                     Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (SQLException ex) {
                     Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
                 }
        
    }//GEN-LAST:event_btnadd2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
                                                                        // Set all click data into txtbox
        DefaultTableModel tblmodel = (DefaultTableModel) jTable1.getModel();

        String tblid = tblmodel.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String tblcat = tblmodel.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String tbldesc = tblmodel.getValueAt(jTable1.getSelectedRow(), 2).toString();

        txtid.setText(tblid);
        txtcat.setText(tblcat);
        txtdesc.setText(tbldesc);
        
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnadd2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcat;
    private javax.swing.JTextField txtdesc;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables

    private void userRegister(String cat, String desc) throws SQLException {
       
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            
            String qwery = ("insert into category(category,description) values (?,?)");
            
            PreparedStatement pstm = con.prepareStatement(qwery);
            pstm.setString(1,cat);
            pstm.setString(2,desc);
            pstm.execute();
            
            JOptionPane.showMessageDialog(this, "Category added successfully!", "Category added", JOptionPane.INFORMATION_MESSAGE);
            
            txtcat.setText("");
            txtdesc.setText("");
            
        } catch (ClassNotFoundException ex1) {
            Logger.getLogger(addprod.class.getName()).log(Level.SEVERE, null, ex1);
        }
     
}

   
        
    }

