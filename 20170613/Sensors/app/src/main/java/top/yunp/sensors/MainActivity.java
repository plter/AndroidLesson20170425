package top.yunp.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {


    private TextView outputTextView;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputTextView = (TextView) findViewById(R.id.outputTv);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
//        for (Sensor s : sensorList) {
//            println("Name:" + s.getName() + ",Type:" + s.getType());
//        }


        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void println(String msg) {
        outputTextView.append(msg + "\n");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        outputTextView.setText("xa=" + event.values[0] + ",ya=" + event.values[1] + ",za=" + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onDestroy() {
        sensorManager.unregisterListener(this);
        super.onDestroy();
    }
}
