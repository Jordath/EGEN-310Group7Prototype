package com.example.egen_310group7prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class EmergencyContactUpdate extends AppCompatActivity implements View.OnClickListener {
    String name, phoneNumber;
    EditText nameInput;
    EditText phoneNumberInput;
    EditText removeContactText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contact_update);
        Button returnHome = findViewById(R.id.returnHomeContactButton);
        returnHome.setOnClickListener(this);
        Button addContactButton = findViewById(R.id.addContactButton);
        addContactButton.setOnClickListener(this);
        Button removeContactButton = findViewById(R.id.removeContactButton);
        removeContactButton.setOnClickListener(this);

        nameInput = (EditText) findViewById(R.id.editTextTextPersonName);
        phoneNumberInput = (EditText) findViewById(R.id.editTextPhone);
        removeContactText = (EditText) findViewById(R.id.removeContactText);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.returnHomeContactButton){
            startReturnHomeActivity();
        }
        if(v.getId() == R.id.addContactButton){
            startAddContactToDatabaseActivity();
        }
        if(v.getId() == R.id.removeContactButton){
            startRemoveContactFromDatabaseActivity();
        }
    }

    private void startRemoveContactFromDatabaseActivity() {
        name = removeContactText.getText().toString();
        phoneNumber = phoneNumberInput.getText().toString();
        Toast.makeText(this, "Successfully removed " + name +
                " from your emergency contacts!", Toast.LENGTH_LONG).show();
    }

    private void startAddContactToDatabaseActivity() {
        Map<String, String> contactList = new HashMap<String, String>();
        name = nameInput.getText().toString();
        phoneNumber = phoneNumberInput.getText().toString();
        Toast.makeText(this, "Successfully added " + name + " to your emergency contacts under "
                + phoneNumber + "!", Toast.LENGTH_LONG).show();
        contactList.put(name, phoneNumber);
        for(Map.Entry<String,String> entry : contactList.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private void startReturnHomeActivity() {
        Intent returnHomeActivity = new Intent(this, MainActivity.class);
        startActivity(returnHomeActivity);
    }
}