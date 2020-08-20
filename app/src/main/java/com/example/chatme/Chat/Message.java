package com.example.chatme.Chat;

import com.example.chatme.User.User;

import java.util.Date;

public class Message {
    private String text;
    private Date date;
    private User userFrom;
    private Boolean isOutput;

    public Message(String text, User userFrom, Boolean isOutput) {
        this.text = text;
        this.date = new Date();
        this.userFrom = userFrom;
        this.isOutput = isOutput;
    }

    public String getText() {
        return text;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public Date getDate() {
        return date;
    }
}
