import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {


        try {
            ServerSocket server = new ServerSocket(9000);
            System.out.println("Server started");

            while (true) {
                Socket connection = server.accept();

                new ChatThread(connection).start();

//                try {
//                    OutputStream outputStream = connection.getOutputStream();
//                    outputStream.write("Hello World\n".getBytes("utf-8"));
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }

        } catch (IOException e) {
            e.printStackTrace();

            System.out.println("Can not start server");
        }

    }
}
