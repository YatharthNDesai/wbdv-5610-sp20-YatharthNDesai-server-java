package com.example.wbdvsp20YatharthDesaiserverjava.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "widgets")
public class Widget {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;
  private String type = "HEADING";
  private int size = 2;
  private String paragraph;
  private String url;

  public String getList() {
    return list;
  }

  public void setList(String list) {
    this.list = list;
  }

  private String list = "Unordered List";

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @ManyToOne
  @JsonIgnore
  private Topic topic;

//  public Integer getOrder() {
//    return order;
//  }
//
//  public void setOrder(int order) {
//    this.order = order;
//  }

  public Topic getTopic() {
    return topic;
  }

  public void setTopic(Topic topic) {
    this.topic = topic;
  }

  public String getParagraph() {
    return paragraph;
  }

  public void setParagraph(String paragraph) {
    this.paragraph = paragraph;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Widget() {
  }

  public Widget(Integer id, String title) {
    this.id = id;
    this.title = title;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

//  @Override
//  public int compareTo(Widget widget) {
//    return this.getOrder().compareTo(widget.getOrder());
//  }
}
