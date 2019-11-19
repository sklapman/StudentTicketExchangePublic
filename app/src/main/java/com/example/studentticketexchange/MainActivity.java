//Initial Login Screen
//Slide 1 in App Powerpoint


package com.example.studentticketexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.button_main_login);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == loginButton) {
            //temporarily skip the Kerberos login and go straight to buy/sell
            startActivity(new Intent(MainActivity.this, ChoiceBuySell.class));
        }
    }
}
