package top.yunp.colorchannel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import top.yunp.colorchannel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        int[] channel = getChannel(0xffff0000);

        for (int c : channel) {
            System.out.println(c);
        }

        binding.btnGetChannel.setOnClickListener(this);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    private native int[] getChannel(int color);

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(binding.colorInput.getText())) {
            Toast.makeText(this, "输入文本不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        long value = Long.parseLong(binding.colorInput.getText().toString(), 16);
        int intValue = (int) value;
        int[] channel = getChannel(intValue);

        binding.channelOutput.setText("Alpha:" + channel[0] + "\n" +
                "Red:" + channel[1] + "\n" +
                "Green:" + channel[2] + "\n" +
                "Blue:" + channel[3]);
    }
}
