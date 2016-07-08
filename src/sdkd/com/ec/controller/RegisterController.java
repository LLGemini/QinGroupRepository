package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qin on 2016-07-06.
 */
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName").trim();
        String passWord = request.getParameter("passWord").trim();
        EbUser new_user = new EbUser();
        new_user.setEu_user_name(userName);
        new_user.setEu_password(passWord);
        EbUserDao user_dao = new EbUserDao();
        user_dao.addUser(new_user);

        response.sendRedirect("reg-result.jsp");

    }

}
