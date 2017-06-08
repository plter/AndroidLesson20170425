package top.yunp.addusers.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import top.yunp.addusers.R;
import top.yunp.addusers.databinding.FragmentUserGroupBinding;
import top.yunp.addusers.db.DbConnector;
import top.yunp.addusers.db.DbCursor;
import top.yunp.addusers.models.UserGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserGroupFragment extends Fragment {


    private FragmentUserGroupBinding binding;
    private DbConnector dbConnector;

    public UserGroupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbConnector = new DbConnector(getContext());
    }

    @Override
    public void onDestroy() {

        dbConnector.close();

        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserGroupBinding.inflate(inflater);

        readGroupsFromDb();

        return binding.getRoot();
    }


    private void readGroupsFromDb() {
        DbCursor cursor = dbConnector.queryGroups();

        List<UserGroup> items = new ArrayList<>();

        while (cursor.moveToNext()) {
            items.add(new UserGroup(cursor.getId(), cursor.getName()));
        }

        cursor.close();

        binding.groupListView.setAdapter(new ArrayAdapter<UserGroup>(getContext(), android.R.layout.simple_list_item_1, items));
    }

}
