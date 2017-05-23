package top.yunp.usinglistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by plter on 5/23/17.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<User> items = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public User getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyAdapterViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_list_item, null);
            holder = new MyAdapterViewHolder(
                    (TextView) convertView.findViewById(R.id.tvName),
                    (TextView) convertView.findViewById(R.id.tvDesc)
            );

            convertView.setTag(holder);
        } else {
            holder = (MyAdapterViewHolder) convertView.getTag();
        }


        User u = getItem(position);
        holder.getTvName().setText(u.getName());
        holder.getTvDesc().setText("年龄:" + u.getAge() + ",性别" + u.getGender());

        return convertView;
    }

    public Context getContext() {
        return context;
    }

    public void add(User item) {
        items.add(item);
        notifyDataSetChanged();
    }
}
