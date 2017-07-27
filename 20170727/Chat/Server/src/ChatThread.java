import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatThread extends Thread {


    private Socket socket;
    private InputStream inputStream;
    private static List<ChatThread> allClients = Collections.synchronizedList(new ArrayList<>());
    private OutputStream outputStream;

    public ChatThread(Socket socket) {
        this.socket = socket;

        allClients.add(this);
    }

    @Override
    public void run() {
        super.run();

        try {
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.equals("quit")) {
                    close();
                    return;
                } else {
                    //向每一个连接的终端发送消息

                    synchronized (allClients) {
                        for (ChatThread chatThread : allClients) {
                            chatThread.writeLine(line);
                        }
                    }
                }
            }

            close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(String line) {
        try {
            outputStream.write((line + "\n").getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void close() throws IOException {
        allClients.remove(this);
        inputStream.close();
        socket.close();
    }
}
