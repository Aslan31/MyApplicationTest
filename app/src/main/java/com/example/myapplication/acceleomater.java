package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.widget.TextView;

public class acceleomater extends AppCompatActivity implements SensorEventListener {

    TextView x_axel;
    TextView y_axel;
    TextView z_axel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceleomater);
        x_axel = (TextView) findViewById(R.id.textView);
        y_axel = (TextView) findViewById(R.id.textView2);
        z_axel = (TextView) findViewById(R.id.textView3);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        float x_degree = Math.round(event.values[0]);
        float y_degree = Math.round(event.values[1]);
        float z_degree = Math.round(event.values[2]);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                x_axel.setText("Heading: " + Html.fromHtml(String.valueOf(x_degree)) + " degrees");
                y_axel.setText("Heading: " + Float.toString(y_degree) + " degrees");
                z_axel.setText("Heading: " + Float.toString(z_degree) + " degrees");
                new Handler().postDelayed(this, 3000);
            }
        }, 3000);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}