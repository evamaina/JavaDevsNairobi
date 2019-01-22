package com.example.javadevsnairobi;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.javadevsnairobi.models.RecyclerAdapter;
import com.example.javadevsnairobi.models.User;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    List<User> users;
    RecyclerView.LayoutManager manager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = new ArrayList<>();
        User user = new User();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();
        User user6 = new User();
        User user7 = new User();


        user.setName("Eva Maina");
        user.setRepositories(60);


        user1.setName("Eva Maina");
        user1.setRepositories(60);


        user2.setName("Eva Maina");
        user2.setRepositories(60);

        user3.setName("Eva Maina");
        user3.setRepositories(60);

        user4.setName("Eva Maina");
        user4.setRepositories(60);

        user5.setName("Eva Maina");
        user5.setRepositories(60);

        user6.setName("Eva Maina");
        user6.setRepositories(60);

        user7.setName("Eva Maina");
        user7.setRepositories(60);

        manager = new   LinearLayoutManager(this);
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        adapter = new RecyclerAdapter(users, this);
        recyclerView.setAdapter(adapter);

    }


}
