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

    Button buttonDone;
    EditText editTextRow, editTextQuantity, editTextSection;
    Switch switchStudentTicket, switchValidated, switchNegotiable;
    RadioButton radioButtonFootball, radioButtonHockey, radioButtonBasketball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_ticket_details);

        //Implement listeners
        editTextQuantity = findViewById(R.id.editTextQuantity);
        editTextRow = findViewById(R.id.editTextRow);
        editTextSection = findViewById(R.id.editTextSection);
        switchStudentTicket = findViewById(R.id.switchStudentTicket);
        switchValidated = findViewById(R.id.switchValidated);
        switchNegotiable = findViewById(R.id.switchNegotiable);
        radioButtonFootball = findViewById(R.id.radioButtonFootball);
        radioButtonBasketball = findViewById(R.id.radioButtonBasketball);
        radioButtonHockey = findViewById(R.id.radioButtonHockey);
        buttonDone = findViewById(R.id.buttonDone);

        //Activate listeners
        buttonDone.setOnClickListener(this);
        editTextQuantity.setOnEditorActionListener(this);
        editTextRow.setOnEditorActionListener(this);
        editTextSection.setOnEditorActionListener(this);
        radioButtonHockey.setOnCheckedChangeListener(this);
        radioButtonBasketball.setOnCheckedChangeListener(this);
        radioButtonFootball.setOnCheckedChangeListener(this);

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
