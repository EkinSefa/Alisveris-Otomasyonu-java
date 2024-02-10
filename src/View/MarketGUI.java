
package View;

import Model.ModelItem;
import com.lux.event.EventItem;
import com.lux.form.FormHome;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;


import javax.swing.ImageIcon;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;


public class MarketGUI extends javax.swing.JFrame {

    private FormHome home;
    private Animator animator;
    private Point animatePoint;
    private ModelItem itemSelected;
   
   
    public MarketGUI() {
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
        for(int i=0;i<=5;i++){
            home.addItem(new ModelItem(ID++,"5RT65SCG"," Beyaz, Kristal, Toz, Miktar: 5 kg",171.59,"Şeker",new ImageIcon(getClass().getResource("/ayakkabıimage/14.jpg"))));
            home.addItem(new ModelItem(ID++,"6T65G1E5","Ayçiçek, Boyut: 1 lt, Pet",99,"Yudum Yağ",new ImageIcon(getClass().getResource("/ayakkabıimage/15.jpg"))));
            home.addItem(new ModelItem(ID++,"5R45GEH8","Buğday, Miktar: 5 kg",90,"Söke Un",new ImageIcon(getClass().getResource("/ayakkabıimage/16.jpg"))));
            home.addItem(new ModelItem(ID++,"06OK6S98","Bir makarnayı lezzetli yapan tek şey üretildiği buğdayın kalitesi oluyor.",16,"Ankara Makarna",new ImageIcon(getClass().getResource("/ayakkabıimage/17.jpg"))));
            home.addItem(new ModelItem(ID++,"E68GF545","Protein değeri ve lif oranı bakımından tatmin edici olan Yayla kırmızı mercimek, mutfakların vazgeçilmez besinleri arasında bulunuyor.",78.90,"Yayla",new ImageIcon(getClass().getResource("/ayakkabıimage/18.jpg"))));
            home.addItem(new ModelItem(ID++,"66RR896S","Sütaş Beyaz Peynir, ideal lezzet ve yapısıyla kahvaltı sofralarının vazgeçilmezidir.",163.50,"Sütaş Peynir",new ImageIcon(getClass().getResource("/ayakkabıimage/19.jpg"))));
             home.addItem(new ModelItem(ID++,"85ŞLO85D8","Yoğurt doğaldır, sadece taze süt ve taze maya içerir, hiçbir koruyucu madde içermez. Çiftliklerimizin doğal ve taze sütleri, her seferinde bol miktarda taze ve canlı maya ile mayalanır. ",37.50,"Sütaş Yoğurt",new ImageIcon(getClass().getResource("/ayakkabıimage/20.jpg"))));
              home.addItem(new ModelItem(ID++,"98AS985S","Ülker Sütlü Lüks Tablet,  yumuşacık, ağızda eriyen yapısı ve yoğun aroması ile oldukça lezzetli bir çikolatadır.",5,"Adidas",new ImageIcon(getClass().getResource("/ayakkabıimage/21.jpg"))));
            
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
            java.util.logging.Logger.getLogger(MarketGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarketGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarketGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarketGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MarketGUI().setVisible(true);
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
