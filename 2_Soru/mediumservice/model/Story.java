package com.medium.mediumservice.model;

import java.time.LocalDateTime;

public class Story {

    private Long no;
    private String name;
    private String text;
    private LocalDateTime publishedDate;
    private User user;
    private StoryType type;

    public Story() {
    }

    public Story(Long no, String name, LocalDateTime publishedDate, User user, StoryType type) {
        this.no = no;
        this.name = name;
        this.publishedDate = publishedDate;
        this.user = user;
        this.type = type;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StoryType getType() {
        return type;
    }

    public void setType(StoryType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Story{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", publishedDate=" + publishedDate +
                ", user=" + user +
                ", storyType='" + type + '\'' +
                '}';
    }
}
