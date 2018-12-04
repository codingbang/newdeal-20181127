package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {
  
  Scanner keyboard;
  MemberDao memberDao;
  
  public MemberUpdateCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {

    try {
      Member member = new Member();

      System.out.print("번호? ");
      int mno = Integer.parseInt(keyboard.nextLine());
      member.setNo(mno);
      
      Member oldMember = memberDao.findByNo(mno);
      
      System.out.printf("이름(%s)? ", oldMember.getName());
      member.setName(keyboard.nextLine());
      
      System.out.printf("이메일(%s)? ", oldMember.getEmail());
      member.setEmail(keyboard.nextLine());
      
      System.out.printf("암호(********)? ");
      member.setPassword(keyboard.nextLine());
      
      System.out.printf("사진(%s)? ", oldMember.getPhoto());
      member.setPhoto(keyboard.nextLine());
      
      System.out.printf("전화(%s)? ", oldMember.getTel());
      member.setTel(keyboard.nextLine());
      
      memberDao.update(member);

      System.out.println("수정하였습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    }
   
  }


}
