package com.example.javadevsnairobi;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.javadevsnairobi.models.GithubUser;
import com.example.javadevsnairobi.adapter.GithubAdapter;
import com.example.javadevsnairobi.models.User;
import com.example.javadevsnairobi.presenter.GithubPresenter;
import com.example.javadevsnairobi.utils.Constants;
import com.example.javadevsnairobi.view.UserListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements UserListView {
    RecyclerView recyclerView;
    GithubAdapter adapter;
    List<GithubUser> users;
    RecyclerView.LayoutManager manager;
    GithubPresenter githubPresenter;
    Parcelable githubUsersList;
    public static final String USER_LIST_KEY = "users_list";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = new   LinearLayoutManager(this);

        GithubPresenter githubPresenter = new GithubPresenter(this);
        githubPresenter.getGithubUsers();

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);



        if (savedInstanceState != null) {
            users = savedInstanceState.getParcelableArrayList(USER_LIST_KEY);
            usersListReady(users);
        } else {
            githubPresenter.getGithubUsers();
        }

    }


    @Override
    public void usersListReady(List<GithubUser> githubUsers) {
        adapter = new GithubAdapter(githubUsers, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void userDetails(GithubUser user) {

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        githubUsersList = manager.onSaveInstanceState();
        outState.putParcelable(USER_LIST_KEY, githubUsersList);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null)
            githubUsersList = savedInstanceState.getParcelable(USER_LIST_KEY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (githubUsersList != null) {
            manager.onRestoreInstanceState(githubUsersList);
        }
    }


}
