package com.example.first;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private retrofitInterface RetrofitInterface;
    private String Base_Url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitInterface = retrofit.create(retrofitInterface.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View v) {
        try {
            Button b = (Button) v;
            handleLogin();
        }
        catch(Exception e){
        }
    }
    public void nextScreen(View v) {
        try{
            Intent nextScreen = new Intent(MainActivity.this,register.class);
            startActivities(new Intent[]{nextScreen});
        }
        catch (Exception e){
        }
    }
    private void handleLogin() {
        View view = getLayoutInflater().inflate(R.layout.activity_main, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view).show();
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        String setEmail = email.getText().toString(); //getting the input from the client
        String setPassword = password.getText().toString();
        Button login = findViewById(R.id.login);
        login.setOnClickListener( new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                HashMap<String, String> map = new HashMap<>();
                map.put("email", setEmail);
                map.put("password", setPassword);

            }
        });
    }
}