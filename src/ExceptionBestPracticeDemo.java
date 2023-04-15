import exceptions.CustomizeUncheckedException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ExceptionBestPracticeDemo {
    static Logger logger = Logger.getLogger("BestPractice");
    public static void method1(String filePath) {
        File file = new File(filePath);
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
            }
        } catch (IOException e) {

        }
    }

    public static void method2(String filePath) {
        File file = new File(filePath);
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
            }
        } catch (Exception e) {
            System.out.println("File Not Found!!!");
            e.printStackTrace();
        }
    }

    public static void method3(String filePath) {
        File file = new File(filePath);
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
            }
        } catch (IOException e) {
            System.out.println("File Not Found!!!");
            e.printStackTrace(); // 不要在生产上用printStackTrace()
        } catch (NullPointerException e) {
            e.printStackTrace();
        // 不要抛实际遇不到或者不能处理的异常
        /**
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
         **/
        }
    }

    /**
     * Do something according to complete flag
     * @param complete flag indicated whether complete or not.
     * @throws IOException
     * @throws SQLException
     */
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

    public static String readFileV2(String filePath) {
        File file = new File(filePath);
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
            }
            return "OK";
        } catch (FileNotFoundException e) { // 把子类，范围小的异常放在前面catch，进行处理
            System.out.println("File Not Found!!!");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("IOException Found！！！");
            throw new RuntimeException(e);
        }
    }

    public static void testUncheckedException() {
        IndexOutOfBoundsException ex = new IndexOutOfBoundsException("Index is out of bounds");
        throw new CustomizeUncheckedException("Unchecked Exception met!", ex); //不要忘记原始的cause
    }

    public static void main(String[] args) {
        method1("123.txt");
        try {
            doSomething(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
