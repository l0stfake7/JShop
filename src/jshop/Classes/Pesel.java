/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jshop.Classes;

import java.util.Date;
import jdk.internal.org.objectweb.asm.Type;

/**
 *
 * @author bartek
 */
public class Pesel {
    private final short PeselLength = 11;
    private int Gender;
    private Date DateOfBirth;
    private Object PeselNumber;
    
    public Pesel()
    {
        PeselNumber = new String("");
    }

    public Pesel(String pesel)
    {
        PeselNumber = pesel;
    }

    public Pesel(long pesel)
    {
        PeselNumber = Long.toString(pesel);
    }

    public Pesel(char[] pesel)
    {
        String tempString = new String(pesel);
        PeselNumber = tempString;
    }

    /**
     *
     * @return
     */
    public int getGender() {
        return this.Gender;
    }
    /**
     * @param peselNumber
     * @return the Gender
     */
    public static boolean getGender(String peselNumber) {
        int index = peselNumber.length() - 2;
        int gender = (Integer.parseInt(peselNumber.valueOf(index)) % 2);
        return (gender == 1);
        //jeśli reszta z dzielenia to jeden, oznacza to, że mamy mężczyznę, w przeciwnym razie mamy kobietę          
       
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(int Gender) {
        this.Gender = Gender;
    }
    
    public static boolean CheckGender(boolean gender, String peselNumber) throws ShopException
    {
        if (gender != getGender(peselNumber))
        {
            throw new ShopException("Wybrana płeć jest niezgodna z podanym numerem Pesel");
        }
        return true;
    }

    /**
     * @return the DateOfBirth
     */
    public Date getDateOfBirth() {
        return DateOfBirth;
    }
    
    private static Date GetDateOfBirth(String peselNumber)
    {
        int day,
            month,
            year;
        String tempString;
        if (Integer.parseInt(peselNumber.substring(2, 2)) <= 12) //1900 – 1999
        {
            tempString = String.format("{0}{1}", "19", Integer.parseInt(peselNumber.substring(0, 2)));
            month = Integer.parseInt(peselNumber.substring(2, 2));

        }
        else //2000 – 2099 - odjac od miesiaca 20
        {
            if (Integer.parseInt(peselNumber.substring(0, 2)) < 10)
            {
                tempString = String.format("{0}{1}{2}", "20", "0", Integer.parseInt(peselNumber.substring(0, 2)));
            }
            else
            {
                tempString = String.format("{0}{1}", "20", Integer.parseInt(peselNumber.substring(0, 2)));
            }
            month = Integer.parseInt(peselNumber.substring(2, 2)) - 20;
        }
        year = Integer.parseInt(tempString);
        day = Integer.parseInt(peselNumber.substring(4, 2));
        Date dateOfBirth = new Date(year, month, day);
        return dateOfBirth;
    }

    /**
     * @param DateOfBirth the DateOfBirth to set
     */
    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    /**
     * @return the PeselNumber
     */
    public Object getPeselNumber() {
        return PeselNumber;
    }

    /**
     * @param PeselNumber the PeselNumber to set
     */
    public void setPeselNumber(Object peselNumber) throws ShopException {
        if(peselNumber instanceof String) {
            if(CheckPesel(peselNumber)) {
                this.PeselNumber = peselNumber;
            }
        }
        else if(peselNumber instanceof Long) {
            if(CheckPesel(Long.parseLong(peselNumber.toString()))) {
                this.PeselNumber = Long.parseLong(peselNumber.toString());
            }
        }
        else { 
            this.PeselNumber = "";
            throw new ShopException("Nieobsługiwany typ danych");
        }

    }
    
}
