package com.example.savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int counter ;
    String keyforgetsher = "key";
    TextView mytextview;
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mybutoon = findViewById(R.id.mybutton);
        settings = getApplicationContext().getSharedPreferences(keyforgetsher, 0);
        counter = settings.getInt("homeScore", 0);
        mybutoon.setOnClickListener(this);
        mytextview = findViewById(R.id.mytext);
        mytextview.setText(String.valueOf(counter));

    }

    @Override
    public void onClick(View v) {
        counter ++;
        mytextview.setText(String.valueOf(counter));


    }

    @Override
    protected void onStop() {
        super.onStop();
        settings = getApplicationContext().getSharedPreferences(keyforgetsher, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("homeScore", counter);
        editor.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
