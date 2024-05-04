package com.jwt.springsecurity.service;

import com.jwt.springsecurity.model.Topic;
import com.jwt.springsecurity.repository.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepo topicRepo;

    List<Topic> topics = new ArrayList<>();

    public List<Topic> getAllTopics(){
        return topicRepo.findAll();
    }

    public Topic getTopicById(Integer id){
        return topicRepo.getReferenceById(id);
    }

    public void saveTopic(Topic t){
        topicRepo.save(t);
    }

    public List<Topic> deleteTopic(@PathVariable Integer id){
        topicRepo.deleteById(id);
        return topicRepo.findAll();
    }
}
