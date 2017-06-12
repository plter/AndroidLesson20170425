package top.yunp.addusers.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by plter on 6/12/17.
 */

public class UserDataProvider extends ContentProvider {

    private DbConnector dbConnector;

    @Override
    public boolean onCreate() {
        dbConnector = new DbConnector(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return dbConnector.getReadableDatabase().query(DbConnector.TABLE_NAME_USER, projection, selection, selectionArgs, null, null, sortOrder, null);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        dbConnector.getWritableDatabase().insert(DbConnector.TABLE_NAME_USER, null, values);
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return dbConnector.getWritableDatabase().delete(DbConnector.TABLE_NAME_USER, selection, selectionArgs);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return dbConnector.getWritableDatabase().update(DbConnector.TABLE_NAME_USER, values, selection, selectionArgs);
    }
}
