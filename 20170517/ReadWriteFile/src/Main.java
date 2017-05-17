import java.io.*;

/**
 * Created by plter on 5/17/17.
 */
public class Main {

    public static void main(String[] args) {

        File f = new File("data.txt");

        //写出文件
//        if (!f.exists()) {
//            try {
//                if (f.createNewFile()) {
//                    FileOutputStream fos = new FileOutputStream(f);
//                    fos.write("Hello World\n".getBytes("utf-8"));
////                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));
////                    writer.append("Hello World\n");
////                    writer.flush();
//                    fos.close();
//                } else {
//                    System.err.println("创建文件失败");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


        try {
            FileInputStream fis = new FileInputStream(f);
            byte[] bytes = new byte[fis.available()];
            int readCount = fis.read(bytes);
            fis.close();

            System.out.println(new String(bytes, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
