package com.example.javadevsnairobi.service;
import com.example.javadevsnairobi.models.GithubUser;
import com.example.javadevsnairobi.models.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubAPI {

    @GET("search/users?q=language:java+location:nairobi")
    Call<GithubUsersResponse> users();

    @GET("users/{username}")
    Call<GithubUser> getUser(@Path("username") String username);


}


