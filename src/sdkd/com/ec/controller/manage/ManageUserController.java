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
        //List<EbUser> generalUsersList = ebUserDao.getGeneralUsersList();
        String pageNumberStr = request.getParameter("pageNumber");
        int pageNumber = 1;     //当前页
        if(pageNumberStr != null && !"".equals(pageNumberStr)) {
            pageNumber = Integer.parseInt(pageNumberStr);
        }

        int pageSize = Integer.parseInt(ebUserDao.getPro("pageSize"));  //每页显示条数
        int totalUsers = ebUserDao.getGeneralUsersCount(); // 总用户数
        int totalPages = totalUsers/pageSize + ((totalUsers%pageSize) > 0 ? 1 : 0); //总页数
        int firstItemID = (pageNumber-1)*pageSize;

        request.setAttribute("pageNumber",pageNumber);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("totalUsers",totalUsers);
        request.setAttribute("totalPages",totalPages);

        List<EbUser> generalUsersList = ebUserDao.getGeneralUsersList(totalUsers,firstItemID,pageSize);
        request.setAttribute("general_users_list",generalUsersList);
        request.getRequestDispatcher("./manage/user.jsp").forward(request,response);
    }
}
