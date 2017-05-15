package com.plter.playmusic;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer player;
    private boolean running = false;
    private LrcReader lrcReader;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);

        readLrc();
        player = MediaPlayer.create(this, R.raw.song);
    }

    @Override
    protected void onResume() {
        super.onResume();

        running = true;
        syncLrcTask.execute();
        player.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        running = false;
        player.stop();
    }

    private AsyncTask<Void, Void, Void> syncLrcTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... params) {
            while (running) {
                try {
                    Thread.sleep(1000);

                    publishProgress();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

            String content = lrcReader.getContent(player.getCurrentPosition() / 1000);
            if (content != null) {
                tv.setText(content);
            }

//            Log.e("Time", (player.getCurrentPosition() / 1000) + "");
//            Log.e("Time",Math.round(((double)player.getCurrentPosition())/1000)+"");
        }
    };


    private void readLrc() {
        InputStream inputStream = getResources().openRawResource(R.raw.song_lrc);
        try {
            lrcReader = new LrcReader(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error parsing lrc", Toast.LENGTH_SHORT).show();
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
