package com.example.studentticketexchange;

import java.io.File;
import java.io.IOException;

public class InboxChat {

    public String name;
    public String imageUri;

    public File profilePic;

    InboxChat(String name, String photoTitle) {
        this.name = name;
        //this.imageUri = "images/" + photoTitle + ".png";
        this.imageUri = "Anonymous_Avatar.png";

        try {
            profilePic = File.createTempFile(photoTitle, "png");
        } catch (IOException exc) {

        }
    }
}
