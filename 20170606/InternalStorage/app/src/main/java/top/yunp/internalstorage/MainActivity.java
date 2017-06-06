package top.yunp.internalstorage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        try {
//            FileOutputStream data = openFileOutput("data", MODE_PRIVATE);
//            data.write("Hello World".getBytes("utf-8"));
//            data.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            FileInputStream data = openFileInput("data");
//            byte[] bytes = new byte[data.available()];
//            data.read(bytes);
//            data.close();
//
//            System.out.println(new String(bytes, "utf-8"));

            BufferedReader br = new BufferedReader(new InputStreamReader(data, "utf-8"));
            String line = br.readLine();
            data.close();

            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
