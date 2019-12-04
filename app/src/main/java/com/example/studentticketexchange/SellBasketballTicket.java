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
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SellBasketballTicket extends AppCompatActivity implements
        TextView.OnEditorActionListener,
        RadioButton.OnCheckedChangeListener,
        View.OnClickListener,
        BottomNavigationView.OnNavigationItemSelectedListener,
        AdapterView.OnItemSelectedListener {

    Button buttonSellBack, buttonSellDone;
    EditText editTextSellBasketballPrice;
    Spinner spinnerSellBasketballGame, spinnerSellBasketballSection, spinnerSellBasketballRow,
            spinnerSellBasketballQuantity, spinnerSellBasketballStudentTicket, spinnerSellBasketballValidated,
            spinnerSellBasketballNegotiable;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_basketball_ticket);

        //implement listeners
        buttonSellBack = findViewById(R.id.buttonSellBack);
        buttonSellDone = findViewById(R.id.buttonSellDone);
        editTextSellBasketballPrice = findViewById(R.id.editTextSellBasketballPrice);
        spinnerSellBasketballGame = findViewById(R.id.spinnerSellBasketballGame);
        spinnerSellBasketballSection = findViewById(R.id.spinnerSellBasketballSection);
        spinnerSellBasketballRow = findViewById(R.id.spinnerSellBasketballRow);
        spinnerSellBasketballQuantity = findViewById(R.id.spinnerSellBasketballQuantity);
        spinnerSellBasketballStudentTicket = findViewById(R.id.spinnerSellBasketballStudentTicket);
        spinnerSellBasketballValidated = findViewById(R.id.spinnerSellBasketballValidated);
        spinnerSellBasketballNegotiable = findViewById(R.id.spinnerSellBasketballNegotiable);

        //activate listeners
        buttonSellDone.setOnClickListener(this);
        buttonSellBack.setOnClickListener(this);
        editTextSellBasketballPrice.setOnEditorActionListener(this);
        spinnerSellBasketballGame.setOnItemSelectedListener(this);
        spinnerSellBasketballSection.setOnItemSelectedListener(this);
        spinnerSellBasketballRow.setOnItemSelectedListener(this);
        spinnerSellBasketballQuantity.setOnItemSelectedListener(this);
        spinnerSellBasketballStudentTicket.setOnItemSelectedListener(this);
        spinnerSellBasketballValidated.setOnItemSelectedListener(this);
        spinnerSellBasketballNegotiable.setOnItemSelectedListener(this);

        mMainNav = (BottomNavigationView) findViewById(R.id.id_Navbar);
        mMainFrame = (FrameLayout) findViewById(R.id.id_frame);

        mMainNav.setOnNavigationItemSelectedListener(this);

        //Game List
        List<String> game = new ArrayList<String>();
        game.add("Saginaw Valley State");
        game.add("Appalachian State");
        game.add("Creighton");
        game.add("Elon");
        game.add("Houston Baptist");
        game.add("Iowa");
        game.add("Oregon");
        game.add("Presbyterian");
        game.add("UMass Lowell");
        game.add("Purdue");
        game.add("Penn State");
        game.add("Illinois");
        game.add("Ohio State");
        game.add("Michigan State");
        game.add("Indiana");
        game.add("Rutgers");
        game.add("Wisconsin");
        game.add("Nebraska");

        ArrayAdapter<String> dataGame = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, game);
        dataGame.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellBasketballGame.setAdapter(dataGame);

        //Section List
        List<String> section = new ArrayList<String>();
        section.add("101");
        section.add("104");
        section.add("105");
        section.add("106");
        section.add("108");
        section.add("110");
        section.add("112");
        section.add("114");
        section.add("116");
        section.add("118");
        section.add("120");
        section.add("122");
        section.add("123");
        section.add("124");
        section.add("126");
        section.add("128");
        section.add("130");
        section.add("132");
        section.add("134");
        section.add("136");
        section.add("201");
        section.add("202");
        section.add("203");
        section.add("204");
        section.add("205");
        section.add("206");
        section.add("207");
        section.add("208");
        section.add("209");
        section.add("210");
        section.add("211");
        section.add("212");
        section.add("213");
        section.add("214");
        section.add("215");
        section.add("216");
        section.add("217");
        section.add("218");
        section.add("219");
        section.add("220");
        section.add("221");
        section.add("222");
        section.add("223");
        section.add("224");
        section.add("225");
        section.add("226");
        section.add("227");
        section.add("228");
        section.add("229");
        section.add("230");
        section.add("231");
        section.add("232");
        section.add("233");
        section.add("234");
        section.add("235");
        section.add("236");

        ArrayAdapter<String> dataSection = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, section);
        dataSection.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellBasketballSection.setAdapter(dataSection);

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

        ArrayAdapter<String> dataRow = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, row);
        dataRow.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellBasketballRow.setAdapter(dataRow);

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
        spinnerSellBasketballQuantity.setAdapter(dataQuantity);

        //Student Ticket List
        List<String> student = new ArrayList<String>();
        student.add("Yes");
        student.add("No");

        ArrayAdapter<String> dataStudent = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, student);
        dataStudent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellBasketballStudentTicket.setAdapter(dataStudent);

        //Validated List
        List<String> validated = new ArrayList<String>();
        validated.add("Yes");
        validated.add("No");

        ArrayAdapter<String> dataValidated = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, validated);
        dataValidated.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellBasketballValidated.setAdapter(dataValidated);

        //Negotiable List
        List<String> negotiable = new ArrayList<String>();
        negotiable.add("Yes");
        negotiable.add("No");

        ArrayAdapter<String> dataNegotiable = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, negotiable);
        dataNegotiable.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellBasketballNegotiable.setAdapter(dataNegotiable);

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
