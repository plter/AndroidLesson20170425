package top.yunp.autocount;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by plter on 5/23/17.
 */

public class CountWrapper extends BaseObservable {

    private int count = 0;
    private String countString = "Current count 0";

    @Bindable
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        notifyPropertyChanged(BR.countWrapper);
        setCountString("Current count " + this.count);
    }

    @Bindable
    public String getCountString() {
        return countString;
    }

    public void setCountString(String countString) {
        this.countString = countString;
        notifyPropertyChanged(BR.countString);
    }

    public void clickedHandler() {
        System.out.println("Clicked");
    }
}
