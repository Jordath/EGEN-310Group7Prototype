package com.example.egen_310group7prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    boolean deviceWorking;
    int batteryLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        batteryLevel = 77;
        deviceWorking = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button contactUpdateButton = findViewById(R.id.updateContactButton);
        contactUpdateButton.setOnClickListener(this);
        Button panicButton = findViewById(R.id.triggerPanicModeButton);
        panicButton.setOnClickListener(this);
        if(!deviceWorking){
            TextView batteryLowStatement = (TextView) findViewById(R.id.textView5);
            batteryLowStatement.setText("Uh oh...");
            TextView pleaseChargeBattery = (TextView) findViewById(R.id.textView6);
            pleaseChargeBattery.setText("Your device is experiencing some issues. Try to reconnect it to your phone.");
        }
        else if(batteryLevel < 15){
            TextView batteryLowStatement = (TextView) findViewById(R.id.textView5);
            batteryLowStatement.setText("Battery level low!");
            TextView pleaseChargeBattery = (TextView) findViewById(R.id.textView6);
            pleaseChargeBattery.setText("Please replace/charge your battery before climbing.");

        }
        if (batteryLevel != 0){
            TextView batteryLowStatement = (TextView) findViewById(R.id.batteryLevelText);
            Integer batLevel = (Integer) batteryLevel;
            batteryLowStatement.setText(batLevel.toString() + "%");
        }


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.updateContactButton){
            //Toast.makeText(this, "You selected update contact", Toast.LENGTH_LONG).show();
            startYesActivity();
        }
        if(view.getId() == R.id.triggerPanicModeButton){
            //Toast.makeText(this, "Start New Activity", Toast.LENGTH_LONG).show();
            startPanicActivity();

        }

    }
    public void startYesActivity(){
        Intent emergencyUpdateContactActivity = new Intent(this, EmergencyContactUpdate.class);
        startActivity(emergencyUpdateContactActivity);

    }
    public void startPanicActivity(){
        Intent panicActivity = new Intent(this, PanicActivityReal.class);
        startActivity(panicActivity);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}