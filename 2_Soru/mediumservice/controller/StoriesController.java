package com.medium.mediumservice.controller;

import com.medium.mediumservice.model.Story;
import com.medium.mediumservice.model.StoryType;
import com.medium.mediumservice.service.StoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stories")
public class StoriesController {
    @Autowired
    private StoriesService storiesService;

    @GetMapping
    public List<Story> getAll(){
        return storiesService.getAll();
    }
    @PostMapping
    public void create(@RequestBody Story story){
        storiesService.createStory(story);
    }
    @DeleteMapping
    public void delete(@RequestBody Story story){
        storiesService.deleteStory(story);
    }
    @GetMapping(value = "/{tag}")
    public List<Story>getSameTag(@PathVariable StoryType tag){
        return storiesService.getSameStoryTag(tag);
    }
}
