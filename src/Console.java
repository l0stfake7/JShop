/**
 * Created by bartek on 24.05.16.
 */
public class Console {
    public static void main(String[] args) {

        try {
            System.out.println("JBank v1.0.0");
        }
        catch(Exception exc) {
            System.out.println("Exception: " + exc);
        }
        finally {
            System.out.println("Bye!");
        }
    }
}
