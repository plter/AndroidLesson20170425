package com.plter.anotherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, MyService.class);

        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnStartService).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartService:
                startService(intent);
                break;
            case R.id.btnStopService:
                stopService(intent);
                break;
        }
    }
}
