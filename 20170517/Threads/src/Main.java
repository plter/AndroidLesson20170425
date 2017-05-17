/**
 * Created by plter on 5/17/17.
 */
public class Main {

    public static void main(String[] args) {
        new Main();
    }


    public Main() {
        System.out.println("Step 1");
        try {
            printHelloDelayed("Main");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Step 2");

        //Thread 1
        new Thread() {
            @Override
            public void run() {
                super.run();

                try {
                    printHelloDelayed("Thread 1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        System.out.println("Step 3");
    }

    void printHelloDelayed(String threadName) throws InterruptedException {
        Thread.sleep(1000);
        System.out.printf("[%s]Hello\n", threadName);
    }
}
