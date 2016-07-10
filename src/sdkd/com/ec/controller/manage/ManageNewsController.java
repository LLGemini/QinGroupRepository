package sdkd.com.ec.controller.manage;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbOrderDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Flower on 2016/7/10.
 */
@WebServlet(name = "ManageNewsController")
public class ManageNewsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        EbNewsDao ebNewsDao = new EbNewsDao();
        List<EbNews> newsList = ebNewsDao.getNewsList();
        /*String pageNumberStr = request.getParameter("pageNumber");
        int pageNumber = 1;     //当前页
        if(pageNumberStr != null && !"".equals(pageNumberStr)) {
            pageNumber = Integer.parseInt(pageNumberStr);
        }

        int pageSize = 10;  //每页显示条数
        int totalUsers = generalUsersList.size(); // 总用户数
        int totalPages = totalUsers/pageSize + ((totalUsers%pageSize) > 0 ? 1 : 0); //总页数

        request.setAttribute("pageNumber",pageNumber);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("totalUsers",totalUsers);
        request.setAttribute("totalPages",totalPages);*/

        //List<EbUser> generalUsersList = ebUserDao.getGeneralUsersList();
        request.setAttribute("news_list", newsList);
        request.getRequestDispatcher("./manage/news.jsp").forward(request,response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
