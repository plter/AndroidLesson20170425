import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by plter on 5/17/17.
 */
public class Main {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
        List<String> list = Collections.synchronizedList(new ArrayList<>());

    }
}
