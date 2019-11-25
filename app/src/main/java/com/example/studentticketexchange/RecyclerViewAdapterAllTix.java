package com.example.studentticketexchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecyclerViewAdapterAllTix extends RecyclerView.Adapter<RecyclerViewAdapterAllTix.AllTixViewHolder> {

    private ArrayList<Listing> listings = new ArrayList<>();
    private Context mContext;


    RecyclerViewAdapterAllTix(ArrayList<Listing> listings, Context mContext) {
        this.listings = listings;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AllTixViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //In next line, demo video used viewGroup.getContext(), but I changed to parent.getContext() based on the line above
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tix_list_item, parent, false);
        AllTixViewHolder viewHolder = new AllTixViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllTixViewHolder holder, final int position) {
        holder.textViewSection.setText(listings.get(position).section);
        holder.parent_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, listings.get(position).section, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listings.size();
    }

    public class AllTixViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkBoxStudentTix;
        TextView textViewSection, textViewRow, textViewQty, textViewPrice;
        RelativeLayout parent_layout;

        public AllTixViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBoxStudentTix = itemView.findViewById(R.id.checkBoxStudentTix);
            textViewSection = itemView.findViewById(R.id.textViewBuySection);
            textViewRow = itemView.findViewById(R.id.textViewRow);
            textViewQty = itemView.findViewById(R.id.textViewQty);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
