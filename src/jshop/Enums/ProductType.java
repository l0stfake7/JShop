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
    napoje,
    alkohol,
    chemia,
    warzywa,
    owoce,
    słodycze,
    mrożonki,
    mięso,
    wędliny,
    ryby,
    przyprawy,
    przekąski;
    
  @Override
  public String toString() {
    switch(this) {
      case pieczywo: return "pieczywo";
      case nabial: return "nabial";
      case napoje: return "napoje";
      case alkohol: return "alkohol";
      case chemia: return "chemia";
      case warzywa: return "warzywa";
      case owoce: return "owoce";
      case słodycze: return "słodycze";
      case mrożonki: return "mrożonki";
      case mięso: return "mięso";
      case wędliny: return "wędliny";
      case ryby: return "ryby";
      case przyprawy: return "przyprawy";
      case przekąski: return "przekąski";      
      default: throw new IllegalArgumentException();
    }
  }
}
