package com.example.studentticketexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Schedule extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {
    Button footballButton, basketballButton, hockeyButton, currentSelected;
    TextView subtitle, footballTextView, basketballTextView, hockeyTextView;
    Drawable greyOutline, blueOutline;
    ImageView footballSelect, basketballSelect, hockeySelect;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        footballButton = findViewById(R.id.button_sched_football);
        basketballButton = findViewById(R.id.button_sched_basketball);
        hockeyButton = findViewById(R.id.button_sched_hockey);
        footballTextView = findViewById(R.id.textView_sched_football);
        basketballTextView = findViewById(R.id.textView_sched_basketball);
        hockeyTextView = findViewById(R.id.textView_sched_hockey);
        footballSelect = findViewById(R.id.imageView_football_selectbar);
        basketballSelect = findViewById(R.id.imageView_basketball_selectbar);
        hockeySelect = findViewById(R.id.imageView_hockey_selectbar);
        subtitle = findViewById(R.id.textView_schedule_subtitle);
        currentSelected = null;

        greyOutline = getResources().getDrawable(R.drawable.button_grey_border);
        blueOutline = getResources().getDrawable(R.drawable.button_blue_border);

        footballButton.setOnClickListener(this);
        basketballButton.setOnClickListener(this);
        hockeyButton.setOnClickListener(this);

        mMainNav = (BottomNavigationView) findViewById(R.id.id_Navbar);
        mMainFrame = (FrameLayout) findViewById(R.id.id_frame);

        mMainNav.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == currentSelected){
            footballTextView.setTypeface(null, Typeface.NORMAL);
            basketballTextView.setTypeface(null, Typeface.NORMAL);
            hockeyTextView.setTypeface(null, Typeface.NORMAL);

            footballButton.setBackground(greyOutline);
            basketballButton.setBackground(greyOutline);
            hockeyButton.setBackground(greyOutline);

            footballSelect.setImageResource(R.color.white);
            basketballSelect.setImageResource(R.color.white);
            hockeySelect.setImageResource(R.color.white);

            subtitle.setText("UPCOMING GAMES");

            currentSelected = null;
        }
        else if (view == footballButton) {
            footballTextView.setTypeface(null, Typeface.BOLD);
            basketballTextView.setTypeface(null, Typeface.NORMAL);
            hockeyTextView.setTypeface(null, Typeface.NORMAL);

            footballButton.setBackground(blueOutline);
            basketballButton.setBackground(greyOutline);
            hockeyButton.setBackground(greyOutline);

            footballSelect.setImageResource(R.color.michiganBlue);
            basketballSelect.setImageResource(R.color.white);
            hockeySelect.setImageResource(R.color.white);

            subtitle.setText("UPCOMING FOOTBALL GAMES");

            currentSelected = footballButton;
        } else if (view == basketballButton) {
            footballTextView.setTypeface(null, Typeface.NORMAL);
            basketballTextView.setTypeface(null, Typeface.BOLD);
            hockeyTextView.setTypeface(null, Typeface.NORMAL);

            footballButton.setBackground(greyOutline);
            basketballButton.setBackground(blueOutline);
            hockeyButton.setBackground(greyOutline);

            footballSelect.setImageResource(R.color.white);
            basketballSelect.setImageResource(R.color.michiganBlue);
            hockeySelect.setImageResource(R.color.white);

            subtitle.setText("UPCOMING BASKETBALL GAMES");

            currentSelected = basketballButton;
        } else if (view == hockeyButton) {
            footballTextView.setTypeface(null, Typeface.NORMAL);
            basketballTextView.setTypeface(null, Typeface.NORMAL);
            hockeyTextView.setTypeface(null, Typeface.BOLD);

            footballButton.setBackground(greyOutline);
            basketballButton.setBackground(greyOutline);
            hockeyButton.setBackground(blueOutline);

            footballSelect.setImageResource(R.color.white);
            basketballSelect.setImageResource(R.color.white);
            hockeySelect.setImageResource(R.color.michiganBlue);

            subtitle.setText("UPCOMING HOCKEY GAMES");

            currentSelected = hockeyButton;
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
                Intent SellIntent = new Intent(this, SellTicketDetails.class);
                startActivity(SellIntent);
                return true;

            default:
                return false;

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

        return super.onOptionsItemSelected(item);

    }
}
