package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View v) {
        Intent intent = new Intent(this, compass.class);
        startActivity(intent);

    }
    public void onClick2(View v) {
        Intent intent = new Intent(this, acceleomater_3.class);
        startActivity(intent);

    }

}