public class UncheckedExceptionDemo {
    public static void handle() {
        try {
            int[] nums = new int[5];
            System.out.println(nums[10]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Handling out of bounds exception");
            ex.printStackTrace();
        }

        try {
            System.out.println("Starting with user!!!");
            ExceptionDemo.User user = null;
            System.out.println(user.id);
        } catch (NullPointerException e) {
            System.out.println("Handling NPE!");
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        handle();
        System.out.println("completed!!");
    }
}
