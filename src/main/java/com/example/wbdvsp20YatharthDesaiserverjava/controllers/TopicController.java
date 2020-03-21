package com.example.wbdvsp20YatharthDesaiserverjava.controllers;


import com.example.wbdvsp20YatharthDesaiserverjava.models.Topic;
import com.example.wbdvsp20YatharthDesaiserverjava.models.Widget;
import com.example.wbdvsp20YatharthDesaiserverjava.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

  @Autowired
  TopicService topicService;

  @PostMapping("/api/lessons/{lid}/topics")
  public Topic createTopic(@PathVariable("lid") String lessonId,
                           @RequestBody Topic topic){

    return topicService.createTopic(lessonId,topic);
  }

  @PutMapping("/api/topics/{topicId}")
  public int updateWidget(@PathVariable("topicId") Integer tid,
                          @RequestBody Topic updateTopic){

    return topicService.updateTopic(tid,updateTopic);
  }
  @DeleteMapping("/api/topics/{topicId}")
  public int deleteWidget(@PathVariable("topicId") Integer wid) {
    return topicService.deleteTopic(wid);
  }


  @GetMapping("/api/topics")
  public List<Topic> findAllTopics() {
    return topicService.findAllTopics();
  }

  @GetMapping("/api/lessons/{lessonId}/topics")
  public List<Topic> findTopicsForLesson(@PathVariable("lessonId") String lid) {
    return topicService.findTopicsForLesson(lid);
  }


}
