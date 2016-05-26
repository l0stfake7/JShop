package Classes;

import java.util.Date;

/**
 * Created by bartek on 26.05.16.
 */
public class Customer extends Person {
    //fields
    Date registerDate;
    double balance;

    //constructors
    public Customer(int id, String name, String surname, long peselNumber, boolean gender, Date dateOfBirth, String address, String emailAddress, Date registerDate, double balance) {
        super(id, name, surname, peselNumber, gender, dateOfBirth, address, emailAddress);
        this.registerDate = registerDate;
        this.balance = balance;
    }

    //methods

}
