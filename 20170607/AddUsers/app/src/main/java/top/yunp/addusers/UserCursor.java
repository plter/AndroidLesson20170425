package top.yunp.addusers;

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

    public int getId() {
        return getInt(getColumnIndex(DbConnector.ID_COLUMN_NAME));
    }

    public String getName() {
        return getString(getColumnIndex(DbConnector.NAME_COLUMN_NAME));
    }

    public int getAge() {
        return getInt(getColumnIndex(DbConnector.AGE_COLUMN_NAME));
    }
}
