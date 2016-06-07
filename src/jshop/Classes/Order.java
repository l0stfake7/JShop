/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Classes;

import java.util.Date;
import jshop.Enums.OrderType;

/**
 *
 * @author bartek
 */
public class Order {
    
    private int Id;
    private OrderType orderType;
    private double price;
    private Customer customer;
    private Date orderDate;
    private Date realizationDate;
    private Product product;
}
