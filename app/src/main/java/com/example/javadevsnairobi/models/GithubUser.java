package com.example.javadevsnairobi.models;

import com.google.gson.annotations.SerializedName;

public class GithubUser {
    @SerializedName("login")
    private String username;

    @SerializedName("avatar_url")
    private String profilePic;

    @SerializedName("url")
    private String url;

    @SerializedName("followers_url")
    private String followers;

    @SerializedName("repos_url")
    private String repositories;

    public GithubUser(String username, String profilePic, String url, String followers, String repositories) {
        this.username = username;
        this.profilePic = profilePic;
        this.url = url;
        this.followers = followers;
        this.repositories = repositories;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getRepositories() {
        return repositories;
    }

    public void setRepositories(String repositories) {
        this.repositories = repositories;
    }
}

