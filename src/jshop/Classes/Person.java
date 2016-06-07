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
public class Person {
    
    //fields
    private int id;
    private String name;
    private String surname;
    private long peselNumber;
    private boolean gender;
    private Date dateOfBirth;
    private String address;
    private String emailAddress;

    //constructors
    public Person() {

    }

    public Person(int id, String name, String surname, long peselNumber, boolean gender, Date dateOfBirth, String address, String emailAddress) {
        this.setId(id);
        this.setName(name);
        this.setSurname(surname);
        this.setPeselNumber(peselNumber);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.setAddress(address);
        this.setEmailAddress(emailAddress);
    }

    //methods
    
    //getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(long peselNumber) {
        this.peselNumber = peselNumber;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
