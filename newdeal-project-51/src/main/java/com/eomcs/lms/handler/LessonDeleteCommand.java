package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;

@Component("/lesson/delete")
public class LessonDeleteCommand implements Command {

  Scanner keyboard;
  LessonDao lessonDao;

  public LessonDeleteCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {

    try {
      System.out.print("게시글번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      lessonDao.delete(no);

      System.out.println("삭제했습니다!");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
