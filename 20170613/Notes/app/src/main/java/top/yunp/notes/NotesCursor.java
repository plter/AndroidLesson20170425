package top.yunp.notes;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteQuery;

/**
 * Created by plter on 6/13/17.
 */

public class NotesCursor extends SQLiteCursor {
    public NotesCursor(SQLiteCursorDriver driver, String editTable, SQLiteQuery query) {
        super(driver, editTable, query);
    }

    public int getId() {
        return getInt(getColumnIndex(DbConnector.ID_COLUMN_NAME));
    }

    public String getTitle() {
        return getString(getColumnIndex(DbConnector.TITLE_COLUMN_NAME));
    }

    public String getContent() {
        return getString(getColumnIndex(DbConnector.CONTENT_COLUMN_NAME));
    }
}
