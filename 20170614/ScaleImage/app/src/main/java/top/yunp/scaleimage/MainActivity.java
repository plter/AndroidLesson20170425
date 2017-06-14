package top.yunp.scaleimage;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import top.yunp.scaleimage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    ActivityMainBinding binding;
    float lastDistance = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.getRoot().setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastDistance = -1;
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getPointerCount() >= 2) {
                    float x1 = event.getX(0);
                    float y1 = event.getY(0);
                    float x2 = event.getX(1);
                    float y2 = event.getY(1);

                    float distanceX = x1 - x2;
                    float distanceY = y1 - y2;
                    float distance = (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);

                    if (lastDistance != -1) {

                        if (distance - lastDistance > 5) {
                            System.out.println("放大");
                            lastDistance = distance;
                        } else if (distance - lastDistance < -5) {
                            System.out.println("缩小");
                            lastDistance = distance;
                        }

                    } else {
                        lastDistance = distance;
                    }
                }
                break;
        }

        return true;
    }
}
