import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Created by plter on 5/17/17.
 */
public class Main {

    public static void main(String[] args) {

        File f = new File("data.txt");

//
//        try {
//            FileInputStream fis = new FileInputStream(f);
//            ByteBuffer buffer = ByteBuffer.allocate(fis.available());
////            ByteBuffer buffer = ByteBuffer.allocateDirect(fis.available());
//
//
//            FileChannel channel = fis.getChannel();
//            channel.read(buffer);
//            channel.close();
//            fis.close();
//
//            String content = new String(buffer.array(), "utf-8");
//            System.out.println(content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Path path = FileSystems.getDefault().getPath("data.txt");
//        ByteBuffer buffer = ByteBuffer.allocate(2048);

        try {
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
            channel.read(buffer, 0, null, new CompletionHandler<Integer, Object>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    try {
                        System.out.println(new String(buffer.array(), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(Throwable exc, Object attachment) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
