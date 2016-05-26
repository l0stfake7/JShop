import java.util.Scanner;

/**
 * Created by bartek on 24.05.16.
 */
public class Console {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){//scanner close automatticly with end of try body
            System.out.println("JBank v1.0.0");
            //write menu here\

            boolean exitFlag = false;
            while(!exitFlag) {
                System.out.println("Menu:\n\n1. Customer\n2. Order\n3. List of Products\n4. Exit\n\nType number");
                short number = scanner.nextShort();

                if(number > 0 && number < 5) {
                    switch(number) {
                        case 1: {
                            break;
                        }
                        case 2: {
                            break;
                        }
                        case 3: {
                            break;
                        }
                        case 4: {
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
