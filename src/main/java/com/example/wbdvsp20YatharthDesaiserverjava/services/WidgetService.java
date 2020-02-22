package com.example.wbdvsp20YatharthDesaiserverjava.services;

import com.example.wbdvsp20YatharthDesaiserverjava.models.Widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetService {
  List<Widget> widgetList = new ArrayList<>();

  {
    Widget w1 = new Widget("123", "Widget 1");
    w1.setTopicId("cC84CVcTG2bhvuva");
    w1.setSize(1);
    Widget w2 = new Widget("234", "Widget 2");
    w2.setTopicId("cC84CVcTG2bhvuva");
    w2.setSize(3);
    w2.setType("PARAGRAPH");
    Widget w3 = new Widget("345", "Widget 3");
    w3.setSize(5);
    w3.setTopicId("cC84CVcTG2bhvuva");
    Widget w4 = new Widget("456", "Widget 4");
    w4.setTopicId("q8LrdYvcEqi5CeDO");
    w4.setType("PARAGRAPH");
    Widget w5 = new Widget("567", "Widget 5");
    w5.setTopicId("q8LrdYvcEqi5CeDO");
    w5.setType("PARAGRAPH");
    Widget w6 = new Widget("678", "Widget 6");
    w6.setTopicId("q8LrdYvcEqi5CeDO");
    widgetList.add(w1);
    widgetList.add(w2);
    widgetList.add(w3);
    widgetList.add(w4);
    widgetList.add(w5);
    widgetList.add(w6);
  }


  public Widget createWidget(Widget widget) {
//    widget.setOrder(widgetList.size());
    widgetList.add(widget);
    return widget;
  }

  public int updateAll(String tid, List<Widget> updateList) {
    int k = 0;
    for (int i = 0; i < widgetList.size(); i++) {

      if (widgetList.get(i).getTopicId().equals(tid)) {
        widgetList.set(i, updateList.get(k));
        k++;
        return 1;
      }

    }
    return 0;
  }
  public int updateWidget(String wid, Widget updateWidget) {
    for (int i = 0; i < widgetList.size(); i++) {
      if (widgetList.get(i).getId().equals(wid)) {
        widgetList.set(i, updateWidget);
//        Collections.sort(widgetList);
        return 1;
      }
    }
    return 0;
  }

  public int deleteWidget(String wid) {
    widgetList = widgetList
            .stream()
            .filter(w -> !w.getId().equals(wid))
            .collect(Collectors.toList());
    return 1;
  }

  public List<Widget> findAllWidgets() {
    return widgetList;

  }

  public Widget getWidget() {
    Widget w1 = new Widget("123", "Widget 1");
    return w1;
  }

  public Widget findWidgetById(String wid) {
    for (Widget widget : widgetList) {
      if (widget.getId().equals(wid)) {
        System.out.println(widget.getId());
        return widget;
      }
    }
    return null;
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    List<Widget> results = new ArrayList<>();
    for (Widget widget : widgetList) {
      if (widget.getTopicId().equals(topicId)) {
        results.add(widget);
      }
    }
    return results;
  }

}
