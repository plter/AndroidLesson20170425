package com.plter.loaddata;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadData("http://baidu.com");
    }

    private void loadData(String url) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... params) {

                try {
                    InputStream in = new URL(params[0]).openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));

                    String line = null;
                    StringBuilder content = new StringBuilder();

                    while ((line = br.readLine()) != null) {
                        content.append(line);
                    }

                    in.close();

                    return content.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                if (s != null) {
                    tv.setText(s);
                } else {
                    tv.setText("Error loading data");
                }
            }
        }.execute(url);
    }
}
