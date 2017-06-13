package top.yunp.baiduloc;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

import top.yunp.baiduloc.service.LocationService;

/**
 * Created by plter on 6/13/17.
 */

public class BaiduLocApp extends Application {

    private LocationService locationService;

    @Override
    public void onCreate() {
        super.onCreate();

        locationService = new LocationService(getApplicationContext());
        SDKInitializer.initialize(getApplicationContext());
    }

    public LocationService getLocationService() {
        return locationService;
    }
}
