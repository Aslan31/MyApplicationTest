package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class acceleomater_3 extends AppCompatActivity implements SensorEventListener {

    TextView x_axel;
    TextView y_axel;
    TextView z_axel;
    private boolean color = false;
    private View view;
    private SensorManager SensorManage;
    private long lastUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_acceleomater_3);
        x_axel = (TextView) findViewById(R.id.textView6);
        y_axel = (TextView) findViewById(R.id.textView5);
        z_axel = (TextView) findViewById(R.id.textView4);
        SensorManage = (SensorManager) getSystemService(SENSOR_SERVICE);


        lastUpdate = System.currentTimeMillis();

        setContentView(R.layout.activity_acceleomater_3);
        view = findViewById(R.id.textView);
        view.setBackgroundColor(Color.GREEN);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        float x_degree = Math.round(event.values[0]);
        float y_degree = Math.round(event.values[1]);
        float z_degree = Math.round(event.values[2]);


        x_axel.setText("Heading: " + Html.fromHtml(String.valueOf(x_degree)) + " degrees");
        y_axel.setText("Heading: " + Float.toString(y_degree) + " degrees");
        z_axel.setText("Heading: " + Float.toString(z_degree) + " degrees");
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {


            float accelationSquareRoot = (x * x + y * y + z * z)
                    / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
            long actualTime = event.timestamp;
            if (accelationSquareRoot >= 2) //
            {
                if (actualTime - lastUpdate < 200) {
                    return;
                }
                lastUpdate = actualTime;

                Toast.makeText(this, "Device was shuffed", Toast.LENGTH_SHORT)
                        .show();
                if (color) {
                    view.setBackgroundColor(Color.GREEN);
                } else {
                    view.setBackgroundColor(Color.RED);
                }
                color = !color;


            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();

        // to stop the listener and save battery
        SensorManage.unregisterListener(this);
    }
    @Override
    protected void onResume() {
        super.onResume();

        // code for system's orientation sensor registered listeners
        SensorManage.registerListener(this, SensorManage.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}