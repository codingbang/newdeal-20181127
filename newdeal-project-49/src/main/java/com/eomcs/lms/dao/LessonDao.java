package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;

public class LessonDao {
  
  public List<Lesson> findAll() throws Exception {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      rs = stmt.executeQuery("select lno, title, cont, sdt, edt, tot_hr, day_hr, mno from lesson");
      
      ArrayList<Lesson> list = new ArrayList<>();
      
      while (rs.next()) {
        Lesson lesson = new Lesson();
        lesson.setNo(rs.getInt("lno"));
        lesson.setTitle(rs.getString("title"));
        lesson.setStartDate(rs.getDate("sdt"));
        lesson.setEndDate(rs.getDate("edt"));
        lesson.setTotalHours(rs.getInt("tot_hr"));
         
        list.add(lesson);
      }
      return list;
      
    } finally {
      try { rs.close(); } catch (Exception e) {}
      try { stmt.close(); } catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
  
  public Board findByNo(int no) throws Exception {
    
    DriverManager.registerDriver(new Driver());
    try ( Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select bno, cont, cdt, view, mno, lno"
            + " from board"
            + " where bno=" + no); ) {
      
      if (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setContents(rs.getString("cont"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("view"));
        board.setWriterNo(rs.getInt("mno"));
        board.setLessonNo(rs.getInt("lno"));
        
        return board;
      } else {
        return null;
      }
    } 
  }
  
  public void insert(Board board) throws Exception {
    
    DriverManager.registerDriver(new Driver()); //안해도 동작함..
    
    try ( Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement(); ) {
      
      
      stmt.executeUpdate("insert into board(cont, mno, lno)"
          + " values('" + board.getContents() +"',"
              + board.getWriterNo() + ","
              + board.getLessonNo() + ")");
     
      System.out.println("입력했습니다!");
     
    }
  }
  
  public void update(Board board) throws Exception {
    
    Connection con = null;
    Statement stmt = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      
      
      stmt.executeUpdate("update board set cont='" + 
          board.getContents() + "' where bno=" + board.getNo());
     
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
      
      
      // SQL을 서버에 전송 => 서버에서 결과를 가져올 일을 할 객체를 리턴
      stmt.executeUpdate("delete from board where bno=" + no);
     
     
    } finally {
      try { stmt.close();} catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
}
