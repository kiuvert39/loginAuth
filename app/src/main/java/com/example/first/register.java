package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View v) {
        try {
            EditText name = findViewById(R.id.name);
            EditText registerEmail = findViewById(R.id.email);
            EditText registerPassword = findViewById(R.id.password);
            String setName = name.getText().toString();
            String setRegisterEmail = registerEmail.getText().toString();
            String setRegisterPassword = registerPassword.getText().toString();
            Log.d("registered name", setName);
            Log.d("registered email", setRegisterEmail);
            Log.d("registered password", setRegisterPassword);
        }
        catch (Exception e){
            
        }


    }

    public void loginScreen(View view) {
        try{
            Intent nextScreen = new Intent(register.this,MainActivity.class);
            startActivities(new Intent[]{nextScreen});

        }
        catch (Exception e){

        }
    }

}