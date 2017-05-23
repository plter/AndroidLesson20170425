package top.yunp.getusers;

import android.widget.TextView;

/**
 * Created by plter on 5/23/17.
 */

public class UserListItemViewHolder {

    private TextView tvUserName, tvDecription;

    public UserListItemViewHolder(TextView tvUserName, TextView tvDecription) {
        this.tvUserName = tvUserName;
        this.tvDecription = tvDecription;
    }

    public TextView getTvDecription() {
        return tvDecription;
    }

    public TextView getTvUserName() {
        return tvUserName;
    }
}
