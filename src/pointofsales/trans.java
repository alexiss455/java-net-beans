/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;

/**
 *
 * @author 2020
 */
public class trans extends javax.swing.JFrame {

    /**
     * Creates new form trans
     */
    public trans() {
        initComponents();    
        date2();
        times();
        qtyy.setVisible(false);
    }
    String lname;
    
     public trans(String name) {
        initComponents();    
       
        this.lname = name;
        lblname.setText(name);
        
    }
Connection con;
PreparedStatement pst;
ResultSet rs;

public void invoice()
{
        try {
            Statement str;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
           
            str = con.createStatement();
            rs = str.executeQuery("select MAX(idinvoice) from transaction");
            rs.next();
            
            rs.getString ("MAX(idinvoice)");
            
            if (rs.getString("MAX(idinvoice)")== null){
                
                txtinvoice.setText("E-0000001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("MAX(idinvoice)").substring(2,rs.getString("MAX(idinvoice)").length()));
                id++;
                txtinvoice.setText("E-" + String.format("%07d",id));
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        }
  
}       
        public void voidItem(){
        try {    
               DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.removeRow(jTable1.getSelectedRow());
        int sum= 0;
        for(int i=0; i<jTable1.getRowCount();i++){
            sum =sum  + Integer.parseInt(jTable1.getValueAt(i, 4).toString());
        }
        txttotal.setText(Integer.toString(sum));
        } catch (Exception e) {
        }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        qtyy = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblname = new javax.swing.JLabel();
        txttime = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtinvoice = new javax.swing.JLabel();
        txtdate = new javax.swing.JLabel();
        lblname1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtpcode = new javax.swing.JTextField();
        txttnew = new javax.swing.JButton();
        txtqty = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtpname = new javax.swing.JLabel();
        txtbalance = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtprint = new javax.swing.JButton();
        btnpayment = new javax.swing.JButton();
        txtpay = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtdisc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnpayment1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtcancel = new javax.swing.JButton();
        txtbefore = new javax.swing.JTextField();
        disc = new javax.swing.JTextField();
        totalamount = new javax.swing.JTextField();
        balancetxt = new javax.swing.JTextField();
        lblcancel = new javax.swing.JLabel();
        lblsucess = new javax.swing.JLabel();
        txt12 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        role1 = new javax.swing.JLabel();
        txtpass1 = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtpass2 = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        role2 = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));
        setMinimumSize(new java.awt.Dimension(1320, 720));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 176, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblname.setText("Anthony Pablo");
        jPanel1.add(lblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 160, 30));

