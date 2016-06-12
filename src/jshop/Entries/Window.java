/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Entries;

import javax.swing.JFrame;
import jshop.Forms.MainPanel;

/**
 *
 * @author bartek
 */
public class Window {
    
    private static void createAndShowUI() {
      JFrame frame = new JFrame("JShop");
      frame.getContentPane().add(new MainPanel());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
    
    public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}