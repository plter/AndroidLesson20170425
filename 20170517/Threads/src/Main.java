/**
 * Created by plter on 5/17/17.
 */
public class Main {

    public static void main(String[] args) {
        new Main();
    }


    public Main() {
        System.out.println("Main thread started");
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

        //Thread 2
        new Thread() {
            @Override
            public void run() {
                super.run();

                try {
                    printHelloDelayed("Thread 2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        System.out.println("Step 3");
    }

    synchronized void printHelloDelayed(String threadName) throws InterruptedException {
        System.out.printf("[%s]Will print \"Hello\"\n", threadName);
        Thread.sleep(1000);
        System.out.printf("[%s]Hello\n", threadName);
        System.out.printf("[%s]Print \"Hello\" end\n", threadName);
    }
}
