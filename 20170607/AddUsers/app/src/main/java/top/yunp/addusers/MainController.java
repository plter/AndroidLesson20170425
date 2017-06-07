package top.yunp.addusers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import top.yunp.addusers.databinding.ActivityMainBinding;

/**
 * Created by plter on 6/7/17.
 */

public class MainController {

    private ActivityMainBinding binding;
    private MainActivity mainActivity;
    private DbConnector dbConnector;
    public static final int REQUEST_CODE_ADD_USER = 2;
    private UserListAdapter adapter;

    public MainController(ActivityMainBinding binding, MainActivity mainActivity) {
        this.binding = binding;
        this.mainActivity = mainActivity;

        dbConnector = new DbConnector(mainActivity);

        //config user list
        adapter = new UserListAdapter(null, mainActivity);
        binding.userList.setAdapter(adapter);

        addListeners();

        readFromDb();
    }

    private void addListeners() {
        binding.userList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                UserCursor cursor = adapter.getItem(position);
                final int currentItemIdInDb = cursor.getId();

                new AlertDialog.Builder(mainActivity)
                        .setTitle("提示")
                        .setMessage("你确定要删除该项吗？")
                        .setPositiveButton("是的", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dbConnector.delete(currentItemIdInDb);
                                readFromDb();
                            }
                        })
                        .setNegativeButton("关闭", null)
                        .show();
                return true;
            }
        });
    }

    public void btnAddUserClicked(View v) {
        mainActivity.startActivityForResult(new Intent(mainActivity, EditUserActivity.class), REQUEST_CODE_ADD_USER);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_ADD_USER:
                switch (resultCode) {
                    case EditUserActivity.RESULT_SAVE:
                        insertUserToDb(
                                data.getStringExtra(EditUserActivity.KEY_USER_NAME),
                                data.getIntExtra(EditUserActivity.KEY_USER_AGE, 0)
                        );
                        break;
                    case EditUserActivity.RESULT_CLOSE:
                        Toast.makeText(mainActivity, "没有可保存的数据", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
        }
    }

    private void insertUserToDb(String name, int age) {
        dbConnector.insertUser(name, age);

        readFromDb();
    }

    private void readFromDb() {
        adapter.setCursor(dbConnector.queryUsers());
    }

    public void onDestroy() {
        dbConnector.close();
    }
}