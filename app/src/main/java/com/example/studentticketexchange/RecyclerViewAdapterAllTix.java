package com.example.studentticketexchange;

import android.content.Context;
import android.content.Intent;
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
    private ArrayList<String> listingKeys = new ArrayList();
    private String opponent;
    private String gameDate;
    private Context mContext;


    RecyclerViewAdapterAllTix(ArrayList<Listing> listings, ArrayList<String> listingKeys, String opponent, String gameDate, Context mContext) {
        this.listings = listings;
        this.listingKeys = listingKeys;
        this.opponent = opponent;
        this.gameDate = gameDate;
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
        final Listing listing = listings.get(position);
        final String key = listingKeys.get(position);
        final String putOpponent = opponent;
        final String putGameDate = gameDate;
        final String sectionAsString = Integer.toString(listing.section);
        final String rowAsString = Integer.toString(listing.row);
        final String qtyAsString = Integer.toString(listing.quantity);
        final String priceAsString = Double.toString(listing.price);
        final Boolean studentChecked = listing.studentTicket;
        holder.textViewSection.setText(sectionAsString);
        holder.textViewQty.setText(qtyAsString);
        holder.textViewPrice.setText(priceAsString);
        holder.textViewRow.setText(rowAsString);
        holder.checkBoxStudentTix.setChecked(studentChecked);
        holder.parent_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent buyTicketDetailsIntent = new Intent(v.getContext(), BuyTicketDetails.class);
                buyTicketDetailsIntent.putExtra("LISTING_KEY", key);
                buyTicketDetailsIntent.putExtra("OPPONENT",putOpponent);
                buyTicketDetailsIntent.putExtra("GAME_DATE",putGameDate);
                mContext.startActivity(buyTicketDetailsIntent);
//                Toast.makeText(mContext, "Section "+sectionAsString, Toast.LENGTH_SHORT).show();
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
            textViewSection = itemView.findViewById(R.id.textViewSection);
            textViewRow = itemView.findViewById(R.id.textViewRow);
            textViewQty = itemView.findViewById(R.id.textViewQty);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
