import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by plter on 5/16/17.
 */
public class Main {

    public static void main(String[] args) {

        Pattern p = Pattern.compile("^\\[(\\d{2}):(\\d{2})\\.\\d{2}\\](.*)$");

        File f = new File("song_lrc.lrc");
        try {
            FileInputStream in = new FileInputStream(f);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = br.readLine()) != null) {
                Matcher matcher = p.matcher(line);
                if (matcher.find()) {
//                    System.out.println(matcher.group(1));

                    //获取分钟
                    int min = Integer.parseInt(matcher.group(1));
                    //获取秒钟
                    int sec = Integer.parseInt(matcher.group(2));
                    String content = matcher.group(3);

                    System.out.println(String.format("%d,%s", min * 60 + sec, content));
                }
            }

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
