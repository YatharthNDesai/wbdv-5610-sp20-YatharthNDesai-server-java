package com.example.wbdvsp20YatharthDesaiserverjava.services;


import com.example.wbdvsp20YatharthDesaiserverjava.models.Topic;
import com.example.wbdvsp20YatharthDesaiserverjava.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
  @Autowired
  TopicRepository topicRepository;

  public List<Topic> findAllTopics() {
    return (List<Topic>)topicRepository.findAll();
  }

  public List<Topic> findTopicsForLesson(String lid) {
    return (List<Topic>)topicRepository.findTopicsForLesson(lid);
  }
}
