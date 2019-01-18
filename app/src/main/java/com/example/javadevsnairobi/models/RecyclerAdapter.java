package com.example.javadevsnairobi.models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javadevsnairobi.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<User> users;
    Context context;

    public RecyclerAdapter(List<User> users, Context context) {
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
        User user = users.get(i);

        viewHolder.image.setImageResource(R.drawable.avatar);
        viewHolder.name.setText(user.getName());
        viewHolder.repositories.setText(new Integer(user.getRepositories()).toString()+" repositories");
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}

class  ViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView name, repositories;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.user_image);
        name = itemView.findViewById(R.id.username);
        repositories = itemView.findViewById(R.id.repositories);

    }
}
