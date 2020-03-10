package com.example.wbdvsp20YatharthDesaiserverjava.controllers;

import com.example.wbdvsp20YatharthDesaiserverjava.models.Widget;
import com.example.wbdvsp20YatharthDesaiserverjava.services.WidgetService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

  WidgetService service = new WidgetService();

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidget(@PathVariable("tid") String topicId,
                             @RequestBody Widget widget){
    System.out.print(widget.getTitle());
    widget.setTopicId(topicId);
    return service.createWidget(widget);
  }

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

  @DeleteMapping("/api/widgets/{widgetId}")
  public int deleteWidget(@PathVariable("widgetId") String wid) {
    return service.deleteWidget(wid);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{widgetId}")
  public Widget findWidgetById(@PathVariable("widgetId") String wid) {
    return service.findWidgetById(wid);
  }

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(@PathVariable("tid") String topicId){
    return service.findWidgetsForTopic(topicId);
  }

  @GetMapping("/api/widget")
  public Widget getWidget(){
    return service.getWidget();
  }

  @GetMapping("/hello")
  public String sayHello() {
    return "Hello World!";
  }
}
