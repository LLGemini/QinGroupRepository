package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by qin on 2016-07-06.
 */
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");

        String userName = request.getParameter("userName").trim();
        String passWord = request.getParameter("passWord").trim();
        EbUserDao ebuserdao= new EbUserDao();
        EbUser user = ebuserdao.verify(userName,passWord);
        if(user != null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("welcome");
        }
        else
        {
            response.sendRedirect("login.jsp");
        }
    }
}
