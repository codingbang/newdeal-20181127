package com.eomcs.lms.dao.impl;

import java.sql.DriverManager;
import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MariaDBMemberDao implements MemberDao {
  
  SqlSessionFactory sqlSessionFactory;
  
  public MariaDBMemberDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public Member findByEmailPassword(String email, String password) throws Exception {
    
    DriverManager.registerDriver(new Driver());
    try ( SqlSession sqlSession = sqlSessionFactory.openSession() ) {
      HashMap<String, Object> params = new HashMap<>();
      params.put("email", email);
      params.put("password", password);
      return sqlSession.selectOne("MemberDao.findByEmailPassword", params);
      
    } 
    
  }
}
