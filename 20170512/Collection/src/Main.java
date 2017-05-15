import java.util.*;

/**
 * Created by plter on 5/12/17.
 */
public class Main {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("name", "XiaoMing");
        map.put("age", "10");
//
//        System.out.println(map.get("name"));

        for (String key : map.keySet()) {
            System.out.println(String.format("%s=%s", key, map.get(key)));
        }


//        List<String> list = new ArrayList<>();
//        list.add("Hello");
//        list.add("World");

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

//        for (String str :
//                list) {
//            System.out.println(str);
//        }

//        ListIterator<String> iterator = list.listIterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }
}
