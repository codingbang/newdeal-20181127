package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class MemberAddCommand implements Command {
  
  Scanner keyboard;
  
  public MemberAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    Connection con = null;
    Statement stmt = null;

    try {
      System.out.print("이름? ");
      String name = keyboard.nextLine();

      System.out.print("이메일? ");
      String email = keyboard.nextLine();

      System.out.print("암호? ");
      String pwd = keyboard.nextLine();

      System.out.print("사진? ");
      String photo = keyboard.nextLine();

      System.out.print("전화? ");
      String tel = keyboard.nextLine();


      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      stmt.executeUpdate("insert into member(name, email, pwd, photo, tel)"
          + " values('"+ name + "', '" + email + "', '" + pwd + "', '" + photo + "', '" + tel + "' )");


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
