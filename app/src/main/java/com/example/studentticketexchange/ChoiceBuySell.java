package com.example.studentticketexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiceBuySell extends AppCompatActivity implements View.OnClickListener{

    Button buyButton, sellButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_buy_sell);

        buyButton = findViewById(R.id.button_choice_buy);
        sellButton = findViewById(R.id.button_choice_sell);

        buyButton.setOnClickListener(this);
        sellButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == buyButton){
            startActivity(new Intent(ChoiceBuySell.this, Schedule.class));
        } else if(view == sellButton){

        }
    }
}
