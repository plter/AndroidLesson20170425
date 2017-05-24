package top.yunp.autocount;

import android.view.View;

/**
 * Created by plter on 5/23/17.
 */

public class CountWrapper {

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCountString() {
        return "Current count " + this.count;
    }

    public void clickedHandler() {
        System.out.println("Clicked");
    }
}
