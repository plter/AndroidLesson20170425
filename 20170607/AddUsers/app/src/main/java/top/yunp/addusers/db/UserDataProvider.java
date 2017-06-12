package top.yunp.addusers.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by plter on 6/12/17.
 */

public class UserDataProvider extends ContentProvider {

    public static final String PATH_USER = "user";
    public static final String PATH_GROUP = "group";
    public static final int MATCH_RESULT_CODE_USERS = 1;
    public static final int MATCH_RESULT_CODE_USER = 3;
    public static final int MATCH_RESULT_CODE_GROUPS = 2;

    public static final String AUTHORITIES = "top.yunp.addusers.provider.UserDataProvider";
    private DbConnector dbConnector;
    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(AUTHORITIES, PATH_USER, MATCH_RESULT_CODE_USERS);
        uriMatcher.addURI(AUTHORITIES, PATH_GROUP, MATCH_RESULT_CODE_GROUPS);
        uriMatcher.addURI(AUTHORITIES, PATH_USER + "/#", MATCH_RESULT_CODE_USER);
    }

    @Override
    public boolean onCreate() {
        dbConnector = new DbConnector(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (uriMatcher.match(uri)) {
            case MATCH_RESULT_CODE_USERS:
                return dbConnector.getReadableDatabase().query(DbConnector.TABLE_NAME_USER, projection, selection, selectionArgs, null, null, sortOrder, null);
            case MATCH_RESULT_CODE_GROUPS:
                return dbConnector.getReadableDatabase().query(DbConnector.TABLE_NAME_GROUP, projection, selection, selectionArgs, null, null, sortOrder, null);
            case MATCH_RESULT_CODE_USER:
                return dbConnector.getReadableDatabase().query(DbConnector.TABLE_NAME_USER, projection, DbConnector.COLUMN_NAME_ID + "=?", new String[]{uri.getLastPathSegment()}, null, null, sortOrder, null);
            default:
                return null;
        }
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
