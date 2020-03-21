package com.example.wbdvsp20YatharthDesaiserverjava.services;


import com.example.wbdvsp20YatharthDesaiserverjava.models.Topic;
import com.example.wbdvsp20YatharthDesaiserverjava.models.Widget;
import com.example.wbdvsp20YatharthDesaiserverjava.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
  @Autowired
  TopicRepository topicRepository;

  public Topic createTopic(String lid, Topic topic){
    topic.setLessonId(lid);
    return topicRepository.save(topic);
  }

  public List<Topic> findAllTopics() {
    return (List<Topic>)topicRepository.findAll();
  }

  public List<Topic> findTopicsForLesson(String lid) {
    return (List<Topic>)topicRepository.findTopicsForLesson(lid);
  }

  public int updateTopic(Integer tid, Topic updateTopic) {

//    Widget widgetToUpdate = widgetRepository.findById(wid).get();
//    widgetToUpdate = updateWidget;
//    updateTopic.setTopic(widgetRepository.findById(wid).get().getTopic());
    Topic topicToUpdate = topicRepository.findById(tid).get();
    topicToUpdate.setTitle(updateTopic.getTitle());
    topicRepository.save(topicToUpdate);
//

    return 0;
  }

  public int deleteTopic(Integer tid) {
    topicRepository.deleteById(tid);
    return 1;
  }
}
