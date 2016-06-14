/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Forms.Order;

import java.awt.Dialog;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.SwingUtilities;
import jshop.Classes.Order;
import jshop.Classes.ShopException;
import jshop.Forms.ChooseActionPanel;

/**
 *
 * @author bartek
 */
public class OrderPanel extends javax.swing.JPanel {

    
    private OrderFormPanel orderAddPanel;
    private ChooseActionPanel orderChooseActionPanel;    
    private int globalIdCounter;//Orders Id        
    private DefaultListModel<String> listModel;
    private static Map<Integer, Order> orderMap;
    
    /**
    * Creates new form OrderPanel
    */
    public OrderPanel() {   
        listModel = new DefaultListModel<>();
        orderMap = new HashMap<Integer, Order>();
        globalIdCounter = 0;        
        initComponents();
    }    
    
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

                if(orderAddPanel.getCustomer() != null) {
                    if(orderAddPanel.getProduct().size() != 0) {
                        double sumOfPrice = 0.0;
                        for(int i = 0; i < orderAddPanel.getProduct().size(); i++) {
                            sumOfPrice += orderAddPanel.getProduct().get(i).getPrice();
                        }                        
                        if(orderAddPanel.getCustomer().getBalance() - sumOfPrice >= 0) {
                            Date todayDate = new Date();

                            Order order = new Order(globalIdCounter,
                                    orderAddPanel.getType(),
                                    orderAddPanel.getCustomer(),
                                    todayDate,
                                    todayDate,
                                    orderAddPanel.getProduct()
                            );
                            //add to collection
                            addOrder(order);

                            //add to list
                            String productInfo = new String(order.getCustomer().getName() + " " + order.getCustomer().getSurname() + " [produktów: " + order.getProduct().size() + "] [kwota: " + order.getSumPriceOfProducts() + "] (id: " + order.getId() + ")");

                            listModel.addElement(productInfo);
                            globalIdCounter++;
                        }
                        else {
                            throw new ShopException("Nie stać cię na tak duże zamówienie");
                        }                            
                    }
                    else {
                        //throw new ShopException("");
                        throw new ShopException("Musisz dodać przynajmniej jeden produkt");
                    }
                }
                else {
                    throw new ShopException("Nie ma takiego klienta");
                    //throw new ShopException("");
                }
                
            } 
            else if(orderChooseActionPanel.getChooseAction() == 2) {//show
                dialog = null;
                if(globalIdCounter != 0) {                            
                    //get id spinner from spinner
                    Order order = getOrder((int) SpinnerOrderId.getValue());
                    if(order != null) {
                        String products = new String("");
                        for(int i = 0; i < order.getProduct().size(); i++) {
                            products += order.getProduct().get(i).getName() + " [" + order.getProduct().get(i).getType() + "][" + order.getProduct().get(i).getPrice() + "PLN] (id: " + order.getProduct().get(i).getId() + ")\n";
                        }
                        
                        String orderDate = new SimpleDateFormat("yyyy-MM-dd").format(order.getOrderDate());
                        String customerInfo = new String(           
                                "Id: " + order.getId() + 
                                "\nImię: " + order.getCustomer().getName()+ 
                                "\nNazwisko: " + order.getCustomer().getSurname() +
                                "\nTyp: " + order.getType().toString() +
                                "\nProdukty:\n" + products +
                                "Kwota do zapłaty: " + order.getSumPriceOfProducts() +
                                "\nData zamówienia: " + orderDate                  
                        );
                        showMessageDialog(this, customerInfo, "Informacje o zamówieniu", HEIGHT);
                    }
                    else {
                       throw new ShopException("Nie ma takiego zamówienia!"); 
                    }                    
                }
                else {
                    throw new ShopException("Brak zamówień");
                }
                dialog = null;                    
            }
            else if(orderChooseActionPanel.getChooseAction() == 3 && globalIdCounter != 0) {//edit
                dialog = null;
                if(globalIdCounter != 0) {  
                    Order order = getOrder((int) SpinnerOrderId.getValue());
                    if(order != null) {
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
                                orderAddPanel.setType(order.getType());
                                orderAddPanel.setCustomer(order.getCustomer());
                                orderAddPanel.setProduct(order.getProduct());
                                
                            }
                        }
                        dialog.setVisible(true); // here the modal dialog takes over
                        //check if customer exist
                        //save
                        order.setType(orderAddPanel.getType());
                        order.setCustomer(orderAddPanel.getCustomer());
                        order.setProduct(orderAddPanel.getProduct());
                        
                        listModel.clear();
                        for(int i = 0; i <= orderMap.size(); i++) {
                            Order tempOrder = getOrder(i);
                            if(tempOrder != null) {
                                String customerInfo = new String(order.getCustomer().getName() + " " + order.getCustomer().getSurname() + " [produktów: " + order.getProduct().size() + "] [kwota: " + order.getSumPriceOfProducts() + "] (id: " + order.getId() + ")");
                                listModel.addElement(customerInfo);
                            }                            
                        } 
                    }
                    else {
                        throw new ShopException("Brak zamówień");
                    }
                }
                else {
                    throw new ShopException("Brak zamówień");
                }
                dialog = null; 
            }
            else if(orderChooseActionPanel.getChooseAction() == 4 && globalIdCounter != 0) {//remove
                dialog = null;
                if(globalIdCounter != 0) {  
                    Order order = getOrder((int) SpinnerOrderId.getValue());
                    if(order != null) {
                        //remove from collection
                        removeOrder(order);
                        //reload list 
                        listModel.clear();
                        for(int i = 0; i <= orderMap.size(); i++) {
                            Order tempOrder = getOrder(i);
                            if(tempOrder != null) {
                                String orderInfo = new String(tempOrder.getCustomer().getName() + " " + tempOrder.getCustomer().getSurname() + " [produktów: " + tempOrder.getProduct().size() + "] [kwota: " + tempOrder.getSumPriceOfProducts() + "] (id: " + tempOrder.getId() + ")");
                                listModel.addElement(orderInfo);
                            }                            
                        } 
                    }
                    else {
                        throw new ShopException("Brak zamówień");
                    }
                }
                else {
                    throw new ShopException("Brak zamówień");
                }
                dialog = null; 
            }
        }
        catch (Exception ex) {
            showMessageDialog(null, ex.getMessage(), "Błąd ogólny programu",  JOptionPane.ERROR_MESSAGE);
        } 
        catch (ShopException ex) {
            showMessageDialog(null, ex.getMessage(), "Komunikat",  JOptionPane.ERROR_MESSAGE);
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
