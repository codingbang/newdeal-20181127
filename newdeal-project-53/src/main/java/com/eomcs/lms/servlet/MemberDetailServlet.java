package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  MemberDao memberDao;
  
  @Override
  public void init() throws ServletException {
    ApplicationContext iocContainer = (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.memberDao = iocContainer.getBean(MemberDao.class);
  }
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      int no = Integer.parseInt(req.getParameter("no"));
      
      Member member = memberDao.findByNo(no);
      
      req.setAttribute("member", member);
      RequestDispatcher rd = req.getRequestDispatcher("/member/detail.jsp");
      resp.setContentType("text/html;charset=UTF-8");
      rd.include(req, resp);
      
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    } 
  }

}
