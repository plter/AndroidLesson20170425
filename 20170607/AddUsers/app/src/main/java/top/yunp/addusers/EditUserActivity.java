package top.yunp.addusers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditUserActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameInput, ageInput;

    public static final int RESULT_CLOSE = 2;
    public static final int RESULT_SAVE = 3;

    public static final String KEY_USER_NAME = "name";
    public static final String KEY_USER_AGE = "age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        nameInput = (EditText) findViewById(R.id.nameInput);
        ageInput = (EditText) findViewById(R.id.ageInput);

        findViewById(R.id.btnClose).setOnClickListener(this);
        findViewById(R.id.btnSave).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                Intent data = new Intent();
                data.putExtra(KEY_USER_NAME, nameInput.getText().toString());
                data.putExtra(KEY_USER_AGE, Integer.parseInt(ageInput.getText().toString()));
                setResult(RESULT_SAVE, data);
                finish();
                break;
            case R.id.btnClose:
                setResultToCloseState();
                finish();
                break;
        }
    }

    private void setResultToCloseState() {
        setResult(RESULT_CLOSE);
    }

    @Override
    public void onBackPressed() {
        setResultToCloseState();
        super.onBackPressed();
    }
}
