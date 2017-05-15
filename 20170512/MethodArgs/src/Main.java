/**
 * Created by plter on 5/12/17.
 */
public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
//        System.out.println(max(2, 3));

        System.out.println(max1(2, 3, 5, 1, 6, 8, 1));
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int max1(int... args) {
        int maxValue = args[0];

        for (int i = 1; i < args.length; i++) {
            maxValue = max(maxValue, args[i]);
        }

        return maxValue;
    }
}
