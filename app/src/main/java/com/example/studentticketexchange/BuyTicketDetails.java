package com.example.studentticketexchange;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BuyTicketDetails extends AppCompatActivity implements
        TextView.OnEditorActionListener,
        View.OnClickListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    Button buttonBuyBack, buttonBuyContactSeller, buttonDelete;
    TextView textViewBuyGameSelected, textViewBuyDateSelected, textViewBuySectionSelected,
            textViewBuyRowSelected, textViewBuyQuantitySelected, textViewBuyPriceSelected,
            textViewBuyStudentTicketSelected, textViewBuyValidatedSelected, textViewBuyNegotiableSelected;
    String getKey, getOpponent, getGameDate, sellerEmail;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket_details);

        //implement listeners
        textViewBuyDateSelected = findViewById(R.id.textViewBuyDateSelected);
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
        buttonDelete = findViewById(R.id.buttonDelete);

        buttonBuyBack.setOnClickListener(this);
        buttonBuyContactSeller.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        mMainNav = (BottomNavigationView) findViewById(R.id.id_Navbar);
        mMainFrame = (FrameLayout) findViewById(R.id.id_frame);


        mMainNav.setOnNavigationItemSelectedListener(this);

        mAuth = FirebaseAuth.getInstance();
        final String UserEmail = mAuth.getCurrentUser().getEmail();


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                getKey = null;
                getOpponent = null;
                getGameDate = null;

            } else {
                getKey = extras.getString("LISTING_KEY");
                getOpponent = extras.getString("OPPONENT");
                getGameDate = extras.getString("GAME_DATE");
            }
        } else {
            getKey = (String) savedInstanceState.getSerializable("LISTING_KEY");
            getOpponent = (String) savedInstanceState.getSerializable("OPPONENT");
            getGameDate = (String) savedInstanceState.getSerializable("GAME_DATE");
        }

//        Toast.makeText(BuyTicketDetails.this, "getKey: "+getKey, Toast.LENGTH_SHORT).show();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("listings");

        myRef.orderByKey().equalTo(getKey).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Listing findListing = dataSnapshot.getValue(Listing.class);

                String findListingSellerEmail = findListing.sellerEmail;
                String findListingPrice = Double.toString(findListing.price);
                String findListingQuantity = Integer.toString(findListing.quantity);
                String findListingSection = Integer.toString(findListing.section);
                String findListingRow = Integer.toString(findListing.row);
                String findListingStudentTicket = Boolean.toString(findListing.studentTicket);
                String findListingValidated = Boolean.toString(findListing.validated);
                String findListingNegotiable = Boolean.toString(findListing.negotiable);

                sellerEmail = findListing.sellerEmail;

                textViewBuyGameSelected.setText(getOpponent);
                textViewBuyDateSelected.setText(getGameDate);
                textViewBuyPriceSelected.setText(findListingPrice);
                textViewBuyQuantitySelected.setText(findListingQuantity);
                textViewBuySectionSelected.setText(findListingSection);
                textViewBuyRowSelected.setText(findListingRow);
                textViewBuyStudentTicketSelected.setText(findListingStudentTicket);
                textViewBuyValidatedSelected.setText(findListingValidated);
                textViewBuyNegotiableSelected.setText(findListingNegotiable);

                if(findListingSellerEmail.equals(UserEmail)){
                    buttonDelete.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onClick(View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("listings");

        if (view == buttonBuyBack) {
            //navigation between pages with buttons

            myRef.orderByKey().equalTo(getKey).addChildEventListener(new ChildEventListener() {
                         @Override
                         public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                             Listing findListing = dataSnapshot.getValue(Listing.class);
                             String findListingGameID = findListing.gameID;
                             Intent portalIntent = new Intent(BuyTicketDetails.this, AllTicketsForGame.class);
                             portalIntent.putExtra("GAME_KEY", findListingGameID);
                             startActivity(portalIntent);
                         }

                         @Override
                         public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                         }

                         @Override
                         public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                         }

                         @Override
                         public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                         }

                         @Override
                         public void onCancelled(@NonNull DatabaseError databaseError) {

                         }
                     });

        } else if (view == buttonBuyContactSeller) {
            //ChatDetails.chatWith = "bbbbbb";

            int index = sellerEmail.indexOf('@');
            sellerEmail = sellerEmail.substring(0,index);

            ChatDetails.chatWith = sellerEmail;
            view.getContext().startActivity(new Intent(view.getContext(), Chat.class));

        } else if (view == buttonDelete) {

            myRef.orderByKey().equalTo(getKey).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    myRef.child(getKey).setValue(null);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
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
