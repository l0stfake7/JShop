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
    pieczywo,
    nabial,
    napoje;
    
  @Override
  public String toString() {
    switch(this) {
      case pieczywo: return "pieczywo";
      case nabial: return "nabial";
      case napoje: return "napoje";
      default: throw new IllegalArgumentException();
    }
  }
}
