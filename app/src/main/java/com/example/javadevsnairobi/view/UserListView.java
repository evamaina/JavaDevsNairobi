package com.example.javadevsnairobi.view;

import com.example.javadevsnairobi.models.GithubUser;

import java.util.List;

public interface UserListView {

    void usersListReady(List<GithubUser> githubUsers);

    void userDetails(GithubUser user);
}
