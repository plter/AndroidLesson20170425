import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by plter on 5/23/17.
 */
public class Main {

    public static void main(String[] args) {

        try {
            InputStream inputStream = new URL("http://localhost:8080/users").openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
