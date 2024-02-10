package View;

import Model.ModelItem;
import com.lux.event.EventItem;
import com.lux.form.FormHome;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;

import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

public class elbise_GUI extends javax.swing.JFrame {

    private FormHome home;
    private Animator animator;
    private Point animatePoint;
    private ModelItem itemSelected;

    public elbise_GUI() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        init();
        // animator başlatma yeri

        animator = PropertySetter.createAnimator(500, anaPanelel, "ImageLocation", animatePoint, anaPanelel.getTargetLocation());
        animator.addTarget(new PropertySetter(anaPanelel, "ImageSize", new Dimension(200, 120), anaPanelel.getTargetSize()));
        animator.addTarget(new TimingTargetAdapter() {
            public void and() {
                anaPanelel.setImageOld(null);
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);

    }

    public void init() {
        home = new FormHome();
        winButton.initEvent(this, background1);
        anaPanelel.setLayout(new BorderLayout());
        anaPanelel.add(home);
        testData();
    }

    private void testData() {
        home.setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, ModelItem item) {
                if (itemSelected != null) {
                    anaPanelel.setImageOld(itemSelected.getImage());
                }
                if (itemSelected != item) {

                    if (!animator.isRunning()) {
                        itemSelected = item;
                        animatePoint = getLocationOf(com);
                        anaPanelel.setImage(item.getImage());
                        anaPanelel.setImageLocation(animatePoint);
                        anaPanelel.setImageSize(new Dimension(180, 120));
                        anaPanelel.repaint();
                        home.setSelected(com);
                        home.showItem(item);
                        animator.start();

                    }

                }
            }
        });

        int ID = 1;
        for (int i = 0; i <= 5; i++) {
            home.addItem(new ModelItem(ID++, "548C8RE4W", "Takım elbiselerimiz kalite standartlarındadır", 2500.59, "Hatemoğlu", new ImageIcon(getClass().getResource("/ayakkabıimage/img7.jpg"))));
            home.addItem(new ModelItem(ID++, "98E985RF", "Erkek çocuk takım elbise modeli ile efsane kombinler oluşturabilirsiniz.", 1249.99, "Mavi", new ImageIcon(getClass().getResource("/ayakkabıimage/cocuk.jpg"))));
            home.addItem(new ModelItem(ID++, "D95SDCVV", "Kumaş İçeriği: %73 Micro Modal %27 Polyester.Yeni koleksiyonumuzla sizleri cesur ve özgür bir stil yaratmaya davet ediyoruz.", 1000, "Defacto", new ImageIcon(getClass().getResource("/ayakkabıimage/kadın1.jpg"))));
            home.addItem(new ModelItem(ID++, "99DF5S6", "Kumaş İçeriği: %80 Micro Modal %20 Polyester.Yeni koleksiyonumuzla sizleri cesur ve özgür bir stil yaratmaya davet ediyoruz.", 1749.99, "Tredyol", new ImageIcon(getClass().getResource("/ayakkabıimage/kadın2.jpg"))));
            home.addItem(new ModelItem(ID++, "PİERRE CARDİN", "Kumaş İçeriği: %55 Micro Modal %15 Polyester. %30 pamuk", 1799.99, "PİERRE CARDİN", new ImageIcon(getClass().getResource("/ayakkabıimage/kadın3.jpg"))));
            home.addItem(new ModelItem(ID++, "98CS98SC", "Kumaş Detay: %100 SAF Pamuk Keten ,Pamuk Astarlı Yumuşacık SAF Pamuk Keten Elbise", 1500, "ZARA", new ImageIcon(getClass().getResource("/ayakkabıimage/kız1.jpg"))));
            home.addItem(new ModelItem(ID++, "SD945S", "Takım elbise %80 pamuk,%20 poliesterden oluşmaktadır.Kalite standartlarındadır", 1300, "HepsiBurada", new ImageIcon(getClass().getResource("/ayakkabıimage/erkek1.jpg"))));

        }
    }

    private Point getLocationOf(Component com) {
        Point p = home.getPanelItemLocation();
        int x = p.x;
        int y = p.y;
        int itemX = com.getX();
        int itemY = com.getY();
        int left = 10;
        int top = 35;
        return new Point(x + itemX + left, y + itemY + top);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new Model.Background();
        header = new javax.swing.JPanel();
        winButton = new View.win_button.WinButton();
        anaPanelel = new Model.AnaPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        header.setOpaque(false);

        javax.swing.GroupLayout anaPanelelLayout = new javax.swing.GroupLayout(anaPanelel);
        anaPanelel.setLayout(anaPanelelLayout);
        anaPanelelLayout.setHorizontalGroup(
            anaPanelelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1108, Short.MAX_VALUE)
        );
        anaPanelelLayout.setVerticalGroup(
            anaPanelelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(winButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(anaPanelel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(winButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anaPanelel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(elbise_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(elbise_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(elbise_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(elbise_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new elbise_GUI().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Model.AnaPanel anaPanelel;
    private Model.Background background1;
    private javax.swing.JPanel header;
    private View.win_button.WinButton winButton;
    // End of variables declaration//GEN-END:variables
}
