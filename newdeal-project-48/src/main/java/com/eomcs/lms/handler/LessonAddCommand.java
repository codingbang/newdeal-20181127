package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class LessonAddCommand implements Command {

  Scanner keyboard;

  public LessonAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    Connection con = null;
    Statement stmt = null;

    try {
      System.out.print("제목? ");
      String title = keyboard.nextLine();

      System.out.print("내용? ");
      String content = keyboard.nextLine();

      System.out.print("시작일? ");
      String startDate = keyboard.nextLine();

      System.out.print("종료일? ");
      String endDate = keyboard.nextLine();

      System.out.print("총강의시간? ");
      String totalHour = keyboard.nextLine();

      System.out.print("일강의시간? ");
      String dayHour = keyboard.nextLine();

      System.out.print("매니저번호? ");
      String mno = keyboard.nextLine();

      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      stmt.executeUpdate("insert into lesson(title, cont, sdt, edt, tot_hr, day_hr, mno)"
          + " values('" + title + "'," + " '" + content + "' , '" + startDate + "', '" + endDate
          + "', " + totalHour + ", " + dayHour + ",  " + mno + ")");


      System.out.println("저장하였습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        stmt.close();
      } catch (Exception e) {
      }
      try {
        con.close();
      } catch (Exception e) {
      }
    }


  }

}
