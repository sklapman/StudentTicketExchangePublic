package com.example.studentticketexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    Button buttonLogout;
    TextView textViewUserName;

    private FirebaseAuth mAuth;


    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        buttonLogout = findViewById(R.id.buttonLogout);
        textViewUserName = findViewById(R.id.textViewUserName);

        buttonLogout.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        textViewUserName.setText(currentUser.getEmail());

        mMainNav = (BottomNavigationView) findViewById(R.id.id_Navbar);
        mMainFrame = (FrameLayout) findViewById(R.id.id_frame);


        mMainNav.setOnNavigationItemSelectedListener(this);

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


    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        Toast.makeText(this, "User: "+currentUser, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if (v == buttonLogout) {
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
            mAuth.signOut();
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
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
