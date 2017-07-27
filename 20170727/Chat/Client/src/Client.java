import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 9000);
            InputStream in = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
