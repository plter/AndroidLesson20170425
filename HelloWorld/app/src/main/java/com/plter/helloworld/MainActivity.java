package com.plter.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {


    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);

        InputStream in = getResources().openRawResource(R.raw.data);
//        byte[] bytes = new byte[1024];
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        int count;
//        try {
//            while ((count = in.read(bytes)) != -1) {
//                baos.write(bytes, 0, count);
//            }
//
//            String result = new String(baos.toByteArray(),"utf-8");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            byte[] bytes = new byte[in.available()];
//            in.read(bytes);
//            String result = new String(bytes, "utf-8");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(in, "utf-8")
            );
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }

            String result = sb.toString();

            JSONObject jo = new JSONObject(result);

            tv.setText(jo.getJSONObject("data").
                    getJSONArray("students").
                    getJSONObject(0).
                    getString("name"));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
