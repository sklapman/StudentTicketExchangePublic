package com.example.studentticketexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Schedule extends AppCompatActivity implements View.OnClickListener{
    Button footballButton, basketballButton, hockeyButton;
    TextView footballTextView, basketballTextView, hockeyTextView;
    Drawable greyOutline, blueOutline;

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

        greyOutline = getResources().getDrawable(R.drawable.button_grey_border);
        blueOutline = getResources().getDrawable(R.drawable.button_blue_border);

        footballButton.setOnClickListener(this);
        basketballButton.setOnClickListener(this);
        hockeyButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == footballButton){
            footballTextView.setTypeface(null, Typeface.BOLD);
            basketballTextView.setTypeface(null, Typeface.NORMAL);
            hockeyTextView.setTypeface(null, Typeface.NORMAL);

            footballButton.setBackground(blueOutline);
            basketballButton.setBackground(greyOutline);
            hockeyButton.setBackground(greyOutline);
        }
        else if(view == basketballButton){
            footballTextView.setTypeface(null, Typeface.NORMAL);
            basketballTextView.setTypeface(null, Typeface.BOLD);
            hockeyTextView.setTypeface(null, Typeface.NORMAL);

            footballButton.setBackground(greyOutline);
            basketballButton.setBackground(blueOutline);
            hockeyButton.setBackground(greyOutline);
        }
        else if(view == hockeyButton){
            footballTextView.setTypeface(null, Typeface.NORMAL);
            basketballTextView.setTypeface(null, Typeface.NORMAL);
            hockeyTextView.setTypeface(null, Typeface.BOLD);

            footballButton.setBackground(greyOutline);
            basketballButton.setBackground(greyOutline);
            hockeyButton.setBackground(blueOutline);
        }
    }
}
