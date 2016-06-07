/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Forms;

import java.awt.Dialog;
import java.awt.Window;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.SwingUtilities;
import jshop.Classes.Customer;
import jshop.Classes.ShopException;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import jshop.Classes.Order;

/**
 *
 * @author bartek
 */
public class MainFramePanel extends javax.swing.JPanel implements ListModel<Order> {
    
    private CustomerAddPanel customerAddPanel;
    private CustomerChooseActionPanel customerChooseActionPanel;
    
    private int globalIdCounter = 0;//Customers Id    
    private int listItemsCounter = 0;//items in jList
    
    DefaultListModel<String> listModel = new DefaultListModel<>();

    //collections
    /**
     * products - list
     * customers - list
     * orders - hasmap
     */
    private static Map<Integer, Customer> customerMap;
    private static Map<Integer, Integer> listCustomerBind;//Customer Id, Id from jList
    
    //po kazdej zmiane odswiezac cala jliste z indeksami, zrobic powiazanie indeks list-obiekt
    private static void addCustomer(Customer cust) {
        customerMap.put(cust.getId(), cust);
    }

    private static Customer getCustomer(int id) throws ShopException {
        if (customerMap.get(id) == null) {
            return null;//or throw new MyException("Not found object with id: " + id);//what is better?
        } else {
            return customerMap.get(id);//// TODO: 26.05.16 add safety search: if id doesn't exists return null or throws exception
        }
    }

    /**
     * Creates new form MainFramePanel
     */
    public MainFramePanel() {
        initComponents();
        
        listCustomerBind = new HashMap<Integer, Integer>();//Customer Id, Id from jList
        customerMap = new HashMap<Integer, Customer>();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelCustomers = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListCustomers = new javax.swing.JList<>();
        ButtonCustomerAdd = new javax.swing.JButton();

        LabelCustomers.setText("Klienci");

        ListCustomers.setModel(listModel);
        ListCustomers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListCustomersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListCustomers);

        ButtonCustomerAdd.setText("Dodaj klienta");
        ButtonCustomerAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonCustomerAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelCustomers)
                    .addComponent(jScrollPane1)
                    .addComponent(ButtonCustomerAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelCustomers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonCustomerAdd)
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCustomerAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCustomerAddMouseClicked
        
            customerAddPanel = new CustomerAddPanel();
            JDialog dialog = null;
            if (dialog == null) {            
                Window win = SwingUtilities.getWindowAncestor(this);
                if (win != null) {
                    dialog = new JDialog(win, "Dodaj klienta",
                            Dialog.ModalityType.APPLICATION_MODAL);
                    dialog.getContentPane().add(customerAddPanel);
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);
                }
            }
            dialog.setVisible(true); // here the modal dialog takes over
            //TODO check if datas from form is not null
            //get values from fields by getters      
            Date todayDate = new Date();
            
            Customer customer = new Customer(globalIdCounter,
                    customerAddPanel.getName(),
                    customerAddPanel.getSurname(),
                    customerAddPanel.getPeselNumber(),
                    customerAddPanel.getGender(),
                    customerAddPanel.getDateBirthDay(),
                    customerAddPanel.getAddress(),
                    customerAddPanel.getEmail(),
                    todayDate,
                    customerAddPanel.getBalance()
            );
            //add to collection
            addCustomer(customer);
            //listCustomerBind.put(customer.getId(), listItemsCounter);
            
            //add to list
            String sb = customer.getName() + " " + customer.getSurname() + " (id: " + customer.getId() + ")";
            listModel.addElement(sb);
            globalIdCounter++;
            listItemsCounter++;

    }//GEN-LAST:event_ButtonCustomerAddMouseClicked

    private void ListCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListCustomersMouseClicked
        try {
            customerChooseActionPanel = new CustomerChooseActionPanel();
            JDialog dialog = null;
            if (evt.getClickCount() == 2) {
                //show 
                showMessageDialog(null, ListCustomers.getSelectedIndex());
                if (dialog == null) {
                    Window win = SwingUtilities.getWindowAncestor(this);
                    if (win != null) {
                        dialog = new JDialog(win, "Wybierz akcję",
                                Dialog.ModalityType.APPLICATION_MODAL);
                        dialog.getContentPane().add(customerChooseActionPanel);
                        dialog.pack();
                        dialog.setLocationRelativeTo(null);
                    }
                }
                dialog.setVisible(true); // here the modal dialog takes over
                //if ListCustomers.getSelectedIndex() == -1 then only add customer
                //get clicked button
                final int selectedItem = ListCustomers.getSelectedIndex();
                if(customerChooseActionPanel.getChooseAction() == 1) {//add                    
                    dialog = null;
                    showMessageDialog(null, "add");
                }
                else if(customerChooseActionPanel.getChooseAction() == 2) {//show
                    if(globalIdCounter != 0) {                        
                        showMessageDialog(null, "show");
                        
                    }
                    else {
                        showMessageDialog(null, "Brak klientów");
                    }
                    dialog = null;                    
                }
                else if(customerChooseActionPanel.getChooseAction() == 3 && globalIdCounter != 0) {//edit
                    if(globalIdCounter != 0) {                        
                        showMessageDialog(null, "edit");
                    }
                    else {
                        showMessageDialog(null, "Brak klientów");
                    }
                    dialog = null; 
                }
                else if(customerChooseActionPanel.getChooseAction() == 4 && globalIdCounter != 0) {//remove
                    if(globalIdCounter != 0) {                        
                        showMessageDialog(null, "remove");
                        listModel.removeElementAt(selectedItem);
                    }
                    else {
                        showMessageDialog(null, "Brak klientów");
                    }
                    dialog = null; 
                }
            }
        }
        catch (Exception e) {
            
        }
    }//GEN-LAST:event_ListCustomersMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCustomerAdd;
    private javax.swing.JLabel LabelCustomers;
    private javax.swing.JList<String> ListCustomers;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getElementAt(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
