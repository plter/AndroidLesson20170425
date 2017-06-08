package top.yunp.addusers.db;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteQuery;

import top.yunp.addusers.db.DbConnector;

/**
 * Created by plter on 6/7/17.
 */

public class DbCursor extends SQLiteCursor {
    public DbCursor(SQLiteCursorDriver driver, String editTable, SQLiteQuery query) {
        super(driver, editTable, query);
    }

    public int getId() {
        return getInt(getColumnIndex(DbConnector.COLUMN_NAME_ID));
    }

    public String getName() {
        return getString(getColumnIndex(DbConnector.COLUMN_NAME_NAME));
    }

    public int getAge() {
        return getInt(getColumnIndex(DbConnector.COLUMN_NAME_AGE));
    }
}
