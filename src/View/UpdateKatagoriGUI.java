
package View;

import Helper.Helper;
import Model.Katagori;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;



public class UpdateKatagoriGUI extends javax.swing.JFrame {
  
 
     private   static Katagori katagori;
  
    public UpdateKatagoriGUI(Katagori katagori) {
        initComponents();
        Image icon = new ImageIcon(this.getClass().getResource("/ayakkabıimage/lo5.png")).getImage();
        this.setIconImage(icon);
        
        
        
        
 
 
            
 
 
 btn_updateKatagori.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
           if(Helper.confirm("sure")){
            try {
            katagori.updataKatagori(katagori.getId(), fld_katagoriName.getText());
            Helper.showMsg("success");
            dispose();
        }  catch (SQLException ex) {
            
        }
        } 
     }
     
 });
     fld_katagoriName.setText(katagori.getName());
 
 
 
    }
       
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        fld_katagoriName = new javax.swing.JTextField();
        btn_updateKatagori = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 250));
        setPreferredSize(new java.awt.Dimension(300, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Katagori  Adı");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 130, 30));

        fld_katagoriName.setBackground(new java.awt.Color(255, 255, 255));
        fld_katagoriName.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(fld_katagoriName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 130, 30));

        btn_updateKatagori.setText("Düzenle");
        btn_updateKatagori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateKatagoriActionPerformed(evt);
            }
        });
        getContentPane().add(btn_updateKatagori, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 130, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateKatagoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateKatagoriActionPerformed



    }//GEN-LAST:event_btn_updateKatagoriActionPerformed

    
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
            java.util.logging.Logger.getLogger(UpdateKatagoriGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateKatagoriGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateKatagoriGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateKatagoriGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
          FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                 UpdateKatagoriGUI frame=new UpdateKatagoriGUI(katagori);
                 frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_updateKatagori;
    private javax.swing.JTextField fld_katagoriName;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    void addWindowListener() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
