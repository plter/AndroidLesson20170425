package top.yunp.addusers.controllers;

import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import top.yunp.addusers.R;
import top.yunp.addusers.databinding.FragmentUserGroupListBinding;
import top.yunp.addusers.db.DbConnector;
import top.yunp.addusers.db.DbCursor;
import top.yunp.addusers.fragments.EditGroupFragment;
import top.yunp.addusers.fragments.UserGroupListFragment;
import top.yunp.addusers.models.UserGroup;

/**
 * Created by plter on 6/8/17.
 */

public class UserGroupListFragmentController {

    private FragmentUserGroupListBinding binding;
    private UserGroupListFragment fragment;
    private DbConnector dbConnector;

    public UserGroupListFragmentController(FragmentUserGroupListBinding binding, UserGroupListFragment userGroupFragment) {
        this.binding = binding;
        this.fragment = userGroupFragment;

        dbConnector = new DbConnector(fragment.getContext());

        readGroupsFromDb();
    }

    public void btnAddGroupClicked(View v) {
        System.out.println("btnAddGroupClicked");
        binding.getRoot().setVisibility(View.GONE);
        fragment.getFragmentManager().beginTransaction().add(R.id.fragmentContainer, new EditGroupFragment()).addToBackStack(EditGroupFragment.NAME).commit();
    }

    public void onDestroy() {
        dbConnector.close();
    }

    private void readGroupsFromDb() {
        DbCursor cursor = dbConnector.queryGroups();

        List<UserGroup> items = new ArrayList<>();

        while (cursor.moveToNext()) {
            items.add(new UserGroup(cursor.getId(), cursor.getName()));
        }

        cursor.close();

        binding.groupListView.setAdapter(new ArrayAdapter<UserGroup>(fragment.getContext(), android.R.layout.simple_list_item_1, items));
    }
}
