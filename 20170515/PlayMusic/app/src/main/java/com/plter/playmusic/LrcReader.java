package com.plter.playmusic;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by plter on 5/15/17.
 */

public class LrcReader {

    private InputStream in;
    private Map<Integer, String> lrcMap = new HashMap<>();

    public LrcReader(InputStream in) throws IOException {
        this.in = in;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));

            String line;
            while ((line = br.readLine()) != null) {

                int start = line.indexOf("[") + 1;
                int end = line.indexOf(":", start);
                String minStr = line.substring(start, end);
                try {
                    int min = Integer.parseInt(minStr);

                    start = end + 1;
                    end = line.indexOf(".", start);
                    String secStr = line.substring(start, end);
                    int sec = Integer.parseInt(secStr);

                    start = line.indexOf("]") + 1;
                    String content = line.substring(start);

                    lrcMap.put(min * 60 + sec, content);
                } catch (NumberFormatException e) {
                    Log.w("NaN", "This string is not a number");
                }
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getContent(int timeTag) {
        return lrcMap.get(timeTag);
    }

    public void close() throws IOException {
        this.in.close();
    }
}
