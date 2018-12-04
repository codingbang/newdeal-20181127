package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonDao {
  
  List<Lesson> findAll() throws Exception;
  
  Lesson findByNo(int no) throws Exception;
  
  void insert(Lesson lesson) throws Exception;
  
  void update(Lesson lesson) throws Exception;
  
  void delete(int no) throws Exception;
}
