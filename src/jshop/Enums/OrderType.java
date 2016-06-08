/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Enums;

/**
 *
 * @author bartek
 */
public enum OrderType {
    kupno,
    sprzedaż,
    wymiana;   
    
    @Override
    public String toString() {
        switch(this) {
        case kupno: return "kupno";
        case sprzedaż: return "sprzedaż";
        case wymiana: return "wymiana";
        default: throw new IllegalArgumentException();
        }
    }
}
