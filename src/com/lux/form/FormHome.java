
package com.lux.form;

import Model.ModelItem;
import Model.ScrollBar;
import com.lux.item.Item;
import com.lux.event.EventItem;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.SwingUtilities;


public class FormHome extends javax.swing.JPanel {

   
    public void setEvent(EventItem event) {
        this.event = event;
    }

 private EventItem event;   
    public FormHome() {
        initComponents();
        scroll.setVerticalScrollBar(new ScrollBar());
    }
    
    
public void addItem(ModelItem data){
    Item item=new Item();
    item.setData(data);
    item.addMouseListener(new MouseAdapter(){
     @Override
     public  void mousePressed(MouseEvent me){
         if (SwingUtilities.isLeftMouseButton(me)) {
             event.itemClick(item, data);
         }
     }
    
    });
    panelItem.add(item);
    panelItem.repaint();
    panelItem.revalidate();
    
}


public void setSelected(Component item){
    for(Component com:panelItem.getComponents()){
        Item i=(Item)com;
        if(i.isSelected()){
            i.setSelected(false);
        }
    }
    ((Item)item).setSelected(true);
}

public  void showItem(ModelItem data){
    lbItemName.setText(data.getItemName());
    txtDesciription.setText(data.getDescription());
    lbBrand.setText(data.getBradName());
    DecimalFormat df=new DecimalFormat("₺#,##0.00");
    lbPrice.setText(df.format(data.getPrice()));
}
   
 public Point getPanelItemLocation(){
     Point p=scroll.getLocation();
     return new Point(p.x,p.y-scroll.getViewport().getViewPosition().y);
 }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbItemName = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        txtDesciription = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        scroll = new javax.swing.JScrollPane();
        panelItem = new Model.PanelItem();

        setOpaque(false);

        jPanel1.setOpaque(false);

        jPanel2.setPreferredSize(new java.awt.Dimension(190, 222));

        lbItemName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(178, 178, 178));
        lbItemName.setText("Item Name");

        lbPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(178, 178, 178));
        lbPrice.setText("0.00 ₺ ");

        lbBrand.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbBrand.setForeground(new java.awt.Color(76, 76, 76));
        lbBrand.setText("Brand");

        txtDesciription.setBorder(null);
        txtDesciription.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDesciription.setForeground(new java.awt.Color(178, 178, 178));
        txtDesciription.setToolTipText("");
        txtDesciription.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbBrand, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                .addGap(186, 186, 186))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDesciription, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbItemName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lbItemName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPrice)
                .addGap(1, 1, 1)
                .addComponent(lbBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDesciription, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setViewportView(panelItem);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private Model.PanelItem panelItem;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextPane txtDesciription;
    // End of variables declaration//GEN-END:variables
}
