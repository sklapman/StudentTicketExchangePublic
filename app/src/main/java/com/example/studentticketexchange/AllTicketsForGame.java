package com.example.studentticketexchange;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentticketexchange.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AllTicketsForGame extends AppCompatActivity implements View.OnClickListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    Button buttonSell;
    TextView textViewGameName, textViewGameDate;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    RecyclerView recyclerViewTix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tickets_for_game);
        mMainNav = (BottomNavigationView) findViewById(R.id.id_Navbar);
        mMainFrame = (FrameLayout) findViewById(R.id.id_frame);

        buttonSell = findViewById(R.id.buttonSell);
        textViewGameName = findViewById(R.id.textViewGameName);
        textViewGameDate = findViewById(R.id.textViewGameDate);
        final String getOpponent;
        final String getGameDate;
        String getKey;

        buttonSell.setOnClickListener(this);

        recyclerViewTix = findViewById(R.id.recyclerViewTix);

        mMainNav.setOnNavigationItemSelectedListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("listings");

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                getOpponent = null;
                getGameDate = null;
                getKey = null;
                textViewGameName.setText(getOpponent);
                textViewGameDate.setText(getGameDate);

            } else {
                getOpponent = extras.getString("OPPONENT");
                getGameDate = extras.getString("GAME_DATE");
                getKey = extras.getString("GAME_KEY");
                textViewGameName.setText(getOpponent);
                textViewGameDate.setText(getGameDate);
            }
        } else {
            getOpponent = (String) savedInstanceState.getSerializable("OPPONENT");
            getGameDate = (String) savedInstanceState.getSerializable("GAME_DATE");
            getKey = (String) savedInstanceState.getSerializable("GAME_KEY");
            textViewGameName.setText(getOpponent);
            textViewGameDate.setText(getGameDate);
        }

        myRef.orderByChild("gameID").equalTo(getKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Listing> listings = new ArrayList<>();
                ArrayList<String> listingKeys = new ArrayList<>();
                for(DataSnapshot listingSnapshot: dataSnapshot.getChildren()){
                   String listingKey = listingSnapshot.getKey();
                   Listing listing = listingSnapshot.getValue(Listing.class);
                   listings.add(listing);
                   listingKeys.add(listingKey);
                }

                RecyclerViewAdapterAllTix recyclerViewAdapterAllTix = new RecyclerViewAdapterAllTix(listings, listingKeys, getOpponent, getGameDate,AllTicketsForGame.this);
                recyclerViewTix.setAdapter(recyclerViewAdapterAllTix);
                recyclerViewTix.setLayoutManager(new LinearLayoutManager(AllTicketsForGame  .this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == buttonSell) {
            Intent sellIntent = new Intent(this, SellTicketOption.class);
            startActivity(sellIntent);
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.tempmenu, menu);
//
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.itemChat) {
//            Intent searchIntent = new Intent(this, Chat.class);
//            startActivity(searchIntent);
//        }
//
//        if (item.getItemId() == R.id.itemAllTicketsForGame) {
//            Intent searchIntent = new Intent(this, AllTicketsForGame.class);
//            startActivity(searchIntent);
//        }
//
//        if (item.getItemId() == R.id.itemTempBuyTixDetails) {
//            Intent searchIntent = new Intent(this, BuyTicketDetails.class);
//            startActivity(searchIntent);
//        }
//
//        if (item.getItemId() == R.id.itemChoiceBuySell) {
//            Intent searchIntent = new Intent(this, ChoiceBuySell.class);
//            startActivity(searchIntent);
//        }
//
//        if (item.getItemId() == R.id.itemInbox) {
//            Intent searchIntent = new Intent(this, Inbox.class);
//            startActivity(searchIntent);
//        }
//
//        if (item.getItemId() == R.id.itemMainOpen) {
//            Intent searchIntent = new Intent(this, MainActivity.class);
//            startActivity(searchIntent);
//        }
//
//        if (item.getItemId() == R.id.itemProfile) {
//            Intent searchIntent = new Intent(this, Profile.class);
//            startActivity(searchIntent);
//        }
//
//        if (item.getItemId() == R.id.itemSchedule) {
//            Intent searchIntent = new Intent(this, Schedule.class);
//            startActivity(searchIntent);
//        }
//
//        if (item.getItemId() == R.id.itemSell) {
//            Intent searchIntent = new Intent(this, SellTicketOption.class);
//            startActivity(searchIntent);
//        }
//
//        if (item.getItemId() == R.id.itemTemp) {
//            Intent searchIntent = new Intent(this, RecyclerViewTest.class);
//            startActivity(searchIntent);
//        }
//
//        return super.onOptionsItemSelected(item);
//
//    }
}
