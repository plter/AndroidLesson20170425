package com.plter.startservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent myServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myServiceIntent = new Intent(this, MyService.class);

        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnSetServiceCountTo100).setOnClickListener(this);
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
        }
    }
}
