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
public enum ProductType {
    dairy,
    bread,
    beverages;
    
  @Override
  public String toString() {
    switch(this) {
      case dairy: return "dairy";
      case bread: return "bread";
      case beverages: return "beverages";
      default: throw new IllegalArgumentException();
    }
  }
}
