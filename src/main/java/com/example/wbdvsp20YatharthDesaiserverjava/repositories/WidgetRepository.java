package com.example.wbdvsp20YatharthDesaiserverjava.repositories;

import com.example.wbdvsp20YatharthDesaiserverjava.models.Widget;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

public interface WidgetRepository
        extends CrudRepository<Widget, Integer> {
  // SELECT * FROM widgets WHERE topic_id=tid
  @Query(value = "SELECT * FROM widgets WHERE topic_id=:tid", nativeQuery = true)
  public List<Widget> findWidgetForTopic(@Param("tid") Integer topicId);
}
