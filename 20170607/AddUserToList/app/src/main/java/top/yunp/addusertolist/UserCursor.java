package top.yunp.addusertolist;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteQuery;

/**
 * Created by plter on 6/7/17.
 */

public class UserCursor extends SQLiteCursor {
    public UserCursor(SQLiteCursorDriver driver, String editTable, SQLiteQuery query) {
        super(driver, editTable, query);
    }

    public String getName() {
        return getString(getColumnIndex("name"));
    }

    public int getAge() {
        return getInt(getColumnIndex("age"));
    }
}
