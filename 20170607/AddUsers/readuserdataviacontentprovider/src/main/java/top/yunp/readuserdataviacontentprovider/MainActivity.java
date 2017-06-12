package top.yunp.readuserdataviacontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor cursor = getContentResolver().query(
                Uri.parse("content://top.yunp.addusers.provider.UserDataProvider/user"),
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                String columnName = cursor.getColumnName(i);
                Object value = null;
                switch (cursor.getType(i)) {
                    case Cursor.FIELD_TYPE_INTEGER:
                        value = cursor.getInt(i);
                        break;
                    case Cursor.FIELD_TYPE_STRING:
                        value = cursor.getString(i);
                        break;
                }
                System.out.print(columnName + "=" + value + ",");
            }
            System.out.println();
        }
    }
}
