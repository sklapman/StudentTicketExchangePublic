package com.example.studentticketexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BuyTicketDetails extends AppCompatActivity implements
        TextView.OnEditorActionListener,
        View.OnClickListener {

    Button buttonBuyBack, buttonBuyContactSeller;
    TextView textViewBuySportSelected, textViewBuyGameSelected, textViewBuySectionSelected,
            textViewBuyRowSelected, textViewBuyQuantitySelected, textViewBuyPriceSelected,
            textViewBuyStudentTicketSelected, textViewBuyValidatedSelected, textViewBuyNegotiableSelected;


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

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
