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
        String password = request.getParameter("passWord").trim();
        if(userName == null || password == null) {
            response.sendRedirect("login.jsp");
        }
        EbUserDao ebUserDao= new EbUserDao();
        EbUser user = ebUserDao.getUserByName(userName);
        if(user != null && user.getEu_password() != null && user.getEu_password().equals(password))
        {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            if(user.getEu_status() == 2) { // 管理员
                response.sendRedirect("/manage/index.jsp");
            } else if(user.getEu_status() == 1) {
                response.sendRedirect("welcome");
            }
        }
        else
        {
            response.sendRedirect("login.jsp");
        }
    }
}
