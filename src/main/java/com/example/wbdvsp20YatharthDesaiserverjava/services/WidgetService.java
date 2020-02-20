package com.example.wbdvsp20YatharthDesaiserverjava.services;

import com.example.wbdvsp20YatharthDesaiserverjava.models.Widget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetService {
  List<Widget> widgetList = new ArrayList<>();

  {
    Widget w1 = new Widget("123","Widget 1");
    Widget w2 = new Widget("234","Widget 2");
    Widget w3 = new Widget("345","Widget 3");
    widgetList.add(w1);
    widgetList.add(w2);
    widgetList.add(w3);
  }


  public Widget createWidget(Widget widget){
    widgetList.add(widget);
    return widget;
  }

  public void deleteWidget(String wid) {
    widgetList = widgetList
            .stream()
            .filter(w -> !w.getId().equals(wid) )
            .collect(Collectors.toList());
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
}
