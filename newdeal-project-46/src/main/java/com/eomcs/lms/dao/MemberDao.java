package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Member;

public class MemberDao {
  
  public List<Member> findAll() throws Exception {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      rs = stmt.executeQuery("select mno, name, email, tel, cdt from member");
      
      ArrayList<Member> list = new ArrayList<>();
      
      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("mno"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setTel(rs.getString("tel"));
        member.setRegisteredDate(rs.getDate("cdt"));
        
        list.add(member);
      }
      return list;
      
    } finally {
      try { rs.close(); } catch (Exception e) {}
      try { stmt.close(); } catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
  
  public Member findByNo(int no) throws Exception {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      DriverManager.registerDriver(new Driver());
       con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
       stmt = con.createStatement();
       rs = stmt.executeQuery("select name, email, pwd, photo, tel, cdt from member where mno=" + no);
       
       if (rs.next()) {
         Member member = new Member();
         member.setName(rs.getString("name"));
         member.setEmail(rs.getString("email"));
         member.setPassword(rs.getString("pwd"));
         member.setPhoto(rs.getString("photo"));
         member.setTel(rs.getString("tel"));
         member.setRegisteredDate(rs.getDate("cdt"));

         return member;
       } else {
         return null;
       }
       
    } finally {
      try { rs.close(); } catch (Exception e) {}
      try { stmt.close(); } catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
  
  public void insert(Member member) throws Exception {
    
    Connection con = null;
    Statement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      stmt.executeUpdate("insert into member(name, email, pwd, photo, tel) "
          + " values('" + member.getName() + "', '" + member.getEmail() + "', '"+ member.getPassword() +"', '"
          + member.getPhoto() +"', '" + member.getTel() + "')"); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
    
  }
  
  public void update(Member member) throws Exception {
    
    Connection con = null;
    Statement stmt = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      stmt.executeUpdate("update lesson set name = '"+ member.getName() +"',"
          + " email='" + member.getEmail() + "',"
              + " photo='" + member.getPhoto() + "',"
                  + " tel='" + member.getTel() + " where mno="+ member.getNo());
     
    } finally {
      try { stmt.close();} catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
  
  public void delete(int no) throws Exception {
    
    Connection con = null;
    Statement stmt = null;
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      
      stmt.executeUpdate("delete from member where mno=" + no);
      
    } finally {
      try { stmt.close();} catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
}
