package pointofsales;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class menuforn extends javax.swing.JFrame {

    public static ImageIcon icon, scaledIcon; //Global variables
    public static Image img, imgScale;
    
    public menuforn() {
        initComponents();
        scaleImage();   //method to scale images
        dt();           //method date
        times();        //medthod time
    }
    
    public void dt(){   //DATE CODE                                 //Start code for Date and Time
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); //set date
            String dd = sdf.format(d);
            lbldate.setText(dd); 
        }
    
                Timer t;                  //variables for Method times
                SimpleDateFormat st;
    public void times(){                                        //TIME CODE
                t = new Timer(0, new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e){ 
                       Date dt = new Date();
                       st = new SimpleDateFormat("hh:mm: a");;
                       String tt = st.format(dt); 
                       lbltime.setText(tt);
                    }
                   }
                );      t.start();
              }                                                 //END code for Date and Time
        
    public void scaleImage(){ //Method for make image fit to labels/btns
                    icon = new ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\NewLogKimKarlaShop.png");
                    img = icon.getImage();
                    imgScale = img.getScaledInstance(lbllogoicon.getWidth(), lbllogoicon.getHeight(), Image.SCALE_SMOOTH);
                    scaledIcon = new ImageIcon(imgScale);
                    lbllogoicon.setIcon(scaledIcon);   //FOR KIMKARLA LOGO

                       icon = new ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\AccountIcon - BLUE.png");
                       img = icon.getImage();
                       imgScale = img.getScaledInstance(lblusericon.getWidth(), lblusericon.getHeight(), Image.SCALE_SMOOTH);
                       scaledIcon = new ImageIcon(imgScale);
                       lblusericon.setIcon(scaledIcon);    //FOR ADMIN ICON

                }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblusericon = new javax.swing.JLabel();
        lblexit = new javax.swing.JLabel();
        lblacc = new javax.swing.JLabel();
        lblsales = new javax.swing.JLabel();
        lblinventory = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbllogoicon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1320, 720));
        setMinimumSize(new java.awt.Dimension(1320, 720));
        setPreferredSize(new java.awt.Dimension(1320, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 176, 240));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMIN");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 80, 30));

        lblusericon.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\AccountIcon - BLUE.png")); // NOI18N
        lblusericon.setText(" ");
        lblusericon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        getContentPane().add(lblusericon, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 170, 150));

        lblexit.setBackground(new java.awt.Color(64, 64, 64));
        lblexit.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\ExitIcon.png")); // NOI18N
        lblexit.setText(" ");
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
        getContentPane().add(lblexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 320, 80));

        lblacc.setBackground(new java.awt.Color(64, 64, 64));
        lblacc.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\ManageAccountIcon.png")); // NOI18N
        lblacc.setText(" ");
        lblacc.setOpaque(true);
        lblacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblaccMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblaccMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblaccMouseExited(evt);
            }
        });
        getContentPane().add(lblacc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 320, 80));

        lblsales.setBackground(new java.awt.Color(64, 64, 64));
        lblsales.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\SalesIcon.png")); // NOI18N
        lblsales.setText(" ");
        lblsales.setOpaque(true);
        lblsales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsalesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblsalesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblsalesMouseExited(evt);
            }
        });
        getContentPane().add(lblsales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 320, 80));

        lblinventory.setBackground(new java.awt.Color(64, 64, 64));
        lblinventory.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblinventory.setForeground(new java.awt.Color(240, 240, 240));
        lblinventory.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\ProductIcon.png")); // NOI18N
        lblinventory.setOpaque(true);
        lblinventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblinventoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblinventoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblinventoryMouseExited(evt);
            }
        });
        getContentPane().add(lblinventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 320, 80));

        jLabel2.setBackground(new java.awt.Color(0, 176, 240));
        jLabel2.setText("  ");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel2.setMaximumSize(new java.awt.Dimension(6, 618));
        jLabel2.setMinimumSize(new java.awt.Dimension(6, 618));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 750));

        lbllogoicon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllogoicon.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\NewLogKimKarlaShop.png")); // NOI18N
        getContentPane().add(lbllogoicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 890, 600));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("DATE:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("TIME:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, -1, -1));

        lbltime.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbltime.setForeground(new java.awt.Color(51, 51, 51));
        lbltime.setText("0");
        getContentPane().add(lbltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, 220, -1));

        lbldate.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbldate.setForeground(new java.awt.Color(51, 51, 51));
        lbldate.setText("0");
        getContentPane().add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 230, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexitMouseClicked
                                                                                // CODE TO EXIT
        int response = JOptionPane.showConfirmDialog(this, "Do you really want to exit?" ,"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(response==JOptionPane.YES_OPTION){
                login log = new login();
                log.setVisible(true);
                this.setVisible(false);
            
        }
    }//GEN-LAST:event_lblexitMouseClicked

    private void lblexitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexitMouseEntered
        lblexit.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\ExitIcon - LIGHT.png"));
    }//GEN-LAST:event_lblexitMouseEntered

    private void lblexitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexitMouseExited
        lblexit.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\ExitIcon.png"));
    }//GEN-LAST:event_lblexitMouseExited

    private void lblaccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccMouseClicked
        createaccount ac = new createaccount();
        ac.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblaccMouseClicked

    private void lblaccMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccMouseEntered
        lblacc.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\ManageAccountIcon - LIGHT.png"));
    }//GEN-LAST:event_lblaccMouseEntered

    private void lblaccMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccMouseExited
        lblacc.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\ManageAccountIcon.png"));
    }//GEN-LAST:event_lblaccMouseExited

    private void lblsalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsalesMouseClicked

            setVisible(false);
            sales s = new sales();
            s.setVisible(true);
        
    }//GEN-LAST:event_lblsalesMouseClicked

    private void lblsalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsalesMouseEntered
        lblsales.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\SalesIcon - LIGHT.png"));
    }//GEN-LAST:event_lblsalesMouseEntered

    private void lblsalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsalesMouseExited
        lblsales.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\SalesIcon.png"));
    }//GEN-LAST:event_lblsalesMouseExited

    private void lblinventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblinventoryMouseClicked
            setVisible(false);
            product p = new product();
            p.setVisible(true);
    }//GEN-LAST:event_lblinventoryMouseClicked

    private void lblinventoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblinventoryMouseEntered
        lblinventory.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\ProductIcon - LIGHT.png"));
    }//GEN-LAST:event_lblinventoryMouseEntered

    private void lblinventoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblinventoryMouseExited
        lblinventory.setIcon(new javax.swing.ImageIcon("C:\\Users\\alex\\Desktop\\KimKarlaPOS - V5\\a-20210914T063938Z-001\\a\\pointofsales\\SystemImgs\\ProductIcon.png"));

    }//GEN-LAST:event_lblinventoryMouseExited

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuforn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblacc;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lblexit;
    private javax.swing.JLabel lblinventory;
    private javax.swing.JLabel lbllogoicon;
    private javax.swing.JLabel lblsales;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel lblusericon;
    // End of variables declaration//GEN-END:variables
}
