package com.example.javadevsnairobi.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GithubUsersResponse {

    public GithubUsersResponse() {
    }

    @SerializedName("items")

    List<GithubUser> githubUsers;

    @SerializedName("total_count")

    private String total_count;

    public GithubUsersResponse(ArrayList<GithubUser> users, String total_count) {
        this.githubUsers = users;
        this.total_count = total_count;
    }

    public List<GithubUser> getGithubUsers() {
        return githubUsers;
    }

    public void setGithubUsers(ArrayList<GithubUser> users) {
        this.githubUsers = users;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }



}
