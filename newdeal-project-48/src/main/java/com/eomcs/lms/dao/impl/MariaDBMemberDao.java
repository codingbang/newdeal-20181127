package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MariaDBMemberDao implements MemberDao {

  @Override
  public Member findByEmailPassword(String email, String password) throws Exception {
    DriverManager.registerDriver(new Driver());
    try ( Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement stmt = con.prepareStatement("select mno, name, email, photo"
            + " from member"
            + " where email=? and pwd=?");) {
      
      stmt.setString(1, email);
      stmt.setString(2, password);
      
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("mno"));
          member.setName(rs.getString("name"));
          member.setEmail(rs.getString("email"));
          member.setPhoto(rs.getString("photo"));
          
          return member;
        } else {
          return null;
        }
      }
    }
  }
  
  
public List<Member> findAll() throws Exception {
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      pstmt = con.prepareStatement("select mno, name, email, tel, cdt from member");
      rs = pstmt.executeQuery();
      
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
      try { pstmt.close(); } catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
  
  public Member findByNo(int no) throws Exception {
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
      DriverManager.registerDriver(new Driver());
       con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
       pstmt = con.prepareStatement("select name, email, pwd, photo, tel, cdt from member where mno=?");
       pstmt.setInt(1, no);
       rs = pstmt.executeQuery();
       
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
      try { pstmt.close(); } catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
  
  public void insert(Member member) throws Exception {
    
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      pstmt = con.prepareStatement("insert into member(name, email, pwd, photo, tel) "
          + " values(?, ?, ?, ?, ?')");
      pstmt.setString(1, member.getName());
      pstmt.setString(2, member.getEmail());
      pstmt.setString(3, member.getPassword());
      pstmt.setString(4, member.getPhoto());
      pstmt.setString(5, member.getTel());
      pstmt.executeUpdate(); 

    } finally {
      try {pstmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
    
  }
  
  public void update(Member member) throws Exception {
    
    Connection con = null;
    PreparedStatement pstmt = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      pstmt = con.prepareStatement("update lesson set name=?, email=?, photo=?, tel=? where mno=?");
      pstmt.setString(1, member.getName());
      pstmt.setString(2, member.getEmail());
      pstmt.setString(3, member.getPhoto());
      pstmt.setString(4, member.getTel());
      pstmt.setInt(5, member.getNo());
          
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
      pstmt = con.prepareStatement("delete from member where mno=?");
      pstmt.setInt(1, no);
      pstmt.executeUpdate();
      
    } finally {
      try { pstmt.close();} catch (Exception e) {}
      try { con.close(); } catch (Exception e) {}
    }
  }
}
