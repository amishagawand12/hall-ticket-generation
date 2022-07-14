/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hall_ticket_generation;

import com.sun.jdi.connect.spi.Connection;
import java.awt.HeadlessException;
import java.beans.Statement;
import javax.naming.spi.DirStateFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author amish
 */
public class Registration_Page extends javax.swing.JFrame {

    /**
     * Creates new form Registration_Page
     */
    String fname,lname,uname,password,con_pass,contact_no,date;
    int id=0;
    public Registration_Page() {
        initComponents();
        
    }
    
    public int getid()
    {
        ResultSet rs=null;
        try { 
            Class.forName("org.postgresql.Driver");
              Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","krishna");
              String sql="select max(id) from registration";
              Statement st=con.createStatement();
             rs= st.executeQuery(sql);
             while (rs.next())
             {
                 
                 id=rs.getInt(1);
                 id++;;
             }   
              
      }catch (Exception e)
      {
          e.printStackTrace();
      } 
      return id;
      
    }      
      
      

        boolean validation()
        {
            
            
            fname=txt_firstname.getText();
            lname=txt_lastname.getText();
            uname=txt_username.getText();
            password=txt_password.getText();
            con_pass=txt_confirmpass.getText();
            contact_no=txt_contactno.getText();
            date=txt_dob.getText();
            
            if (fname.equals(""))
            {
                JOptionPane.showMessageDialog(this, "please enter first name");
                return false;
             }  
            
            if (lname.equals(""))
            {
                JOptionPane.showMessageDialog(this, "please enter last name");
                return false;
             } 
            
            if (uname.equals(""))
            {
                JOptionPane.showMessageDialog(this, "please enter user name");
                return false;
             } 
            
            if (password.equals(""))
            {
                JOptionPane.showMessageDialog(this, "please enter password");
                return false;
             } 
            
            if (con_pass.equals(""))
            {
                JOptionPane.showMessageDialog(this, "please confirm the password");
                return false;
             } 
            
            if (date.equals(""))
            {
                JOptionPane.showMessageDialog(this, "please enter date of birth");
                return false;
             } 
            
             if (password.length()<8)
             {
                lbl_password_error.setText("password should be 8 digits"); 
             }
             
             if (!password.equals(con_pass))
             {
                 JOptionPane.showMessageDialog(this, "password not matched");
                 return false;
             }
            
             
            return true;
        }
        
        
        public void checkPassword()
        {
            password=txt_password.getText();
           if (password.length()<8) 
           {
              lbl_password_error.setText("password should be 8 digits");
           }
           else
           {
              lbl_password_error.setText("");
           }
        }  
        
        
        public void checkContactNo()
        {
            contact_no=txt_contactno.getText();
            if (contact_no.length()==10)
            {
               lbl_contact_error.setText("");
            }  
            else
            {
               lbl_contact_error.setText("conatct_no should be 10 digits"); 
            }
        }
             
        void insertDetails()
        {
            try
            {
              Class.forName("org.postgresql.Driver");
              Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
              String sql="insert into registration values(?,?,?,?,?,?,?)";
              PreparedStatement stmt=con.prepareStatement(sql);
              stmt.setInt(1,getid());
              stmt.setString(2, fname);
              stmt.setString(3, lname);
              stmt.setString(4, uname);
              stmt.setString(5, password);
              stmt.setString(6, date);
              stmt.setString(7, contact_no);
              int i=stmt.executeUpdate();
              if (i>0)
              {
                  JOptionPane.showMessageDialog(this, "record inserted");
              }
              else
              {
                  JOptionPane.showMessageDialog(this, "record not inserted");
              }    
            }
            catch (Exception e)
            {
              e.printStackTrace();
            }    
                    
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_contactno = new javax.swing.JTextField();
        txt_firstname = new javax.swing.JTextField();
        txt_lastname = new javax.swing.JTextField();
        txt_confirmpass = new javax.swing.JPasswordField();
        txt_password = new javax.swing.JPasswordField();
        txt_username = new javax.swing.JTextField();
        txt_dob = new javax.swing.JTextField();
        btn_login = new javax.swing.JButton();
        btn_register = new javax.swing.JButton();
        lbl_contact_error = new javax.swing.JLabel();
        lbl_password_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRATION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 117, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contact No :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 117, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("First Name :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 117, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("User Name :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 117, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 117, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Confirm Password :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 180, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("D.O.B :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 117, -1));

        txt_contactno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_contactno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactnoActionPerformed(evt);
            }
        });
        txt_contactno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contactnoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contactnoKeyReleased(evt);
            }
        });
        jPanel2.add(txt_contactno, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 190, 30));

        txt_firstname.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_firstnameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 190, 30));

        txt_lastname.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lastnameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 190, 30));

        txt_confirmpass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(txt_confirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 190, 30));

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passwordKeyReleased(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 190, 30));

        txt_username.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 190, 30));

        txt_dob.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dobActionPerformed(evt);
            }
        });
        jPanel2.add(txt_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 190, 30));

        btn_login.setBackground(new java.awt.Color(255, 0, 0));
        btn_login.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Login");
        jPanel2.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        btn_register.setBackground(new java.awt.Color(0, 204, 51));
        btn_register.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_register.setText("Register");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });
        jPanel2.add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        lbl_contact_error.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_contact_error.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lbl_contact_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 260, 30));

        lbl_password_error.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_password_error.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lbl_password_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 153, 190, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 760, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_contactnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactnoActionPerformed

    private void txt_firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_firstnameActionPerformed

    private void txt_lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastnameActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dobActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
    if (validation())
    {
        insertDetails();
    }//GEN-LAST:event_btn_registerActionPerformed
    }
    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
       checkPassword();
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyReleased
checkPassword();
    }//GEN-LAST:event_txt_passwordKeyReleased

    private void txt_contactnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactnoKeyReleased
checkContactNo();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactnoKeyReleased

    private void txt_contactnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactnoKeyPressed
checkContactNo();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactnoKeyPressed

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
            java.util.logging.Logger.getLogger(Registration_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_contact_error;
    private javax.swing.JLabel lbl_password_error;
    private javax.swing.JPasswordField txt_confirmpass;
    private javax.swing.JTextField txt_contactno;
    private javax.swing.JTextField txt_dob;
    private javax.swing.JTextField txt_firstname;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
