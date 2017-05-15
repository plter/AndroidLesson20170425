import com.plter.rf.Hello;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by plter on 5/12/17.
 */
public class Main {

    public static void main(String[] args) {

        Class[] importedClasses = new Class[]{
                Hello.class
        };

//        try {
//            Hello h = Hello.class.newInstance();
//            h.sayHello();
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        try {
            Class<?> helloClass = Class.forName("com.plter.rf.Hello");
            Object hello = helloClass.newInstance();
            Method sayHelloMethod = helloClass.getMethod("sayHello", String.class);
            sayHelloMethod.invoke(hello, "ZhangSan");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
