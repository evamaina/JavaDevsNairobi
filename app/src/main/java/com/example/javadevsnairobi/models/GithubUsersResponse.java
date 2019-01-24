package com.example.javadevsnairobi.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GithubUsersResponse {

    @SerializedName("")

    ArrayList<GithubUser> GithubUsers;

    @SerializedName("total_count")

    private String total_count;

    public GithubUsersResponse(ArrayList<GithubUser> GithubUsers, String total_count) {
        this.GithubUsers = GithubUsers;
        this.total_count = total_count;
    }

    public ArrayList<GithubUser> getGithubUsers() {
        return GithubUsers;
    }

    public void setGithubUsers(ArrayList<GithubUser> GithubUsers) {
        this.GithubUsers = GithubUsers;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }



}
