/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Classes;

import jshop.Enums.ProductType;

/**
 *
 * @author bartek
 */
public class Product {
    
    //fields
    private int id;
    private ProductType type;
    private String name;

    //constructors
    public Product(int id, ProductType type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }
    
    //methods
    
    //getters & setters
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public ProductType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ProductType type) {
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
