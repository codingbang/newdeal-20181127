package com.eomcs.lms;
import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.BoardHandler2;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.LessonHandler2;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.lms.handler.MemberHandler2;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    LessonHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    LessonHandler2.keyboard = keyboard;
    MemberHandler2.keyboard = keyboard;
    BoardHandler2.keyboard = keyboard;
    
    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        LessonHandler.addLesson();
        
      } else if (command.equals("/lesson/list")) {
        LessonHandler.listLesson();
      
      } else if (command.equals("/member/add")) {
        MemberHandler.addMember();
        
      } else if (command.equals("/member/list")) {
        MemberHandler.listMember();
        
      } else if (command.equals("/board/add")) {
        BoardHandler.addBoard();
        
      } else if (command.equals("/board/list")) {
        BoardHandler.listBoard();
        
      } else if (command.equals("/lesson2/add")) {
        LessonHandler2.addLesson();
        
      } else if (command.equals("/lesson2/list")) {
        LessonHandler2.listLesson();
      
      } else if (command.equals("/member2/add")) {
        MemberHandler2.addMember();
        
      } else if (command.equals("/member2/list")) {
        MemberHandler2.listMember();
        
      } else if (command.equals("/board2/add")) {
        BoardHandler2.addBoard();
        
      } else if (command.equals("/board2/list")) {
        BoardHandler2.listBoard();
        
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
