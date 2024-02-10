
package View;

import Helper.Helper;

import Model.Katagori;
import Model.Yönetici;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;





public class YöneticiGUI extends javax.swing.JFrame {

    static Yönetici yönetici=new Yönetici();     // yazamaz isek hata veriri  rahat kullanımı sağlamak için
    private DefaultTableModel yöneticiModel=null;
    private DefaultTableModel müsteriModel=null;
    private Object [] MüsteriData=null;
    
    private DefaultTableModel katagoriModel=null;
    private Object[] katagoriData=null;
    Katagori katagori=new Katagori();
    
 
    private JPopupMenu katagoriMenu;
    
   
     public YöneticiGUI(Yönetici yöneticiGUI) throws SQLException{            // sayın yazılan yere isim eklemek için
        initComponents();
        Image icon = new ImageIcon(this.getClass().getResource("/ayakkabıimage/lo5.png")).getImage();
        this.setIconImage(icon);
      
         System.out.println("");
        
        jLabel1.setText("Hoşgeldiniz, Sayın " + yöneticiGUI.getNickname());
        
    
        //musteri
        müsteriModel=new DefaultTableModel();
        Object [] colMüsteriName=new Object[5];
        colMüsteriName[0]="ID";
        colMüsteriName[1]="KULLANICI ADI";
        colMüsteriName[2]="ŞİFRE";
        colMüsteriName[3]="ADI";
        colMüsteriName[4]="tür";
        müsteriModel.setColumnIdentifiers(colMüsteriName);
        MüsteriData=new Object[5];
         Tablo_kullanıcı.setModel(müsteriModel);
       IDbelirle();
       updateMüsteriModel();
       
       
       
       
            // katagori model  
           katagoriModel=new DefaultTableModel();
           Object [] colkatagori=new Object[2];
           colkatagori[0]="ID";
           colkatagori[1]="Katagori";
           
           katagoriModel.setColumnIdentifiers(colkatagori);
           katagoriData=new Object[2];
           Table_katagori.setModel(katagoriModel);
           
           for(int i=0;i<katagori.getList().size();i++){
               katagoriData[0]=katagori.getList().get(i).getId();
               katagoriData[1]=katagori.getList().get(i).getName();
               katagoriModel.addRow(katagoriData);
               
                
           } 
       
       
          katagoriMenu=new JPopupMenu();
          JMenuItem updataMenü=new JMenuItem("Güncelle");
          JMenuItem deleteMenü=new JMenuItem("Silme");
          katagoriMenu.add(updataMenü);
          katagoriMenu.add(deleteMenü);
            
            
            updataMenü.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int selID=Integer.parseInt(Table_katagori.getValueAt(Table_katagori.getSelectedRow(), 0).toString());
                Katagori selectKatagori=katagori.getFetch(selID);
                UpdateKatagoriGUI updateGUI=new UpdateKatagoriGUI(selectKatagori);
                updateGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                updateGUI.setVisible(true);
                updateGUI.addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosed(WindowEvent e) {
                        try {
                            updateKatagoriModel();
                        } catch (SQLException ex) {
                            
                        }
                    }
                    
                });
                
              
            }
                
            });
            deleteMenü.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.confirm("sure")) {
                    try {
                        int selID=Integer.parseInt(Table_katagori.getValueAt(Table_katagori.getSelectedRow(), 0).toString());
                        if (katagori.deleteKatagori(selID)) {
                            Helper.showMsg("success");
                            updateKatagoriModel();
                            
                        }
                        else{
                            Helper.showMsg("error");
                            
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                
            }
                
            });
         
            
              
               Table_katagori.setModel(katagoriModel); 
            Table_katagori.setComponentPopupMenu(katagoriMenu);
           Table_katagori.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point =e.getPoint();
                int selectedRow=Table_katagori.rowAtPoint(point);
                Table_katagori.setRowSelectionInterval(selectedRow, selectedRow);
                
                 
            }
               
           });
         
           
          
          
        
              
       
    }
         
     
     
       public  void updateMüsteriModel() throws SQLException{
     
        DefaultTableModel clearModel=(DefaultTableModel)Tablo_kullanıcı.getModel();
        clearModel.setRowCount(0);
              for(int i=0;i<yönetici.getMüsteriList().size();i++){
           MüsteriData[0]=yönetici.getMüsteriList().get(i).getId();       // collection   !!!!
           MüsteriData[1]=yönetici.getMüsteriList().get(i).getNickname();
           MüsteriData[2]=yönetici.getMüsteriList().get(i).getPassword(); 
           MüsteriData[3]=yönetici.getMüsteriList().get(i).getName(); 
           MüsteriData[4]=yönetici.getMüsteriList().get(i).getType();
           müsteriModel.addRow(MüsteriData);
           
           Tablo_kullanıcı.setModel(müsteriModel);
              }
              
              
 
              
              
             
    }
       
         public  void updateKatagoriModel() throws SQLException{
     
        DefaultTableModel clearModel=(DefaultTableModel)Table_katagori.getModel();
        clearModel.setRowCount(0);
              for(int i=0;i<katagori.getList().size();i++){
           katagoriData[0]=katagori.getList().get(i).getId();       // collection   !!!!
           katagoriData[1]=katagori.getList().get(i).getName();
           katagoriModel.addRow(katagoriData);
           
           Tablo_kullanıcı.setModel(katagoriModel);
       }
         }
       
       
     public void IDbelirle()throws SQLException{
       Tablo_kullanıcı.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
       
           @Override
           public void valueChanged(ListSelectionEvent e) {
               try {
                   fld_kullanıcıID.setText(Tablo_kullanıcı.getValueAt(Tablo_kullanıcı.getSelectedRow(), 0).toString());
               } catch (Exception ex) {
               }
           }
     });
     
       
       
       
       Tablo_kullanıcı.getModel().addTableModelListener(new TableModelListener() {
           @Override
           public void tableChanged(TableModelEvent e) {
               if (e.getType()==TableModelEvent.UPDATE) {
                   int selectID=Integer.parseInt(Tablo_kullanıcı.getValueAt(Tablo_kullanıcı.getSelectedRow(), 0).toString());
                   String selectNickname=Tablo_kullanıcı.getValueAt(Tablo_kullanıcı.getSelectedRow(), 1).toString();
                   String selectPassword=Tablo_kullanıcı.getValueAt(Tablo_kullanıcı.getSelectedRow(), 2).toString();
                   String selectName=Tablo_kullanıcı.getValueAt(Tablo_kullanıcı.getSelectedRow(), 3).toString();
                   String selectType=Tablo_kullanıcı.getValueAt(Tablo_kullanıcı.getSelectedRow(), 4).toString();
                   
                   
                   try {
                      boolean kontrol= yönetici.UpdataKullanıcı(selectID, selectNickname, selectPassword, selectName, selectType);
                      
  
                   } catch (SQLException e1) {
                       e1.printStackTrace();
                   }
               }
           }
       });
       
       
       
       
       
     }
     
     
     

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        w_Tabbedpane = new javax.swing.JTabbedPane();
        w_kullanıcıpanel = new javax.swing.JPanel();
        fld_search = new javax.swing.JTextField();
        lbl_search = new javax.swing.JLabel();
        fld_kullanıcıID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_KullanıcıSil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablo_kullanıcı = new javax.swing.JTable();
        w_katagori = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_katagori = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        fld_katagoriName = new javax.swing.JTextField();
        btn_addkatagori = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Yönetici Ekranı");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(350, 175));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Hoşgeldiniz, Sayın");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 45, 214, 27));

        fld_search.setBackground(new java.awt.Color(255, 255, 255));
        fld_search.setForeground(new java.awt.Color(0, 0, 0));
        fld_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fld_searchActionPerformed(evt);
            }
        });
        fld_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fld_searchKeyReleased(evt);
            }
        });

        lbl_search.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        lbl_search.setForeground(new java.awt.Color(0, 0, 0));
        lbl_search.setText("Arama :");

        fld_kullanıcıID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Kullanıcı ID");

        btn_KullanıcıSil.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_KullanıcıSil.setText("Kullanıcıyı Sil");
        btn_KullanıcıSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KullanıcıSilActionPerformed(evt);
            }
        });

        Tablo_kullanıcı.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tablo_kullanıcı);

        javax.swing.GroupLayout w_kullanıcıpanelLayout = new javax.swing.GroupLayout(w_kullanıcıpanel);
        w_kullanıcıpanel.setLayout(w_kullanıcıpanelLayout);
        w_kullanıcıpanelLayout.setHorizontalGroup(
            w_kullanıcıpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(w_kullanıcıpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(w_kullanıcıpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(w_kullanıcıpanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbl_search, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(fld_search, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(w_kullanıcıpanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(w_kullanıcıpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(w_kullanıcıpanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(w_kullanıcıpanelLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(fld_kullanıcıID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_KullanıcıSil, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        w_kullanıcıpanelLayout.setVerticalGroup(
            w_kullanıcıpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(w_kullanıcıpanelLayout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(w_kullanıcıpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_search, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fld_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(w_kullanıcıpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(w_kullanıcıpanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(fld_kullanıcıID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btn_KullanıcıSil)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        w_Tabbedpane.addTab("Kullanıcı", w_kullanıcıpanel);

        w_katagori.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table_katagori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Table_katagori);

        w_katagori.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 490, 320));

        jLabel3.setText("Katagori  Adı");
        w_katagori.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 110, 30));
        w_katagori.add(fld_katagoriName, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 110, 30));

        btn_addkatagori.setText("Ekle");
        btn_addkatagori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addkatagoriActionPerformed(evt);
            }
        });
        w_katagori.add(btn_addkatagori, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 110, 30));

        w_Tabbedpane.addTab("Katagoriler", w_katagori);

        jPanel1.add(w_Tabbedpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 680, 360));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jButton1.setText(" Çıkış Yap");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 30, 120, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_KullanıcıSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KullanıcıSilActionPerformed
        if (fld_kullanıcıID.getText().length()==0) {
            Helper.showMsg("Lütfen geçerli bir kullanıcı seçiniz ");
        }
        else{
            if (Helper.confirm("sure")) {
                            try {
                int selectID=Integer.parseInt(fld_kullanıcıID.getText());
                boolean kontrol =yönetici.deleteKullanıcı(selectID);
                if(kontrol){
                    Helper.showMsg("success");
                    fld_kullanıcıID.setText(null);
                    updateMüsteriModel();
                    
                }
            } catch (SQLException e) {
               e.printStackTrace();
            }
                
            }
        }
    }//GEN-LAST:event_btn_KullanıcıSilActionPerformed

    private void fld_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fld_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fld_searchActionPerformed

    private void fld_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fld_searchKeyReleased
        
       String searchKey=fld_search.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter=new TableRowSorter<DefaultTableModel>(müsteriModel);
        Tablo_kullanıcı.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
        
        
    }//GEN-LAST:event_fld_searchKeyReleased

    private void btn_addkatagoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addkatagoriActionPerformed
       
        if (fld_katagoriName.getText().length()==0) {
            
            Helper.showMsg("fill");
        }else{
            try {
                if (katagori.addKatagori(fld_katagoriName.getText())) {
                    Helper.showMsg("success");
                    fld_katagoriName.setText(null);
                    updateKatagoriModel();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
    }//GEN-LAST:event_btn_addkatagoriActionPerformed

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
            java.util.logging.Logger.getLogger(YöneticiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YöneticiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YöneticiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YöneticiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    YöneticiGUI frame=new YöneticiGUI(yönetici);
                    frame.setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_katagori;
    private javax.swing.JTable Tablo_kullanıcı;
    private javax.swing.JButton btn_KullanıcıSil;
    private javax.swing.JButton btn_addkatagori;
    private javax.swing.JTextField fld_katagoriName;
    private javax.swing.JTextField fld_kullanıcıID;
    private javax.swing.JTextField fld_search;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_search;
    private javax.swing.JTabbedPane w_Tabbedpane;
    private javax.swing.JPanel w_katagori;
    private javax.swing.JPanel w_kullanıcıpanel;
    // End of variables declaration//GEN-END:variables
}
