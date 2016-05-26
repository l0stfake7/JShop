package Classes;

import java.util.Date;

/**
 * Created by bartek on 26.05.16.
 */
public class Person {
    //fields
    int id;
    String name;
    String surname;
    long peselNumber;
    boolean gender;
    Date dateOfBirth;
    String address;
    String emailAddress;

    //constructors
    public Person(int id, String name, String surname, long peselNumber, boolean gender, Date dateOfBirth, String address, String emailAddress) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.peselNumber = peselNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.emailAddress = emailAddress;
    }

    //methods
}
