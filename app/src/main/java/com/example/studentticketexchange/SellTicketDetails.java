package com.example.studentticketexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class SellTicketDetails extends AppCompatActivity implements
        TextView.OnEditorActionListener,
        RadioButton.OnCheckedChangeListener,
        View.OnClickListener {

    Button buttonSellDone;
    EditText editTextSellRow, editTextSellQuantity, editTextSellSection;
    Switch switchSellStudentTicket, switchSellValidated, switchSellNegotiable;
    RadioButton radioButtonSellFootball, radioButtonSellHockey, radioButtonSellBasketball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_ticket_details);

        //Implement listeners
        editTextSellQuantity = findViewById(R.id.editTextSellQuantity);
        editTextSellRow = findViewById(R.id.editTextSellRow);
        editTextSellSection = findViewById(R.id.editTextSellSection);
        switchSellStudentTicket = findViewById(R.id.switchSellStudentTicket);
        switchSellValidated = findViewById(R.id.switchSellValidated);
        switchSellNegotiable = findViewById(R.id.switchSellNegotiable);
        radioButtonSellFootball = findViewById(R.id.radioSellButtonFootball);
        radioButtonSellBasketball = findViewById(R.id.radioSellButtonBasketball);
        radioButtonSellHockey = findViewById(R.id.radioSellButtonHockey);
        buttonSellDone = findViewById(R.id.buttonSellDone);

        //Activate listeners
        buttonSellDone.setOnClickListener(this);
        editTextSellQuantity.setOnEditorActionListener(this);
        editTextSellRow.setOnEditorActionListener(this);
        editTextSellSection.setOnEditorActionListener(this);
        radioButtonSellHockey.setOnCheckedChangeListener(this);
        radioButtonSellBasketball.setOnCheckedChangeListener(this);
        radioButtonSellFootball.setOnCheckedChangeListener(this);

    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }

    @Override
    public void onClick(View view) {

    }
}
