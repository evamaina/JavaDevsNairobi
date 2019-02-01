package com.example.javadevsnairobi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Parcelable;
//import android.support.v7.widget.LinearLayoutManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.javadevsnairobi.models.GithubUser;
import com.example.javadevsnairobi.adapter.GithubAdapter;
import com.example.javadevsnairobi.models.User;
import com.example.javadevsnairobi.presenter.GithubPresenter;
import com.example.javadevsnairobi.utils.Constants;
import com.example.javadevsnairobi.view.LoadListener;
import com.example.javadevsnairobi.view.UserListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements UserListView, SwipeRefreshLayout.OnRefreshListener, LoadListener {
    RecyclerView recyclerView;
    GithubAdapter adapter;
    List<GithubUser> users;
    GridLayoutManager gridLayoutManager;
    GithubPresenter githubPresenter;
    Parcelable githubUsersList;
    public static final String USER_LIST_KEY = "users_list";
    SwipeRefreshLayout swipeRefreshLayout;
    ProgressDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayoutManager = new GridLayoutManager(this, 2);
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);

       fetchUsers();

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);

        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("loading...");
        dialog.show();




        if (savedInstanceState != null) {
            users = savedInstanceState.getParcelableArrayList(USER_LIST_KEY);
            usersListReady(users);
        } else {
            fetchUsers();
        }

    }


    @Override
    public void usersListReady(List<GithubUser> githubUsers) {
        adapter = new GithubAdapter(githubUsers, this);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void userDetails(GithubUser user) {


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        githubUsersList = gridLayoutManager.onSaveInstanceState();
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
            gridLayoutManager.onRestoreInstanceState(githubUsersList);
        }
    }

    @Override
    public void onRefresh() {
        fetchUsers();
    }

    private void fetchUsers() {
        GithubPresenter githubPresenter = new GithubPresenter(this, this);
        githubPresenter.getGithubUsers();
    }


    @Override
    public void isLoading(boolean hasLoaded) {
        if (hasLoaded && swipeRefreshLayout.isRefreshing()){
            swipeRefreshLayout.setRefreshing(false);
        }
        else if(hasLoaded && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
