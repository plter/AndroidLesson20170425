import java.util.Arrays;

/**
 * Created by plter on 5/12/17.
 */
public class Main {

    public static void main(String[] args) {

//        String str = "Hello World";
//        String str1 = new String("Hello World");
//        String str2 = "Hello World";
//
//
//        System.out.println(str == str1);

//        String str = String.format("Hello %d,%f,%s,%c,%x,%o", 100, 3.14f, "World", 'A', 11, 8);
//
//        System.out.println(str);

//        String numberString = "100";
//        Integer number = Integer.parseInt(numberString);
//
//        System.out.println(100 * 2);

//        String str = number + "";

        //Reverse string by using array
//        String str = "Hello World";
//        String[] strArr = str.split("");
//        String[] reversedArray = new String[strArr.length];
//        for (int i = strArr.length - 1; i >= 0; i--) {
//            reversedArray[strArr.length - i - 1] = strArr[i];
//        }
//        StringBuilder content = new StringBuilder();
//        for (String s :
//                reversedArray) {
//            content.append(s);
//        }
//
//        System.out.println(content.toString());

//        dumpArray(reversedArray);

        //Reverse string by charAt
//        String str = "Hello World";
//        StringBuilder sb = new StringBuilder();
//        for (int i = str.length() - 1; i >= 0; i--) {
//            sb.append(str.charAt(i));
//        }
//        System.out.println(sb.toString());

        //Index
//        String str = "He[llo Wo]rld";
////        System.out.println(str.indexOf("l"));
//        int startIndex = str.indexOf("[") + 1;
//        int endIndex = str.indexOf("]", startIndex);
//        String content = str.substring(startIndex, endIndex);
//        System.out.println(content);

        //Replace
        String str = "Hello World";
        str = str.replace("o", "d");
//        str = str.replaceFirst("o", "d");
        System.out.println(str);
    }

    static void dumpArray(String[] arr) {
        for (String str :
                arr) {
            System.out.println(str);
        }
    }

}
