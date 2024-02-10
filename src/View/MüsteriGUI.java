
package View;

import Helper.*;
import Model.Katagori;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.ImageIcon;



public class MüsteriGUI extends javax.swing.JFrame {
  Katagori katagori=new Katagori();
    
    public MüsteriGUI() throws SQLException{
        initComponents();
        Image icon = new ImageIcon(this.getClass().getResource("/ayakkabıimage/lo5.png")).getImage();
        this.setIconImage(icon);
        
        for(int i=0;i<katagori.getList().size();i++){{
            select_katagoriler.addItem( katagori.getList().get(i).getName());
            
        }
            
        }
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        select_katagoriler = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(450, 175));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        select_katagoriler.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz" }));
        select_katagoriler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_katagorilerActionPerformed(evt);
            }
        });
        jPanel1.add(select_katagoriler, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 190, 40));

        jLabel1.setText("Katagori Seçiniz");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 170, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ayakkabıimage/logo5.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 150, 140));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 0));
        jLabel2.setText("Her Gün Bir Alışveriş Günüdür");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 230, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void select_katagorilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_katagorilerActionPerformed
       
        if (select_katagoriler.getSelectedIndex()==0) {
            try {
                Helper.showMsg("Lütfen Katagori Seçiniz");
                MüsteriGUI müsteriGUI=new MüsteriGUI();
                müsteriGUI.setVisible(true);
            } catch (SQLException ex) {
               
            }
            
        }
        else if(select_katagoriler.getSelectedIndex()==1){
            
                elbise_GUI giyimÜrünleriGUI=new elbise_GUI();
                giyimÜrünleriGUI.setVisible(true);
                
             
          
        }
       
        else if (select_katagoriler.getSelectedIndex()==2) {
            TeknolojiGUI teknolojiGUI=new TeknolojiGUI();
            teknolojiGUI.setVisible(true);
            dispose();
            
        }
        
     
         else if(select_katagoriler.getSelectedIndex()==3){
             HijyenGUI hijyenGUI=new HijyenGUI();
             hijyenGUI.setVisible(true);
             dispose();
            
        }  else if(select_katagoriler.getSelectedIndex()==4){
             MarketGUI marketGUI=new MarketGUI();
             marketGUI.setVisible(true);
             dispose();
            
        }
        
        
       
        
    }//GEN-LAST:event_select_katagorilerActionPerformed

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
            java.util.logging.Logger.getLogger(MüsteriGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MüsteriGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MüsteriGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MüsteriGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
              FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MüsteriGUI().setVisible(true);
                } catch (SQLException ex) {
                  
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> select_katagoriler;
    // End of variables declaration//GEN-END:variables
}
