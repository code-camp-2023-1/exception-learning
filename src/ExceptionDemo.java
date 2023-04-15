import java.io.IOException;

public class ExceptionDemo {
    static class User {
        int id;
        String name;
    }
    public static void main(String[] args) throws IOException {
        int[] nums = new int[5];
        System.out.println(nums[10]);

        User user = null;
        System.out.println(user.id);

        throw new IOException("sss");

    }
}
