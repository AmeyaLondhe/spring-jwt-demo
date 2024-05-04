package com.jwt.springsecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Topic {
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public Topic(int topicId, String topicName, String topicDescription) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
    }
    public Topic(){

    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    @Id
    private Integer topicId;

    private String topicName;
    private String topicDescription;
}
