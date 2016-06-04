/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Classes;

import java.util.Date;

/**
 *
 * @author bartek
 */
public class Customer extends Person {
    //fields
    private Date registerDate;
    private double balance;

    //constructors

    public Customer() {

    }
    public Customer(int id, String name, String surname, long peselNumber, boolean gender, Date dateOfBirth, String address, String emailAddress, Date registerDate, double balance) {
        super(id, name, surname, peselNumber, gender, dateOfBirth, address, emailAddress);
        this.setRegisterDate(registerDate);
        this.setBalance(balance);
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //methods

}
