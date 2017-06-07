package top.yunp.addusers;

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
    public static final int DB_VERSION = 1;
    public static final String USER_TABLE_NAME = "user";
    public static final String ID_COLUMN_NAME = "_id";
    public static final String NAME_COLUMN_NAME = "name";
    public static final String AGE_COLUMN_NAME = "age";
    private SQLiteDatabase writableDatabase;
    private SQLiteDatabase readableDatabase;

    public DbConnector(Context context) {
        super(context, DB_NAME, new SQLiteDatabase.CursorFactory() {
            @Override
            public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String editTable, SQLiteQuery query) {
                return new UserCursor(masterQuery, editTable, query);
            }
        }, DB_VERSION);

        writableDatabase = getWritableDatabase();
        readableDatabase = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + USER_TABLE_NAME + "(" +
                ID_COLUMN_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NAME_COLUMN_NAME + " TEXT NOT NULL DEFAULT NONE," +
                AGE_COLUMN_NAME + " INTEGER DEFAULT 1)");
    }

    public void insertUser(String name, int age) {
        ContentValues cvs = new ContentValues();
        cvs.put(NAME_COLUMN_NAME, name);
        cvs.put(AGE_COLUMN_NAME, age);
        writableDatabase.insert(USER_TABLE_NAME, "", cvs);
    }

    public UserCursor queryUsers() {
        return (UserCursor) readableDatabase.query("user", null, null, null, null, null, null);
    }

    /**
     * 根据id删除该条数据
     *
     * @param id
     */
    public void delete(int id) {
        writableDatabase.delete(USER_TABLE_NAME, ID_COLUMN_NAME + "=?", new String[]{String.valueOf(id)});
    }

    public void updateUser(int id, String userName, int age) {
        ContentValues cvs = new ContentValues();
        cvs.put(NAME_COLUMN_NAME, userName);
        cvs.put(AGE_COLUMN_NAME, age);

        writableDatabase.update(USER_TABLE_NAME, cvs, ID_COLUMN_NAME + "=?", new String[]{String.valueOf(id)});
    }

    public void close() {
        writableDatabase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
