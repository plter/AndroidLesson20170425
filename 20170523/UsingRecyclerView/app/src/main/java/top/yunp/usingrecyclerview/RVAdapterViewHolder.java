package top.yunp.usingrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by plter on 5/23/17.
 */

public class RVAdapterViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName, tvDesc;

    public RVAdapterViewHolder(View itemView) {
        super(itemView);

        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvDesc = (TextView) itemView.findViewById(R.id.tvDesc);
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvDesc() {
        return tvDesc;
    }
}
