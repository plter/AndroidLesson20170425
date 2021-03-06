package top.yunp.startactivitywithpermission;

import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.yunp.startactivitywithpermission.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPresenter(new Presenter());


        System.out.println(checkSelfPermission("top.yunp.anotheractivity.permission.StartBActivity") == PackageManager.PERMISSION_GRANTED);
    }
}
