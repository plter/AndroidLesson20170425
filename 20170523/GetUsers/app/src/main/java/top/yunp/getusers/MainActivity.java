package top.yunp.getusers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import top.yunp.getusers.models.User;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private RequestQueue requestQueue;
    private UserListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);
        adapter = new UserListAdapter(this);
        lv.setAdapter(adapter);

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(new JsonArrayRequest("http://10.0.2.2:8080/users", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        adapter.add(new User(response.getJSONObject(i)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "加载网络数据失败", Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
