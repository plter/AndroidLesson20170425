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
import top.yunp.addusers.fragments.UserListFragment;
import top.yunp.addusers.models.OperationsMenuItem;
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

        //创建数据库连接
        dbConnector = new DbConnector(fragment.getContext());

        addListeners();
        readGroupsFromDb();
    }

    public void btnAddGroupClicked(View v) {

        //呈现添加用户组的界面
        fragment.getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, EditGroupFragment.newInstance())
                .addToBackStack(EditGroupFragment.NAME)
                .commit();
    }

    public void onDestroy() {
        dbConnector.close();
    }

    /**
     * 从数据库中读取所有组，并呈现在列表中
     */
    private void readGroupsFromDb() {
        DbCursor cursor = dbConnector.queryGroups();

        List<UserGroup> items = new ArrayList<>();

        while (cursor.moveToNext()) {
            items.add(new UserGroup(cursor.getId(), cursor.getName()));
        }

        cursor.close();

        binding.groupListView.setAdapter(new ArrayAdapter<UserGroup>(fragment.getContext(), android.R.layout.simple_list_item_1, items));
    }


    private void addListeners() {
        addListItemLongClickListener();
        addListItemClickListener();
    }

    private void addListItemClickListener() {

        //当列表项被点击时，呈现该组中的用户列表界面
        binding.groupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserGroup userGroup = (UserGroup) parent.getAdapter().getItem(position);

                fragment.getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, UserListFragment.newInstance(userGroup.getId()))
                        .addToBackStack(UserListFragment.NAME)
                        .commit();
            }
        });

    }

    private void addListItemLongClickListener() {

        //长按呈现选项菜单
        binding.groupListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final UserGroup group = (UserGroup) binding.groupListView.getAdapter().getItem(position);
                final int groupId = group.getId();

                //菜单选项列表，其中包括编辑和删除
                final ArrayAdapter<OperationsMenuItem> adapter = new ArrayAdapter<OperationsMenuItem>(fragment.getContext(), android.R.layout.simple_list_item_1, new OperationsMenuItem[]{
                        new OperationsMenuItem(OperationsMenuItem.OPERATION_EDIT, "编辑"),
                        new OperationsMenuItem(OperationsMenuItem.OPERATION_DELETE, "删除")
                });

                new AlertDialog.Builder(fragment.getContext())
                        .setTitle("组操作选项")
                        .setAdapter(adapter, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (adapter.getItem(which).getOperation()) {
                                    case OperationsMenuItem.OPERATION_EDIT:
                                        //呈现编辑该组的界面
                                        fragment.getFragmentManager()
                                                .beginTransaction()
                                                .replace(R.id.fragmentContainer, EditGroupFragment.newInstance(group.getId(), group.getName()))
                                                .addToBackStack(EditGroupFragment.NAME)
                                                .commit();
                                        break;
                                    case OperationsMenuItem.OPERATION_DELETE:
                                        //根据id删除该该组
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
