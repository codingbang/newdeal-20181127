package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberDao {
  
  public List<Member> findAll() throws Exception;
  
  public Member findByNo(int no) throws Exception;
  
  public void insert(Member member) throws Exception;
  
  public void update(Member member) throws Exception;
  
  public void delete(int no) throws Exception;
}
