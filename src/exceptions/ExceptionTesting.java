package exceptions;

public class ExceptionTesting {
    public static void testCheckedException() throws CustomizeCheckedException {
        throw new CustomizeCheckedException("Checked Exception met!");
    }

    public static void testUncheckedException() {
        IndexOutOfBoundsException ex = new IndexOutOfBoundsException("Index is out of bounds");
        throw new CustomizeUncheckedException("Unchecked Exception met!", ex);
    }
    public static void main(String[] args) {
        testUncheckedException();
    }
}
