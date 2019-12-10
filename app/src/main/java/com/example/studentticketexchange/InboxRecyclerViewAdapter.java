package com.example.studentticketexchange;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class InboxRecyclerViewAdapter extends RecyclerView.Adapter <InboxRecyclerViewAdapter.InboxViewHolder> {

    private ArrayList<InboxChat> inboxChats;
    private Context iContext;
    private StorageReference mStorageRef;

    InboxRecyclerViewAdapter(ArrayList<InboxChat> inboxChats, Context iContext) {
        this.inboxChats = inboxChats;
        this.iContext = iContext;
        mStorageRef = FirebaseStorage.getInstance().getReference();
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
    public void onBindViewHolder(@NonNull final InboxViewHolder holder, final int position) {
        holder.textViewName.setText(inboxChats.get(position).name);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(iContext, inboxChats.get(position).name, Toast.LENGTH_SHORT).show();
                ChatDetails.chatWith = "bbbbbb";
                view.getContext().startActivity(new Intent(view.getContext(), Chat.class));

            }
        });

        final File localFile = inboxChats.get(position).profilePic;
        StorageReference AvatarsPicRef = mStorageRef.child(inboxChats.get(position).imageUri);
        AvatarsPicRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        // Successfully downloaded data to local file
                        // ...

                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(iContext.getContentResolver(), Uri.fromFile(localFile));
                            holder.imageViewAvatar.setImageBitmap(bitmap);
                        } catch (IOException exc) {

                        }
                    }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle failed download
                        // ...
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
