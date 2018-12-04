package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class MariaDBLessonDao implements LessonDao {
  
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
  
  public Lesson findByNo(int no) throws Exception {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      DriverManager.registerDriver(new Driver());
       con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
       stmt = con.createStatement();
       rs = stmt.executeQuery("select lno, title, cont, sdt, edt, tot_hr, day_hr, mno "
           + " from lesson"
           + " where lno=" + no);
       
       if (rs.next()) {
         Lesson lesson = new Lesson();
         lesson.setNo(rs.getInt("lno"));
         lesson.setTitle(rs.getString("title"));
         lesson.setContents(rs.getString("cont"));
         lesson.setStartDate(rs.getDate("sdt"));
         lesson.setEndDate(rs.getDate("edt"));
         lesson.setTotalHours(rs.getInt("tot_hr"));
         lesson.setDayHours(rs.getInt("day_hr"));
         lesson.setMemberNo(rs.getInt("mno"));
         return lesson;
       } else {
         return null;
       }
       
    } finally {
      try { rs.close(); } catch (Exception e) {}
      try { stmt.close(); } catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
  
  public void insert(Lesson lesson) throws Exception {
    
    Connection con = null;
    Statement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      stmt.executeUpdate("insert into lesson(title, cont, sdt, edt, tot_hr, day_hr, mno)"
          + " values('" + lesson.getTitle() + "'," + " '" + lesson.getContents() + "' , '" + lesson.getStartDate() + "', '" + lesson.getEndDate()
          + "', " + lesson.getTotalHours() + ", " + lesson.getDayHours() + ", "  + lesson.getMemberNo() + ")"); 

    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
    
  }
  
  public void update(Lesson lesson) throws Exception {
    
    Connection con = null;
    Statement stmt = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();
      
      stmt.executeUpdate("update lesson set title = '"+ lesson.getTitle() +"',"
          + " cont='" + lesson.getContents() + "',"
              + " sdt='" + lesson.getStartDate() + "',"
                  + " edt='" + lesson.getEndDate() + "',"
                      + " tot_hr='" + lesson.getTotalHours() + "',"
                          + " day_hr='" + lesson.getDayHours() + "', mno='" + lesson.getMemberNo() + "' where lno="+ lesson.getNo());
     
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
      
      stmt.executeUpdate("delete from lesson where lno=" + no);
      
    } finally {
      try { stmt.close();} catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
}
