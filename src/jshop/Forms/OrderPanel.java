/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Forms;

import java.awt.Dialog;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.SwingUtilities;
import jshop.Classes.Order;
import jshop.Classes.ShopException;

/**
 *
 * @author bartek
 */
public class OrderPanel extends javax.swing.JPanel {

    
    private OrderFormPanel orderAddPanel;
    private ChooseActionPanel orderChooseActionPanel;
    
    private int globalIdCounter = 0;//Orders Id    
    
    DefaultListModel<String> listModel = new DefaultListModel<>();

    private static Map<Integer, Order> orderMap;
    
    //po kazdej zmiane odswiezac cala jliste z indeksami, zrobic powiazanie indeks list-obiekt
    private static void addOrder(Order order) {
        orderMap.put(order.getId(), order);
    }

    private static Order getOrder(int id) throws ShopException {
        if (orderMap.get(id) == null) {
            return null;//or throw new MyException("Not found object with id: " + id);//what is better?
        } else {
            return orderMap.get(id);//// TODO: 26.05.16 add safety search: if id doesn't exists return null or throws exception
        }
    }
    
    private static void removeOrder(Order order) {
        orderMap.remove(order.getId());
    }
    /**
     * Creates new form OrderPanel
     */
    public OrderPanel() {
        initComponents();
        
        orderMap = new HashMap<Integer, Order>();
    }

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
        SpinnerOrderId = new javax.swing.JSpinner();
        ButtonOrderAction = new javax.swing.JButton();
        LabelOrderId = new javax.swing.JLabel();

        jList1.setModel(listModel);
        jScrollPane1.setViewportView(jList1);

