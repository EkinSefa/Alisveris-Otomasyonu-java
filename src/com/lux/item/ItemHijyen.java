/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.lux.item;

import Model.ModelItem;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;


public class ItemHijyen extends javax.swing.JPanel {

    
    public ModelItem getData() {
        return data;
    }

   
    public boolean isSelected() {
        return selected;
    }

    
    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

 private boolean selected;
    public ItemHijyen() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }
    private ModelItem data;
    public void setData(ModelItem data){
        this.data=data;
        pic.setImage(data.getImage());
        lbItemName.setText(data.getItemName());
        lbDesciription.setText(data.getDescription());
        lbBrand.setText(data.getBradName());
        DecimalFormat df=new DecimalFormat("₺#,##0.00");
        lbPrice.setText(df.format(data.getPrice()));
        
    }

    @Override
   public void paint(Graphics grphcs){
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242,242,242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if(selected){
            g2.setColor(new Color(94,156,255));
            g2.drawRoundRect(0,0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        g2.dispose();
        super.paint(grphcs);
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbItemName = new javax.swing.JLabel();
        lbDesciription = new javax.swing.JLabel();
        pic = new Model.PictureBox();
        lbPrice = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(190, 222));

        lbItemName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(178, 178, 178));
        lbItemName.setText("Item Name");

        lbDesciription.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDesciription.setForeground(new java.awt.Color(76, 76, 76));
        lbDesciription.setText("Desciription");

        pic.setImage(new javax.swing.ImageIcon(getClass().getResource("/ayakkabıimage/8.jpg"))); // NOI18N

        lbPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(178, 178, 178));
        lbPrice.setText("0.00 ₺ ");

        lbBrand.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbBrand.setForeground(new java.awt.Color(76, 76, 76));
        lbBrand.setText("Brand");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbPrice)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbDesciription, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbItemName)
                .addGap(10, 10, 10)
                .addComponent(lbDesciription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPrice)
                    .addComponent(lbBrand))
                .addContainerGap(11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbDesciription;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private Model.PictureBox pic;
    // End of variables declaration//GEN-END:variables
}
