/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Forms;

import java.awt.Window;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import jshop.Classes.Customer;
import jshop.Classes.Product;
import jshop.Enums.OrderType;

/**
 *
 * @author bartek
 */
public class OrderFormPanel extends javax.swing.JPanel {

    DefaultComboBoxModel<String> customerComboBoxModel;
    DefaultComboBoxModel<String> productComboBoxModel;
    DefaultListModel<String> productListModel;
    /**
     * Creates new form OrderFormPanel
     */
    public OrderFormPanel() {
        
        customerComboBoxModel = new DefaultComboBoxModel<>();
        productComboBoxModel = new DefaultComboBoxModel<>();
        productListModel = new DefaultListModel<>();
        initComponents();        
    }
    
    public void setType(OrderType orderType) {
        ComboBoxType.setSelectedItem(orderType.toString());
    }
    
    public OrderType getType() {
        return OrderType.valueOf(ComboBoxType.getSelectedItem().toString());
    }
    
    public void setCustomer(Map<Integer, Customer> customerMap, Customer customer) {
        for(int i = 0; i < customerMap.size(); i++) {
            if (customerMap.get(i) != null) {
                String customerInfo = new String(
                    customerMap.get(i).getName() + " " +
                    customerMap.get(i).getSurname() + " [Id: " +
                    customerMap.get(i).getId() + "]"
                );
                customerComboBoxModel.addElement(customerInfo);
            }            
        }
        if(customer != null) {
            ComboBoxCustomer.setSelectedItem(customer);
        }        
    }
    
    //public Customer getCustomer() {
        //return ComboBoxType.getSelectedItem();
        //return new Customer();
    //}
    
    //get&set products
    public void setProduct(Map<Integer, Product> productMap, List<Product> product) {
        for(int i = 0; i <= productMap.size(); i++) {
            if (productMap.get(i) != null) {
                String productInfo = new String(
                    productMap.get(i).getName() + " " +
                    productMap.get(i).getType() + " [Id: " +
                    productMap.get(i).getId() + "]"
                );
                productComboBoxModel.addElement(productInfo);
            }            
        }  
        if(product != null) {
            for(int i = 0; i <= product.size(); i++) {
                String productInfo = new String(
                    productMap.get(i).getName() + " " +
                    productMap.get(i).getType() + " [Id: " +
                    productMap.get(i).getId() + "]"
                );
                productListModel.addElement(productInfo);
            }
        }
    }

    public void setButtonText(String text) {
        ButtonActionOrderDialog.setText(text);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelType = new javax.swing.JLabel();
        ComboBoxType = new javax.swing.JComboBox<>();
        LabelCustomer = new javax.swing.JLabel();
        ComboBoxCustomer = new javax.swing.JComboBox<>();
        LabelProducts = new javax.swing.JLabel();
        ComboBoxProducts = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListProducts = new javax.swing.JList<>();
        ButtonActionOrderDialog = new javax.swing.JButton();

        LabelType.setText("Typ");

        ComboBoxType.setModel(new DefaultComboBoxModel(OrderType.values()));

        LabelCustomer.setText("Klient");

        ComboBoxCustomer.setModel(customerComboBoxModel);

        LabelProducts.setText("Produkty");

        ComboBoxProducts.setModel(productComboBoxModel);
        ComboBoxProducts.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxProductsItemStateChanged(evt);
            }
        });

        ListProducts.setModel(productListModel);
        ListProducts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListProducts.setEnabled(false);
        jScrollPane1.setViewportView(ListProducts);

        ButtonActionOrderDialog.setText("Dodaj zamówienie");
        ButtonActionOrderDialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonActionOrderDialogMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelType)
                            .addComponent(LabelCustomer)
                            .addComponent(LabelProducts))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(ComboBoxType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBoxCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ComboBoxProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(ButtonActionOrderDialog)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelType)
                    .addComponent(ComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCustomer)
                    .addComponent(ComboBoxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelProducts)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboBoxProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonActionOrderDialog)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonActionOrderDialogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonActionOrderDialogMouseClicked
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
           window.dispose();
        }
    }//GEN-LAST:event_ButtonActionOrderDialogMouseClicked

    private void ComboBoxProductsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxProductsItemStateChanged
        //add item to list
    }//GEN-LAST:event_ComboBoxProductsItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonActionOrderDialog;
    private javax.swing.JComboBox<String> ComboBoxCustomer;
    private javax.swing.JComboBox<String> ComboBoxProducts;
    private javax.swing.JComboBox<String> ComboBoxType;
    private javax.swing.JLabel LabelCustomer;
    private javax.swing.JLabel LabelProducts;
    private javax.swing.JLabel LabelType;
    private javax.swing.JList<String> ListProducts;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}