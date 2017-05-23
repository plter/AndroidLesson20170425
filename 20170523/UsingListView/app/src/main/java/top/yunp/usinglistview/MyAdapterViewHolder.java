package top.yunp.usinglistview;

import android.widget.TextView;

/**
 * Created by plter on 5/23/17.
 */

public class MyAdapterViewHolder {


    private TextView tvName,tvDesc;

    public MyAdapterViewHolder(TextView tvName, TextView tvDesc) {
        this.tvName = tvName;
        this.tvDesc = tvDesc;
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvDesc() {
        return tvDesc;
    }
}
