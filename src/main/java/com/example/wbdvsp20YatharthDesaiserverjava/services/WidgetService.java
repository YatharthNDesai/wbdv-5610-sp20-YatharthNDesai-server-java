package com.example.wbdvsp20YatharthDesaiserverjava.services;

import com.example.wbdvsp20YatharthDesaiserverjava.models.Topic;
import com.example.wbdvsp20YatharthDesaiserverjava.models.Widget;
import com.example.wbdvsp20YatharthDesaiserverjava.repositories.TopicRepository;
import com.example.wbdvsp20YatharthDesaiserverjava.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository widgetRepository;

  @Autowired
  TopicRepository topicRepository;


  public Widget createWidget(Integer topicId,Widget widget) {
    Topic topic = topicRepository.findById(topicId).get();
    widget.setTopic(topic);
    return widgetRepository.save(widget);

  }

  public int updateAll(String tid, List<Widget> updateList) {
    System.out.println("Update all called");
    int k = 0;
    List<Widget> widgetList = (List<Widget>) widgetRepository.findAll();
    for (Widget widget : widgetList) {

      if (widget.getTopic().getId().equals(tid)) {
        widget = updateList.get(k);
        widget.setTopic(updateList.get(k).getTopic());
        widgetRepository.save(widget);
        k++;
      }
    }
    return 0;
  }
  public int updateWidget(Integer wid, Widget updateWidget) {

//    Widget widgetToUpdate = widgetRepository.findById(wid).get();
//    widgetToUpdate = updateWidget;
    updateWidget.setTopic(widgetRepository.findById(wid).get().getTopic());
    widgetRepository.save(updateWidget);
//

    return 0;
  }

  public int deleteWidget(Integer wid) {
    widgetRepository.deleteById(wid);
    return 1;
  }

  public List<Widget> findAllWidgets() {
    List<Widget> results = new ArrayList<>();
    return (List<Widget>) widgetRepository.findAll();

  }

//  public Widget getWidget() {
//    Widget w1 = new Widget("123", "Widget 1");
//    return w1;
//  }

  public Widget findWidgetById(Integer wid) {
    return widgetRepository.findById(wid).get();
  }

  public List<Widget> findWidgetsForTopic(Integer topicId) {
    Topic topic = topicRepository.findById(topicId).get();
    return topic.getWidgets();
//    return widgetRepository.findWidgetForTopic(topicId);
  }

}
