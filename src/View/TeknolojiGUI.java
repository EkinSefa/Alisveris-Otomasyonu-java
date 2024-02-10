
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


public class TeknolojiGUI extends javax.swing.JFrame {

    private FormHome home;
    private Animator animator;
    private Point animatePoint;
    private ModelItem itemSelected;
   
   
    public TeknolojiGUI() {
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
            home.addItem(new ModelItem(ID++,"41232471","Ürün Tipi: Akıllı Telefon Renk (Üreticiye Göre): Beyaz Titanium Üretici Garantisi: 2 Yıl Apple Türkiye Garantili İşlemci: 6 çekirdekli GPU’ya sahip A17 Pro çip Bellek Kapasitesi: 256 GB Arttırılabilir Hafıza: Hayır RAM Bellek Boyutu: 8 GB",78999,"Apple",new ImageIcon(getClass().getResource("/ayakkabıimage/1.jpg"))));
            home.addItem(new ModelItem(ID++,"SM-X710NZAATUR","Ürün Tipi: Tablet Renk (Üreticiye Göre): Gri Üretici Garantisi: 2 Yıl Samsung Türkiye Garantili Ekran Boyutu (inç): 11 inç Çözünürlük: Dynamic Amoled 2X Görüntü kalitesi: Full-HD Ekran boyutu(cm): 27.94 cm",18999,"Samsung",new ImageIcon(getClass().getResource("/ayakkabıimage/2.jpg"))));
            home.addItem(new ModelItem(ID++,"7a89BD96D","Ürün Tipi: Oyuncu Kulak Üstü Kulaklık Renk (Üreticiye Göre): Siyah, Kırmızı Üretici Garantisi: 2 Yıl Resmi Üretici Garantili Desteklenen platformlar: Multi-platform Sinyal iletimi: Kablolu ve Kablosuz Genişlik: 214 mm Yükseklik: 229 mm",5899,"HYPERX",new ImageIcon(getClass().getResource("/ayakkabıimage/3.jpg"))));
            home.addItem(new ModelItem(ID++,"65LS03BG","Ürün Tipi: QLED TV Renk (Üreticiye Göre): Siyah Üretici Garantisi: 2 Yıl Samsung Türkiye Garantili Ekran Tipi: LED Ekran Boyutu: 163.9 cm / 65 inç Standsız boyutlar (G/Y/D): 145.68 cm / 83.19 cm / 2.49 cm Görüntü kalitesi: 4K UHD",61199,"Samsung",new ImageIcon(getClass().getResource("/ayakkabıimage/4.jpg"))));
            home.addItem(new ModelItem(ID++,"RF85A9111AP","Soğutucu (Bölme Hacmi): 525 l Donmuş Bölmelerin Hacmi: 355 l Enerji Verimliliği Sınıfı (EU 2017/1369): E Boyutlar (G/Y/D): 912 cm x 1853 cm x 906 cm Hızlı soğutma fonksiyonu: Evet Üretici Garantisi: 3 Yıl Samsung Türkiye Garantili Ürün Tipi: Gardrop Tipi Buzdolabı",99999,"Samsung",new ImageIcon(getClass().getResource("/ayakkabıimage/5.jpg"))));
            home.addItem(new ModelItem(ID++,"1Z Fold 5","Ürün Tipi: Akıllı Telefon Renk (Üreticiye Göre): Cream Üretici Garantisi: 2 Yıl Samsung Türkiye Garantili İşlemci: Snapdragon 8 Gen 2  İşlemci Hızı: 2.3GHz + 1.7 GHz Bellek Kapasitesi: 512 GB Arttırılabilir Hafıza: Evet",69000,"Samsung",new ImageIcon(getClass().getResource("/ayakkabıimage/6.jpg"))));
             home.addItem(new ModelItem(ID++,"C7UDX-292XTR","Ekran Boyutu17,3 inçEkran KartıNvidia GeForce RTX 4070Ekran Kartı Hafızası8 GBHarddisk KapasitesiYokİşletim SistemiYok (Free Dos)İşlemci13620Hİşlemci TipiIntel Core i7Ram (Sistem Belleği)16 GB",51499,"MSI",new ImageIcon(getClass().getResource("/ayakkabıimage/7.jpg"))));
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
            java.util.logging.Logger.getLogger(TeknolojiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeknolojiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeknolojiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeknolojiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TeknolojiGUI().setVisible(true);
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
