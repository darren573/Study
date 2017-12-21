package com.darren.study;

/**
 * Created by lenovo on 2017/12/13.
 */

public class Message {
    private String username;
    private String time;
    private String message;
    private int img_id;

    public Message(String username, String time, String message, int img_id) {
        this.username = username;
        this.time = time;
        this.message = message;
        this.img_id = img_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }
}
