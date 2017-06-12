package top.yunp.addusers.controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import top.yunp.addusers.R;
import top.yunp.addusers.adapters.UserListAdapter;
import top.yunp.addusers.databinding.FragmentUserListBinding;
import top.yunp.addusers.db.DbConnector;
import top.yunp.addusers.fragments.EditUserFragment;
import top.yunp.addusers.fragments.UserListFragment;
import top.yunp.addusers.models.OperationsMenuItem;
import top.yunp.addusers.models.User;

/**
 * Created by plter on 6/7/17.
 */

public class UserListFragmentController {

    private FragmentUserListBinding binding;
    private UserListFragment fragment;
    private DbConnector dbConnector;
    private UserListAdapter adapter;

    public UserListFragmentController(FragmentUserListBinding binding, UserListFragment fragment) {
        this.binding = binding;
        this.fragment = fragment;

        dbConnector = new DbConnector(fragment.getContext());

        //config user list
        adapter = new UserListAdapter(null, fragment.getContext());
        binding.userListView.setAdapter(adapter);

        addListeners();

        readFromDb();
    }

    private void addListeners() {
        addUserListItemLongClickListener();
        addUserListItemClickListener();
    }

    private void addUserListItemClickListener() {
        binding.userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showEditUserFragment((User) parent.getAdapter().getItem(position));
            }
        });
    }

    private void addUserListItemLongClickListener() {
        binding.userListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final User user = adapter.getItem(position);
                final int currentItemIdInDb = user.getId();

                final ArrayAdapter<OperationsMenuItem> opsAdapter = new ArrayAdapter<OperationsMenuItem>(fragment.getContext(), android.R.layout.simple_list_item_1, new OperationsMenuItem[]{
                        new OperationsMenuItem(OperationsMenuItem.OPERATION_EDIT, "编辑"),
                        new OperationsMenuItem(OperationsMenuItem.OPERATION_DELETE, "删除")
                });
                new AlertDialog.Builder(fragment.getContext())
                        .setTitle("操作选项")
                        .setAdapter(opsAdapter, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (opsAdapter.getItem(which).getOperation()) {
                                    case OperationsMenuItem.OPERATION_EDIT:
                                        showEditUserFragment(user);
                                        break;
                                    case OperationsMenuItem.OPERATION_DELETE:
                                        new AlertDialog.Builder(fragment.getContext())
                                                .setTitle("提示")
                                                .setMessage("你确定要删除该项吗？")
                                                .setPositiveButton("是的", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dbConnector.deleteUserById(currentItemIdInDb);
                                                        readFromDb();
                                                    }
                                                })
                                                .setNegativeButton("关闭", null)
                                                .show();
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

    private void showEditUserFragment(User user) {
        fragment.getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, EditUserFragment.newInstance(fragment.getGroupId(), user.getId(), user.getName(), user.getAge()))
                .addToBackStack(EditUserFragment.NAME)
                .commit();
    }

    public void btnAddUserClicked(View v) {
        //呈现添加用户的界面
        fragment.getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, EditUserFragment.newInstance(fragment.getGroupId(), 0, "", 1))
                .addToBackStack(EditUserFragment.NAME)
                .commit();
    }

    /**
     * 从数据库中读取出该组中的用户信息并呈现在列表中
     */
    private void readFromDb() {
        adapter.setCursor(dbConnector.queryUsers(fragment.getGroupId()));
    }

    public void onDestroy() {
        dbConnector.close();
    }
}
