package com.example.javadevsnairobi;

import com.example.javadevsnairobi.models.GithubUser;
import com.example.javadevsnairobi.models.GithubUsersResponse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class GithubResponseTest {
    private String username = "username";
    private String profilePic = "profilePic";
    private String url = "url";
    private String followers = "followers";
    private String repos = "repos";

    private GithubUsersResponse githubUsersResponse = new GithubUsersResponse();
    private GithubUser githubUsers = new GithubUser(username, profilePic, url, followers, repos);
    private GithubUser githubUsers1 = new GithubUser(username, profilePic, url, followers, repos);
    private ArrayList<GithubUser> githubUsersArrayList = new ArrayList<>();

    @Test
    public void testGithubResponse() {

        githubUsersArrayList.add(githubUsers);
        githubUsersArrayList.add(githubUsers1);
        githubUsersResponse.setGithubUsers(githubUsersArrayList);
        githubUsersResponse.setTotal_count("2");

        assertEquals("2", githubUsersResponse.getTotal_count());
        assertArrayEquals(new ArrayList[]{githubUsersArrayList}, new List[]{githubUsersResponse.getGithubUsers()});
    }
}
