/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Classes;

import java.util.Date;
import java.util.List;
import jshop.Enums.OrderType;

/**
 *
 * @author bartek
 */
public class Order {
    
    //fields
    private int Id;
    private OrderType type;
    private Customer customer;
    private Date orderDate;
    private Date realizationDate;
    private List<Product> product;
    
    //constructors
    public Order (int Id, OrderType type, Customer customer, Date orderDate, Date realizationDate, List<Product> product) {
        this.Id = Id;
        this.type = type;
        this.customer = customer;
        this.orderDate = orderDate;
        this.realizationDate = realizationDate;
        this.product =  product;
    }
    
    //methods
    
    //getters & setters
    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the type
     */
    public OrderType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(OrderType type) {
        this.type = type;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the realizationDate
     */
    public Date getRealizationDate() {
        return realizationDate;
    }

    /**
     * @param realizationDate the realizationDate to set
     */
    public void setRealizationDate(Date realizationDate) {
        this.realizationDate = realizationDate;
    }

    /**
     * @return the product
     */
    public List<Product> getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
