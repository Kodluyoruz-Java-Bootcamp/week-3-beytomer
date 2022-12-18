package com.medium.mediumservice.repository;

import com.medium.mediumservice.model.Story;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StoryDao {

    private static List<Story>storyList=new ArrayList<>();

    public void saveStories(Story story){
        storyList.add(story);
    }

    public List<Story>getStoryList(){
        return  storyList;
    }

    public void deleteStory(Story story){
        storyList.remove(story);
    }
}
