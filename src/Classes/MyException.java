package Classes;


/**
 * Created by bartek on 26.05.16.
 */
public class MyException extends Throwable {
    private static final long serialVersionUID = 1L;

    public MyException(String message) {
        super(message);
    }
}