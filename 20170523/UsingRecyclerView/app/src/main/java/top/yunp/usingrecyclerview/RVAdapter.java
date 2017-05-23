package top.yunp.usingrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by plter on 5/23/17.
 */

public class RVAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<User> users = new ArrayList<>();

    public RVAdapter(Context context) {
        this.context = context;

        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
        users.add(new User("小明", "男", 10));
    }

    @Override
    public RVAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVAdapterViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.rv_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RVAdapterViewHolder rvHolder = (RVAdapterViewHolder) holder;
        User user = users.get(position);
        rvHolder.getTvName().setText(user.getName());
        rvHolder.getTvDesc().setText("年龄：" + user.getAge() + ",性别：" + user.getGender());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public Context getContext() {
        return context;
    }
}
