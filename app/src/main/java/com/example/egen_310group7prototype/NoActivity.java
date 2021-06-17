package com.example.egen_310group7prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no2);
        Button returnButton = findViewById(R.id.returnHomeButton);
        returnButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //finish();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}