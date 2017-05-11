/**
 * Created by plter on 5/11/17.
 */

public class Main {


    static final int STATE_A = 0b0001;
    static final int STATE_B = 0b0010;
    static final int STATE_C = 0b0100;
    static final int STATE_D = 0b1000;

    public static void main(String[] args) {
        int a = 1;
        Integer a1 = 1;
        short s = 1;
        Short s1 = 2;
        long d = 1;
        Long l = 1L;
        float b = 2;
        Float b1 = 2.0f;
        double c = 1;
        Double c1 = 1.0;
        byte e = 1;
        boolean f = true;
        char g = 'A';

        int h = 8;
        int h1 = 0xA;
        int h2 = 0b100;

        System.out.println(h2);

        int state = 0b1111;

        if (hasStateA(state)) {
            System.out.println("有状态A");
        }
        if (hasStateB(state)) {
            System.out.println("有状态B");
        }
    }

    static boolean hasStateA(int stateCode) {
        return (stateCode & STATE_A) != 0;
    }

    static boolean hasStateB(int stateCode) {
        return (stateCode & STATE_B) != 0;
    }
}
