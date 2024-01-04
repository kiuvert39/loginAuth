package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    SQLitedb DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }



    public void loginScreen(View view) {
        try{
            Intent nextScreen = new Intent(register.this,MainActivity.class);
            startActivities(new Intent[]{nextScreen});

        }
        catch (Exception e){

        }
    }

    public void signUp(View view) {
        try {
            EditText name = findViewById(R.id.name);
            EditText registerPassword = findViewById(R.id.password);
            EditText confirmPassWord = findViewById(R.id.repassword);
            String setName = name.getText().toString();
            String setRegisterPassword = registerPassword.getText().toString();
            if(setName.equals("")||setRegisterPassword.equals(""))
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                if (setRegisterPassword.equals(confirmPassWord)) {
                    Boolean checkUser = DB.checkName(setName );
                    if(checkUser == false){
                        Boolean insert = DB.insertData(setName, setRegisterPassword  );
                        if(insert==true) {
                            Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                }
            }
        }
        catch (Exception e){

        }

    }
}