package com.example.studentticketexchange;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {
    Button footballButton, basketballButton, hockeyButton;
    TextView footballTextView, basketballTextView, hockeyTextView;
    Drawable greyOutline, blueOutline;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private ProfileFragment profileFragment;
    private ScheduleFragment scheduleFragment;
    private SellFragment sellFragment;
    private InboxFragment inboxFragment;



    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_schedule, container, false);
/*
        footballButton = getView().findViewById(R.id.button_sched_football);
        basketballButton = getView().findViewById(R.id.button_sched_basketball);
        hockeyButton = getView().findViewById(R.id.button_sched_hockey);
        footballTextView = getView().findViewById(R.id.textView_sched_football);
        basketballTextView = getView().findViewById(R.id.textView_sched_basketball);
        hockeyTextView = getView().findViewById(R.id.textView_sched_hockey);

        greyOutline = getResources().getDrawable(R.drawable.button_grey_border);
        blueOutline = getResources().getDrawable(R.drawable.button_blue_border);

        footballButton.setOnClickListener(this);
        basketballButton.setOnClickListener(this);
        hockeyButton.setOnClickListener(this);

        mMainNav = (BottomNavigationView) getView().findViewById(R.id.id_Navbar);
        mMainFrame = (FrameLayout) getView().findViewById(R.id.id_frame);

        profileFragment = new ProfileFragment();
        scheduleFragment = new ScheduleFragment();
        sellFragment = new SellFragment();
        inboxFragment = new InboxFragment();

        mMainNav.setOnNavigationItemSelectedListener(this); */
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
