package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@Component("/lesson/detail")
public class LessonDetailCommand implements Command {
  
  Scanner keyboard;
  LessonDao lessonDao;
  
  public LessonDetailCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {
    
    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      
      Lesson lesson = lessonDao.findByNo(no);
       
      if (lesson != null) {
        System.out.printf("번호: %d\n", lesson.getNo());
        System.out.printf("제목: %s\n", lesson.getTitle());
        System.out.printf("내용: %s\n", lesson.getContents());
        System.out.printf("시작일: %s\n", lesson.getStartDate());
        System.out.printf("종료일: %s\n", lesson.getEndDate());
        System.out.printf("총강의시간: %d\n", lesson.getTotalHours());
        System.out.printf("일강의시간: %d\n", lesson.getDayHours());
        //System.out.printf("매니저번호: %d\n", );
      } else {
        System.out.println("해당하는 강의가 없습니다.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

}
  

}