        SpinnerOrderId.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        ButtonOrderAction.setText("Wybierz akcję");
        ButtonOrderAction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonOrderActionMouseClicked(evt);
            }
        });

        LabelOrderId.setText("Id:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelOrderId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SpinnerOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonOrderAction, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelOrderId)
                    .addComponent(SpinnerOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonOrderAction))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonOrderActionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonOrderActionMouseClicked
        try {
            orderChooseActionPanel = new ChooseActionPanel();
            JDialog dialog = null;
            //show 
            if (dialog == null) {
                Window win = SwingUtilities.getWindowAncestor(this);
                if (win != null) {
                    dialog = new JDialog(win, "Wybierz akcję",
                            Dialog.ModalityType.APPLICATION_MODAL);
                    dialog.getContentPane().add(orderChooseActionPanel);
                    orderChooseActionPanel.ButtonAddSetText("Dodaj zamówienie");
                    orderChooseActionPanel.ButtonShowSetText("Zobacz zamówienie");
                    orderChooseActionPanel.ButtonEditSetText("Edytuj zamówienie");
                    orderChooseActionPanel.ButtonRemoveSetText("Usuń zamówienie");
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);
                }
            }
            dialog.setVisible(true); // here the modal dialog takes over
            //get clicked button
            if(orderChooseActionPanel.getChooseAction() == 1) {//add                    
                dialog = null;
                orderAddPanel = new OrderFormPanel();
                if (dialog == null) {            
                    Window win = SwingUtilities.getWindowAncestor(this);
                    if (win != null) {
                        dialog = new JDialog(win, "Dodaj zamówienie",
                                Dialog.ModalityType.APPLICATION_MODAL);
                        dialog.getContentPane().add(orderAddPanel);
                        dialog.pack();
                        dialog.setLocationRelativeTo(null);
                    }
                }
                dialog.setVisible(true); // here the modal dialog takes over
                //TODO check if datas from form is not null
                //get values from fields by getters      
                Date todayDate = new Date();

                Order order = new Order(globalIdCounter,
                        orderAddPanel.getType(),
                        orderAddPanel.getName(),
                        orderAddPanel.getPrice()
                );
                //add to collection
                addOrder(order);
                //listCustomerBind.put(product.getId(), listItemsCounter);

                //add to list
                String productInfo = order.getName() + " [" + order.getType() + "][" + order.getPrice() + "PLN] (id: " + product.getId() + ")";
                listModel.addElement(productInfo);
                globalIdCounter++;
            } 
            else if(orderChooseActionPanel.getChooseAction() == 2) {//show
                dialog = null;
                if(globalIdCounter != 0) {                            
                    //get id spinner from spinner
                    Order cust = getOrder((int) SpinnerOrderId.getValue());
                    if(cust != null) {
                        String customerBirthDate = new SimpleDateFormat("yyyy-MM-dd").format(cust.getDateOfBirth());
                        String customerInfo = new String(           
                                "Id: " + cust.getId() + 
                                "\nImię: " + cust.getName() + 
                                "\nNazwisko: " + cust.getSurname() +
                                "\nPesel: " + cust.getPeselNumber() +
                                "\nPłeć: " + ((cust.getGender()) ? "Tak" : "Nie") +
                                "\nData urodzin: " + customerBirthDate +
                                "\nAdres: " + cust.getAddress() +
                                "\nAdres email: " + cust.getEmailAddress() +
                                "\nData rejestracji: " + cust.getSurname() +
                                "\nStan konta: " + cust.getBalance()
                    
                        );
                        showMessageDialog(this, customerInfo, "Informacje o zamówieniu", HEIGHT);
                    }
                    else {
                       showMessageDialog(null, "Nie ma takiego zamówienia!"); 
                    }                    
                }
                else {
                    showMessageDialog(null, "Brak zamówień");
                }
                dialog = null;                    
            }
            else if(orderChooseActionPanel.getChooseAction() == 3 && globalIdCounter != 0) {//edit
                dialog = null;
                if(globalIdCounter != 0) {  
                    Order cust = getOrder((int) SpinnerOrderId.getValue());
                    if(cust != null) {
                        orderAddPanel = new OrderFormPanel();
                        if (dialog == null) {            
                            Window win = SwingUtilities.getWindowAncestor(this);
                            if (win != null) {
                                dialog = new JDialog(win, "Edytuj zamówienie",
                                        Dialog.ModalityType.APPLICATION_MODAL);
                                dialog.getContentPane().add(orderAddPanel);
                                orderAddPanel.setButtonText("Edytuj zamówienie");
                                dialog.pack();
                                dialog.setLocationRelativeTo(null);
                                
                                //set data
                                orderAddPanel.setName(cust.getName());
                                orderAddPanel.setSurname(cust.getSurname());
                                orderAddPanel.setPeselNumber(cust.getPeselNumber());
                                orderAddPanel.setGender(cust.getGender());
                                orderAddPanel.setDateBirthDay(cust.getDateOfBirth());
                                orderAddPanel.setAddress(cust.getAddress());
                                orderAddPanel.setEmail(cust.getEmailAddress());
                                orderAddPanel.setBalance(cust.getBalance());
                            }
                        }
                        dialog.setVisible(true); // here the modal dialog takes over
                        
                        //save
                        cust.setName(orderAddPanel.getName());
                        cust.setSurname(orderAddPanel.getSurname());
                        cust.setPeselNumber(orderAddPanel.getPeselNumber());
                        cust.setGender(orderAddPanel.getGender());
                        cust.setDateOfBirth(orderAddPanel.getDateBirthDay());
                        cust.setAddress(orderAddPanel.getAddress());
                        cust.setEmailAddress(orderAddPanel.getEmail());
                        cust.setBalance(orderAddPanel.getBalance());
                        
                        listModel.clear();
                        for(int i = 0; i <= orderMap.size(); i++) {
                            Order customer = getOrder(i);
                            if(customer != null) {
                                String customerInfo = customer.getName() + " " + customer.getSurname() + " (id: " + customer.getId() + ")";
                                listModel.addElement(customerInfo);
                            }                            
                        } 
                    }
                    else {
                        showMessageDialog(null, "Brak zamówień");
                    }
                }
                else {
                    showMessageDialog(null, "Brak zamówień");
                }
                dialog = null; 
            }
            else if(orderChooseActionPanel.getChooseAction() == 4 && globalIdCounter != 0) {//remove
                dialog = null;
                if(globalIdCounter != 0) {  
                    Order cust = getOrder((int) SpinnerOrderId.getValue());
                    if(cust != null) {
                        //remove from collection
                        removeOrder(cust);
                        //reload list 
                        listModel.clear();
                        for(int i = 0; i <= orderMap.size(); i++) {
                            Order customer = getOrder(i);
                            if(customer != null) {
                                String sb = customer.getName() + " " + customer.getSurname() + " (id: " + customer.getId() + ")";
                                listModel.addElement(sb);
                            }                            
                        } 
                    }
                    else {
                        showMessageDialog(null, "Brak zamówień");
                    }
                }
                else {
                    showMessageDialog(null, "Brak zamówień");
                }
                dialog = null; 
            }
        }
        catch (Exception ex) {
            Logger.getLogger(CustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ShopException ex) {
            Logger.getLogger(CustomerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonOrderActionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonOrderAction;
    private javax.swing.JLabel LabelOrderId;
    private javax.swing.JSpinner SpinnerOrderId;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
