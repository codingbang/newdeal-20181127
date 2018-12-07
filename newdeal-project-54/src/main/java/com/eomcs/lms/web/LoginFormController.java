package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.MemberDao;

@Controller
public class LoginFormController {
  
  MemberDao memberDao;
  
  public LoginFormController(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @RequestMapping("/auth/loginForm")
  public String loginForm(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    response.setContentType("text/html;charset=UTF-8");
    return "/auth/login.jsp";
  }
}
