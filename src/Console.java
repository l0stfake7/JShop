import Classes.Customer;

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

    private static Customer getCustomer(int id) {
        return customerMap.get(id);
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){//scanner close automatically with end of try body
            System.out.println("JBank v1.0.0");

            //test object
            DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            Date todayDate = dateFormat.parse("12-10-2016"); // for example, today's date
            Customer customer1 = new Customer(0, "Bartek", "Poniatyszyn", 94070606974L, false, todayDate, "Nyska 9/7, 48-200 Prudnik", "bartek.poniatyszyn@gmail.com", todayDate, 1900);
            Customer emptyCustomer = new Customer();

            addCustomer(customer1);
            addCustomer(emptyCustomer);

            boolean exitFlag = false;
            while(!exitFlag) {
                System.out.println("Menu:\n\n1. Customer\n2. Order\n3. List of Products\n4. Exit\n\nType number");
                short number = scanner.nextShort();

                if(number > 0 && number < 5) {
                    switch(number) {
                        case 1: {
                            System.out.println("Menu:\n\n1. Show all customers\n2. Add\n3. Edit\n4. Delete\n\nType number");
                            number = scanner.nextShort();
                            switch(number) {
                                case 1: {
                                    System.out.println("1");
                                    break;
                                }
                                case 2: {
                                    System.out.println("2");
                                    break;
                                }
                                case 3: {
                                    System.out.println("3");
                                    break;
                                }
                                case 4: {
                                    System.out.println("4");
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
        }
        finally {
            System.out.println("Bye!");
        }
    }
}
