package com.example.wbdvsp20YatharthDesaiserverjava.controllers;

import com.example.wbdvsp20YatharthDesaiserverjava.models.Widget;
import com.example.wbdvsp20YatharthDesaiserverjava.services.WidgetService;

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
public class WidgetController {

@Autowired
  WidgetService service;

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidget(@PathVariable("tid") Integer topicId,
                             @RequestBody Widget widget){

    return service.createWidget(topicId,widget);
  }
//
//  @GetMapping("/api//widgets/create")
//  public Widget createWidgetTest(){
//    Widget w1 = new Widget();
//    w1.setTitle("New Widget");
//    w1.setSize(4);
//    return service.createWidget(w1);
//  }

  @PutMapping("/api/widgets/{widgetId}")
  public int updateWidget(@PathVariable("widgetId") String wid,
                          @RequestBody Widget updateWidget){

    return service.updateWidget(wid,updateWidget);
  }

  @PutMapping("/api/topics/{tid}/widgets")
  public int updateAll(@PathVariable("tid") String tid,
                       @RequestBody List<Widget> updateList) {
    return service.updateAll(tid,updateList);
  }

  @GetMapping("/api/delete/widgets/{widgetId}")
  public int deleteWidgetTest(@PathVariable("widgetId") Integer wid) {
    return service.deleteWidget(wid);
  }

  @DeleteMapping("/api/widgets/{widgetId}")
  public int deleteWidget(@PathVariable("widgetId") Integer wid) {
    return service.deleteWidget(wid);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{widgetId}")
  public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
    return service.findWidgetById(wid);
  }

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(@PathVariable("tid") Integer topicId){
    return service.findWidgetsForTopic(topicId);
  }
}
