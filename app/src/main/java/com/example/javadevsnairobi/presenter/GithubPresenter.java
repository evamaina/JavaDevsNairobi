package com.example.javadevsnairobi.presenter;

import android.annotation.SuppressLint;

import com.example.javadevsnairobi.models.GithubUser;
import com.example.javadevsnairobi.models.GithubUsersResponse;
import com.example.javadevsnairobi.service.GithubService;
import com.example.javadevsnairobi.view.UserListView;

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
                .get_users()
                .enqueue(new Callback<GithubUsersResponse>() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                        userListView.usersListReady(response.body().getGithubUsers());
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


    public void getUserDetails(String username){
        githubService.getGithubAPI().getUser(username).enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
                userListView.userDetails(response.body());
            }

            @Override
            public void onFailure(Call<GithubUser> call, Throwable t) {

            }
        });
    }

}
