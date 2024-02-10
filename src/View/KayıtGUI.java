
package View;

import Helper.Helper;
import Model.Müsteri;

import Model.Yönetici;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;



public class KayıtGUI extends javax.swing.JFrame  {

 static Yönetici yönetici=new Yönetici();
 
   
    public KayıtGUI () {
        initComponents();
        Image icon = new ImageIcon(this.getClass().getResource("/ayakkabıimage/lo5.png")).getImage();
        this.setIconImage(icon);
    }

    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fld_isimkyd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jkombo_türü = new javax.swing.JComboBox();
        btn_kayıtol = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fld_passwordkyd = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        fld_kullanıcıadkyd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 204, 255));
        setLocation(new java.awt.Point(450, 250));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fld_isimkyd.setBackground(new java.awt.Color(255, 255, 255));
        fld_isimkyd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        fld_isimkyd.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(fld_isimkyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 99, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tür :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 103, 24));

        jkombo_türü.setBackground(new java.awt.Color(255, 255, 255));
        jkombo_türü.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jkombo_türü.setForeground(new java.awt.Color(0, 0, 0));
        jkombo_türü.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seçiniz", "Müşteri", "Yönetici" }));
        jkombo_türü.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jkombo_türüActionPerformed(evt);
            }
        });
        jPanel1.add(jkombo_türü, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 99, 27));

        btn_kayıtol.setBackground(new java.awt.Color(255, 255, 255));
        btn_kayıtol.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btn_kayıtol.setForeground(new java.awt.Color(0, 0, 0));
        btn_kayıtol.setText("Kayıt Ol");
        btn_kayıtol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kayıtolActionPerformed(evt);
            }
        });
        jPanel1.add(btn_kayıtol, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 201, 242, 42));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("İsim");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 103, 27));

        fld_passwordkyd.setBackground(new java.awt.Color(255, 255, 255));
        fld_passwordkyd.setForeground(new java.awt.Color(0, 0, 0));
        fld_passwordkyd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fld_passwordkydActionPerformed(evt);
            }
        });
        jPanel1.add(fld_passwordkyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 99, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Şifre :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 103, 29));

        fld_kullanıcıadkyd.setBackground(new java.awt.Color(255, 255, 255));
        fld_kullanıcıadkyd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        fld_kullanıcıadkyd.setForeground(new java.awt.Color(0, 0, 0));
        fld_kullanıcıadkyd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fld_kullanıcıadkydActionPerformed(evt);
            }
        });
        jPanel1.add(fld_kullanıcıadkyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 100, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Kullanıcı Adı :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 42, 103, 26));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 430, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fld_kullanıcıadkydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fld_kullanıcıadkydActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fld_kullanıcıadkydActionPerformed

    private void fld_passwordkydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fld_passwordkydActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fld_passwordkydActionPerformed

    private void btn_kayıtolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kayıtolActionPerformed
        if (fld_kullanıcıadkyd.getText().length()==0 ||fld_isimkyd.getText().length()==0 ||fld_passwordkyd.getText().length()==0|| jkombo_türü.getSelectedIndex()==0 ) {
              JOptionPane.showMessageDialog(null, "Lütfen Tüm Alanları Doldurunuz");
            Helper.showMsg("fill");
        }
        else{
            
            try {
                String tür=String.valueOf(jkombo_türü.getSelectedItem());
                boolean kontrol =yönetici.addMüsteri(fld_kullanıcıadkyd.getText(), fld_passwordkyd.getText(), fld_isimkyd.getText(),tür);
                if (kontrol) {
                    Helper.showMsg("success");
                    fld_kullanıcıadkyd.setText(null);
                    fld_passwordkyd.setText(null);
                    fld_isimkyd.setText(null);
                    
                    
                }
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
       
        }
        
        LoginGUI login=new LoginGUI();
         login.setVisible(true);
         dispose();
         
    }//GEN-LAST:event_btn_kayıtolActionPerformed

    private void jkombo_türüActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jkombo_türüActionPerformed
       
        
    }//GEN-LAST:event_jkombo_türüActionPerformed

  
    
   
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
            java.util.logging.Logger.getLogger(KayıtGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KayıtGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KayıtGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KayıtGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                KayıtGUI frame=new KayıtGUI();
                frame.setVisible(true);
            }  
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kayıtol;
    private javax.swing.JTextField fld_isimkyd;
    private javax.swing.JTextField fld_kullanıcıadkyd;
    private javax.swing.JPasswordField fld_passwordkyd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox jkombo_türü;
    // End of variables declaration//GEN-END:variables

 
}
