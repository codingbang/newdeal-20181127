package com.eomcs.lms.dao.impl;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MariaDBMemberDao implements MemberDao {
  
  SqlSessionFactory sqlSessionFactory;
  
  public MariaDBMemberDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public Member findByEmailPassword(String email, String password) throws Exception {
    
    try ( SqlSession sqlSession = sqlSessionFactory.openSession() ) {
      HashMap<String, Object> params = new HashMap<>();
      params.put("email", email);
      params.put("password", password);
      return sqlSession.selectOne("MemberDao.findByEmailPassword", params);
      
    } 
    
  }
  
  
  public List<Member> findAll() throws Exception {
    
    try ( SqlSession sqlSession = sqlSessionFactory.openSession() ) {
      
      return sqlSession.selectList("MemberDao.findAll");
    
    }
  }
  
  public Member findByNo(int no) throws Exception {
    
    try ( SqlSession sqlSession = sqlSessionFactory.openSession() ) {
      
      return sqlSession.selectOne("MemberDao.findByNo", no);
    
    }
  }
  
  public int insert(Member member) throws Exception {
    
    try ( SqlSession sqlSession = sqlSessionFactory.openSession() ) {
      
      int result = sqlSession.insert("MemberDao.insert", member);
      sqlSession.commit();
      return result;
    
    }
    
  }
  
  public int update(Member member) throws Exception {
    
    try ( SqlSession sqlSession = sqlSessionFactory.openSession() ) {
      
      int result = sqlSession.update("MemberDao.update", member);
      sqlSession.commit();
      return result;
     
    }
  }
  
  public int delete(int no) throws Exception {
    
    try ( SqlSession sqlSession = sqlSessionFactory.openSession() ) {
      
      int result = sqlSession.delete("MemberDao.delete", no);
      sqlSession.commit();
      return result;
    
    }
  }
}
