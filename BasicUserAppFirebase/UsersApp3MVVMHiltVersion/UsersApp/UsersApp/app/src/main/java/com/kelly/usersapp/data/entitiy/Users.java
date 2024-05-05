package com.kelly.usersapp.data.entitiy;

import java.io.Serializable;

public class Users implements Serializable {
    private String user_id;
    private String user_name;
    private String user_phone;

    public Users(String user_id, String user_name, String user_phone) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_phone = user_phone;
    }

    public Users() {
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
