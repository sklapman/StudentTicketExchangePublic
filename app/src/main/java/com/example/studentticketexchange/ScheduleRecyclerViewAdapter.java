package com.example.studentticketexchange;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScheduleRecyclerViewAdapter {
    public class ScheduleViewHolder extends RecyclerView.ViewHolder{
        TextView dateText, opponentText, availableText, minPriceText, avgPriceText, maxPriceTest;

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
