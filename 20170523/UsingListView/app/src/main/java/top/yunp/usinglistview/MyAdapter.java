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

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_list_item, null);
            Map<String, TextView> holder = new HashMap<>();
            holder.put("tvName", (TextView) convertView.findViewById(R.id.tvName));
            holder.put("tvDesc", (TextView) convertView.findViewById(R.id.tvDesc));
            convertView.setTag(holder);
        }

        Map<String, TextView> holder = (Map<String, TextView>) convertView.getTag();
        TextView tvName = holder.get("tvName");
        TextView tvDesc = holder.get("tvDesc");

        User u = getItem(position);
        tvName.setText(u.getName());
        tvDesc.setText("年龄:" + u.getAge() + ",性别" + u.getGender());

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
