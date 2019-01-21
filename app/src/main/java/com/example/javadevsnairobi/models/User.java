package com.example.javadevsnairobi.models;

public class User {

    int image;
    String name;
    int repositories;

    public User() {
    }

    public User(int image, String name, int repositories) {
        this.image = image;
        this.name = name;
        this.repositories = repositories;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRepositories() {
        return repositories;
    }

    public void setRepositories(int repositories) {
        this.repositories = repositories;
    }
}
