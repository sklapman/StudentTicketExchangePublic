package com.example.studentticketexchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InboxRecyclerViewAdapter extends RecyclerView.Adapter <InboxRecyclerViewAdapter.InboxViewHolder> {

    private ArrayList<InboxChat> inboxChats;
    private Context iContext;

    InboxRecyclerViewAdapter(ArrayList<InboxChat> inboxChats, Context iContext) {
        this.inboxChats = inboxChats;
        this.iContext = iContext;

    }


    @NonNull
    @Override
    public InboxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_inbox_item, parent, false);
        InboxViewHolder viewHolder = new InboxViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return inboxChats.size();
    }

    @Override
    public void onBindViewHolder(@NonNull InboxViewHolder holder, final int position) {
        holder.textViewName.setText(inboxChats.get(position).name);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(iContext, inboxChats.get(position).name, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class InboxViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewAvatar;
        TextView textViewName;
        RelativeLayout parentLayout;

        public InboxViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewAvatar = itemView.findViewById(R.id.imageView_InboxAvatar);
            textViewName = itemView.findViewById(R.id.textView_InboxName);
            parentLayout = itemView.findViewById(R.id.parent_layout_Inbox);

        }
    }


}
