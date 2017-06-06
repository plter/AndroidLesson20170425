package top.yunp.userlist;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by plter on 6/6/17.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListItem> {

    private final Context context;
    private Cursor cursor;

    public UserListAdapter(Cursor cursor, Context context) {
        setCursor(cursor);

        this.context = context;
    }

    @Override
    public UserListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserListItem(LayoutInflater.from(getContext()).inflate(R.layout.list_item_view, null));
    }

    @Override
    public void onBindViewHolder(UserListItem holder, int position) {
        if (cursor != null) {
            cursor.moveToPosition(position);

            String name = cursor.getString(cursor.getColumnIndex("name"));
            String age = cursor.getString(cursor.getColumnIndex("age"));

            holder.getTvName().setText(name);
            holder.getTvAge().setText(age);
        }
    }

    @Override
    public int getItemCount() {
        return cursor != null ? cursor.getCount() : 0;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;

        notifyDataSetChanged();
    }

    public Context getContext() {
        return context;
    }
}
