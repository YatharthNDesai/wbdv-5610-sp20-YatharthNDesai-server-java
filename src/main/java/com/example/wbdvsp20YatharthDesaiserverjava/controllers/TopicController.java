package com.example.wbdvsp20YatharthDesaiserverjava.controllers;


import com.example.wbdvsp20YatharthDesaiserverjava.models.Topic;
import com.example.wbdvsp20YatharthDesaiserverjava.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

  @Autowired
  TopicService topicService;

  @GetMapping("/api/topics")
  public List<Topic> findAllTopics() {
    return topicService.findAllTopics();
  }

  @GetMapping("/api/lessons/{lessonId}/topics")
  public List<Topic> findTopicsForLesson(@PathVariable("lessonId") String lid) {
    return topicService.findTopicsForLesson(lid);
  }
}
