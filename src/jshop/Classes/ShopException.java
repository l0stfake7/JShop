/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Classes;

/**
 *
 * @author bartek
 */
public class ShopException extends Throwable {
    private static final long serialVersionUID = 1L;

    public ShopException(String message) {
        super(message);
    }
}