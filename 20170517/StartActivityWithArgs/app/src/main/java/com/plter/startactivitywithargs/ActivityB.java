package com.plter.startactivitywithargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    private TextView tv;
    private EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        inputText = (EditText) findViewById(R.id.editText);

        tv = (TextView) findViewById(R.id.textView);

        CharSequence data = getIntent().getCharSequenceExtra("data");
        tv.setText(data);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("result", inputText.getText());
        setResult(0, intent);

        super.onBackPressed();
    }
}
