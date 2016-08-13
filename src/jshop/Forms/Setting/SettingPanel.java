/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Forms.Setting;

import javax.swing.JOptionPane;

/**
 *
 * @author Bartek
 */
public class SettingPanel extends javax.swing.JPanel {

    /**
     * Creates new form SettingPanel
     */
    public SettingPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonLoadData = new javax.swing.JButton();
        ButtonSaveData = new javax.swing.JButton();

        ButtonLoadData.setText("Wczytaj dane");
        ButtonLoadData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonLoadDataMouseClicked(evt);
            }
        });

        ButtonSaveData.setText("Zapisz dane");
        ButtonSaveData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonSaveDataMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonLoadData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(ButtonSaveData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonLoadData)
                    .addComponent(ButtonSaveData))
                .addContainerGap(156, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLoadDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLoadDataMouseClicked
        JOptionPane.showMessageDialog(this, "Load Data");
    }//GEN-LAST:event_ButtonLoadDataMouseClicked

    private void ButtonSaveDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSaveDataMouseClicked
        JOptionPane.showMessageDialog(this, "Save Data");
    }//GEN-LAST:event_ButtonSaveDataMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLoadData;
    private javax.swing.JButton ButtonSaveData;
    // End of variables declaration//GEN-END:variables
}
