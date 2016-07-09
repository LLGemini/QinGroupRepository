package sdkd.com.ec.controller.manage;

import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Flower on 2016/7/9.
 */

public class ManageUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        EbUserDao ebUserDao = new EbUserDao();
        List<EbUser> generalUsersList = ebUserDao.getGeneralUsersList();
        request.setAttribute("general_users_list",generalUsersList);

        request.getRequestDispatcher("./manage/user.jsp").forward(request,response);
    }
}
