package du.iic.exampleapp;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

public class SensorActivity extends AppCompatActivity {

    public static final String TAG = "SENSOR";

    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        layout = (RelativeLayout) findViewById(R.id.activity_sensor);

        SensorManager sensMan = (SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor accelSensor = sensMan.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
//                Log.d(TAG, "onSensorChanged: ax" + event.values[0]);
//                Log.d(TAG, "onSensorChanged: ay" + event.values[1]);
//                Log.d(TAG, "onSensorChanged: az" + event.values[2]);

                int background = Color.rgb(
                        accelToColor(event.values[0]),
                        accelToColor(event.values[1]),
                        accelToColor(event.values[2])
                );
                layout.setBackgroundColor(background);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        sensMan.registerListener(sensorEventListener,
                accelSensor,
                100 * 1000);

    }

    int accelToColor (float accel) {
        return (int) (((accel + 12) / 24) * 255);
    }
}
