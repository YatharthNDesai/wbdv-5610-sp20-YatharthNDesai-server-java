package com.example.wbdvsp20YatharthDesaiserverjava.services;

import com.example.wbdvsp20YatharthDesaiserverjava.models.Widget;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WidgetService {
  List<Widget> widgetList = new ArrayList<>();

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
