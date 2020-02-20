package com.example.wbdvsp20YatharthDesaiserverjava.controllers;

import com.example.wbdvsp20YatharthDesaiserverjava.models.Widget;
import com.example.wbdvsp20YatharthDesaiserverjava.services.WidgetService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WidgetController {

  WidgetService service = new WidgetService();

  @PostMapping("/api/widgets")
  public Widget createWidget(@RequestBody Widget widget){
    return service.createWidget(widget);
  }

  @DeleteMapping("/api/widgets/{widgetId}")
  public void deleteWidget(@PathVariable("widgetId") String wid) {
    service.deleteWidget(wid);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{widgetId}")
  public Widget findWidgetById(@PathVariable("widgetId") String wid) {
    return service.findWidgetById(wid);
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
