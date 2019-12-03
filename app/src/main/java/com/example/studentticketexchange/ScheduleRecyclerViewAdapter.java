package com.example.studentticketexchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScheduleRecyclerViewAdapter extends RecyclerView.Adapter<ScheduleRecyclerViewAdapter.ScheduleViewHolder> {
    private ArrayList<Game> games = new ArrayList<>();
    private Context mContext;

    ScheduleRecyclerViewAdapter(ArrayList<Game> games, Context mContext) {
        this.games = games;
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
        Game game = games.get(position);
        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        holder.dateText.setText(months[game.month - 1] + " " + game.day);
        holder.opponentText.setText(games.get(position).opponent);
//        holder.availableText.setText("");
//        holder.minPriceText.setText("");
//        holder.avgPriceText.setText("");
//        holder.maxPriceText.setText("");
        holder.gameItemParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Now would navigate to ticket options", Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder{
        TextView dateText, opponentText, availableText, minPriceText, avgPriceText, maxPriceText;
        RelativeLayout gameItemParent;
        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.textView_game_date);
            opponentText = itemView.findViewById(R.id.textView_game_opponent);
            availableText = itemView.findViewById(R.id.textView_game_available);
            minPriceText = itemView.findViewById(R.id.textView_game_price_min);
            avgPriceText = itemView.findViewById(R.id.textView_game_price_avg);
            maxPriceText = itemView.findViewById(R.id.textView_game_price_max);
            gameItemParent = itemView.findViewById(R.id.gameItem_layout);
        }
    }
}
