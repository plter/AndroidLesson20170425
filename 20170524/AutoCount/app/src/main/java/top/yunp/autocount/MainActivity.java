package top.yunp.autocount;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.yunp.autocount.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new Presenter((ActivityMainBinding) DataBindingUtil.setContentView(this,R.layout.activity_main));
    }
}
