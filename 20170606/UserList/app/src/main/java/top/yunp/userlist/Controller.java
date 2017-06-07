package top.yunp.userlist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.LinearLayoutManager;

import top.yunp.userlist.databinding.ActivityMainBinding;

/**
 * Created by plter on 6/6/17.
 */

public class Controller {
    private final ActivityMainBinding binding;
    private UserListAdapter adapter;
    private SQLiteDatabase database;

    public Controller(ActivityMainBinding binding) {
        this.binding = binding;

        adapter = new UserListAdapter(null, binding.getRoot().getContext());
        connectSqliteDatabase();

        initUI();

        readDataFromDB();
    }

    private void connectSqliteDatabase() {
        database = binding.getRoot().getContext().openOrCreateDatabase("users", Context.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL DEFAULT \"\"," +
                "age TEXT NOT NULL DEFAULT \"\")");

//        ContentValues cvs = new ContentValues();
//        cvs.put("name", "张三");
//        cvs.put("age", "12");
//        database.insert("user", "", cvs);
//
//        cvs = new ContentValues();
//        cvs.put("name", "李四");
//        cvs.put("age", "13");
//        database.insert("user", "", cvs);
//
//        cvs = new ContentValues();
//        cvs.put("name", "王五");
//        cvs.put("age", "10");
//        database.insert("user", "", cvs);
//
//        cvs = new ContentValues();
//        cvs.put("name", "赵六");
//        cvs.put("age", "16");
//        database.insert("user", "", cvs);
    }


    private void readDataFromDB() {
        Cursor userCursor = database.query("user", null, null, null, null, null, null, null);
        adapter.setCursor(userCursor);
    }

    private void initUI() {
        binding.userList.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(), LinearLayoutManager.VERTICAL, false));
        binding.userList.setAdapter(adapter);
    }
}
