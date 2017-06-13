package top.yunp.notes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

/**
 * Created by plter on 6/13/17.
 */
public class DbConnector extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "notes";
    public static final String ID_COLUMN_NAME = "_id";
    public static final String TITLE_COLUMN_NAME = "title";
    public static final String CONTENT_COLUMN_NAME = "content";
    private final SQLiteDatabase readableDatabase;
    private final SQLiteDatabase writableDatabase;

    public DbConnector(Context context) {
        super(context, "notes.db", new SQLiteDatabase.CursorFactory() {
            @Override
            public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String editTable, SQLiteQuery query) {
                return new NotesCursor(masterQuery, editTable, query);
            }
        }, 1);

        readableDatabase = getReadableDatabase();
        writableDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                ID_COLUMN_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TITLE_COLUMN_NAME + " TEXT NOT NULL DEFAULT NONE," +
                CONTENT_COLUMN_NAME + " TEXT NOT NULL DEFAULT NONE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public NotesCursor queryNotes() {
        return (NotesCursor) readableDatabase.query(TABLE_NAME, null, null, null, null, null, null, null);
    }

    public void insertNote(String title, String content) {
        ContentValues values = new ContentValues();
        values.put(TITLE_COLUMN_NAME, title);
        values.put(CONTENT_COLUMN_NAME, content);
        writableDatabase.insert(TABLE_NAME, null, values);
    }

    public void updateNote(int id, String title, String content) {
        ContentValues values = new ContentValues();
        values.put(TITLE_COLUMN_NAME, title);
        values.put(CONTENT_COLUMN_NAME, content);
        writableDatabase.update(TABLE_NAME, values, ID_COLUMN_NAME + "=?", new String[]{String.valueOf(id)});
    }

    public void close() {
        writableDatabase.close();
    }
}
