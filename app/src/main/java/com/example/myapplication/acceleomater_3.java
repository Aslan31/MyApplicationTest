package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.widget.TextView;

public class acceleomater_3 extends AppCompatActivity implements SensorEventListener {

    TextView x_axel;
    TextView y_axel;
    TextView z_axel;
   // private SensorManager SensorManage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceleomater_3);
        x_axel = (TextView) findViewById(R.id.textView6);
        y_axel = (TextView) findViewById(R.id.textView5);
        z_axel = (TextView) findViewById(R.id.textView4);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        float x_degree = Math.round(event.values[0]);
        float y_degree = Math.round(event.values[1]);
        float z_degree = Math.round(event.values[2]);
        //SensorManage = (SensorManager) getSystemService(SENSOR_SERVICE);




        x_axel.setText("Heading: " + Html.fromHtml(String.valueOf(x_degree)) + " degrees");
        y_axel.setText("Heading: " + Float.toString(y_degree) + " degrees");
        z_axel.setText("Heading: " + Float.toString(z_degree) + " degrees");




    }
    @Override
    protected void onPause() {
        super.onPause();

        // to stop the listener and save battery
       // SensorManage.unregisterListener(this);
    }
    @Override
    protected void onResume() {
        super.onResume();

        // code for system's orientation sensor registered listeners
      //  SensorManage.registerListener(this, SensorManage.getDefaultSensor(Sensor.TYPE_ORIENTATION),
        //        SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}