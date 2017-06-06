package top.yunp.userlist;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.yunp.userlist.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Controller controller;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        controller = new Controller(binding);
        binding.setController(controller);
    }
}
