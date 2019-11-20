package com.example.studentticketexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tempmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemChat) {
            Intent searchIntent = new Intent(this, Chat.class);
            startActivity(searchIntent);
        }

        if (item.getItemId() == R.id.itemAllTicketsForGame) {
            Intent searchIntent = new Intent(this, AllTicketsForGame.class);
            startActivity(searchIntent);
        }

        if (item.getItemId() == R.id.itemTempBuyTixDetails) {
            Intent searchIntent = new Intent(this, BuyTicketDetails.class);
            startActivity(searchIntent);
        }

        if (item.getItemId() == R.id.itemChoiceBuySell) {
            Intent searchIntent = new Intent(this, ChoiceBuySell.class);
            startActivity(searchIntent);
        }

        if (item.getItemId() == R.id.itemInbox) {
            Intent searchIntent = new Intent(this, Inbox.class);
            startActivity(searchIntent);
        }

        if (item.getItemId() == R.id.itemMainOpen) {
            Intent searchIntent = new Intent(this, MainActivity.class);
            startActivity(searchIntent);
        }

        if (item.getItemId() == R.id.itemProfile) {
            Intent searchIntent = new Intent(this, Profile.class);
            startActivity(searchIntent);
        }

        if (item.getItemId() == R.id.itemSchedule) {
            Intent searchIntent = new Intent(this, Schedule.class);
            startActivity(searchIntent);
        }

        if (item.getItemId() == R.id.itemSell) {
            Intent searchIntent = new Intent(this, SellFragment.class);
            startActivity(searchIntent);
        }

        return super.onOptionsItemSelected(item);

    }
}
