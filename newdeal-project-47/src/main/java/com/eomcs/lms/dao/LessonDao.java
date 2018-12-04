package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonDao {
  
  public List<Lesson> findAll() throws Exception;
  
  public Lesson findByNo(int no) throws Exception;
  
  public void insert(Lesson lesson) throws Exception;
  
  public void update(Lesson lesson) throws Exception;
  
  public void delete(int no) throws Exception;
}
