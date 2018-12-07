package com.eomcs.lms.web;

import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Controller
@RequestMapping("/auth")
public class AuthController {

  MemberDao memberDao;

  public AuthController(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @RequestMapping("login")
  public String login(String email, String password, HttpSession session,
      HttpServletResponse response) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("email", email);
    params.put("password", password);
    Member member = memberDao.findByEmailPassword(params);

    if (member != null) {
      session.setAttribute("loginUser", member);
      return "redirect:../board/list";
    } else {
      session.invalidate();
      return "redirect:login";
    }
  }

  @RequestMapping("loginForm")
  public String loginForm() throws Exception {
    return "auth/login";
  }

  @RequestMapping("logout")
  public String logout(HttpSession session) throws Exception {
    session.invalidate();
    return "redirect:loginForm";
  }

}
