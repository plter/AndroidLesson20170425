package top.yunp.autocount;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import top.yunp.autocount.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final CountWrapper countWrapper = new CountWrapper();
        dataBinding.setCountWrapper(countWrapper);

        new Thread() {
            @Override
            public void run() {
                super.run();

                while (countWrapper.getCount() < 100) {
                    try {
                        sleep(1000);
                        countWrapper.setCount(countWrapper.getCount() + 1);
//                        dataBinding.setCountWrapper(countWrapper);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}
