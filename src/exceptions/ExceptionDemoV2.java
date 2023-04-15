package exceptions;

public class ExceptionDemoV2 {
    public static void main(String[] args) {
        RuntimeException exception = new ArithmeticException("Invalid!!!");
        exception.initCause(new RuntimeException("Manual Error"));
        // throw exception;
        Throwable cause = new Throwable("Manual Work Caused!!!");
        System.out.println("Cause ToString: " + cause.toString());
        //throw new RuntimeException("Due to some reason", cause);
        throw new RuntimeException(cause);


    }
}
