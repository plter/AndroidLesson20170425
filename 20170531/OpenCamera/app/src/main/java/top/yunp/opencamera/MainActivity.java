package top.yunp.opencamera;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private CameraManager cameraManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (VERSION.SDK_INT >= 23) {
//            System.out.println(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED);
//        }

        openCamera();
    }


    public void openCamera() {
        cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        try {
            String[] idList = cameraManager.getCameraIdList();
            String firstCameraId = idList[0];

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("提醒")
                        .setMessage("您还没有授权该应用使用摄像机，是否现在授权？")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                requestCameraPermission();
                            }
                        }).setNegativeButton("否", null)
                        .show();
                return;
            }
            cameraManager.openCamera(firstCameraId, openCameraStateCallback, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }


    private void requestCameraPermission() {
        //TODO request camera permisson
    }

    private final CameraDevice.StateCallback openCameraStateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(@NonNull CameraDevice camera) {

        }

        @Override
        public void onDisconnected(@NonNull CameraDevice camera) {

        }

        @Override
        public void onError(@NonNull CameraDevice camera, int error) {

        }
    };
}
