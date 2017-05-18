package com.plter.startservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection, MyService.OnCountChangeListener {

    private Intent myServiceIntent;
    private MyService.MyBinder binder;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = (TextView) findViewById(R.id.outputText);

        myServiceIntent = new Intent(this, MyService.class);

        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnSetServiceCountTo100).setOnClickListener(this);
        findViewById(R.id.btnBindService).setOnClickListener(this);
        findViewById(R.id.btnUnbindService).setOnClickListener(this);
        findViewById(R.id.btnSetCountTo100ViaBinder).setOnClickListener(this);
        findViewById(R.id.btnGetCountFromServiceViaBinder).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartService:
                startService(myServiceIntent);
                break;
            case R.id.btnStopService:
                stopService(myServiceIntent);
                break;
            case R.id.btnSetServiceCountTo100:
                Intent intent = new Intent(this, MyService.class);
                intent.putExtra("count", 100);
                startService(intent);
                break;
            case R.id.btnBindService:
                bindService(myServiceIntent, this, BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindService:
                binder = null;
                unbindService(this);
                break;
            case R.id.btnSetCountTo100ViaBinder:
                if (binder != null) {
                    binder.setCount(100);
                }
                break;
            case R.id.btnGetCountFromServiceViaBinder:
                if (binder != null) {
                    Toast.makeText(this, "" + binder.getCount(), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        binder = (MyService.MyBinder) service;
        binder.setOnCountChangeListener(this);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    @Override
    public void onChange(int count) {

//        final int c = count;
//
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                outputText.setText("Count " + c);
//            }
//        });

        Message message = new Message();
        message.arg1 = count;
        handler.sendMessage(message);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            outputText.setText("Count " + msg.arg1);
            super.handleMessage(msg);
        }
    };
}
