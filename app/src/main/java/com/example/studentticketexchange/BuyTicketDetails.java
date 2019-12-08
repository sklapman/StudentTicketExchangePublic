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
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BuyTicketDetails extends AppCompatActivity implements
        TextView.OnEditorActionListener,
        View.OnClickListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    Button buttonBuyBack, buttonBuyContactSeller;
    TextView textViewBuySportSelected, textViewBuyGameSelected, textViewBuySectionSelected,
            textViewBuyRowSelected, textViewBuyQuantitySelected, textViewBuyPriceSelected,
            textViewBuyStudentTicketSelected, textViewBuyValidatedSelected, textViewBuyNegotiableSelected;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket_details);

        //implement listeners
        textViewBuySportSelected = findViewById(R.id.textViewBuySportSelected);
        textViewBuyGameSelected = findViewById(R.id.textViewBuyGameSelected);
        textViewBuySectionSelected = findViewById(R.id.textViewBuySectionSelected);
        textViewBuyRowSelected = findViewById(R.id.textViewBuyRowSelected);
        textViewBuyQuantitySelected = findViewById(R.id.textViewBuyQuantitySelected);
        textViewBuyPriceSelected = findViewById(R.id.textViewBuyPriceSelected);
        textViewBuyStudentTicketSelected = findViewById(R.id.textViewBuyStudentTicketSelected);
        textViewBuyValidatedSelected = findViewById(R.id.textViewBuyValidatedSelected);
        textViewBuyNegotiableSelected = findViewById(R.id.textViewBuyNegotiableSelected);

        buttonBuyBack = findViewById(R.id.buttonBuyBack);
        buttonBuyContactSeller = findViewById(R.id.buttonBuyContactSeller);

        buttonBuyBack.setOnClickListener(this);
        buttonBuyContactSeller.setOnClickListener(this);

        mMainNav = (BottomNavigationView) findViewById(R.id.id_Navbar);
        mMainFrame = (FrameLayout) findViewById(R.id.id_frame);


        mMainNav.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == buttonBuyBack) {
            //navigation between pages with buttons
            Intent portalIntent = new Intent(this, AllTicketsForGame.class);
            startActivity(portalIntent);

        } else if (view == buttonBuyContactSeller) {

        }


    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
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
}
