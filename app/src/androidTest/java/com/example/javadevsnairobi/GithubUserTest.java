package com.example.javadevsnairobi;



import android.os.Parcel;

import com.example.javadevsnairobi.models.GithubUser;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GithubUserTest {
    private String username = "username";
    private String profilePic = "profilePic";
    private String url = "url";
    private String followers = "followers";
    private String public_repos = "public_repos";
    private String company = "company";
    private String location = "location";
    private String repos_url = "repos_url";

    private GithubUser userInfo() {
        GithubUser githubUsers = new GithubUser();
        githubUsers.setUsername(username);
        githubUsers.setProfilePic(profilePic);
        githubUsers.setUrl(url);
        githubUsers.setFollowers(followers);
        githubUsers.setRepositories(public_repos);
        githubUsers.setCompany(company);
        githubUsers.setRepos_url(repos_url);
        githubUsers.setLocation(location);

        return githubUsers;

    }

    @Test
    public void testUserDetail() {
        GithubUser githubUsers = userInfo();
        assertEquals(username, githubUsers.getUsername());
        assertEquals(profilePic, githubUsers.getProfilePic());
        assertEquals(url, githubUsers.getUrl());
        assertEquals(followers, githubUsers.getFollowers());
        githubUsers.setRepositories(public_repos);
        assertEquals(public_repos, githubUsers.getRepositories());
        assertEquals(company,githubUsers.getCompany());
        assertEquals(location, githubUsers.getLocation());
        assertEquals(repos_url,githubUsers.getRepos_url());
    }

    @Test
    public void GithubUserParcelable() {
        GithubUser githubUsers = userInfo();
        Parcel parcel = Parcel.obtain();
        githubUsers.writeToParcel(parcel, githubUsers.describeContents());
        parcel.setDataPosition(0);
        GithubUser createdFromParcel = GithubUser.CREATOR.createFromParcel(parcel);
        assertThat(createdFromParcel.getUsername(), is("username"));
        assertThat(createdFromParcel.getProfilePic(), is("profilePic"));
        assertThat(createdFromParcel.getUrl(), is("url"));
        assertThat(createdFromParcel.getFollowers(), is("followers"));
        assertThat(createdFromParcel.getRepositories(), is("public_repos"));
        assertThat(createdFromParcel.getCompany(), is("company"));


    }




}
