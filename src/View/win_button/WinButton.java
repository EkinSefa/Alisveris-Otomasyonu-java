package View.win_button;


import Model.Background;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class WinButton extends javax.swing.JPanel {

    public WinButton() {
        initComponents();
        setOpaque(false);
    }

    public void initEvent(JFrame fram,Background panel) {
        cmdClose_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        cmdMi_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fram.setState(JFrame.ICONIFIED);
            }
        });
        cmdRE_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (fram.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                  panel.setRound(20);
                    fram.setExtendedState(JFrame.NORMAL);
                } else {
                    panel.setRound(0);
                    fram.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdClose_btn = new javax.swing.JButton();
        cmdRE_btn = new javax.swing.JButton();
        cmdMi_btn = new javax.swing.JButton();

        cmdClose_btn.setText("Kapat");
        cmdClose_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdClose_btnActionPerformed(evt);
            }
        });

        cmdRE_btn.setText("Tam Ekran");

        cmdMi_btn.setText("Geri");
        cmdMi_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMi_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(cmdMi_btn)
                .addGap(18, 18, 18)
                .addComponent(cmdRE_btn)
                .addGap(18, 18, 18)
                .addComponent(cmdClose_btn)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdClose_btn)
                    .addComponent(cmdRE_btn)
                    .addComponent(cmdMi_btn))
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdMi_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMi_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdMi_btnActionPerformed

    private void cmdClose_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClose_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdClose_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdClose_btn;
    private javax.swing.JButton cmdMi_btn;
    private javax.swing.JButton cmdRE_btn;
    // End of variables declaration//GEN-END:variables
}
