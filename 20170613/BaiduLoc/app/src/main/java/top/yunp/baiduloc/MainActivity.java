package top.yunp.baiduloc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

import top.yunp.baiduloc.service.LocationService;
import top.yunp.baiduloc1.R;

public class MainActivity extends AppCompatActivity implements BDLocationListener {

    private LocationService locationService;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputTextView = (TextView) findViewById(R.id.outputTextView);

        locationService = ((BaiduLocApp) getApplication()).getLocationService();
        locationService.registerListener(this);
        locationService.start();
    }

    @Override
    public void onReceiveLocation(final BDLocation bdLocation) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                outputTextView.setText(bdLocation.getCity());
            }
        });
    }

    @Override
    public void onConnectHotSpotMessage(String s, int i) {

    }

    @Override
    protected void onDestroy() {
        locationService.stop();
        locationService.unregisterListener(this);
        super.onDestroy();
    }
}
