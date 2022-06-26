/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsales;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import static pointofsales.menuforn.icon;
import static pointofsales.menuforn.img;
import static pointofsales.menuforn.imgScale;
import static pointofsales.menuforn.scaledIcon;


public class product extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
   
    public product() {
        initComponents();
 
        list();     //method list of data
        dt();       //method date
        times();    //method time
        combo();
        }
    
    
    public void dt(){      //DATE CODE      //Start code for Date and Time
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //set date
            String dd = sdf.format(d);
            lbldate.setText(dd);
        }
    Timer t;            //variables for Method times
    SimpleDateFormat st;
            
    public void times(){    //TIME CODE
            t = new Timer(0, new ActionListener(){
                
                public void actionPerformed(ActionEvent e){
                    Date dt = new Date();
                    st = new SimpleDateFormat("hh:mm: a");
                    String tt = st.format(dt);
                    lbltime.setText(tt);
                    }
                } 
             );         t.start();
           }
    
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
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
                jButton2.setEnabled(true);
                jPanel5.hide(); 
                jPanel4.show();
                list();
                }

           } catch (ClassNotFoundException ex) {
                    Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
                }
                } catch (Exception e) {
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
       
       public void combo(){    //To get all category into combobox
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            pst = con.prepareStatement("select category from category");

            rs = pst.executeQuery();  

            while(rs.next()){

            String cat = rs.getString("category");
            combocat.addItem(cat);
            combocatup.addItem(cat);
            }

       } catch (ClassNotFoundException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
       public static void createImage(String image_name,String myString)  {
		try {
		Code128Bean code128 = new Code128Bean();
		code128.setHeight(15f);
		code128.setModuleWidth(0.3);
		code128.setQuietZone(10);
		code128.doQuietZone(true);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		code128.generateBarcode(canvas, myString);
		canvas.finish();
		//write to png file
		FileOutputStream fos = new FileOutputStream("C:\\Users\\alex\\Desktop\\GENERATED BARCODES\\"+image_name);
		fos.write(baos.toByteArray());
		fos.flush();
		fos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
       
       
       
       
        public void update(){   //Function to update product
        try {
            try {
                String  id =  txtupdate.getText();
                String  barcode = txtbarcodeup.getText();
                String  pname = txtpnameup.getText();
                String  desc = txtdescup.getText();
                String  price = txtpriceup.getText();
                String  qt = txtqup.getText();
                String cat = combocatup.getSelectedItem().toString(); 
                String  date1 = date.format(txtdateup.getDate());
                Date date;
                date = txtdateup.getDate();
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
               jPanel7.hide();
               jPanel4.show();
               list();
                }  
               
                    txtupdate.setText("");
                    txtbarcodeup.setText("");
                    txtpnameup.setText("");
                    txtdescup.setText(""); 
                    txtpriceup.setText(""); 
                    txtqup.setText(""); 
                    txtsearchup.setText("");
                    combocatup.setSelectedIndex(0);
     
                } catch (ClassNotFoundException ex) {
                         Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (SQLException ex) {
                         Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 } catch (Exception e) {
                     }

                 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtbarcode = new javax.swing.JTextField();
        txtpname = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txtdesc = new javax.swing.JTextField();
        txtq = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        combocat = new javax.swing.JComboBox<>();
        txtdate = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        txtid1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        txtbarcodeup = new javax.swing.JTextField();
        txtpnameup = new javax.swing.JTextField();
        txtpriceup = new javax.swing.JTextField();
        txtdescup = new javax.swing.JTextField();
        txtqup = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        combocatup = new javax.swing.JComboBox<>();
        txtdateup = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        txtsearchup = new javax.swing.JTextField();
        txtupdate = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lbladdprod = new javax.swing.JLabel();
        lblcategory = new javax.swing.JLabel();
        lblexit = new javax.swing.JLabel();
        lblupdateprod = new javax.swing.JLabel();
        lblcritStocks = new javax.swing.JLabel();
        lblExpire = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbldate = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1323, 749));
        setMinimumSize(new java.awt.Dimension(1323, 749));
        setPreferredSize(new java.awt.Dimension(1323, 749));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(64, 64, 64));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 50, 40));

        jLabel9.setBackground(new java.awt.Color(0, 176, 240));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText(" ADD PRODUCT");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel9.setOpaque(true);
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 100));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel6.add(txtbarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 248, 33));

        txtpname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel6.add(txtpname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 248, 33));

        txtprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpriceKeyTyped(evt);
            }
        });
        jPanel6.add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 248, 33));

        txtdesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel6.add(txtdesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 248, 33));

        txtq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtqKeyTyped(evt);
            }
        });
        jPanel6.add(txtq, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 248, 33));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Barcode #");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 105, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ProductName");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 105, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Decription");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 105, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Price");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 105, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Quantity");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 105, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Category");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 105, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Expiration Date");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 105, 26));

        jButton5.setBackground(new java.awt.Color(64, 64, 64));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("ADD PRODUCT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 150, 50));

        combocat.setBorder(null);
        combocat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocatActionPerformed(evt);
            }
        });
        jPanel6.add(combocat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 248, 34));

        txtdate.setDateFormatString("yyyy-MM-dd");
        jPanel6.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 248, 31));

        jButton2.setBackground(new java.awt.Color(64, 64, 64));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("GENERATE BARCODE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, 50));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 400, 400));

        txtid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid1ActionPerformed(evt);
            }
        });
        jPanel5.add(txtid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 510, 70, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 440, 550));

        jPanel1.setBackground(new java.awt.Color(0, 176, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\FrmInventoryHeaderWithLogo.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 140));

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 140));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setBackground(new java.awt.Color(64, 64, 64));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("X");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, 30));

        jLabel13.setBackground(new java.awt.Color(0, 176, 240));
        jLabel13.setFont(new java.awt.Font("Arial", 0, 39)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText(" UPDATE PRODUCT");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel13.setOpaque(true);
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbarcodeup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel9.add(txtbarcodeup, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 248, 33));

        txtpnameup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel9.add(txtpnameup, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 248, 33));

        txtpriceup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtpriceup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpriceupKeyTyped(evt);
            }
        });
        jPanel9.add(txtpriceup, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 248, 33));

        txtdescup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel9.add(txtdescup, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 248, 33));

        txtqup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtqup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtqupKeyTyped(evt);
            }
        });
        jPanel9.add(txtqup, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 248, 33));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Barcode #");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 105, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("ProductName");
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 105, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Decription");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 105, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Price");
        jPanel9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 105, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Quantity");
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 105, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Category");
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 105, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Expiration Date");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 105, 26));

        combocatup.setBorder(null);
        combocatup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocatupActionPerformed(evt);
            }
        });
        jPanel9.add(combocatup, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 248, 34));

        txtdateup.setDateFormatString("yyyy-MM-dd");
        jPanel9.add(txtdateup, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 248, 31));

        jButton4.setBackground(new java.awt.Color(64, 64, 64));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("UPDATE PRODUCT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 160, 50));

        txtsearchup.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        txtsearchup.setForeground(new java.awt.Color(153, 153, 153));
        txtsearchup.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtsearchup.setText(" Search Barcode#...");
        txtsearchup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtsearchup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsearchupFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtsearchupFocusLost(evt);
            }
        });
        txtsearchup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchupActionPerformed(evt);
            }
        });
        txtsearchup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchupKeyPressed(evt);
            }
        });
        jPanel9.add(txtsearchup, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 190, 30));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 380, 420));

        txtupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtupdateActionPerformed(evt);
            }
        });
        jPanel7.add(txtupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, 20, 30));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 420, 540));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProdID", "Barcode", "ProductName", "ProdDescription", "Price", "Quantity", "Category", "Expiration"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 850, 430));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 870, 440));

        jPanel4.setBackground(new java.awt.Color(143, 170, 220));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbladdprod.setBackground(new java.awt.Color(64, 64, 64));
        lbladdprod.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbladdprod.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\AddProductImg.png")); // NOI18N
        lbladdprod.setOpaque(true);
        lbladdprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbladdprodMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbladdprodMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbladdprodMouseExited(evt);
            }
        });
        jPanel4.add(lbladdprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 330, 70));

        lblcategory.setBackground(new java.awt.Color(64, 64, 64));
        lblcategory.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblcategory.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\CategoryImg.png")); // NOI18N
        lblcategory.setOpaque(true);
        lblcategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcategoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblcategoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblcategoryMouseExited(evt);
            }
        });
        jPanel4.add(lblcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 330, 70));

        lblexit.setBackground(new java.awt.Color(64, 64, 64));
        lblexit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblexit.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\ExitIconINV.png")); // NOI18N
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
        jPanel4.add(lblexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 330, 70));

        lblupdateprod.setBackground(new java.awt.Color(64, 64, 64));
        lblupdateprod.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblupdateprod.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\UpdateProdImg.png")); // NOI18N
        lblupdateprod.setOpaque(true);
        lblupdateprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblupdateprodMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblupdateprodMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblupdateprodMouseExited(evt);
            }
        });
        jPanel4.add(lblupdateprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 330, 70));

        lblcritStocks.setBackground(new java.awt.Color(64, 64, 64));
        lblcritStocks.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblcritStocks.setForeground(new java.awt.Color(255, 255, 255));
        lblcritStocks.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\OutOfStocksImg.png")); // NOI18N
        lblcritStocks.setOpaque(true);
        lblcritStocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcritStocksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblcritStocksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblcritStocksMouseExited(evt);
            }
        });
        jPanel4.add(lblcritStocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 330, 70));

        lblExpire.setBackground(new java.awt.Color(64, 64, 64));
        lblExpire.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblExpire.setForeground(new java.awt.Color(255, 255, 255));
        lblExpire.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpire.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\SoonToExpireImg.png")); // NOI18N
        lblExpire.setOpaque(true);
        lblExpire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExpireMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblExpireMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblExpireMouseExited(evt);
            }
        });
        jPanel4.add(lblExpire, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 330, 70));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 360, 550));

        jPanel2.setBackground(new java.awt.Color(0, 176, 240));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbldate.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbldate.setText("0");
        jPanel2.add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 140, 30));

        lbltime.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbltime.setText("0");
        jPanel2.add(lbltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 120, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setText("TIME:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setText("DATE:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 640, 990, 50));

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
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 150, 290, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
   
    @Override
     public void list(){ //Set all data in Jtable from product_table
    
        try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
            
            pst = con.prepareStatement("select pid,barcode,pname,description,qty,price,category,expiration from product_table");
            rs = pst.executeQuery();  
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
    
    
    
    private void lbladdprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbladdprodMouseClicked
        jPanel5.show();
        jPanel4.hide();
        
       
    }//GEN-LAST:event_lbladdprodMouseClicked

    private void lbladdprodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbladdprodMouseEntered
        lbladdprod.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\AddProductImg - LIGHT.png"));
    }//GEN-LAST:event_lbladdprodMouseEntered

    private void lbladdprodMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbladdprodMouseExited
        lbladdprod.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\AddProductImg.png"));
    }//GEN-LAST:event_lbladdprodMouseExited

    private void lblcategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcategoryMouseClicked
            category cat = new category();
            cat.setVisible(true);
    }//GEN-LAST:event_lblcategoryMouseClicked

    private void lblcategoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcategoryMouseEntered
        lblcategory.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\CategoryImg - LIGHT.png"));
    }//GEN-LAST:event_lblcategoryMouseEntered

    private void lblcategoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcategoryMouseExited
        lblcategory.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\CategoryImg.png"));
    }//GEN-LAST:event_lblcategoryMouseExited

    private void lblexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexitMouseClicked
            setVisible(false);
            menuforn mf = new menuforn();
            mf.setVisible(true);        
    }//GEN-LAST:event_lblexitMouseClicked

    private void lblexitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexitMouseEntered
        lblexit.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\ExitIconINV - LIGHT.png"));
    }//GEN-LAST:event_lblexitMouseEntered

    private void lblexitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexitMouseExited
        lblexit.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\ExitIconINV.png"));
    }//GEN-LAST:event_lblexitMouseExited

    private void lblupdateprodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblupdateprodMouseClicked
            
        jPanel7.show();
        jPanel4.hide();
        txtbarcodeup.setEditable(false);
    }//GEN-LAST:event_lblupdateprodMouseClicked

    private void lblupdateprodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblupdateprodMouseEntered
        lblupdateprod.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\UpdateProdImg - LIGHT.png"));
    }//GEN-LAST:event_lblupdateprodMouseEntered

    private void lblupdateprodMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblupdateprodMouseExited
       lblupdateprod.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\UpdateProdImg.png"));
    }//GEN-LAST:event_lblupdateprodMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jTable1.requestFocus();
        jPanel5.hide();
        jPanel7.hide();
        
    }//GEN-LAST:event_formWindowOpened

    private void lblcritStocksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcritStocksMouseEntered
        lblcritStocks.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\OutOfStocksImg - LIGHT.png"));
    }//GEN-LAST:event_lblcritStocksMouseEntered

    private void lblcritStocksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcritStocksMouseExited
        lblcritStocks.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\OutOfStocksImg.png"));
    }//GEN-LAST:event_lblcritStocksMouseExited

    private void lblExpireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExpireMouseEntered
        lblExpire.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\SoonToExpireImg - LIGHT.png"));
    }//GEN-LAST:event_lblExpireMouseEntered

    private void lblExpireMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExpireMouseExited
        lblExpire.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\SoonToExpireImg.png"));
    }//GEN-LAST:event_lblExpireMouseExited

    private void lblcritStocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcritStocksMouseClicked
        critStocks cs = new critStocks();
        cs.show();
    }//GEN-LAST:event_lblcritStocksMouseClicked

    private void lblExpireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExpireMouseClicked
        try {
            expirationNotif en = new expirationNotif();
            en.show();
        } catch (ParseException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblExpireMouseClicked

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
       String tf = txtsearch.getText(); //Search all data base on type keywords on txtfield
            try{
                if(tf.matches("[A-Za-z0-9]") && tf.matches("^[0-9]+$")){
                    String query = "SELECT pid,barcode,pname,description,qty,price,category,expiration FROM product_table WHERE pid ="+tf;
                    pst = con.prepareStatement(query);
                    rs = pst.executeQuery();
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                }else{
                    String query = "SELECT pid,barcode,pname,description,qty,price,category,expiration FROM product_table WHERE barcode LIKE '%"+tf+"%' OR pname LIKE '%"+tf+"%' OR description LIKE '%"+tf+"%' OR category LIKE '%"+tf+"%' OR expiration LIKE '%"+tf+"%'";
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
    }//GEN-LAST:event_txtsearchKeyReleased

    private void txtsearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsearchFocusGained
        if(txtsearch.getText().equals(" Search...")){   //Clear text when focus gained
            txtsearch.setText("");
            txtsearch.setForeground(new Color(0,0,0));
            txtsearch.setFont(new Font("Arial",Font.PLAIN,18));
        }
    }//GEN-LAST:event_txtsearchFocusGained

    private void txtsearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsearchFocusLost
        if(txtsearch.getText().equals("")){          //Set text Search... when focus lost
            txtsearch.setText(" Search...");
            txtsearch.setForeground(new Color(153,153,153));
            txtsearch.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
        
        }
    }//GEN-LAST:event_txtsearchFocusLost

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void txtid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Do you want to generate Barcode#?" ,"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(response==JOptionPane.YES_OPTION){
            Random random = new Random();
            int randNum;
            randNum = random.nextInt(1000000000);
            String strnum = String.valueOf(randNum);
            txtbarcode.setText(strnum);
            product.createImage(strnum.concat(".png") , strnum);
            jButton2.setEnabled(false);
            System.out.println("finished");
        }else{
            jButton2.setEnabled(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void combocatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocatActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_combocatActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        searchbarcode();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtqKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqKeyTyped
        char c= evt.getKeyChar();
        if (!(Character.isDigit(c) || (c ==KeyEvent.VK_ENTER) || c==KeyEvent.VK_DELETE)){

            evt.consume();
        }
    }//GEN-LAST:event_txtqKeyTyped

    private void txtpriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpriceKeyTyped
        char c= evt.getKeyChar();
        if (!(Character.isDigit(c) || (c ==KeyEvent.VK_ENTER) || c==KeyEvent.VK_DELETE)){

            evt.consume();
        }
    }//GEN-LAST:event_txtpriceKeyTyped

    private void txtbarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbarcodeKeyTyped
        char c= evt.getKeyChar();
        if (!(Character.isDigit(c) || (c ==KeyEvent.VK_ENTER) || c==KeyEvent.VK_DELETE)){

            evt.consume();
        }
    }//GEN-LAST:event_txtbarcodeKeyTyped

    private void txtbarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbarcodeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPanel5.hide();
        jPanel4.show();
        txtid1.setText("");
        txtbarcode.setText("");
        txtpname.setText("");
        txtdesc.setText("");
        txtprice.setText("");
        txtq.setText("");
        combocat.setSelectedItem(0);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtupdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtupdateActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        update();   // Call function update
    }//GEN-LAST:event_jButton4ActionPerformed

    private void combocatupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocatupActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_combocatupActionPerformed

    private void txtqupKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqupKeyTyped
        char c= evt.getKeyChar();
        if (!(Character.isDigit(c) || (c ==KeyEvent.VK_ENTER) || c==KeyEvent.VK_DELETE)){

            evt.consume();
        }
    }//GEN-LAST:event_txtqupKeyTyped

    private void txtpriceupKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpriceupKeyTyped
        char c= evt.getKeyChar();
        if (!(Character.isDigit(c) || (c ==KeyEvent.VK_ENTER) || c==KeyEvent.VK_DELETE)){

            evt.consume();
        }
    }//GEN-LAST:event_txtpriceupKeyTyped

    private void txtsearchupKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchupKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)  //Code for search when keypress txtsearch
        {
            String search = txtsearchup.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trans","root","alexiess");
                pst = con.prepareStatement("select * from product_table where barcode = ?");

                pst.setString(1,search);

                rs = pst.executeQuery();
                if (rs.next() == false)
                {
                    JOptionPane.showMessageDialog(this,"Product not Found!", "Not found", JOptionPane.WARNING_MESSAGE);
                    txtupdate.setText("");
                    txtbarcodeup.setText("");
                    txtpnameup.setText("");
                    txtdescup.setText("");
                    txtpriceup.setText("");
                    txtqup.setText("");
                    txtsearchup.setText("");
                    combocatup.setSelectedItem(0);
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
                    String  date1 = rs.getString("expiration");

                    txtupdate.setText(id1.trim());
                    txtbarcodeup.setText(barcode.trim());
                    txtpnameup.setText(pname.trim());
                    txtdescup.setText(desc.trim());
                    txtpriceup.setText(price.trim());
                    txtqup.setText(qt.trim());
                    combocatup.setSelectedItem(cat);
                    ((JTextField)txtdateup.getDateEditor().getUiComponent()).setText(date1);
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(trans.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtsearchupKeyPressed

    private void txtsearchupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchupActionPerformed

    }//GEN-LAST:event_txtsearchupActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        txtupdate.setText("");
        txtbarcodeup.setText("");
        txtpnameup.setText("");
        txtdescup.setText(""); 
        txtpriceup.setText(""); 
        txtqup.setText(""); 
        txtsearchup.setText("");
        combocatup.setSelectedIndex(0);
        jPanel7.hide();
        jPanel4.show();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtsearchupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsearchupFocusGained
        if(txtsearchup.getText().equals(" Search Barcode#...")){   //Clear text when focus gained
            txtsearchup.setText("");
            txtsearchup.setForeground(new Color(0,0,0));
            txtsearchup.setFont(new Font("Arial",Font.PLAIN,14));
        }
    }//GEN-LAST:event_txtsearchupFocusGained

    private void txtsearchupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsearchupFocusLost
        if(txtsearchup.getText().equals("")){          //Set text Search... when focus lost
            txtsearchup.setText(" Search Barcode#...");
            txtsearchup.setForeground(new Color(153,153,153));
            txtsearchup.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        
        }
    }//GEN-LAST:event_txtsearchupFocusLost

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
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combocat;
    private javax.swing.JComboBox<String> combocatup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JLabel lblExpire;
    private javax.swing.JLabel lbladdprod;
    private javax.swing.JLabel lblcategory;
    private javax.swing.JLabel lblcritStocks;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lblexit;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel lblupdateprod;
    private javax.swing.JTextField txtbarcode;
    private javax.swing.JTextField txtbarcodeup;
    private com.toedter.calendar.JDateChooser txtdate;
    private com.toedter.calendar.JDateChooser txtdateup;
    private javax.swing.JTextField txtdesc;
    private javax.swing.JTextField txtdescup;
    private javax.swing.JTextField txtid1;
    private javax.swing.JTextField txtpname;
    private javax.swing.JTextField txtpnameup;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtpriceup;
    private javax.swing.JTextField txtq;
    private javax.swing.JTextField txtqup;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtsearchup;
    private javax.swing.JTextField txtupdate;
    // End of variables declaration//GEN-END:variables

    void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
