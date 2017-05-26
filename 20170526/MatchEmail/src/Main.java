import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by plter on 5/26/17.
 */
public class Main {

    public static void main(String[] args) {

        String email = "xtiqin@163.com";
        Pattern p = Pattern.compile("^[\\w\\d]+@[\\w\\d]+-?[\\w\\d]+\\.[\\w\\d]{2,}$");

        Matcher matcher = p.matcher(email);
        System.out.println(matcher.find());

    }
}
