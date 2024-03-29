package com.example.studentticketexchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil;

import java.util.HashMap;
import java.util.Map;

public class Chat extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    String TestUser1;
    String TestUser2;

    LinearLayout layout;
    RelativeLayout layout_2;
    ImageView sendButton;
    EditText messageArea;
    ScrollView scrollView;
    Firebase reference1, reference2, reference3, reference4;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mMainNav = (BottomNavigationView) findViewById(R.id.id_Navbar);
        mMainFrame = (FrameLayout) findViewById(R.id.id_frame);

        mMainNav.setOnNavigationItemSelectedListener(this);

        // CHAT USERS

        // Take email of current user, cut the domain, and use it as name of the user 1
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        int index = email.indexOf('@');
        TestUser1 = email.substring(0,index);

        //Take name of the second user from java class
        TestUser2 = ChatDetails.chatWith;

        //Fixed user 1 - just for testing
        //TestUser1 = "aaaaaa";

        //Fixed user 2 - just for testing
        // TestUser2 = "bbbbbb";


        layout = (LinearLayout) findViewById(R.id.layout1);
        layout_2 = (RelativeLayout)findViewById(R.id.layout2);
        sendButton = (ImageView)findViewById(R.id.sendButton);
        messageArea = (EditText)findViewById(R.id.messageArea);
        scrollView = (ScrollView)findViewById(R.id.scrollView);

        Firebase.setAndroidContext(this);
        //reference1 = new Firebase("https://studentticketsexchange.firebaseio.com/messages/" + UserDetails.username + "_" + UserDetails.chatWith);
       //reference2 = new Firebase("https://studentticketsexchange.firebaseio.com/messages/" + UserDetails.chatWith + "_" + UserDetails.username);

        reference1 = new Firebase("https://studentticketsexchange.firebaseio.com/messages/" + TestUser1 + "/" + TestUser2);
        reference2 = new Firebase("https://studentticketsexchange.firebaseio.com/messages/" + TestUser2 + "/" + TestUser1);

        reference3 = new Firebase("https://studentticketsexchange.firebaseio.com/chats/" + TestUser1 + "_" + TestUser2);
        reference4 = new Firebase("https://studentticketsexchange.firebaseio.com/chats/" + TestUser2 + "_" + TestUser1);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageArea.getText().toString();

                if(!messageText.equals("")){
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("message", messageText);
                    //map.put("user", UserDetails.username);
                    map.put("user", TestUser1);
                    reference1.push().setValue(map);
                    reference2.push().setValue(map);
                    messageArea.setText("");

                    //adding chat to the list of existing chats
                    Map<String, String> map3 = new HashMap<String, String>();
                    map3.put("userInbox", TestUser1);
                    map3.put("chatWith", TestUser2);
                    reference3.setValue(map3);

                    Map<String, String> map4 = new HashMap<String, String>();
                    map4.put("userInbox", TestUser2);
                    map4.put("chatWith", TestUser1);
                    reference4.setValue(map4);

                }
            }
        });



        reference1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map map = dataSnapshot.getValue(Map.class);
                String message = map.get("message").toString();
                String userName = map.get("user").toString();
                // if(userName.equals(UserDetails.username)){
                if(userName.equals(TestUser1)){
                    addMessageBox("You:-\n" + message, 1);
                }
                else{
                    // addMessageBox(UserDetails.chatWith + ":-\n" + message, 2);
                    addMessageBox(TestUser2 + ":-\n" + message, 2);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Override
    // CLOSE KEYBOARD
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }


    public void  addMessageBox (String message, int type) {
        TextView textView = new TextView(Chat.this);
        textView.setText(message);

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp2.weight = 1.0f;

        if(type == 1) {
            lp2.gravity = Gravity.RIGHT;
            textView.setBackgroundResource(R.drawable.bubble_in);
            textView.setTextColor(Color.WHITE);
        }
        else{
            lp2.gravity = Gravity.LEFT;
            textView.setBackgroundResource(R.drawable.bubble_out);
        }
        textView.setLayoutParams(lp2);
        layout.addView(textView);
        scrollView.fullScroll(View.FOCUS_DOWN);
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
//
//        return super.onOptionsItemSelected(item);
//
//    }
}
