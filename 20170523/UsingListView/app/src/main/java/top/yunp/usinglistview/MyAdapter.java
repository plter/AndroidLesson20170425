package top.yunp.usinglistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by plter on 5/23/17.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<String> items = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public String getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, null);
        }
        TextView textView = (TextView) convertView;

        textView.setText(getItem(position));
        return textView;
    }

    public Context getContext() {
        return context;
    }

    public void add(String item) {
        items.add(item);
        notifyDataSetChanged();
    }
}
