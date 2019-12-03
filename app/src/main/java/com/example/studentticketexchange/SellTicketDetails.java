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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SellTicketDetails extends AppCompatActivity implements
        TextView.OnEditorActionListener,
        RadioButton.OnCheckedChangeListener,
        View.OnClickListener,
        BottomNavigationView.OnNavigationItemSelectedListener,
        AdapterView.OnItemSelectedListener {

    RadioButton radioSellButtonFootball, radioSellButtonBasketball, radioSellButtonHockey;
    EditText editTextSellRow, editTextSellSection, editTextSellPrice;
    Spinner spinnerSellQuantity, spinnerSellGame, spinnerSellStudentTicket, spinnerSellValidated, spinnerSellNegotiable;
    Button buttonSellDone, buttonSellBack;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_ticket_details);

        //Implement listeners
        radioSellButtonFootball = findViewById(R.id.radioSellButtonFootball);
        radioSellButtonBasketball = findViewById(R.id.radioSellButtonBasketball);
        radioSellButtonHockey = findViewById(R.id.radioSellButtonHockey);
        editTextSellRow = findViewById(R.id.editTextSellFootballRow);
        editTextSellSection = findViewById(R.id.editTextSellFootballSection);
        editTextSellPrice = findViewById(R.id.editTextSellFootballPrice);
        buttonSellDone = findViewById(R.id.buttonSellDone);
        buttonSellBack = findViewById(R.id.buttonSellBack);
        spinnerSellQuantity = findViewById(R.id.spinnerSellFootballQuantity);
        spinnerSellGame = findViewById(R.id.spinnerSellFootballGame);
        spinnerSellStudentTicket = findViewById(R.id.spinnerSellFootballStudentTicket);
        spinnerSellValidated = findViewById(R.id.spinnerSellFootballValidated);
        spinnerSellNegotiable = findViewById(R.id.spinnerSellFootballNegotiable);

        //Activate listeners
        buttonSellDone.setOnClickListener(this);
        buttonSellBack.setOnClickListener(this);
        editTextSellRow.setOnEditorActionListener(this);
        editTextSellSection.setOnEditorActionListener(this);
        editTextSellPrice.setOnEditorActionListener(this);
        radioSellButtonFootball.setOnCheckedChangeListener(this);
        radioSellButtonBasketball.setOnCheckedChangeListener(this);
        radioSellButtonHockey.setOnCheckedChangeListener(this);
        spinnerSellQuantity.setOnItemSelectedListener(this);
        spinnerSellGame.setOnItemSelectedListener(this);
        spinnerSellStudentTicket.setOnItemSelectedListener(this);
        spinnerSellValidated.setOnItemSelectedListener(this);
        spinnerSellNegotiable.setOnItemSelectedListener(this);

        mMainNav = (BottomNavigationView) findViewById(R.id.id_Navbar);
        mMainFrame = (FrameLayout) findViewById(R.id.id_frame);

        mMainNav.setOnNavigationItemSelectedListener(this);

        //Quantity List
        List<String> quantity = new ArrayList<String>();
        quantity.add("1");
        quantity.add("2");
        quantity.add("3");
        quantity.add("4");
        quantity.add("5");
        quantity.add("6");

        ArrayAdapter<String> dataQuantity = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, quantity);

        dataQuantity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellQuantity.setAdapter(dataQuantity);

        //Student Ticket List
        List<String> student = new ArrayList<String>();
        student.add("Yes");
        student.add("No");

        ArrayAdapter<String> dataStudent = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, student);

        dataStudent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellStudentTicket.setAdapter(dataStudent);

        //Validated List
        List<String> validated = new ArrayList<String>();
        validated.add("Yes");
        validated.add("No");

        ArrayAdapter<String> dataValidated = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, validated);

        dataValidated.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellValidated.setAdapter(dataValidated);

        //Negotiable List
        List<String> negotiable = new ArrayList<String>();
        negotiable.add("Yes");
        negotiable.add("No");

        ArrayAdapter<String> dataNegotiable = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, validated);

        dataNegotiable.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellNegotiable.setAdapter(dataNegotiable);


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

        if (view == buttonSellBack) {
            Intent portalIntent = new Intent(this, MainActivity.class);
            startActivity(portalIntent);

        } else if (view == buttonSellDone) {

        }

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
            Intent searchIntent = new Intent(this, SellTicketDetails.class);
            startActivity(searchIntent);
        }

        if (item.getItemId() == R.id.itemTemp) {
            Intent searchIntent = new Intent(this, RecyclerViewTest.class);
            startActivity(searchIntent);
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.itemInbox:
                Intent InboxIntent = new Intent(this, Inbox.class);
                startActivity(InboxIntent);
                return true;

            case R.id.itemProfile:
                Intent ProfileIntent = new Intent(this, Profile.class);
                startActivity(ProfileIntent);
                return true;

            case R.id.itemSchedule:
                Intent ScheduleIntent = new Intent(this, Schedule.class);
                startActivity(ScheduleIntent);
                return true;

            case R.id.itemSell:
                Intent SellIntent = new Intent(this, SellTicketDetails.class);
                startActivity(SellIntent);
                return true;

            default:
                return false;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String strSelection = adapterView.getItemAtPosition(i).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
