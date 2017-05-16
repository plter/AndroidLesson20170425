import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by plter on 5/16/17.
 */
public class Main {

    public static void main(String[] args) {


        String idNumber = "000000200001010000";

        Pattern p = Pattern.compile("^\\d{6}(\\d{4})(\\d{2})(\\d{2})\\d{3}[\\dX]$");

        Matcher matcher = p.matcher(idNumber);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            String year = matcher.group(1);
            String month = matcher.group(2);
            String date = matcher.group(3);

            System.out.println(String.format("%s-%s-%s", year, month, date));
        } else {
            System.out.println("It's not a id number");
        }
    }
}
