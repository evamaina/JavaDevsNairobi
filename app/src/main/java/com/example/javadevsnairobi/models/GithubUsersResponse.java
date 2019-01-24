package com.example.javadevsnairobi.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GithubUsersResponse {

    @SerializedName("item")

    ArrayList<GithubUser> users;

    @SerializedName("total_count")

    private String total_count;

    public GithubUsersResponse(ArrayList<GithubUser> users, String total_count) {
        this.users = users;
        this.total_count = total_count;
    }

    public ArrayList<GithubUser> getGithubUsers() {
        return users;
    }

    public void setGithubUsers(ArrayList<GithubUser> users) {
        this.users = users;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }



}
