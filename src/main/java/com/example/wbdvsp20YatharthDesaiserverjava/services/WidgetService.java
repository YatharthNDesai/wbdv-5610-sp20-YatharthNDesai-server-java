package com.example.wbdvsp20YatharthDesaiserverjava.services;

import com.example.wbdvsp20YatharthDesaiserverjava.models.Widget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetService {
  List<Widget> widgetList = new ArrayList<>();

  {
    Widget w1 = new Widget("123","Widget 1");
    w1.setTopicId("X9HxiEwdCOTAbLbL");
    Widget w2 = new Widget("234","Widget 2");
    w2.setTopicId("X9HxiEwdCOTAbLbL");
    w2.setType("PARAGRAPH");
    Widget w3 = new Widget("345","Widget 3");
    w3.setTopicId("X9HxiEwdCOTAbLbL");
    Widget w4 = new Widget("456","Widget 4");
    w4.setTopicId("q8LrdYvcEqi5CeDO");
    w4.setType("PARAGRAPH");
    Widget w5 = new Widget("567","Widget 5");
    w5.setTopicId("q8LrdYvcEqi5CeDO");
    w5.setType("PARAGRAPH");
    Widget w6 = new Widget("678","Widget 6");
    w6.setTopicId("q8LrdYvcEqi5CeDO");
    widgetList.add(w1);
    widgetList.add(w2);
    widgetList.add(w3);
    widgetList.add(w4);
    widgetList.add(w5);
    widgetList.add(w6);
  }


  public Widget createWidget(Widget widget){

    widgetList.add(widget);
    return widget;
  }

  public int deleteWidget(String wid) {
    widgetList = widgetList
            .stream()
            .filter(w -> !w.getId().equals(wid) )
            .collect(Collectors.toList());
    return 1;
  }

  public List<Widget> findAllWidgets() {
    return widgetList;

  }
  public Widget getWidget(){
    Widget w1 = new Widget("123","Widget 1");
    return w1;
  }

  public Widget findWidgetById(String wid) {
    for(Widget widget : widgetList){
      if(widget.getId().equals(wid)){
        System.out.println(widget.getId());
        return widget;
      }
    }
    return null;
  }
  public List<Widget> findWidgetsForTopic(String topicId){
    List<Widget> results = new ArrayList<>();
    for(Widget widget : widgetList){
      if(widget.getTopicId().equals(topicId)){
        results.add(widget);
      }
    }
    return results;
  }

}
