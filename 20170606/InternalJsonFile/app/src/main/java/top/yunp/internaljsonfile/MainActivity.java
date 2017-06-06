package top.yunp.internaljsonfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {


    private JSONObject data;
    private static final String dataFileName = "data.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readJsonData();


//        try {
//            data.put("name", "ZhangSan");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//        writeJsonData();


        try {
            System.out.println(data.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void readJsonData() {
        try {
            FileInputStream inputStream = openFileInput(dataFileName);
            byte[] bytes = new byte[1024];
            int count = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((count = inputStream.read(bytes)) != -1) {
                bos.write(bytes, 0, count);
            }
            inputStream.close();

            String jsonString = new String(bos.toByteArray(), "utf-8");
            data = new JSONObject(jsonString);
        } catch (IOException | JSONException e) {
            e.printStackTrace();

            data = new JSONObject();
        }
    }

    void writeJsonData() {
        FileOutputStream outputStream = null;

        try {
            outputStream = openFileOutput(dataFileName, MODE_PRIVATE);
            outputStream.write(data.toString().getBytes("utf-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
