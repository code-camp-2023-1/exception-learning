import java.io.IOException;
import java.sql.SQLException;

public class CheckedExceptionDemo {
    // 方法1： 用throws关键字声明受检异常, 抛出异常让调用方自己处理
    public static void doSomething(boolean complete) throws IOException, SQLException {
        System.out.println("Doing something");

        if (!complete) {
            // 抛出一个异常
            //throw new RuntimeException("The flag complete is false.");
            throw new IOException("The flag complete is false.");
        }

        System.out.println("Completed!");
        throw new SQLException("SQL Exception!!!");
    }

    public static void doSomethingWithRuntimeException(boolean complete) {
        System.out.println("Doing something");

        if (!complete) {
            // 抛出一个异常
            //throw new RuntimeException("The flag complete is false.");
            throw new RuntimeException("The flag complete is false.");
        }
        System.out.println("Completed RuntimeException!");
    }

    public static void doNothing() {

    }

    // 方法2：利用try-catch捕获异常进行处理
    public static void handleWorkV2(boolean complete) {
        try {
            System.out.println("Handling work");
            doSomething(complete);
            doNothing();
        } catch (IOException | SQLException /*union type*/ e) { // 捕获具体的异常，不要用Exception或者Throwable
            System.out.println("Handling Exception");

            // 不推荐方式：什么都不做，直接把异常吞掉

            // 封装异常再抛出
            throw new RuntimeException(e);
        }
    }

    public static void handleWorkV3(boolean complete) {
        try {
            System.out.println("Handling work");
            doSomething(complete);
            doNothing();
        } catch (IOException e) { // 捕获具体的异常，不要用Exception或者Throwable
            // 不推荐方式：什么都不做，直接把异常吞掉
            System.out.println("Handling IO Exception");
            // 封装异常再抛出
            throw new RuntimeException(e);
        } catch (SQLException e) {
            // 不推荐方式：什么都不做，直接把异常吞掉
            System.out.println("Handling SQL Exception");
            // e.printStackTrace();
            throw new RuntimeException(e);
            // System.out.println("SQLException handle completed!");
        }
    }

    public static void handleWork(boolean complete) throws IOException, SQLException {
        doSomething(complete);
    }

    public static void handleWork2(boolean complete) {
        doSomethingWithRuntimeException(complete);
    }

    public static void main(String[] args) {
        boolean complete = Boolean.parseBoolean(args[0]);
        System.out.println("complete arg from cli: " + args[0]);
        // handleWork(complete);
        // handleWorkV2(complete);
        handleWorkV3(complete);
    }
}
