package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {
  
  Scanner keyboard;
  LessonDao lessonDao;
  
  public LessonUpdateCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {

    try {
      Lesson lesson = new Lesson();
      
      System.out.print("번호? ");
      lesson.setNo(Integer.parseInt(keyboard.nextLine()));
      
      System.out.print("제목? ");
      lesson.setTitle(keyboard.nextLine());
      

      System.out.print("내용? ");
      lesson.setContents(keyboard.nextLine());

      System.out.print("시작일? ");
      lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

      System.out.print("종료일? ");
      lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

      System.out.print("총강의시간? ");
      lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

      System.out.print("일강의시간? ");
      lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

      /*System.out.print("매니저번호? ");
      String mno = keyboard.nextLine();*/

      lessonDao.update(lesson);

      System.out.println("수정하였습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    }

}
  
}
