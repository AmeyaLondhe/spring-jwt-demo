package com.jwt.springsecurity.controller;

import com.jwt.springsecurity.model.Topic;
import com.jwt.springsecurity.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable int id){
        return topicService.getTopicById(id);
    }

    @PostMapping("/new")
    public void saveTopic(@RequestBody Topic t){
        topicService.saveTopic(t);
    }

    @DeleteMapping("/delete/{id}")
    public List<Topic> deleteTopic(@PathVariable int id){
        return topicService.deleteTopic(id);
    }

    @GetMapping("/current-user")
    public String getCurrentUser(Principal p){
        return p.getName();
    }
}
