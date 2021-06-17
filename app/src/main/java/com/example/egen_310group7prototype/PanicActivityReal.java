package com.example.egen_310group7prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PanicActivityReal extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic_real);
        Button yesButton = findViewById(R.id.yesButton);
        yesButton.setOnClickListener(this);
        Button noButton = findViewById(R.id.noButton);
        noButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.yesButton){
            //Toast.makeText(this, "You selected yes", Toast.LENGTH_LONG).show();
            startYesActivity();
        }
        if(view.getId() == R.id.noButton){
            //Toast.makeText(this, "Start New Activity", Toast.LENGTH_LONG).show();
            startNoActivity();

        }

    }
    public void startYesActivity(){
        Intent yesActivity = new Intent(this, YesActivityReal.class);
        startActivity(yesActivity);

    }
    public void startNoActivity(){
        Intent noActivity = new Intent(this, NoActivity.class);
        startActivity(noActivity);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}