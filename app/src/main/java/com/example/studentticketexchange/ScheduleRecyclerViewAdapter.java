package com.example.studentticketexchange;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ScheduleRecyclerViewAdapter extends RecyclerView.Adapter<ScheduleRecyclerViewAdapter.ScheduleViewHolder> {
    private ArrayList<Game> games = new ArrayList<>();
    private ArrayList<String> gameKeys = new ArrayList<>();
    private Context mContext;

    ScheduleRecyclerViewAdapter(ArrayList<Game> games, ArrayList<String> gameKeys, Context mContext) {
        this.games = games;
        this.gameKeys = gameKeys;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_schedule_game_item, parent, false);
        ScheduleViewHolder viewHolder = new ScheduleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        final String key = gameKeys.get(position);
        final Game game = games.get(position);
        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        final String dateStr = months[game.month - 1] + " " + game.day;
        holder.dateText.setText(dateStr);
        holder.opponentText.setText(game.opponent);


        int numTickets = 0; //Temporarily just set to zero, really we would find all tickets
        if(numTickets == 0) {
            holder.availableText.setText("");
            holder.minPriceText.setText("");
            holder.avgPriceText.setText("");
            holder.maxPriceText.setText("");
            holder.noTicketsText.setText("Sold Out");
            holder.gameItemParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent allTixIntent = new Intent(view.getContext(), AllTicketsForGame.class);
                    String game_opponent = game.opponent;
                    String game_date = game.month + "/" + game.day + "/" + game.year;
                    String game_id = key;
                    allTixIntent.putExtra("OPPONENT",game_opponent);
                    allTixIntent.putExtra("GAME_DATE",game_date);
                    allTixIntent.putExtra("GAME_KEY",key);
                    mContext.startActivity(allTixIntent);
                    Toast.makeText(mContext, "No tickets available for " + game.opponent +
                            " game on " + dateStr + ". Pleae select a different game.", Toast.LENGTH_LONG).show();
                }
            });
        }
        // else set the numAvailable, minPrice, avgPrice, maxPrice

    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder{
        TextView dateText, opponentText, availableText, minPriceText, avgPriceText, maxPriceText, noTicketsText;
        RelativeLayout gameItemParent;
        public ScheduleViewHolder(@NonNull View itemView) {//comment
            super(itemView);
            dateText = itemView.findViewById(R.id.textView_game_date);
            opponentText = itemView.findViewById(R.id.textView_game_opponent);
            availableText = itemView.findViewById(R.id.textView_game_available);
            minPriceText = itemView.findViewById(R.id.textView_game_price_min);
            avgPriceText = itemView.findViewById(R.id.textView_game_price_avg);
            maxPriceText = itemView.findViewById(R.id.textView_game_price_max);
            gameItemParent = itemView.findViewById(R.id.gameItem_layout);
            noTicketsText = itemView.findViewById(R.id.textView_game_noTicketsAvailable);
        }
    }
}
