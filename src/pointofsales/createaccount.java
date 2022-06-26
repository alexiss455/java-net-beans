/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsales;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;

/**
 *
 * @author 2020
 */
public class createaccount extends javax.swing.JFrame {

    
    public createaccount() {
        initComponents();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtid = new javax.swing.JTextField();
        jSpinnerDateEditor1 = new com.toedter.calendar.JSpinnerDateEditor();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblupdateacc = new javax.swing.JLabel();
        lbllistacc = new javax.swing.JLabel();
        lblexit = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtno = new javax.swing.JTextField();
        txtuser = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtfname = new javax.swing.JTextField();
        txtlname = new javax.swing.JTextField();
        btnacc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtrole = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(717, 580));
        setMinimumSize(new java.awt.Dimension(717, 580));
        setPreferredSize(new java.awt.Dimension(717, 580));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(143, 170, 220));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(143, 170, 220));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Manage Account");
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 100, 40));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\AccountIcon - PURPLE.png")); // NOI18N
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 160, 140));

        lblupdateacc.setBackground(new java.awt.Color(64, 64, 64));
        lblupdateacc.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblupdateacc.setForeground(new java.awt.Color(255, 255, 255));
        lblupdateacc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblupdateacc.setText("UPDATE ACCOUNT");
        lblupdateacc.setOpaque(true);
        lblupdateacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblupdateaccMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblupdateaccMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblupdateaccMouseExited(evt);
            }
        });
        jPanel1.add(lblupdateacc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 50));

        lbllistacc.setBackground(new java.awt.Color(64, 64, 64));
        lbllistacc.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbllistacc.setForeground(new java.awt.Color(255, 255, 255));
        lbllistacc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllistacc.setText("LIST OF ACCOUNTS");
        lbllistacc.setOpaque(true);
        lbllistacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllistaccMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbllistaccMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbllistaccMouseExited(evt);
            }
        });
        jPanel1.add(lbllistacc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 210, 50));

        lblexit.setBackground(new java.awt.Color(64, 64, 64));
        lblexit.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblexit.setForeground(new java.awt.Color(255, 255, 255));
        lblexit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblexit.setText("EXIT");
        lblexit.setOpaque(true);
        lblexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblexitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblexitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblexitMouseExited(evt);
            }
        });
        jPanel1.add(lblexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 210, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 220, 680));

        jLabel8.setBackground(new java.awt.Color(0, 176, 240));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\FrmAccountHeaderWithLogo.png")); // NOI18N
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 500, 100));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtno.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoActionPerformed(evt);
            }
        });
        txtno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnoKeyTyped(evt);
            }
        });
        jPanel2.add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 210, 30));

        txtuser.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtuser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtuser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        jPanel2.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 210, 30));

        txtaddress.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtaddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtaddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 210, 30));

        txtfname.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtfname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 210, 30));

        txtlname.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtlname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtlname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.add(txtlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 210, 30));

        btnacc.setBackground(new java.awt.Color(64, 64, 64));
        btnacc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnacc.setForeground(new java.awt.Color(255, 255, 255));
        btnacc.setText("CREATE ACCOUNT");
        btnacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaccActionPerformed(evt);
            }
        });
        jPanel2.add(btnacc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 200, 55));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("FIRST NAME ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("LAST NAME");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("ADDRESS");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("CONTACT NO.");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 110, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("USERNAME");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("PASSWORD");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, 30));

        txtrole.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtrole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Cashier" }));
        jPanel2.add(txtrole, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 210, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("ROLE");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 100, 30));

        txtpass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 210, 30));

        jCheckBox1.setText(" Show Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 140, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 400, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void lblupdateaccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblupdateaccMouseClicked
        updateacc ua = new updateacc();
        ua.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblupdateaccMouseClicked

    private void lblupdateaccMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblupdateaccMouseEntered
        lblupdateacc.setBackground(new Color(167,165,165));
    }//GEN-LAST:event_lblupdateaccMouseEntered

    private void lblupdateaccMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblupdateaccMouseExited
        lblupdateacc.setBackground(new Color(64,64,64));
    }//GEN-LAST:event_lblupdateaccMouseExited

    private void lbllistaccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllistaccMouseClicked
        listaccount la = new listaccount();
        la.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbllistaccMouseClicked

    private void lbllistaccMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllistaccMouseEntered
        lbllistacc.setBackground(new Color(167,165,165));
    }//GEN-LAST:event_lbllistaccMouseEntered

    private void lbllistaccMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllistaccMouseExited
        lbllistacc.setBackground(new Color(64,64,64));
    }//GEN-LAST:event_lbllistaccMouseExited

    private void lblexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexitMouseClicked
        menuforn menu = new menuforn();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblexitMouseClicked

    private void lblexitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexitMouseEntered
        lblexit.setBackground(new Color(167,165,165));
    }//GEN-LAST:event_lblexitMouseEntered

    private void lblexitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexitMouseExited
        lblexit.setBackground(new Color(64,64,64));
    }//GEN-LAST:event_lblexitMouseExited

    private void txtnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnoActionPerformed

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

    private void btnaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaccActionPerformed

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String  user = txtuser.getText();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            pst = con.prepareStatement("select * from account_table where username = ?");
        
            pst.setString(1,user);   
            rs = pst.executeQuery(); 
            
            String  fname = txtfname.getText();
            String  lname = txtlname.getText();
            String  address = txtaddress.getText();
            String  no = txtno.getText();
            String  pass = String.valueOf(txtpass.getPassword());
            String role = txtrole.getSelectedItem().toString();
            
            if (rs.next() != false){
                JOptionPane.showMessageDialog(this, "Username already existed. Please use another username", "Username already used", JOptionPane.INFORMATION_MESSAGE);
                txtuser.setText("");
                txtuser.requestFocus();
            }
            else if (fname.isEmpty() || lname.isEmpty() || address.isEmpty() || no.isEmpty() || user.isEmpty() || pass.isEmpty() || role.isEmpty()){

                JOptionPane.showMessageDialog(this, "Fill the Blank.","Error", JOptionPane.ERROR_MESSAGE);
            }else{

                userRegister(fname,lname,address,no,user,pass,role);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnaccActionPerformed

    private void txtnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnoKeyTyped

        char c= evt.getKeyChar();
               if (!(Character.isDigit(c) || (c ==KeyEvent.VK_ENTER) || c==KeyEvent.VK_DELETE)){
                   evt.consume();
               }

       
    }//GEN-LAST:event_txtnoKeyTyped

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        JPasswordField password = txtpass;

   if (jCheckBox1.isSelected()) {
      password.setEchoChar((char)0); //password = JPasswordField
   } else {
      password.setEchoChar('*');
   }

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(createaccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createaccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createaccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createaccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createaccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnacc;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JSpinnerDateEditor jSpinnerDateEditor1;
    private javax.swing.JLabel lblexit;
    private javax.swing.JLabel lbllistacc;
    private javax.swing.JLabel lblupdateacc;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtno;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JComboBox<String> txtrole;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables

    private void userRegister(String fname, String lname, String address, String no, String user, String pass, String role) {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");    
        String qwery = ("insert into account_table (fname,lname,address,contact,username,password,role) values (?,?,?,?,?,?,?)");

            PreparedStatement pstm = con.prepareStatement(qwery);
              pstm.setString(1,fname);
              pstm.setString(2,lname);
              pstm.setString(3,address);
              pstm.setString(4,no);
              pstm.setString(5,user);
              pstm.setString(6,pass);
              pstm.setString(7,role);
              pstm.execute(); 

          JOptionPane.showMessageDialog(this, "Created successfully!", "Successfully", JOptionPane.INFORMATION_MESSAGE);

          txtfname.setText("");
          txtlname.setText("");
          txtaddress.setText("");
          txtno.setText("");
          txtuser.setText("");
          txtpass.setText("");

       } catch (ClassNotFoundException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }

    private void fetch() {
        
    }
}
