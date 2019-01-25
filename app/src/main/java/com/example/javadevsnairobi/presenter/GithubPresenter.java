package com.example.javadevsnairobi.presenter;

import android.util.Log;

import com.example.javadevsnairobi.models.GithubUser;
import com.example.javadevsnairobi.models.GithubUsersResponse;
import com.example.javadevsnairobi.service.GithubService;
import com.example.javadevsnairobi.view.UserListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter {
    private GithubService githubService;
    private UserListView userListView;

    public GithubPresenter(UserListView userListView) {
        this.userListView = userListView;
        if (this.githubService == null) {
            this.githubService = new GithubService();
        }
    }

    public void getGithubUsers() {
        githubService
                .getGithubAPI()
                .users()
                .enqueue(new Callback<GithubUsersResponse>() {
                    @Override
                    public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                        if (response.isSuccessful()) {
                            ArrayList<GithubUser> users = response.body().getGithubUsers();
                        }
                    }

                    @Override
                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something is wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
