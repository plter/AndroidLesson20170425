import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by plter on 5/16/17.
 */
public class Main {

    public static void main(String[] args) {


        String str = "Hello 2001 World 100";

//        Pattern p = Pattern.compile(".{2}");
//        Pattern p = Pattern.compile("\\d+");
//        Pattern p = Pattern.compile("[0-9]+");
//        Pattern p = Pattern.compile("\\w+");
        Pattern p = Pattern.compile("[a-zA-Z]+");

        Matcher matcher = p.matcher(str);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
