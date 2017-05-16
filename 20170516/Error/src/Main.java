/**
 * Created by plter on 5/16/17.
 */
public class Main {

    public static void main(String[] args) {

        new Main();
    }

    public Main() {

        try {
            customError(true);
            System.out.println("Run normally");
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Error occurred");
        } finally {
            System.out.println("Finally run");
        }

        customRuntimeError(true);
        System.out.println("End");
    }

    void customError(boolean willThrow) throws Exception {
        if (willThrow) {
            throw new Exception("Custom error");
        }
    }

    void customRuntimeError(boolean willThrow) {
        if (willThrow) {
            throw new RuntimeException("Custom runtime error");
        }
    }
}
