package top.yunp.addusers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import top.yunp.addusers.R;
import top.yunp.addusers.db.DbCursor;
import top.yunp.addusers.models.User;

/**
 * Created by plter on 6/6/17.
 */

public class UserListAdapter extends BaseAdapter {

    private final Context context;
    private List<User> users = new ArrayList<>();

    public UserListAdapter(DbCursor cursor, Context context) {
        setCursor(cursor);

        this.context = context;
    }

    public void setCursor(DbCursor cursor) {

        if (cursor != null) {
            System.out.println(cursor.getCount() + "<<<<<<<");
            while (cursor.moveToNext()) {
                users.add(new User(cursor.getId(), cursor.getName(), cursor.getAge()));
            }
            cursor.close();

            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_view, null);
            convertView.setTag(new UserListItem(convertView));
        }

        User cursor = getItem(position);
        UserListItem itemView = (UserListItem) convertView.getTag();
        itemView.getTvName().setText(cursor.getName());
        itemView.getTvAge().setText(String.valueOf(cursor.getAge()));
        return convertView;
    }
}
