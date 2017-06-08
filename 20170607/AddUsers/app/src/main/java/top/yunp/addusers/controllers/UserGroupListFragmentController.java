package top.yunp.addusers.controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import top.yunp.addusers.R;
import top.yunp.addusers.databinding.FragmentUserGroupListBinding;
import top.yunp.addusers.db.DbConnector;
import top.yunp.addusers.db.DbCursor;
import top.yunp.addusers.fragments.EditGroupFragment;
import top.yunp.addusers.fragments.UserGroupListFragment;
import top.yunp.addusers.models.GroupListOperationsMenuItem;
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

        addListeners();
        readGroupsFromDb();
    }

    public void btnAddGroupClicked(View v) {
        System.out.println("btnAddGroupClicked");
        binding.getRoot().setVisibility(View.GONE);
        fragment.getFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainer, EditGroupFragment.newInstance())
                .addToBackStack(EditGroupFragment.NAME)
                .commit();
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

    public void onBackToFragment() {
        readGroupsFromDb();
    }


    private void addListeners() {
        addListItemLongClickListener();
    }

    private void addListItemLongClickListener() {
        binding.groupListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final UserGroup group = (UserGroup) binding.groupListView.getAdapter().getItem(position);
                final int groupId = group.getId();

                final ArrayAdapter<GroupListOperationsMenuItem> adapter = new ArrayAdapter<GroupListOperationsMenuItem>(fragment.getContext(), android.R.layout.simple_list_item_1, new GroupListOperationsMenuItem[]{
                        new GroupListOperationsMenuItem(GroupListOperationsMenuItem.OPERATION_EDIT, "编辑"),
                        new GroupListOperationsMenuItem(GroupListOperationsMenuItem.OPERATION_DELETE, "删除")
                });

                new AlertDialog.Builder(fragment.getContext())
                        .setTitle("组操作选项")
                        .setAdapter(adapter, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (adapter.getItem(which).getOperation()) {
                                    case GroupListOperationsMenuItem.OPERATION_EDIT:
                                        fragment.getFragmentManager()
                                                .beginTransaction()
                                                .add(R.id.fragmentContainer, EditGroupFragment.newInstance(group.getId(), group.getName()))
                                                .addToBackStack(EditGroupFragment.NAME)
                                                .commit();
                                        break;
                                    case GroupListOperationsMenuItem.OPERATION_DELETE:
                                        dbConnector.deleteGroup(groupId);
                                        readGroupsFromDb();
                                        break;
                                }
                            }
                        })
                        .setNegativeButton("关闭", null)
                        .show();
                return true;
            }
        });
    }
}
