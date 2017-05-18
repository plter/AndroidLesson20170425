package com.plter.bindserviceinanotherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnBindRemoteService).setOnClickListener(this);
        findViewById(R.id.btnUnbindRemoteService).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBindRemoteService:
                //TODO implement bind remote service
                break;
        }
    }
}
