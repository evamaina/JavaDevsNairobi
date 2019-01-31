package com.example.javadevsnairobi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.javadevsnairobi.models.GithubUser;
import com.example.javadevsnairobi.models.GithubUsersResponse;
import com.example.javadevsnairobi.presenter.GithubPresenter;
import com.example.javadevsnairobi.service.GithubService;
import com.example.javadevsnairobi.utils.Constants;
import com.example.javadevsnairobi.view.UserListView;

import java.sql.Struct;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity implements UserListView {
    String username;
    String url;
    String profile_pic;
    GithubPresenter presenter;
    TextView followersTextview;
    TextView organizationTextview;
    TextView repoTextview;
    TextView locationTextview;
    TextView usenameTextview;
    TextView urlTextview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("User detail");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        presenter = new GithubPresenter(this);
        followersTextview = findViewById(R.id.follow);
        organizationTextview = findViewById(R.id.org);
        repoTextview = findViewById(R.id.repos);
        locationTextview = findViewById(R.id.location);
        urlTextview = findViewById(R.id.url);
        usenameTextview = findViewById(R.id.username);
        getIntent();
        if (getIntent().getExtras() != null) {
            username = getIntent().getStringExtra(Constants.USERNAME);
            presenter.getUserDetails(username);
            url = getIntent().getStringExtra(Constants.URL);
            profile_pic = getIntent().getStringExtra(Constants.PROFILEPIC);
            ImageView userImageView = findViewById(R.id.avatar);
            Glide.with(this).load(profile_pic).into(userImageView);


        }


        urlTextview.setText(url);

        urlTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/"+username));
                startActivity(browserIntent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void usersListReady(List<GithubUser> githubUsers) {
    }

    @Override
    public void userDetails(GithubUser user) {
        if(user != null){
        followersTextview.setText(user.getFollowers() + " Followers");
        organizationTextview.setText(user.getCompany());
        repoTextview.setText(user.getRepositories() + " Repositories");
        locationTextview.setText(user.getLocation());}
        usenameTextview.setText(user.getUsername());
//        urlTextview.setText(user.getRepos_url());

    }


}
