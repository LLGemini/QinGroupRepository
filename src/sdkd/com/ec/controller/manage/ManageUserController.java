package sdkd.com.ec.controller.manage;

import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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
        String action = request.getParameter("action");
        if("search".equals(action)) {
            searchByUserInfo(request, response);
        } else if("index".equals(action)) {
            managePage(request, response);
        }

        request.getRequestDispatcher("./manage/user.jsp").forward(request,response);
    }

    /**
     * 根据用户信息查询用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void searchByUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EbUser> generalUsersList = new ArrayList<EbUser>();
        String userName = request.getParameter("userName");
        EbUserDao ebUserDao = new EbUserDao();
        EbUser user = ebUserDao.getUserByName(userName);
        if(user != null) {
            generalUsersList.add(user);
        }
        request.setAttribute("pageNumber",1);
        request.setAttribute("pageSize",1);
        request.setAttribute("totalUsers",1);
        request.setAttribute("totalPages",1);
        request.setAttribute("general_users_list",generalUsersList);
    }

    /**
     * 分页管理
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void managePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EbUserDao ebUserDao = new EbUserDao();
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
    }
}
