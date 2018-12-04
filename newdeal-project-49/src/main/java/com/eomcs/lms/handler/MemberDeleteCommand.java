package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class MemberDeleteCommand implements Command {
  
  Scanner keyboard;
  
  public MemberDeleteCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    
    Connection con = null;
    Statement stmt = null;
    
    try {
      DriverManager.registerDriver(new Driver()); //안해도 동작함..
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      
      System.out.print("번호? ");
      String no = keyboard.nextLine();
      
      // SQL을 서버에 전송 => 서버에서 결과를 가져올 일을 할 객체를 리턴
      stmt.executeUpdate("delete from member where mno=" + no);
     
      System.out.println("삭제했습니다!");
     
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try { stmt.close();} catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
    
  }
  
}
