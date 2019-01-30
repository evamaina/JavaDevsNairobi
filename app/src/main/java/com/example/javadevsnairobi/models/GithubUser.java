package com.example.javadevsnairobi.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GithubUser implements Parcelable {
    @SerializedName("login")
    private String username;

    @SerializedName("avatar_url")
    private String profilePic;

    @SerializedName("url")
    private String url;

    @SerializedName("followers")
    private String followers;

    @SerializedName("public_repos")
    private String public_repos;

    @SerializedName("repos_url")
    private String repos_url;

    @SerializedName("company")
    private String company;

    @SerializedName("location")
    private String location;


    public GithubUser(String username, String profilePic, String url, String followers, String public_repos, String company, String repos_url, String location) {
        this.username = username;
        this.profilePic = profilePic;
        this.url = url;
        this.followers = followers;
        this.public_repos = public_repos;
        this.company = company;
        this.repos_url = repos_url;
        this.location = location;

    }

    public GithubUser() {
    }

    private GithubUser(Parcel in) {
        username = in.readString();
        profilePic = in.readString();
        url = in.readString();
        followers = in.readString();
        public_repos = in.readString();
        company = in.readString();
        location = in.readString();
    }

    public static final Creator<GithubUser> CREATOR = new Creator<GithubUser>() {
        @Override
        public GithubUser createFromParcel(Parcel source) {
            return new GithubUser(source);
        }

        @Override
        public GithubUser[] newArray(int size) {
            return new GithubUser[size];
        }
    };

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company =company;
    }

    public String getRepositories() {
        return public_repos;
    }

    public void setRepositories(String repositories) {
        this.public_repos = public_repos;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(profilePic);
        dest.writeString(url);
        dest.writeString(followers);
        dest.writeString(public_repos);
        dest.writeString(company);
    }
}

