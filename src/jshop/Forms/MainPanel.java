/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Forms;


/**
 *
 * @author bartek
 */
public class MainPanel extends javax.swing.JPanel {
//TODO:
/**
 * zrobic wyjatki
 * gdy usuwany klient lub produkt to sprawic powiazane zlecenia
 * graniczne punkty, puste formularze, parsowanie peselu
 * maksymalna wartosc spinnera jako wielkosc counter obiektow
 */
    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        customerPanel2 = new jshop.Forms.CustomerPanel();
        productPanel1 = new jshop.Forms.ProductPanel();
        orderPanel1 = new jshop.Forms.OrderPanel();

        jTabbedPane2.addTab("Klienci", customerPanel2);
        jTabbedPane2.addTab("Produkty", productPanel1);
        jTabbedPane2.addTab("Zamówienia", orderPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jshop.Forms.CustomerPanel customerPanel2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private jshop.Forms.OrderPanel orderPanel1;
    private jshop.Forms.ProductPanel productPanel1;
    // End of variables declaration//GEN-END:variables
}
