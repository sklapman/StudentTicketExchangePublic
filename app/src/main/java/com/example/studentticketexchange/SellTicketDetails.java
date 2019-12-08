package com.example.studentticketexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SellTicketDetails extends AppCompatActivity implements
        View.OnClickListener,
        BottomNavigationView.OnNavigationItemSelectedListener,
        AdapterView.OnItemSelectedListener {

    Button buttonSellBack, buttonSellDone;
    EditText editTextSellPrice;
    Spinner spinnerSellGame, spinnerSellSection, spinnerSellRow, spinnerSellQuantity,
            spinnerSellStudentTicket, spinnerSellValidated, spinnerSellNegotiable;
    private ArrayList<String> gameKeys;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    int sport;

    String gameID_selected;
    Boolean studentTicket_selected;
    Boolean validated_selected;
    Boolean negotiable_selected;
    int quantity_selected;
    int section_selected;
    int row_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_ticket_details);

        Bundle extras = getIntent().getExtras();
        sport = extras.getInt("sport");

        TextView sportText = findViewById(R.id.textView_sell_details_sportValue);
        switch(sport){
            case 1:
                sportText.setText("Football");
                break;
            case 2:
                sportText.setText("Basketball");
                break;
            case 3:
                sportText.setText("Hockey");
                break;
        }

        //implement listeners
        buttonSellBack = findViewById(R.id.button_sell_details_back);
        buttonSellDone = findViewById(R.id.button_sell_details_done);
        editTextSellPrice = findViewById(R.id.editText_sell_details_price);
        spinnerSellGame = findViewById(R.id.spinner_sell_details_game);
        spinnerSellSection = findViewById(R.id.spinner_sell_details_section);
        spinnerSellRow = findViewById(R.id.spinner_sell_details_row);
        spinnerSellQuantity = findViewById(R.id.spinner_sell_details_quantity);
        spinnerSellStudentTicket = findViewById(R.id.spinner_sell_details_student);
        spinnerSellValidated = findViewById(R.id.spinner_sell_details_validated);
        spinnerSellNegotiable = findViewById(R.id.spinner_sell_details_negotiable);

        //activate listeners
        buttonSellDone.setOnClickListener(this);
        buttonSellBack.setOnClickListener(this);
        spinnerSellGame.setOnItemSelectedListener(this);
        spinnerSellSection.setOnItemSelectedListener(this);
        spinnerSellRow.setOnItemSelectedListener(this);
        spinnerSellQuantity.setOnItemSelectedListener(this);
        spinnerSellStudentTicket.setOnItemSelectedListener(this);
        spinnerSellValidated.setOnItemSelectedListener(this);
        spinnerSellNegotiable.setOnItemSelectedListener(this);

        mMainNav = (BottomNavigationView) findViewById(R.id.id_Navbar);
        mMainFrame = (FrameLayout) findViewById(R.id.id_frame);

        mMainNav.setOnNavigationItemSelectedListener(this);

        //Selected ticket values start at null
        gameID_selected = null;
        studentTicket_selected = null;
        validated_selected = null;
        negotiable_selected = null;
        section_selected = -1;
        row_selected = -1;
        quantity_selected = -1;

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

        ArrayAdapter<String> dataSection = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, section);
        dataSection.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellSection.setAdapter(dataSection);

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

        ArrayAdapter<String> dataRow = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, row);
        dataRow.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellRow.setAdapter(dataRow);

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

        ArrayAdapter<String> dataNegotiable = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, negotiable);
        dataNegotiable.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSellNegotiable.setAdapter(dataNegotiable);

        //Game List
        gameKeys = new ArrayList<>();
        setGamesAvailable();

        //List<String> games = new ArrayList<String>();
        //game.add("Windsor");
        //game.add("Clarkson");
        //game.add("Lake Superior State");
        //game.add("Western Michigan");
        //game.add("Minnesota");
        //game.add("Michigan State");
        //game.add("Penn State");
        //game.add("Ohio State");
        //game.add("Wisconsin");

        //ArrayAdapter<String> dataGame = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, games);
        //dataGame.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinnerSellGame.setAdapter(dataGame);
        findViewById(R.id.textView_sell_details_noGames).setVisibility(View.INVISIBLE);
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
            Intent searchIntent = new Intent(this, SellTicketOption.class);
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
            Intent portalIntent = new Intent(this, SellTicketOption.class);
            startActivity(portalIntent);
        } else if (view == buttonSellDone) {
            Double price_selected = -1.0;
            try {
                price_selected = Double.parseDouble(editTextSellPrice.getText().toString());
            } catch(NumberFormatException e) {
                Toast.makeText(this, "Please enter a price in the proper format", Toast.LENGTH_SHORT).show();
                return;
            }
            if(section_selected == -1){
                Toast.makeText(this, "Please select a section", Toast.LENGTH_SHORT).show();
                return;
            }
            if(row_selected == -1){
                Toast.makeText(this, "Please select a row", Toast.LENGTH_SHORT).show();
                return;
            }
            if(quantity_selected == -1){
                Toast.makeText(this, "Please select a quantity of tickets for this listing", Toast.LENGTH_SHORT).show();
                return;
            }
            if(studentTicket_selected == null){
                Toast.makeText(this, "Please select if ticket is a student ticket or not", Toast.LENGTH_SHORT).show();
                return;
            }
            if(validated_selected == null){
                Toast.makeText(this, "Please select if ticket is a validate ticket or not", Toast.LENGTH_SHORT).show();
                return;
            }
            if(negotiable_selected == null){
                Toast.makeText(this, "Please select if ticket is a validate ticket or not", Toast.LENGTH_SHORT).show();
                return;
            }
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String name = user.getEmail();
            Listing newListing = new Listing(gameID_selected, name, section_selected, row_selected,
                    quantity_selected, price_selected, studentTicket_selected, validated_selected,
                    negotiable_selected);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("listings");
            myRef.push().setValue(newListing);
            Toast.makeText(this, "Listing successfully placed on market", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId() == spinnerSellGame.getId()){
            gameID_selected = gameKeys.get(i);
        } else if(adapterView.getId() == spinnerSellSection.getId()){
            section_selected = Integer.parseInt(adapterView.getItemAtPosition(i).toString());
        } else if(adapterView.getId() == spinnerSellRow.getId()){
            row_selected = Integer.parseInt(adapterView.getItemAtPosition(i).toString());
        } else if(adapterView.getId() == spinnerSellQuantity.getId()){
            quantity_selected = Integer.parseInt(adapterView.getItemAtPosition(i).toString());
        } else if(adapterView.getId() == spinnerSellStudentTicket.getId()){
            if(adapterView.getItemAtPosition(i).toString() == "Yes"){
                studentTicket_selected = true;
            } else if(adapterView.getItemAtPosition(i).toString() == "No"){
                studentTicket_selected = false;
            }
        } else if(adapterView.getId() == spinnerSellValidated.getId()){
            if(adapterView.getItemAtPosition(i).toString() == "Yes"){
                validated_selected = true;
            } else if(adapterView.getItemAtPosition(i).toString() == "No"){
                validated_selected = false;
            }
        } else if(adapterView.getId() == spinnerSellNegotiable.getId()){
            if(adapterView.getItemAtPosition(i).toString() == "Yes"){
                negotiable_selected = true;
            } else if(adapterView.getItemAtPosition(i).toString() == "No"){
                negotiable_selected = false;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        if(adapterView.getId() == spinnerSellGame.getId()){
            gameID_selected = null;
        }
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
                Intent SellIntent = new Intent(this, SellTicketOption.class);
                startActivity(SellIntent);
                return true;

            default:
                return false;
        }
    }

    public void setGamesAvailable(){
        gameKeys.clear();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("gameSchedule");
        final Calendar currentDate = Calendar.getInstance();
        final Context context = this;
        myRef.orderByChild("sport").equalTo(sport).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Game> games = new ArrayList<Game>();
                for (DataSnapshot gameSnap : dataSnapshot.getChildren()) {
                    Game gameItem = gameSnap.getValue(Game.class);
                    Calendar gameDate = Calendar.getInstance();
                    gameDate.set(Calendar.MONTH, gameItem.month - 1);
                    gameDate.set(Calendar.DATE, gameItem.day);
                    gameDate.set(Calendar.YEAR, gameItem.year);
                    String gameKey = gameSnap.getKey();
                    if(!gameDate.before(currentDate)){
                        if(games.isEmpty()){
                            games.add(gameItem);
                            gameKeys.add(gameKey);
                        } else {
                            Boolean found = false;
                            for (int i = 0; i < games.size(); i++){
                                Game gameComp = games.get(i);
                                if(gameItem.compareTo(gameComp) < 0 ){
                                    games.add(i, gameItem);
                                    gameKeys.add(i, gameKey);
                                    found = true;
                                    break;
                                }
                            }
                            if(!found){
                                games.add(gameItem);
                                gameKeys.add(gameKey);
                            }
                        }
                    }
                }
                if(games.isEmpty()){
                    setVisibility(false);
                } else {
                    setVisibility(true);
                    List<String> gameStrings = new ArrayList<String>();
                    for(Game gameItem : games){
                        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                        String dateStr = months[gameItem.month - 1] + " " + gameItem.day;
                        gameStrings.add(dateStr + " - " + gameItem.opponent);
                    }
                    ArrayAdapter<String> dataGame = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, gameStrings);
                    dataGame.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerSellGame.setAdapter(dataGame);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void setVisibility(Boolean tf){
        if(tf){
            //Set all views to be visible again
            findViewById(R.id.textView_sell_details_noGames).setVisibility(View.INVISIBLE);
            findViewById(R.id.scrollView_sell_details).setVisibility(View.VISIBLE);
            buttonSellDone.setVisibility(View.VISIBLE);
        } else {
            //No games set all to be invisible
            findViewById(R.id.textView_sell_details_noGames).setVisibility(View.VISIBLE);
            findViewById(R.id.scrollView_sell_details).setVisibility(View.INVISIBLE);
            buttonSellDone.setVisibility(View.INVISIBLE);
        }
    }
}
