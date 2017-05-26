import top.yunp.cmwdv.DefaultValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by plter on 5/26/17.
 */
public class Main {


    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        callSayHello();
    }

    public void callSayHello(String... arg) {
        try {
            Method sayHelloMethod = Main.class.getMethod("sayHello", String.class);

            Object[] params = new Object[1];
            if (arg.length >= 1) {
                params[0] = arg[0];
            } else {
                Annotation[][] parameterAnnotations = sayHelloMethod.getParameterAnnotations();
                DefaultValue defaultValueAnnotation = (DefaultValue) parameterAnnotations[0][0];
                params[0] = defaultValueAnnotation.value();
            }

            sayHelloMethod.invoke(this, params);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void sayHello(@DefaultValue(value = "LiSi") String name) {
        System.out.println("Hello " + name);
    }
}
