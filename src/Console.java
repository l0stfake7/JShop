import Classes.Customer;
import Classes.MyException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by bartek on 24.05.16.
 */
public class Console {

    static Map<Integer, Customer> customerMap=new HashMap<Integer, Customer>();

    private static void addCustomer(Customer cust) {
        customerMap.put(cust.getId(), cust);
    }

    private static Customer getCustomer(int id) throws MyException {
        if(customerMap.get(id) == null)
            return null;//or throw new MyException("Not found object with id: " + id);//what is better?
        else
            return customerMap.get(id);//// TODO: 26.05.16 add safety search: if id doesn't exists return null or throws exception
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){//scanner close automatically with end of try body
            System.out.println("JBank v1.0.0\n\n");

            //test object
            DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            Date todayDate = dateFormat.parse("12-10-2016"); // for example, today's date
            Customer customer1 = new Customer(1, "Bartek", "Kowalski", 12312342454L, false, todayDate, "Kłodzka 8/7, 20-200 Opole", "bartek.kowalski@gmail.com", todayDate, 1900);
            Customer customer2 = new Customer(2, "Janina", "Kowalska", 12345678901L, true, todayDate, "Pomorska 9, 50-200", "janina.kowalska@microsoft.com", todayDate, 2000);
            customer1.setName("Zdzichu");
            addCustomer(customer1);
            addCustomer(customer2);

            Customer newCustomer = getCustomer(1);
            System.out.println(newCustomer.getBalance());

            boolean exitFlag = false;
            while(!exitFlag) {
                System.out.println("Menu:\n1. Customer\n2. Order\n3. List of Products\n4. Exit\n\nType number");
                short number = scanner.nextShort();

                if(number > 0 && number < 5) {
                    switch(number) {
                        case 1: {
                            System.out.println("Menu:\n1. Show all customers\n2. Add\n3. Edit\n4. Remove\n\nType number");
                            number = scanner.nextShort();
                            switch(number) {
                                case 1: {
                                    System.out.println("Show all customers");
                                    for(int i = 1; i <= customerMap.size(); i++) {
                                        System.out.println(i);
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.println("Add customer");
                                    Customer cust = new Customer(customerMap.size() + 1, "Janina", "Kowalska", 12345678901L, true, todayDate, "Pomorska 9, 50-200", "janina.kowalska@microsoft.com", todayDate, 2000);
                                    addCustomer(cust);
                                    break;
                                }
                                case 3: {
                                    System.out.println("Edit customer");
                                    System.out.println("Type customer Id to edit");

                                    number = scanner.nextShort();
                                    if(getCustomer(number) == null) {
                                        throw new MyException("Not found object with id: " + number);
                                    }
                                    else {
                                        Customer customer = getCustomer(number);
                                        System.out.println("ID " + customer.getId() + "Name" + customer.getName() + "RegDate" + customer.getRegisterDate());
                                    }
                                    break;
                                }
                                case 4: {
                                    System.out.println("Remove customer");
                                    break;
                                }
                                default: System.out.println("Incorrect number!"); break;
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("2A");
                            break;
                        }
                        case 3: {
                            System.out.println("3A");
                            break;
                        }
                        case 4: {
                            System.out.println("4A");
                            exitFlag = true;
                            break;
                        }
                        default: continue;//never run :d?
                    }
                }
                else {
                    continue;
                }
            }
        }
        catch(Exception exc) {
            System.out.println("Exception: " + exc);
        } catch (MyException exc ) {
            System.out.println("Exception: " + exc);
        } finally {
            System.out.println("Bye!");
        }
    }
}
