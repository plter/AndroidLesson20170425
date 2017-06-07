package top.yunp.addusers;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView userList;
    private UserListAdapter adapter;
    private DbConnector dbConnector;

    public static final int REQUEST_CODE_ADD_USER = 2;
    private SQLiteDatabase readableDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, EditUserActivity.class), REQUEST_CODE_ADD_USER);
            }
        });

        userList = (RecyclerView) findViewById(R.id.userList);
        userList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new UserListAdapter(null, this);
        userList.setAdapter(adapter);

        connectDb();
        readFromDb();
    }


    private void connectDb() {
        dbConnector = new DbConnector(this);
        readableDatabase = dbConnector.getReadableDatabase();
    }


    private void readFromDb() {
        UserCursor userCursor = (UserCursor) readableDatabase.query("user", null, null, null, null, null, null);
        adapter.setCursor(userCursor);
    }


    @Override
    protected void onDestroy() {
        readableDatabase.close();
        dbConnector.close();
        super.onDestroy();
    }

    private void insertUserToDb(String name, int age) {
        dbConnector.insertUser(name, age);

        readFromDb();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_ADD_USER:
                switch (resultCode) {
                    case EditUserActivity.RESULT_SAVE:
                        insertUserToDb(
                                data.getStringExtra(EditUserActivity.KEY_USER_NAME),
                                data.getIntExtra(EditUserActivity.KEY_USER_AGE, 0)
                        );
                        break;
                    case EditUserActivity.RESULT_CLOSE:
                        Toast.makeText(this, "没有可保存的数据", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
