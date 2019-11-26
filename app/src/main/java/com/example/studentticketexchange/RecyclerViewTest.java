package com.example.studentticketexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class RecyclerViewTest extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {


    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


        private ArrayList<Listing> listings;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recycler_view_test);
        mMainNav = (BottomNavigationView) findViewById(R.id.id_Navbar);
        mMainFrame = (FrameLayout) findViewById(R.id.id_frame);

        mMainNav.setOnNavigationItemSelectedListener(this);

        initListings();

        }

        @Override
        public void onClick(View v) {

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
                Intent searchIntent = new Intent(this, com.example.studentticketexchange.AllTicketsForGame.class);
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

        private void initListings() {
            listings = new ArrayList<>();
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "330","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "331","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "332","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "333","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "334","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "335","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "336","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "337","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "338","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "339","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "330","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "331","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "332","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "333","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "334","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "335","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "336","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "337","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "338","Selling together"));
            listings.add(new Listing("a@a.com",Boolean.TRUE, Boolean.TRUE, "339","Selling together"));
            initRecyclerView();
        }

        private void initRecyclerView() {
            RecyclerView recyclerViewTix = findViewById(R.id.recyclerViewTix);
            RecyclerViewAdapterAllTix recyclerViewAdapterAllTix = new RecyclerViewAdapterAllTix(listings, this);
            recyclerViewTix.setAdapter(recyclerViewAdapterAllTix);
            recyclerViewTix.setLayoutManager(new LinearLayoutManager(this));
        }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}