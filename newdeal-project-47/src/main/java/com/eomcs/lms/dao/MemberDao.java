package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberDao {
  
  List<Member> findAll() throws Exception;
  
  Member findByNo(int no) throws Exception;
  
  void insert(Member member) throws Exception;
  
  void update(Member member) throws Exception;
  
  void delete(int no) throws Exception;
}
