import java.io.*;

public class TryCatchFinallyDemo {
    public static String readFile(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                System.out.println("Line: " + line);
            }
            return "OK";
        } catch (FileNotFoundException e) { // 把子类，范围小的异常放在前面catch，进行处理
            System.out.println("File Not Found!!!");
            e.printStackTrace();
            return "File Not Found";
        } catch (IOException e) {
            System.out.println("IOException Found！！！");
            throw new RuntimeException(e);
        } finally {
            // 任何IO流都要考虑关闭
            System.out.println("Closing IO");
            if (reader != null) {
                reader.close();
            }
            return "FINALLY";
        }
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
            e.printStackTrace();
            return "File Not Found";
        } catch (IOException e) {
            System.out.println("IOException Found！！！");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        // 正常执行路径
        // String result = readFile("/Users/ge/JIRENGU/Java体系课程/code/exception-learning/exception-learning/src/123.txt");


        // 发生异常，FileNotFound
        String result = readFile("123.txt");
        System.out.println("Result: " + result);
    }
}
