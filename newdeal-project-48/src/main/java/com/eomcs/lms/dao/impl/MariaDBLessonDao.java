package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class MariaDBLessonDao implements LessonDao {
  
  public List<Lesson> findAll() throws Exception {
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      pstmt = con.prepareStatement("select lno, title, cont, sdt, edt, tot_hr, day_hr, mno from lesson");
      rs = pstmt.executeQuery();
      
      
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
      try { pstmt.close(); } catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
  
  public Lesson findByNo(int no) throws Exception {
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
      DriverManager.registerDriver(new Driver());
       con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
       pstmt = con.prepareStatement("select lno, title, cont, sdt, edt, tot_hr, day_hr, mno from lesson where lno=?");
       pstmt.setInt(1, no);
       rs = pstmt.executeQuery();
       
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
      try { pstmt.close(); } catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
  
  public void insert(Lesson lesson) throws Exception {
    
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      pstmt = con.prepareStatement("insert into lesson(title, cont, sdt, edt, tot_hr, day_hr, mno)"
          + " values(?, ?, ?, ?, ?, ?, ?)");
      
      pstmt.setString(1, lesson.getTitle());
      pstmt.setString(2, lesson.getContents());
      pstmt.setDate(3, lesson.getStartDate());
      pstmt.setDate(4, lesson.getEndDate());
      pstmt.setInt(5, lesson.getTotalHours());
      pstmt.setInt(6, lesson.getDayHours());
      pstmt.setInt(7, lesson.getMemberNo());
      
      
      pstmt.executeUpdate(); 

    } finally {
      try {pstmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
    
  }
  
  public void update(Lesson lesson) throws Exception {
    
    Connection con = null;
    PreparedStatement pstmt = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      pstmt = con.prepareStatement("update lesson set title=?, cont=?, sdt=?, edt=? tot_hr=?, day_hr=?, mno=? where lno=?");
      pstmt.setString(1, lesson.getTitle());
      pstmt.setString(2, lesson.getContents());
      pstmt.setDate(3, lesson.getStartDate());
      pstmt.setDate(4, lesson.getEndDate());
      pstmt.setInt(5, lesson.getTotalHours());
      pstmt.setInt(6, lesson.getDayHours());
      pstmt.setInt(7, lesson.getMemberNo());
      pstmt.setInt(8, lesson.getNo());
      
      pstmt.executeUpdate();
     
    } finally {
      try { pstmt.close();} catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
  
  public void delete(int no) throws Exception {
    
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      pstmt = con.prepareStatement("delete from lesson where lno=?");
      pstmt.setInt(1, no);
      pstmt.executeUpdate();
      
    } finally {
      try { pstmt.close();} catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
}
