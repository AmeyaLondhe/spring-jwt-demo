package com.jwt.springsecurity.repository;

import com.jwt.springsecurity.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepo extends JpaRepository<Topic, Integer> {
}
