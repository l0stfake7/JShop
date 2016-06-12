/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Forms;

import java.util.Map;
import javax.swing.DefaultListModel;
import static javax.swing.JOptionPane.showMessageDialog;
import jshop.Classes.Customer;
import jshop.Classes.Product;

/**
 *
 * @author bartek
 */
public class InfoPanel extends javax.swing.JPanel {

    private DefaultListModel<String> listModel;
   
    /**
     * Creates new form InfoPanel
     */
    public InfoPanel() {
        listModel = new DefaultListModel<>();
        initComponents();
    }
    
    public void InfoPanelCustomer(Map<Integer, Customer> customerMap) {
        if(customerMap.size() != 0) {
            Customer customer;
            for(int i = 0; i <= customerMap.size(); i++) {
                if((customer = customerMap.get(i)) != null) {
                    String customerInfo = customer.getName() + " " + customer.getSurname() + " (id: " + customer.getId() + ")";
                    listModel.addElement(customerInfo);
                }
            }
        }
        else {
            listModel.addElement("Brak klientow");
        }
    }
    
    public void InfoPanelProduct(Map<Integer, Product> productMap) {
        if(productMap.size() != 0) {
            Product product;
            for(int i = 0; i <= productMap.size(); i++) {
                if((product = productMap.get(i)) != null) {
                    String productInfo = product.getName() + " [" + product.getType() + "][" + productMap.get(i).getPrice() + "PLN] (id: " + productMap.get(i).getId() + ")";
                    listModel.addElement(productInfo);
                }
            }
        }
        else {
            listModel.addElement("Brak produktów");
        }
    }
    
    /*public <T extends Customer> InfoPanel(T t,Map<Integer, t> map) {
        //wpisanie wartosci do jlist
        super();   
    }   
    
    public <R extends Product> InfoPanel(Map<Integer, R> map) {
        super();   
    }  
    */
    /*public <T extends OverloadInterface> void InfoPanel(Map<Integer, T> objects)
    {
        listModel = new DefaultListModel<>();
        initComponents();
        for(T object: objects) 
        {
            object.construct();
        }           
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        jList1.setModel(listModel);
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
