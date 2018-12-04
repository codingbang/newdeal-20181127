package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class MemberUpdateCommand implements Command {
  
  Scanner keyboard;
  
  public MemberUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    
    Connection con = null;
    Statement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      
      System.out.print("번호? ");
      String mno = keyboard.nextLine();
      
      ResultSet rs = stmt.executeQuery("select name, email, photo, tel from member where mno=" +mno);
      String oldName = "";
      String oldEmail = "";
      String oldPhoto = "";
      String oldTel = "";
      if (rs.next()) {
        oldName = rs.getString("name");
        oldEmail = rs.getString("email");
        oldPhoto = rs.getString("photo");
        oldTel = rs.getString("tel");
      }
      
        
      rs.close();
      
      System.out.printf("이름(%s)? ", oldName);
      String name = keyboard.nextLine();
      
      System.out.printf("이메일(%s)? ", oldEmail);
      String email = keyboard.nextLine();
      
      System.out.printf("암호(********)? ", oldPhoto);
      String pwd = keyboard.nextLine();
      
      System.out.printf("사진(%s)? ", rs.getString("photo"));
      String photo = keyboard.nextLine();
      
      System.out.printf("전화(%s)? ", oldTel);
      String tel = keyboard.nextLine();
      
      
      stmt.executeUpdate("update member set name = '"+ name +"',"
          + " email='" + email + "',"
              + " pwd='" + pwd + "',"
                  + " photo='" + photo + "',"
                      + " tel='" + tel + "' where mno="+mno);


      System.out.println("수정하였습니다.");

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
