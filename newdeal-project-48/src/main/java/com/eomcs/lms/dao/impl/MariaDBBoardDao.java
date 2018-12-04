package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class MariaDBBoardDao  implements BoardDao{
  
  public List<Board> findAll() throws Exception {
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      
      pstmt = con.prepareStatement("select bno, cont, cdt, view from board");
      rs = pstmt.executeQuery();
      
      ArrayList<Board> list = new ArrayList<>();
      
      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setContents(rs.getString("cont"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("view"));
        
        list.add(board);
      }
      
      return list;
    
    } catch (Exception e) {
      throw e;
    } finally {
      try { rs.close(); } catch (Exception e) {}
      try { pstmt.close();} catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
  
  public Board findByNo(int no) throws Exception {
    
    DriverManager.registerDriver(new Driver());
    try ( Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement pstmt = con.prepareStatement("select bno, cont, cdt, view, mno, lno from board"
            + " where bno=?"); ) {
      pstmt.setInt(1, no);
      
      try (ResultSet rs = pstmt.executeQuery()) {
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
  }
  
  public int insert(Board board) throws Exception {
    
    DriverManager.registerDriver(new Driver()); //안해도 동작함..
    
    try ( Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement pstmt = con.prepareStatement("insert into board(cont, mno, lno) values(?, ?, ?)"); ) {
      
      pstmt.setString(1, board.getContents());
      pstmt.setInt(2, board.getWriterNo());
      pstmt.setInt(3, board.getLessonNo());
      
     return pstmt.executeUpdate();
     
    }
  }
  
  public int update(Board board) throws Exception {
    
    Connection con = null;
    PreparedStatement pstmt = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      pstmt = con.prepareStatement("update board set cont=? where bno=?");
      
      pstmt.setString(1, board.getContents());
      pstmt.setInt(2, board.getNo());
      
      return pstmt.executeUpdate();
     
    } finally {
      try { pstmt.close();} catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
  
  public int delete(int no) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      pstmt = con.prepareStatement("delete from board where bno=?");
      
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();
     
    } finally {
      try { pstmt.close();} catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
}
