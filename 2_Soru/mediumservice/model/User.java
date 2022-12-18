package com.medium.mediumservice.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String mail;
    private String password;
    private List<Story> favoriteStoryList;
    private LocalDateTime createDate;
    private List<Story>stories;
    private List<User> followedList=new ArrayList<>();

    public User() {
    }

    public User(String name, String mail, String password, List<Story> stories) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.stories = stories;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Story> getFavoriteStoryList() {
        return favoriteStoryList;
    }

    public void setFavoriteStoryList(List<Story> favoriteStoryList) {
        this.favoriteStoryList = favoriteStoryList;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<User> getFollowedList() {
        return followedList;
    }

    public void addFollowedList(List<User> followedList) {
        this.followedList = followedList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", favoriteStoryList=" + favoriteStoryList +
                ", createDate=" + createDate +
                ", stories=" + stories +
                '}';
    }
}
