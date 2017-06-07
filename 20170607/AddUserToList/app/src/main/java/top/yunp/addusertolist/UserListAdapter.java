package top.yunp.addusertolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by plter on 6/6/17.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListItem> {

    private final Context context;
    private UserCursor cursor;

    public UserListAdapter(UserCursor cursor, Context context) {
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

            holder.getTvName().setText(cursor.getName());
            holder.getTvAge().setText(String.valueOf(cursor.getAge()));
        }
    }

    @Override
    public int getItemCount() {
        return cursor != null ? cursor.getCount() : 0;
    }

    public void setCursor(UserCursor cursor) {
        if (this.cursor != null) {
            this.cursor.close();
        }

        this.cursor = cursor;

        notifyDataSetChanged();
    }

    public Context getContext() {
        return context;
    }
}
