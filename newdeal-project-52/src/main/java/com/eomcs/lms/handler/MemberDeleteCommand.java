package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;

@Component("/member/delete")
public class MemberDeleteCommand implements Command {
  
  Scanner keyboard;
  MemberDao memberDao;
  
  public MemberDeleteCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    
    try {
      System.out.print("번호? ");
      int mno = Integer.parseInt(keyboard.nextLine());
      
      memberDao.delete(mno);
      
      System.out.println("삭제했습니다!");
     
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
}
