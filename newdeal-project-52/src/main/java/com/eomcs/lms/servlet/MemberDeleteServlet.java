package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  MemberDao memberDao;
  
  @Override
  public void init() throws ServletException {
    ApplicationContext iocContainer = (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.memberDao = iocContainer.getBean(MemberDao.class);
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      HttpSession session = request.getSession();
      Member loginUser = (Member) session.getAttribute("loginUser");
      
      RequestDispatcher rd = request.getRequestDispatcher("/member/delete.jsp");
      response.setContentType("text/html;charset=UTF-8");
      
      int mno = Integer.parseInt(request.getParameter("no"));
      
      if (loginUser != null) {
        int loginNo = loginUser.getNo();
        if (mno != loginNo) {
          request.setAttribute("count", -1);
          rd.include(request, response);
        } else {
          request.setAttribute("count", memberDao.delete(mno));
          rd.include(request, response);
        }
      } else {
        request.setAttribute("count", -2);
        rd.include(request, response);
      }
      
      
     
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
    
  }
  
}
