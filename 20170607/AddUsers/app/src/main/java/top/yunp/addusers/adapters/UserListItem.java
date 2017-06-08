package top.yunp.addusers.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import top.yunp.addusers.R;

/**
 * Created by plter on 6/6/17.
 */

public class UserListItem {

    private TextView tvName, tvAge;

    public UserListItem(View itemView) {
        tvAge = (TextView) itemView.findViewById(R.id.tvAge);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
    }

    public TextView getTvAge() {
        return tvAge;
    }

    public TextView getTvName() {
        return tvName;
    }
}
