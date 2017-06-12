package top.yunp.addusers.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

/**
 * Created by plter on 6/7/17.
 */

public class DbConnector extends SQLiteOpenHelper {

    public static final String DB_NAME = "users.db";
    public static final int DB_VERSION = 2;
    public static final String TABLE_NAME_USER = "user";
    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_AGE = "age";

    public static final String TABLE_NAME_GROUP = "user_group";
    public static final String COLUMN_NAME_GROUP_ID = "group_id";

    private SQLiteDatabase writableDatabase;
    private SQLiteDatabase readableDatabase;

    public DbConnector(Context context) {
        super(context, DB_NAME, new SQLiteDatabase.CursorFactory() {
            @Override
            public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String editTable, SQLiteQuery query) {
                return new DbCursor(masterQuery, editTable, query);
            }
        }, DB_VERSION);

        writableDatabase = super.getWritableDatabase();
        readableDatabase = super.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME_GROUP + "(" +
                COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME_NAME + " TEXT NOT NULL DEFAULT \"default group\")");
        initGroupData(db);

        db.execSQL("CREATE TABLE " + TABLE_NAME_USER + "(" +
                COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME_NAME + " TEXT NOT NULL DEFAULT NONE," +
                COLUMN_NAME_AGE + " INTEGER DEFAULT 1," +
                COLUMN_NAME_GROUP_ID + " INTEGER DEFAULT 1)");


        //v1
//        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_USER + "(" +
//                COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//                COLUMN_NAME_NAME + " TEXT NOT NULL DEFAULT NONE," +
//                COLUMN_NAME_AGE + " INTEGER DEFAULT 1)");
    }

    public DbCursor queryUsers() {
        return (DbCursor) readableDatabase.query("user", null, null, null, null, null, null);
    }

    /**
     * 根据组id查找用户
     *
     * @param groupId
     * @return
     */
    public DbCursor queryUsers(int groupId) {
        return (DbCursor) readableDatabase.query("user", null, COLUMN_NAME_GROUP_ID + "=?", new String[]{String.valueOf(groupId)}, null, null, null);
    }

    public DbCursor queryGroups() {
        return (DbCursor) readableDatabase.query(TABLE_NAME_GROUP, null, null, null, null, null, null);
    }

    /**
     * 添加一个组
     *
     * @param name
     */
    public void addGroup(String name) {
        ContentValues cvs = new ContentValues();
        cvs.put(COLUMN_NAME_NAME, name);
        getWritableDatabase().insert(TABLE_NAME_GROUP, null, cvs);
    }

    /**
     * 修改组
     *
     * @param groupId
     * @param name
     */
    public void editGroup(int groupId, String name) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_NAME, name);

        getWritableDatabase().update(TABLE_NAME_GROUP, values, COLUMN_NAME_ID + "=?", new String[]{String.valueOf(groupId)});
    }

    /**
     * 根据id删除该条数据
     *
     * @param id
     */
    public void deleteUserById(int id) {
        writableDatabase.delete(TABLE_NAME_USER, COLUMN_NAME_ID + "=?", new String[]{String.valueOf(id)});
    }

    public void updateUser(int groupId, int id, String userName, int age) {
        ContentValues cvs = new ContentValues();
        cvs.put(COLUMN_NAME_NAME, userName);
        cvs.put(COLUMN_NAME_AGE, age);
        cvs.put(COLUMN_NAME_GROUP_ID, groupId);

        writableDatabase.update(TABLE_NAME_USER, cvs, COLUMN_NAME_ID + "=?", new String[]{String.valueOf(id)});
    }

    public void insertUser(int groupId, String name, int age) {
        ContentValues cvs = new ContentValues();
        cvs.put(COLUMN_NAME_NAME, name);
        cvs.put(COLUMN_NAME_AGE, age);
        cvs.put(COLUMN_NAME_GROUP_ID, groupId);
        writableDatabase.insert(TABLE_NAME_USER, "", cvs);
    }

    /**
     * 根据id删除用户组
     *
     * @param id
     */
    public void deleteGroup(int id) {
        writableDatabase.delete(TABLE_NAME_GROUP, COLUMN_NAME_ID + "=?", new String[]{String.valueOf(id)});
    }

    public void close() {
        writableDatabase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //upgrade from 1 to 2
        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL("CREATE TABLE " + TABLE_NAME_GROUP + "(" +
                    COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME_NAME + " TEXT NOT NULL DEFAULT \"default group\")");
            initGroupData(db);

            //upgrade user table
            db.execSQL("ALTER TABLE " + TABLE_NAME_USER + " ADD COLUMN " + COLUMN_NAME_GROUP_ID + " INTEGER DEFAULT 1");
        }
    }

    /**
     * 初始化用户组数据
     */
    private void initGroupData(SQLiteDatabase db) {
        ContentValues cvs = new ContentValues();
        cvs.put(COLUMN_NAME_ID, 1);
        cvs.put(COLUMN_NAME_NAME, "default group");
        db.insert(TABLE_NAME_GROUP, null, cvs);
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return readableDatabase;
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return writableDatabase;
    }
}
