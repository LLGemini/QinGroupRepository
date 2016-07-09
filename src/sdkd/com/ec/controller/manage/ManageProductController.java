package sdkd.com.ec.controller.manage;

import sdkd.com.ec.dao.impl.EbOrderDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbOrder;
import sdkd.com.ec.model.EbProduct;
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
@WebServlet(name = "ManageProductController")
public class ManageProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        EbProductDao ebProductDao = new EbProductDao();
        List<EbProduct> productsList = ebProductDao.getProductsList();
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
        request.setAttribute("products_list", productsList);
        request.getRequestDispatcher("./manage/product.jsp").forward(request,response);
    }
}
