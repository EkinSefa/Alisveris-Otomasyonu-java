package View;
import Helper.*;
import Model.Müsteri;
import Model.User;
import Model.Yönetici;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;




public class LoginGUI extends javax.swing.JFrame {
    
    private DBConnection conn=new DBConnection();
    

    public LoginGUI() {
        initComponents();
        Image icon = new ImageIcon(this.getClass().getResource("/ayakkabıimage/lo5.png")).getImage();
        this.setIconImage(icon);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        YöneticiPanel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fld_kullanıcıisim = new javax.swing.JTextField();
        btn_kullanıcıgiriş = new javax.swing.JButton();
        btn_kullanıcıkayıt = new javax.swing.JButton();
        fld_kullanıcıpassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_yöneticigiriş = new javax.swing.JButton();
        btn_yöneticikayıt = new javax.swing.JButton();
        fld_yöneticiİsim = new javax.swing.JTextField();
        fld_yöneticipassword = new javax.swing.JPasswordField();
        lbl_logo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 204, 255));
        setLocation(new java.awt.Point(450, 150));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        YöneticiPanel.setBackground(new java.awt.Color(255, 255, 255));
        YöneticiPanel.setForeground(new java.awt.Color(0, 0, 0));
        YöneticiPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Kullanıcı İsmi :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 30, 90, 25));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 36, 19, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Şifre :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 90, 20));

        fld_kullanıcıisim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fld_kullanıcıisimActionPerformed(evt);
            }
        });
        jPanel2.add(fld_kullanıcıisim, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 90, -1));

        btn_kullanıcıgiriş.setBackground(new java.awt.Color(255, 255, 255));
        btn_kullanıcıgiriş.setForeground(new java.awt.Color(0, 0, 153));
        btn_kullanıcıgiriş.setText("Giriş Yap");
        btn_kullanıcıgiriş.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kullanıcıgirişActionPerformed(evt);
            }
        });
        jPanel2.add(btn_kullanıcıgiriş, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 91, 30));

        btn_kullanıcıkayıt.setBackground(new java.awt.Color(255, 255, 255));
        btn_kullanıcıkayıt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_kullanıcıkayıt.setForeground(new java.awt.Color(0, 204, 0));
        btn_kullanıcıkayıt.setText("Kayıt Ol");
        btn_kullanıcıkayıt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kullanıcıkayıtActionPerformed(evt);
            }
        });
        jPanel2.add(btn_kullanıcıkayıt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 92, 30));

        fld_kullanıcıpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fld_kullanıcıpasswordActionPerformed(evt);
            }
        });
        jPanel2.add(fld_kullanıcıpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 60, 90, -1));

        YöneticiPanel.addTab("Kullanıcı Girişi", jPanel2);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Yönetici İsmi:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 88, 25));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Şifre  :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 56, 88, 24));

        btn_yöneticigiriş.setBackground(new java.awt.Color(255, 255, 255));
        btn_yöneticigiriş.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_yöneticigiriş.setForeground(new java.awt.Color(0, 0, 153));
        btn_yöneticigiriş.setText("Giriş Yap");
        btn_yöneticigiriş.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_yöneticigirişActionPerformed(evt);
            }
        });
        jPanel1.add(btn_yöneticigiriş, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 90, 30));

        btn_yöneticikayıt.setBackground(new java.awt.Color(255, 255, 255));
        btn_yöneticikayıt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_yöneticikayıt.setForeground(new java.awt.Color(0, 204, 51));
        btn_yöneticikayıt.setText("Kayıt Ol");
        btn_yöneticikayıt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_yöneticikayıtActionPerformed(evt);
            }
        });
        jPanel1.add(btn_yöneticikayıt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 98, 30));

        fld_yöneticiİsim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fld_yöneticiİsimActionPerformed(evt);
            }
        });
        jPanel1.add(fld_yöneticiİsim, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 26, 98, -1));

        fld_yöneticipassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fld_yöneticipasswordActionPerformed(evt);
            }
        });
        jPanel1.add(fld_yöneticipassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 57, 98, -1));

        YöneticiPanel.addTab("Yönetici Girişi", jPanel1);

        jPanel3.add(YöneticiPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 470, 220));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ayakkabıimage/analogo.png"))); // NOI18N
        jPanel3.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 87, 82));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 470, 320));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ayakkabıimage/yildizlar_630x485.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fld_kullanıcıisimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fld_kullanıcıisimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fld_kullanıcıisimActionPerformed

    private void fld_yöneticiİsimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fld_yöneticiİsimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fld_yöneticiİsimActionPerformed

    private void btn_yöneticigirişActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_yöneticigirişActionPerformed
        
       
        if (fld_yöneticiİsim.getText().length()==0  || fld_yöneticipassword.getText().length()==0) {
            JOptionPane.showMessageDialog(null, "Lütfen Tüm Alanları Doldurunuz");
            Helper.showMsg("fill");
          
        }
        else{
            try {
                Connection con=conn.connDb();
                Statement st=con.createStatement(); 
                ResultSet rs=st.executeQuery("SELECT * FROM user");  // sorgu   user var mı yok mu
                while(rs.next()){
                    if (fld_yöneticiİsim.getText().equals(rs.getString("nickname"))&&fld_yöneticipassword.getText().equals(rs.getString("password"))) {
                        Yönetici yönetici =new Yönetici();
                        yönetici.setId(rs.getInt("id"));
                        yönetici.setPassword("password");
                        yönetici.setNickname(rs.getString("nickname"));
                        yönetici.setName(rs.getNString("name"));
                        yönetici.setType(rs.getString("type"));
                        YöneticiGUI yöneticiGUI=new YöneticiGUI(yönetici);
                        yöneticiGUI.setVisible(true);
                        dispose();
                    }
            }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_yöneticigirişActionPerformed

    private void fld_yöneticipasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fld_yöneticipasswordActionPerformed
        
        
        
    }//GEN-LAST:event_fld_yöneticipasswordActionPerformed

    private void fld_kullanıcıpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fld_kullanıcıpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fld_kullanıcıpasswordActionPerformed

    private void btn_kullanıcıkayıtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kullanıcıkayıtActionPerformed
      
       KayıtGUI kayıt=new KayıtGUI();
       kayıt.setVisible(true);
       dispose();
       
        
        
    }//GEN-LAST:event_btn_kullanıcıkayıtActionPerformed

    private void btn_kullanıcıgirişActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kullanıcıgirişActionPerformed
         if (fld_kullanıcıisim.getText().length()==0  || fld_kullanıcıpassword.getText().length()==0) {
            JOptionPane.showMessageDialog(null, "Lütfen Tüm Alanları Doldurunuz");
            Helper.showMsg("fill");
          
        }
        else{
            try {
                Connection con=conn.connDb();
                Statement st=con.createStatement(); 
                ResultSet rs=st.executeQuery("SELECT * FROM user");  // sorgu   user var mı yok mu
                while(rs.next()){
                    if (fld_kullanıcıisim.getText().equals(rs.getString("nickname"))&&fld_kullanıcıpassword.getText().equals(rs.getString("password"))) {
                        Müsteri müsteri =new Müsteri();
                        müsteri.setId(rs.getInt("id"));
                        müsteri.setPassword("password");
                        müsteri.setNickname(rs.getString("nickname"));
                        müsteri.setName(rs.getNString("name"));
                        müsteri.setType(rs.getString("type"));
                        MüsteriGUI müsteriGUI=new MüsteriGUI();
                        müsteriGUI.setVisible(true);
                        dispose();
                    }
            }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
              
    }//GEN-LAST:event_btn_kullanıcıgirişActionPerformed

    private void btn_yöneticikayıtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_yöneticikayıtActionPerformed
       KayıtGUI kayıt=new KayıtGUI();
       kayıt.setVisible(true);
       dispose();
       
       
        
    }//GEN-LAST:event_btn_yöneticikayıtActionPerformed

   
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatLightLaf.setup();

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane YöneticiPanel;
    private javax.swing.JButton btn_kullanıcıgiriş;
    private javax.swing.JButton btn_kullanıcıkayıt;
    private javax.swing.JButton btn_yöneticigiriş;
    private javax.swing.JButton btn_yöneticikayıt;
    private javax.swing.JTextField fld_kullanıcıisim;
    private javax.swing.JPasswordField fld_kullanıcıpassword;
    private javax.swing.JPasswordField fld_yöneticipassword;
    private javax.swing.JTextField fld_yöneticiİsim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_logo;
    // End of variables declaration//GEN-END:variables

   

 

    
      
}