        txttime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txttime.setForeground(new java.awt.Color(255, 0, 0));
        txttime.setText("TIME");
        jPanel1.add(txttime, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 121, 31));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\LogoutIcon.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 40, 40));

        txtinvoice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtinvoice.setForeground(new java.awt.Color(255, 0, 0));
        txtinvoice.setText("TRNCODE");
        jPanel1.add(txtinvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 30));

        txtdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtdate.setForeground(new java.awt.Color(255, 0, 0));
        txtdate.setText("DATE");
        jPanel1.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 148, 31));

        lblname1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblname1.setText("Cashier:");
        jPanel1.add(lblname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("BARCODE#");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 150, 21));

        txtpcode.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtpcode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpcode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtpcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpcodeActionPerformed(evt);
            }
        });
        txtpcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpcodeKeyPressed(evt);
            }
        });
        jPanel1.add(txtpcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 240, 40));

        txttnew.setBackground(new java.awt.Color(153, 255, 153));
        txttnew.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txttnew.setText("Click here to transact");
        txttnew.setBorder(null);
        txttnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttnewActionPerformed(evt);
            }
        });
        jPanel1.add(txttnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 230, 50));

        txtqty.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtqty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtqty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });
        txtqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtqtyKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtqtyKeyTyped(evt);
            }
        });
        jPanel1.add(txtqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 110, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("QUANTITY");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));

        txtpname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtpname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpname.setText("--------------");
        jPanel1.add(txtpname, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 170, 20));

        txtbalance.setBackground(new java.awt.Color(255, 255, 255));
        txtbalance.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        txtbalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtbalance.setText("00");
        jPanel1.add(txtbalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 60, 180, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CHANGE");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 40, 220, 21));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("₱");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 50, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 150));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("PRODUCT NAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 790, 130, 21));
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 800, 152, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("PRICE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 790, 70, 21));

        jPanel3.setBackground(new java.awt.Color(143, 170, 220));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtprint.setBackground(new java.awt.Color(64, 64, 64));
        txtprint.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtprint.setForeground(new java.awt.Color(255, 255, 255));
        txtprint.setText("PRINT");
        txtprint.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        txtprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprintActionPerformed(evt);
            }
        });
        jPanel3.add(txtprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 250, 70));

        btnpayment.setBackground(new java.awt.Color(64, 64, 64));
        btnpayment.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnpayment.setForeground(new java.awt.Color(255, 255, 255));
        btnpayment.setText("SETTLE PAYMENT");
        btnpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpaymentActionPerformed(evt);
            }
        });
        jPanel3.add(btnpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 230, 50));

        txtpay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtpay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpayActionPerformed(evt);
            }
        });
        txtpay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpayKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpayKeyTyped(evt);
            }
        });
        jPanel3.add(txtpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 230, 40));

        jLabel10.setBackground(new java.awt.Color(0, 176, 240));
        jLabel10.setOpaque(true);
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -90, 170, 90));

        txtdisc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtdisc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdisc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtdisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiscActionPerformed(evt);
            }
        });
        txtdisc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdiscKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdiscKeyTyped(evt);
            }
        });
        jPanel3.add(txtdisc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 180, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DISCOUNT");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 142, 230, 30));

        btnpayment1.setBackground(new java.awt.Color(64, 64, 64));
        btnpayment1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnpayment1.setForeground(new java.awt.Color(255, 255, 255));
        btnpayment1.setText("ADD DISCOUNT");
        btnpayment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpayment1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnpayment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 230, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PAYMENT");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 230, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("%");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 50, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 150, 320, 540));

        jPanel2.setBackground(new java.awt.Color(0, 176, 240));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel7.setText("TOTAL ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 110, 50));

        txttotal.setFont(new java.awt.Font("Tahoma", 1, 90)); // NOI18N
        txttotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txttotal.setText("00");
        jPanel2.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 380, 100));

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("VOID ITEM");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 160, 80));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel9.setText("AMOUNT");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 130, 50));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 55)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("₱");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 60, 50));

        txtcancel.setBackground(new java.awt.Color(255, 102, 102));
        txtcancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtcancel.setText("Cancel transact");
        txtcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcancelActionPerformed(evt);
            }
        });
        jPanel2.add(txtcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 180, 80));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1310, 140));
        getContentPane().add(txtbefore, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 830, 50, -1));

        disc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discActionPerformed(evt);
            }
        });
        getContentPane().add(disc, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 820, 80, 30));
        getContentPane().add(totalamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 820, 100, 30));

        balancetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balancetxtActionPerformed(evt);
            }
        });
        getContentPane().add(balancetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 820, 90, 30));

        lblcancel.setText("Cancelled");
        getContentPane().add(lblcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 780, -1, -1));

        lblsucess.setText("Successfully");
        getContentPane().add(lblsucess, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 780, -1, -1));

        txt12.setText("0.00");
        getContentPane().add(txt12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 790, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 176, 240));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        role1.setText("admin");
        jPanel6.add(role1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 40, -1));

        txtpass1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtpass1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpass1.setBorder(null);
        txtpass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpass1KeyPressed(evt);
            }
        });
        jPanel6.add(txtpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 220, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Enter password:");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 210, 30));

        jButton4.setBackground(new java.awt.Color(64, 64, 64));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("X");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 0, -1, 30));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 410, 150));

        jPanel4.setBackground(new java.awt.Color(0, 176, 240));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtpass2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtpass2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpass2.setBorder(null);
        txtpass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpass2KeyPressed(evt);
            }
        });
        jPanel4.add(txtpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 220, 40));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Enter password:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 160, -1));

        jButton5.setBackground(new java.awt.Color(64, 64, 64));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("X");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        role2.setText("admin");
        jPanel4.add(role2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 410, 150));

        panel4.setBackground(new java.awt.Color(204, 204, 255));
        panel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbill.setColumns(20);
        txtbill.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtbill.setRows(5);
        jScrollPane2.setViewportView(txtbill);

        panel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 420));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Confirm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, -1));

        getContentPane().add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 340, 480));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "ProductName", "Quantity", "Price", "Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 990, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void sales1(){
    
       try{
                                    
                    String  bar = txtinvoice.getText();
                    String tot  = txttotal.getText();
                    String disc1 = disc.getText();
                    String  lbln = lblname.getText();
                    String  date = txtdate.getText();
                    String  sucess = lblsucess.getText();
                    //insert into database table
                    String qwery = ("insert into sales(Transaction_Code,Totalamount,Discount,Date,Cashier,Status) values (?,?,?,?,?,?)");
                    
                    PreparedStatement pstm = con.prepareStatement(qwery);
                    //parameters numbers insert to database
                    
                    pstm.setString(1,bar);
                    pstm.setString(2,tot);
                    pstm.setString(3,disc1);
                    pstm.setString(4,date);
                    pstm.setString(5,lbln);
                    pstm.setString(6,sucess);
                    pstm.execute();
    } catch (SQLException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void txtprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprintActionPerformed
      try {
            panel4.show();
            bill();
            
            } catch (PrinterException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }//GEN-LAST:event_txtprintActionPerformed

    private void txtpcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpcodeKeyPressed
        // key code for enter commaand
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String pcode = txtpcode.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
                pst = con.prepareStatement("select * from product_table where barcode = ?");

                pst.setString(1,pcode);
                rs = pst.executeQuery();

                if (rs.next() == false)
                {
                    JOptionPane.showMessageDialog(this,"Not Found");
                }
                else
                {
                    String pname = rs.getString("pname");
                    String price = rs.getString("price");
                    String qt = rs.getString("qty");

                    txtpname.setText(pname.trim());
                    qtyy.setText(qt.trim());
                    txtprice.setText(price.trim());
                    txtqty.requestFocus();
                    txtqty.setText("1");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtpcodeKeyPressed

    private void txtpcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpcodeActionPerformed

    private void txtpayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpayKeyTyped

        char c= evt.getKeyChar();
        if (!(Character.isDigit(c) || (c ==KeyEvent.VK_ENTER) || c==KeyEvent.VK_DELETE)){

            evt.consume();
        }
        
       
        
    }//GEN-LAST:event_txtpayKeyTyped

    private void txtpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpayActionPerformed

    private void txttnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttnewActionPerformed
        times();
        date2();
        
        txtpcode.setEditable(true);
        txtqty.setEditable(true);
        txtpay.setEditable(true);
        txtcancel.setEnabled(true);
        
        jButton2.setEnabled(true);
        btnpayment.setEnabled(true);
        txttnew.setEnabled(false);
        
        txtpcode.requestFocus();
        txtpname.setText("--------------");
        txttotal.setText("00");
        txtbalance.setText("00");
        txtbill.setText("");
        txtdisc.setText("");
        disc.setText("00");
        txtbefore.setText("");
        txtpay.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        invoice();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            String  no = txtinvoice.getText();
            String  name = lblname.getText();
            String  date = txtdate.getText();
           
            pst = con.prepareStatement("insert into transaction(idinvoice,cashier,transdate) values (?,?,?)");
            pst.setString(1,no);
            pst.setString(2,name);
            pst.setString(3,date);
          
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"New transaction!", "New", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txttnewActionPerformed

    private void btnpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpaymentActionPerformed
            try{
            int tpay = Integer.parseInt(txtpay.getText());
            int totalA = Integer.parseInt(txttotal.getText());
            if(tpay < totalA){
                JOptionPane.showMessageDialog(this, "Insufficient payment!", "Please try again.", JOptionPane.WARNING_MESSAGE);
                txtpay.setText("");
                txtpay.requestFocus();
            }else{
                balance();
                txtprint.setEnabled(true);
                jButton2.setEnabled(false);
                btnpayment1.setEnabled(true);
            }
            }catch(Exception e){
            }
        
    }//GEN-LAST:event_btnpaymentActionPerformed

    private void txtqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqtyKeyTyped
        char c= evt.getKeyChar();
        if (!(Character.isDigit(c) || (c ==KeyEvent.VK_ENTER) || c==KeyEvent.VK_DELETE)){

            evt.consume();
        }
        
       
    }//GEN-LAST:event_txtqtyKeyTyped

    private void txtqtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqtyKeyPressed
        try {
            
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String pcode = txtpcode.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
                pst = con.prepareStatement("select * from product_table where barcode = ?");
                pst.setString(1,pcode);
                rs = pst.executeQuery();
                while (rs.next()){
                    int curr;
                    curr = rs.getInt("qty");
                    int price = Integer.parseInt(txtprice.getText());
                    int qty1 = Integer.parseInt(txtqty.getText());
                    int tot = price * qty1;

                    if (qty1 > curr){

                        JOptionPane.showMessageDialog(this,"Available product = "+ curr +" Quantiity is not Enough");
                        txtqty.setText("");
                        txtqty.requestFocus();
                    }
                    else {

                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.addRow(new Object[]
                            {
                                txtpcode.getText(),
                                txtpname.getText(),
                                txtqty.getText(),
                                txtprice.getText(),
                                tot

                            });

                            int sum= 0;
                            for(int i=0; i<jTable1.getRowCount();i++){
                                sum =sum  + Integer.parseInt(jTable1.getValueAt(i, 4).toString());
                                
                            }
                            txttotal.setText(Integer.toString(sum));
                            txtbefore.setText(Integer.toString(sum)); 
                            txtpcode.setText("");
                            txtpname.setText("");
                            txtqty.setText("");
                            txtprice.setText("");
                            txtpcode.requestFocus();
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception e) {
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_txtqtyKeyPressed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // CODE TO LOGOUT
        int response = JOptionPane.showConfirmDialog(this, "Do you want to logout?" ,"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(response==JOptionPane.YES_OPTION){
        login log = new login();
        log.setVisible(true);
        this.setVisible(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton4.doClick();
        jPanel6.show(true);
        txtpass1.requestFocus();
        jButton2.setEnabled(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtdiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiscActionPerformed

    private void btnpayment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpayment1ActionPerformed
        jButton5.doClick();
        jPanel4.show(true);
        
        txtpass2.requestFocus();
        btnpayment1.setEnabled(false);
    }//GEN-LAST:event_btnpayment1ActionPerformed

    private void txtdiscKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscKeyTyped
        char c= evt.getKeyChar();
        if (!(Character.isDigit(c) || (c ==KeyEvent.VK_ENTER) || c==KeyEvent.VK_DELETE)){

            evt.consume();
        }
        
        
    }//GEN-LAST:event_txtdiscKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        panel4.hide();
        jPanel6.hide();
        jPanel4.hide();
        txtpcode.setEditable(false);
        txtqty.setEditable(false);
        txtpay.setEditable(false);
        txtdisc.setEditable(false);
        
        jButton2.setEnabled(false);
        txtprint.setEnabled(false);
        btnpayment.setEnabled(false);
        btnpayment1.setEnabled(false);
        txtcancel.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void balancetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balancetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balancetxtActionPerformed

    private void discActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discActionPerformed

    private void txtpayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpayKeyReleased
        
    }//GEN-LAST:event_txtpayKeyReleased

    private void txtdiscKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscKeyReleased
        try{
        String strdisc = txtdisc.getText();
        int intdisc = Integer.parseInt(strdisc);
        if (intdisc > 50){
            JOptionPane.showMessageDialog(this, "Maximum of 50% discount!", "Maximun 50%", JOptionPane.INFORMATION_MESSAGE);
            txtdisc.setText("");
            txtdisc.requestFocus();
        }    
        }catch(Exception e){
                }
    }//GEN-LAST:event_txtdiscKeyReleased

    private void txtcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcancelActionPerformed
        
        try {
        try{                        
                    //int response = 0;
                 int response = JOptionPane.showConfirmDialog(this, "Do you want to Cancel?" ,"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response!=JOptionPane.YES_OPTION)
                {
                 
        
                } else if(response==JOptionPane.YES_OPTION){
                    
                    String  bar = txtinvoice.getText();
                    String tot  = txt12.getText();
                    String disc1 = disc.getText();
                    String  lbln = lblname.getText();
                    String  date = txtdate.getText();
                    String  cancel = lblcancel.getText();
                    //insert into database table
                    pst = con.prepareStatement("insert into sales(Transaction_Code,Totalamount,Discount,Date,Cashier,Status) values (?,?,?,?,?,?)");
                    
                  //  PreparedStatement pstm = con.prepareStatement(qwery);
                    //parameters numbers insert to database
                    
                    pst.setString(1,bar);
                    pst.setString(2,tot);
                    pst.setString(3,disc1);
                    pst.setString(4,date);
                    pst.setString(5,lbln);
                    pst.setString(6,cancel);
                    pst.execute();
                    String no = txtinvoice.getText();
                    String date1 = txtdate.getText();
                    String lbln1 = lblname.getText();
                    String time = txttime.getText();
                    //insert into database table
                    pst = con.prepareStatement("insert into invoiced(barcode,prodname,qty,price,amount,payment,discount,balance,invoiced,time,date,cashier,status) values (null,null,null,null,null,null,null,null,?,?,?,?,?)");
                    //PreparedStatement pstm1 = con.prepareStatement(qwery1);
                    //parameters numbers insert to database
                    pst.setString(1,no);
                    pst.setString(2,time);
                    pst.setString(3,date1);
                    pst.setString(4,lbln1);
                    pst.setString(5,cancel);
                    pst.execute();
                   
                    txtpname.setText("--------------");
                    txttotal.setText("00");
                    txtbalance.setText("00");
                    txtbill.setText("");
                    txtdisc.setText("");
                    disc.setText("00");
                    txtbefore.setText("");
                    txtpay.setText("");
                    txtinvoice.setText("TRNCODE");
                    txttnew.setEnabled(true);
                    txtcancel.setEnabled(false);
                    jButton2.setEnabled(false);
                    txtprint.setEnabled(false);
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                    
                    }     
                    
                  
                              
          
        } catch (SQLException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  } catch (Exception e) {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtcancelActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            txtbill.print();
            panel4.hide();
            sales1();
            DefaultTableModel tblmodel = (DefaultTableModel) jTable1.getModel();
            String pid,pname,qty,price,amount,barcode;
            try {
                for (int i = 0; i < tblmodel.getRowCount(); i++){
                    String  no = txtinvoice.getText();
                    barcode = tblmodel.getValueAt(i,0).toString();
                    pname = tblmodel.getValueAt(i,1).toString();
                    qty = tblmodel.getValueAt(i,2).toString();
                    price = tblmodel.getValueAt(i,3).toString();
                    amount = tblmodel.getValueAt(i,4).toString();
                    String  date = txtdate.getText();
                    String  lbln = lblname.getText();
                    String time = txttime.getText();
                    String  pay = txtpay.getText();
                    String bal  = balancetxt.getText(); 
                    String disc1 = disc.getText();
                    String suc  = lblsucess.getText();
                    //insert into database table
                    String qwery = ("insert into invoiced(barcode,prodname,qty,price,amount,payment,discount,balance,invoiced,time,date,cashier,status) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    
                    PreparedStatement pstm = con.prepareStatement(qwery);
                    //parameters numbers insert to database
                    pstm.setString(1,barcode);
                    pstm.setString(2,pname);
                    pstm.setString(3,qty);
                    pstm.setString(4,price);
                    pstm.setString(5,amount);
                    pstm.setString(6,pay);
                    pstm.setString(7,disc1);
                    pstm.setString(8,bal);
                    pstm.setString(9,no);
                    pstm.setString(10,time);
                    pstm.setString(11,date);
                    pstm.setString(12,lbln);
                    pstm.setString(13,suc);
                    pstm.execute();
                    
                }
                //qwery for update quantity
                String qwery1 = "update product_table set qty = qty - ?  where barcode = ?   ";
                PreparedStatement pstm1 = con.prepareStatement(qwery1);
                for (int i = 0; i < jTable1.getRowCount(); i++){
                    pid = (String)jTable1.getValueAt(i,0);
                    qty = (String)jTable1.getValueAt(i,2);
                    
                    pstm1.setString(1, qty);
                    pstm1.setString(2, pid);
                    pstm1.executeUpdate();
                }
                
                pstm1.addBatch();
                
                try{
                txtpcode.setEditable(false);
                txtqty.setEditable(false);
                txtpay.setEditable(false);
                txtdisc.setEditable(false);
                txtbalance.setText("0");
                txtpay.setText("");
                txtdisc.setText("");
                txttotal.setText("0");
                txtqty.setText("");

                jButton2.setEnabled(false);
                txtprint.setEnabled(false);
                btnpayment.setEnabled(false);
                btnpayment1.setEnabled(false);
                txtcancel.setEnabled(false);
                txttnew.setEnabled(true);
                
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                }catch(Exception e){
           }
            } catch (SQLException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            }
             txtinvoice.setText("TRNCODE");
            // TODO add your handling code here:
        } catch (PrinterException ex) {
            Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtpass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass1KeyPressed
        String strrole = role1.getText();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
                pst = con.prepareStatement("select * from account_table where password =? and role = ?");
                pst.setString(1, String.valueOf(txtpass1.getPassword()));
                pst.setString(2 , String.valueOf(strrole));
                rs = pst.executeQuery();
                if (rs.next())
                {
                    voidItem();
                    jPanel6.hide();
                    jButton2.setEnabled(true);
                    txtpass1.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(this,"Password is incorrect!", "Incorrect!", JOptionPane.ERROR_MESSAGE);
                    txtpass1.setText("");
                    txtpass1.requestFocus();

                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtpass1KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jPanel6.hide();
        txtpass1.setText("");
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtpass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass2KeyPressed
        String strrole = role2.getText();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
                pst = con.prepareStatement("select * from account_table where password =? and role = ?");
                pst.setString(1, String.valueOf(txtpass2.getPassword()));
                pst.setString(2 , String.valueOf(strrole));
                rs = pst.executeQuery();
                if (rs.next())
                {
                    txtdisc.setEditable(true);
                    jPanel4.hide();
                    btnpayment1.setEnabled(true);
                    txtpass2.setText("");
                    txtdisc.requestFocus();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Password is incorrect!", "Incorrect!", JOptionPane.ERROR_MESSAGE);
                    txtpass2.setText("");
                    txtpass2.requestFocus();

                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtpass2KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jPanel4.hide();
        txtpass2.setText("");
        btnpayment1.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtdiscKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
        try {    
                    DecimalFormat df = new DecimalFormat(".00");
                    DecimalFormat df1 = new DecimalFormat(".00");
                    double disc1 = Double.parseDouble(txtdisc.getText()); 
                    double total = Double.parseDouble(txttotal.getText());     
                    double bal = total * disc1/100;  
                    disc.setText(String.valueOf(df1.format(bal)));
                    double b = Double.parseDouble(txtbalance.getText());
                    double a = Double.parseDouble(disc.getText());
                    double d = Double.parseDouble(txttotal.getText());
                    double c = a+b;
                    double e = d-a;
                    txtbalance.setText(String.valueOf(df.format(c)));
                    txttotal.setText(String.valueOf(df.format(e)));

                   balancetxt.setText(String.valueOf(df.format(c)));
                   totalamount.setText(String.valueOf(df.format(e)));
                   btnpayment.setEnabled(false);
                   txtdisc.setEditable(false);
                   btnpayment1.setEnabled(false);
                   txtprint.requestFocus();
                    }catch (Exception e) {
                    }
        }     
    }//GEN-LAST:event_txtdiscKeyPressed

    public void date2()
    {
     Date d  =new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dd = sdf.format(d);
    txtdate.setText(dd);
    }  
 Timer t ;
 SimpleDateFormat st ;
    public void times(){
  t = new Timer(0, new ActionListener() {
      @Override
        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Date dt  =new Date();
        st = new SimpleDateFormat("hh:mm: a");
        String tt = st.format(dt);
        txttime.setText(tt);
        }
    });
    t.start();
}
    public void balance()//balance 
    {
        try {
       DecimalFormat df = new DecimalFormat(".00");
        double total = Double.parseDouble(txttotal.getText());
        double pay  = Double.parseDouble(txtpay.getText());       
        double bal = pay - total;  
        txtbalance.setText(String.valueOf(df.format(bal))); 
       
        balancetxt.setText(String.valueOf(df.format(bal)));
      totalamount.setText(String.valueOf(df.format(total)));
        } catch (Exception e) {
        }
    }
    public void bill() throws PrinterException
    {
        DecimalFormat df = new DecimalFormat("00");
        String total = txttotal.getText();
        String pay = txtpay.getText();
        String bal = txtbalance.getText();
        String trans = txtinvoice.getText();
        String time = txttime.getText();
        String name = lblname.getText();
        String disc1 = disc.getText();
        String dte = txtdate.getText();
       // String getold = txtbefore.getText();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        txtbill.setText(txtbill.getText()+"              KIMKARLA CAKES AND PASTRIES SHOP \n");
        txtbill.setText(txtbill.getText()+"\n");
        txtbill.setText(txtbill.getText()+ "Cashier: "+name+"\n");
        txtbill.setText(txtbill.getText()+"\n");
        txtbill.setText(txtbill.getText()+trans +"   "+ time +"   "+dte+"\n");
        txtbill.setText(txtbill.getText()+"________________________________________________\n");
        txtbill.setText(txtbill.getText()+"--------------------POSTBILL--------------------\n");
        txtbill.setText(txtbill.getText()+"________________________________________________\n");
        txtbill.setText(txtbill.getText()+ "\n");
        for (int i = 0; i<model.getRowCount();i++)
        {
            //String pname = (String)model.getValueAt(i,0).toString();
            String qty = (String)model.getValueAt(i,1).toString();
            String price = (String)model.getValueAt(i,2).toString();
            String amount = (String)model.getValueAt(i,3).toString();
            String tot = (String)model.getValueAt(i,4).toString();
            txtbill.setText(txtbill.getText() + qty + "\n");
            txtbill.setText(txtbill.getText()+ price+ "\t" + "(PCS)" + "\t" + amount + "\t" +tot+"\n");
        }
                  txtbill.setText(txtbill.getText() + "\n");
                  txtbill.setText(txtbill.getText() + "\n");
                  //txtbill.setText(txtbill.getText() + "Total Amount before Discount :" + getold + "\n");
                  txtbill.setText(txtbill.getText() + "TotalAmount :" + total + "\n");
                  txtbill.setText(txtbill.getText() + "Payment :" + pay + "\n");
                  txtbill.setText(txtbill.getText() + "Discount :" +disc1 + "\n");
                  txtbill.setText(txtbill.getText() + "Change :" + bal + "\n");
                  txtbill.setText(txtbill.getText() +"\n");
                  txtbill.setText(txtbill.getText()+"________________________________________________\n");
                  txtbill.setText(txtbill.getText()+"               Thank You Come Again             \n");  
                  txtbill.setText(txtbill.getText()+"________________________________________________\n");
                  
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
            java.util.logging.Logger.getLogger(trans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trans().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField balancetxt;
    private javax.swing.JButton btnpayment;
    private javax.swing.JButton btnpayment1;
    private javax.swing.JTextField disc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    private javax.swing.JLabel lblcancel;
    public javax.swing.JLabel lblname;
    private javax.swing.JLabel lblname1;
    private javax.swing.JLabel lblsucess;
    private javax.swing.JPanel panel4;
    private javax.swing.JTextField qtyy;
    private javax.swing.JLabel role1;
    private javax.swing.JLabel role2;
    private javax.swing.JTextField totalamount;
    private javax.swing.JTextField txt12;
    public javax.swing.JLabel txtbalance;
    public javax.swing.JTextField txtbefore;
    private javax.swing.JTextArea txtbill;
    private javax.swing.JButton txtcancel;
    public javax.swing.JLabel txtdate;
    public javax.swing.JTextField txtdisc;
    public javax.swing.JLabel txtinvoice;
    private javax.swing.JPasswordField txtpass1;
    private javax.swing.JPasswordField txtpass2;
    public javax.swing.JTextField txtpay;
    private javax.swing.JTextField txtpcode;
    public javax.swing.JLabel txtpname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JButton txtprint;
    private javax.swing.JTextField txtqty;
    public javax.swing.JLabel txttime;
    private javax.swing.JButton txttnew;
    public javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables
}
