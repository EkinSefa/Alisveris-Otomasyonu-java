
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
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;


public class Ana extends javax.swing.JFrame {

    private FormHome home;
    private Animator animator;
    private Point animatePoint;
    private ModelItem itemSelected;
   
   
    public Ana() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        init();
        // animator başlatma yeri
        
        animator = PropertySetter.createAnimator(500, anaPanel, "ImageLocation", animatePoint,anaPanel.getTargetLocation());
        animator.addTarget(new PropertySetter(anaPanel,"ImageSize",new Dimension(200,120),anaPanel.getTargetSize()));
        animator.addTarget(new TimingTargetAdapter(){
            public  void and(){
               anaPanel.setImageOld(null);
            }
        });
       animator.setResolution(0);
       animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        
    }
  
    
    public  void init(){
        home=new FormHome();
        winButton.initEvent(this, background1);
        anaPanel.setLayout(new BorderLayout());
        anaPanel.add(home);
        testData();
    }
    
    private void testData() {
        home.setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, ModelItem item) {
                if(itemSelected!=null){
                    anaPanel.setImageOld(itemSelected.getImage());
                }
                if (itemSelected != item) {
                    
               if(!animator.isRunning()){
                   itemSelected=item;
                   animatePoint =getLocationOf(com);
                   anaPanel.setImage(item.getImage());
                   anaPanel.setImageLocation(animatePoint);
                   anaPanel.setImageSize(new Dimension(180,120));
                   anaPanel.repaint();
                   home.setSelected(com);
                   home.showItem(item);
                   animator.start();
                   
               }     
                    
          
            }
           }
        });
        
        int ID=1;
        for(int i=0;i<=5;i++){   // örnek  ürün ekleme
            home.addItem(new ModelItem(ID++,"4DFWD PULSE","This product is exculuded from all promatial discountus and offers",1500,"Adidas",new ImageIcon(getClass().getResource("/ayakkabıimage/img1.png"))));
            home.addItem(new ModelItem(ID++,"FORUM MİD","This product is exculuded from all promatial discountus and offers",1600,"Adidas",new ImageIcon(getClass().getResource("/ayakkabıimage/img2.png"))));
            home.addItem(new ModelItem(ID++,"5DFWD PULSE","This product is exculuded from all promatial discountus and offers",1700,"Adidas",new ImageIcon(getClass().getResource("/ayakkabıimage/img3.png"))));
            home.addItem(new ModelItem(ID++,"7DFWD PULSE","This product is exculuded from all promatial discountus and offers",1800,"Adidas",new ImageIcon(getClass().getResource("/ayakkabıimage/img4.png"))));
            home.addItem(new ModelItem(ID++,"2DFWD PULSE","This product is exculuded from all promatial discountus and offers",1900,"Adidas",new ImageIcon(getClass().getResource("/ayakkabıimage/img5.png"))));
            home.addItem(new ModelItem(ID++,"1DFWD PULSE","MBD City Stock 2",2000,"Adidas",new ImageIcon(getClass().getResource("/ayakkabıimage/img6.png"))));
            
        }
    }
    
    private Point getLocationOf(Component com){
        Point p=home.getPanelItemLocation();
        int x=p.x;
        int y=p.y;
        int itemX=com.getX();
        int itemY=com.getY();
        int left=10;
        int top=35;
        return  new Point(x+itemX+left,y+itemY+top);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new Model.Background();
        header = new javax.swing.JPanel();
        winButton = new View.win_button.WinButton();
        anaPanel = new Model.AnaPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        header.setOpaque(false);

        javax.swing.GroupLayout anaPanelLayout = new javax.swing.GroupLayout(anaPanel);
        anaPanel.setLayout(anaPanelLayout);
        anaPanelLayout.setHorizontalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1108, Short.MAX_VALUE)
        );
        anaPanelLayout.setVerticalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(winButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(anaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(winButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Ana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ana().setVisible(true);
            }
        });
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Model.AnaPanel anaPanel;
    private Model.Background background1;
    private javax.swing.JPanel header;
    private View.win_button.WinButton winButton;
    // End of variables declaration//GEN-END:variables
}
