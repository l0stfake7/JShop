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
public class Pesel {
    private static final short PeselLength = 11;
    private int Gender;
    private Date DateOfBirth;
    private Object PeselNumber;
    
    public Pesel()
    {
        PeselNumber = new String("");
    }

    public Pesel(String peselNumber)
    {
        PeselNumber = peselNumber;
    }

    public Pesel(long peselNumber)
    {
        PeselNumber = Long.toString(peselNumber);
    }

    public Pesel(char[] peselNumber)
    {
        String tempString = new String(peselNumber);
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
        int gender = (Integer.parseInt(peselNumber.substring(9, 10)) % 2);
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
        if (Integer.parseInt(peselNumber.substring(2, 4)) <= 12) //1900 – 1999
        {
            tempString = String.format("{0}{1}", "19", Integer.parseInt(peselNumber.substring(0, 2)));
            month = Integer.parseInt(peselNumber.substring(2, 4));

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
            month = Integer.parseInt(peselNumber.substring(2, 4)) - 20;
        }
        year = Integer.parseInt(tempString);
        day = Integer.parseInt(peselNumber.substring(4, 6));
        Date dateOfBirth = new Date(year, month, day);
        return dateOfBirth;
    }

    /**
     * @param DateOfBirth the DateOfBirth to set
     */
    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }
    
    public static boolean CheckDateOfBirth(Date date, String peselNumber) throws ShopException
    {
        if(date.compareTo(GetDateOfBirth(peselNumber)) != 0) {
            throw new ShopException("Wybrana data jest niezgodna z podanym numerem Pesel");
        }
        return true;
    }

    public static int CalculateControlSum(String input, int[] weights)
    {
        int controlSum = 0;
        for (int i = 0; i < input.length() - 1; i++)
        {
            controlSum += weights[i] * Integer.parseInt(input.substring(i, i+1));
            //Convert.ToInt32(input[i].ToString());//zmieniam znak asci odpowiedniego znaku pesel-ciągu na cyfrę
        }
        return controlSum;
    }

    /**
     * @return the PeselNumber
     */
    public Object getPeselNumber() {
        return PeselNumber;
    }

    /**
     * @param peselNumber
     * @param PeselNumber the PeselNumber to set
     * @throws jshop.Classes.ShopException
     */
    public void setPeselNumber(Object peselNumber) throws ShopException {
        if(peselNumber instanceof String) {
            if(CheckPesel(peselNumber.toString())) {
                this.PeselNumber = peselNumber.toString();
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
    
    public static boolean CheckPesel(String peselNumber) throws ShopException
    {
        int[] scales = //wagi dla każdej kolejnej cyfry numeru pesel
        {
            1, 3, 7, 9, 1, 3, 7, 9, 1, 3
        };
        String regex = new String("^[0-9]*$");
        if (peselNumber == null)
        {
            throw new NullPointerException("Wykryto odwołanie do obiektu o wartosc null");
        }
        if (peselNumber.length() == 0)
        {
            throw new ShopException("Nic nie wpisałeś!");
        }
        if (peselNumber.length() != PeselLength)
        {
            throw new ShopException("Nieprawidłowa długość numeru PESEL!");
        }
        if (!peselNumber.matches(regex))
        {
            throw new ShopException("Wykryto nieprawdiłowe znaki, PESEL może zawierać tylko cyfry!");
        }
        int controlSum = CalculateControlSum(peselNumber, scales);
        int controlNum = controlSum % 10;
        controlNum = 10 - controlNum;
        if (controlNum == 10)
        {
            controlNum = 0;
        }
        int lastDigit = Integer.parseInt(peselNumber.substring(10, 11));
        if (controlNum != lastDigit)
        {
            throw new ShopException("Nieprawidłowa suma kontrolna, taki PESEL nie istnieje!");
        }
        return true;
    }
    
    public static boolean CheckPesel(long peselNumber) throws ShopException
    {
        return CheckPesel(Long.toString(peselNumber));
    }
    
}
