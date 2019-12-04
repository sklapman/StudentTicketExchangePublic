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
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SellFootballTicket extends AppCompatActivity implements
        TextView.OnEditorActionListener,
        RadioButton.OnCheckedChangeListener,
        View.OnClickListener,
        BottomNavigationView.OnNavigationItemSelectedListener,
        AdapterView.OnItemSelectedListener {

    Button buttonSellBack, buttonSellDone;
    EditText editTextSellFootballPrice;
    Spinner spinnerSellFootballGame, spinnerSellFootballSection, spinnerSellFootballRow,
            spinnerSellFootballQuantity, spinnerSellFootballStudentTicket, spinnerSellFootballValidated,
            spinnerSellFootballNegotiable;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_football_ticket);

        //implement listeners
        buttonSellBack = findViewById(R.id.buttonSellBack);
        buttonSellDone = findViewById(R.id.buttonSellDone);
        editTextSellFootballPrice = findViewById(R.id.editTextSellFootballPrice);
        spinnerSellFootballGame = findViewById(R.id.spinnerSellFootballGame);
        spinnerSellFootballSection = findViewById(R.id.spinnerSellFootballSection);
        spinnerSellFootballRow = findViewById(R.id.spinnerSellFootballRow);
        spinnerSellFootballQuantity = findViewById(R.id.spinnerSellFootballQuantity);
        spinnerSellFootballStudentTicket = findViewById(R.id.spinnerSellFootballStudentTicket);
        spinnerSellFootballValidated = findViewById(R.id.spinnerSellFootballValidated);
        spinnerSellFootballNegotiable = findViewById(R.id.spinnerSellFootballNegotiable);

        //activate listeners
        buttonSellDone.setOnClickListener(this);
        buttonSellBack.setOnClickListener(this);
        editTextSellFootballPrice.setOnEditorActionListener(this);
        spinnerSellFootballGame.setOnItemSelectedListener(this);
        spinnerSellFootballSection.setOnItemSelectedListener(this);
        spinnerSellFootballRow.setOnItemSelectedListener(this);
        spinnerSellFootballQuantity.setOnItemSelectedListener(this);
        spinnerSellFootballStudentTicket.setOnItemSelectedListener(this);
        spinnerSellFootballValidated.setOnItemSelectedListener(this);
        spinnerSellFootballNegotiable.setOnItemSelectedListener(this);

        mMainNav = (BottomNavigationView) findViewById(R.id.id_Navbar);
        mMainFrame = (FrameLayout) findViewById(R.id.id_frame);

        mMainNav.setOnNavigationItemSelectedListener(this);

        //Game List
        List<String> game = new ArrayList<String>();
        game.add("Middle Tennessee State");
        game.add("Army");
        game.add("Rutgers");
        game.add("Iowa");
        game.add("Notre Dame");
        game.add("Michigan State");
        game.add("Ohio State");

        ArrayAdapter<String> dataGame = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, game);
        dataGame.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellFootballGame.setAdapter(dataGame);

        //Section List
        List<String> section = new ArrayList<String>();
        section.add("1");
        section.add("2");
        section.add("3");
        section.add("4");
        section.add("5");
        section.add("6");
        section.add("7");
        section.add("8");
        section.add("9");
        section.add("10");
        section.add("11");
        section.add("12");
        section.add("13");
        section.add("14");
        section.add("15");
        section.add("16");
        section.add("17");
        section.add("18");
        section.add("19");
        section.add("20");
        section.add("21");
        section.add("22");
        section.add("23");
        section.add("24");
        section.add("25");
        section.add("26");
        section.add("27");
        section.add("28");
        section.add("29");
        section.add("30");
        section.add("31");
        section.add("32");
        section.add("33");
        section.add("34");
        section.add("35");
        section.add("36");
        section.add("37");
        section.add("38");
        section.add("39");
        section.add("40");
        section.add("41");
        section.add("42");
        section.add("43");
        section.add("44");

        ArrayAdapter<String> dataSection = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, section);
        dataSection.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellFootballSection.setAdapter(dataSection);

        //Row List
        List<String> row = new ArrayList<String>();
        row.add("1");
        row.add("2");
        row.add("3");
        row.add("4");
        row.add("5");
        row.add("6");
        row.add("7");
        row.add("8");
        row.add("9");
        row.add("10");
        row.add("11");
        row.add("12");
        row.add("13");
        row.add("14");
        row.add("15");
        row.add("16");
        row.add("17");
        row.add("18");
        row.add("19");
        row.add("20");
        row.add("21");
        row.add("22");
        row.add("23");
        row.add("24");
        row.add("25");
        row.add("26");
        row.add("27");
        row.add("28");
        row.add("29");
        row.add("30");
        row.add("31");
        row.add("32");
        row.add("33");
        row.add("34");
        row.add("35");
        row.add("36");
        row.add("37");
        row.add("38");
        row.add("39");
        row.add("40");
        row.add("41");
        row.add("42");
        row.add("43");
        row.add("44");
        row.add("45");
        row.add("46");
        row.add("47");
        row.add("48");
        row.add("49");
        row.add("50");
        row.add("51");
        row.add("52");
        row.add("53");
        row.add("54");
        row.add("55");
        row.add("56");
        row.add("57");
        row.add("58");
        row.add("59");
        row.add("60");
        row.add("61");
        row.add("62");
        row.add("63");
        row.add("64");
        row.add("65");
        row.add("66");
        row.add("67");
        row.add("68");
        row.add("69");
        row.add("70");
        row.add("71");
        row.add("72");
        row.add("73");
        row.add("74");
        row.add("75");
        row.add("76");
        row.add("77");
        row.add("78");
        row.add("79");
        row.add("80");
        row.add("81");
        row.add("82");
        row.add("83");
        row.add("84");
        row.add("85");
        row.add("86");
        row.add("87");
        row.add("88");
        row.add("89");
        row.add("90");
        row.add("91");
        row.add("92");
        row.add("93");
        row.add("94");
        row.add("95");
        row.add("96");

        ArrayAdapter<String> dataRow = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, row);
        dataRow.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellFootballRow.setAdapter(dataRow);

        //Quantity List
        List<String> quantity = new ArrayList<String>();
        quantity.add("1");
        quantity.add("2");
        quantity.add("3");
        quantity.add("4");
        quantity.add("5");
        quantity.add("6");
        quantity.add("7");
        quantity.add("8");
        quantity.add("9");
        quantity.add("10");

        ArrayAdapter<String> dataQuantity = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, quantity);
        dataQuantity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellFootballQuantity.setAdapter(dataQuantity);

        //Student Ticket List
        List<String> student = new ArrayList<String>();
        student.add("Yes");
        student.add("No");

        ArrayAdapter<String> dataStudent = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, student);
        dataStudent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellFootballStudentTicket.setAdapter(dataStudent);

        //Validated List
        List<String> validated = new ArrayList<String>();
        validated.add("Yes");
        validated.add("No");

        ArrayAdapter<String> dataValidated = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, validated);
        dataValidated.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellFootballValidated.setAdapter(dataValidated);

        //Negotiable List
        List<String> negotiable = new ArrayList<String>();
        negotiable.add("Yes");
        negotiable.add("No");

        ArrayAdapter<String> dataNegotiable = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, negotiable);
        dataNegotiable.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellFootballNegotiable.setAdapter(dataNegotiable);
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
    public void onClick(View view) {

        if (view == buttonSellBack) {
            Intent portalIntent = new Intent(this, SellTicketDetails.class);
            startActivity(portalIntent);
        } else if (view == buttonSellDone) {

        }





    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String strSelection = adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
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
}
