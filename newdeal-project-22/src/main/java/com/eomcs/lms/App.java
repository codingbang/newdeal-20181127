package com.eomcs.lms;
import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    
    MemberHandler m1 = new MemberHandler(keyboard);
    MemberHandler m2 = new MemberHandler(keyboard);
    
    LessonHandler l1 = new LessonHandler(keyboard);
    LessonHandler l2 = new LessonHandler(keyboard);

    BoardHandler b1 = new BoardHandler(keyboard);
    BoardHandler b2 = new BoardHandler(keyboard);
    
    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        l1.addLesson();
        
      } else if (command.equals("/lesson/list")) {
        l1.listLesson();
      
      } else if (command.equals("/lesson2/add")) {
        l2.addLesson();
        
      } else if (command.equals("/lesson2/list")) {
        l2.listLesson();
      
      } else if (command.equals("/member/add")) {
        m1.addMember();
        
      } else if (command.equals("/member/list")) {
        m1.listMember();
        
      }else if (command.equals("/member2/add")) {
        m2.addMember();
        
      } else if (command.equals("/member2/list")) {
        m2.listMember();
        
      } else if (command.equals("/board/add")) {
        b1.addBoard();
        
      } else if (command.equals("/board/list")) {
        b1.listBoard();
        
      } else if (command.equals("/board2/add")) {
        b2.addBoard();
        
      } else if (command.equals("/board2/list")) {
        b2.listBoard();
        
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      
      System.out.println(); 
    }

    keyboard.close();
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
