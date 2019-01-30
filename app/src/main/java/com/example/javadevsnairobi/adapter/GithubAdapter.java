package com.example.javadevsnairobi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.javadevsnairobi.DetailActivity;
import com.example.javadevsnairobi.MainActivity;
import com.example.javadevsnairobi.R;
import com.example.javadevsnairobi.models.GithubUser;
import com.example.javadevsnairobi.utils.Constants;

import java.util.List;

public class GithubAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<GithubUser> users;
    Context context;

    public GithubAdapter(List<GithubUser> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater  inflater = LayoutInflater.from(context);
        View user_view = inflater.inflate(R.layout.user_view, viewGroup, false);
        return new ViewHolder(user_view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final GithubUser user = users.get(i);

        Glide.with(context).load(user.getProfilePic()).into(viewHolder.image);
        viewHolder.name.setText(user.getUsername());
        viewHolder.repositories.setText((user.getRepos_url() +" repositories"));
        viewHolder.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent =  new Intent(context, DetailActivity.class);
             intent.putExtra(Constants.USERNAME, user.getUsername());
             intent.putExtra(Constants.URL, user.getUrl());
             intent.putExtra(Constants.PROFILEPIC, user.getProfilePic());
             context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users != null ? users.size() : 0;
    }

}

class  ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView image;
    TextView name, repositories;
    View.OnClickListener listener;

    public ViewHolder(@NonNull View itemView, View.OnClickListener listener) {
        super(itemView);
        this.listener = listener;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.user_image);
        name = itemView.findViewById(R.id.username);
        repositories = itemView.findViewById(R.id.repositories);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        listener.onClick(v);

    }
}
