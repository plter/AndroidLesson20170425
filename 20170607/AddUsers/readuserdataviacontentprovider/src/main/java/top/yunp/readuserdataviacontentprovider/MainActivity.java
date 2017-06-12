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
                Uri.parse("content://top.yunp.addusers.provider.UserDataProvider"),
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            System.out.printf("_id=%d,name=%s,age=%d\n", cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
        }
    }
}
