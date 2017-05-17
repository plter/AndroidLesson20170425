import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by plter on 5/17/17.
 */
public class Main {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://baidu.com");
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
