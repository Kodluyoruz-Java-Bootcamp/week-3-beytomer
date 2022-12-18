package com.medium.mediumservice.service;



import com.medium.mediumservice.model.Story;
import com.medium.mediumservice.model.StoryType;
import com.medium.mediumservice.repository.StoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoriesService {
    @Autowired
    private StoryDao storyDao;
    @Autowired
    private UserService userService;

    public void createStory(Story story){
        storyDao.saveStories(story);
    }

    public List<Story> getAll(){
        return storyDao.getStoryList();
    }

    public void deleteStory(Story story){
        storyDao.deleteStory(story);
        System.out.println(story.getNo()+". Story Silindi ..");
    }

    public List<Story>getAllStoriesByUser(String name){
        return getAll().stream().filter(it ->it.getUser().getName().equals(name)).toList();
    }

    public List<Story>getSameStoryTag(StoryType storyType){
        return getAll().stream().filter(it ->it.getType().equals(storyType)).toList();
    }


}
