package sdkd.com.ec.controller.manage;

import sdkd.com.ec.dao.impl.EbProductCategoryDao;
import sdkd.com.ec.model.EbProductCategory;

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
public class ManageProductCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        EbProductCategoryDao ebProductCategoryDao = new EbProductCategoryDao();
        List<EbProductCategory> categoriesList = ebProductCategoryDao.getProductClassesList();
        request.setAttribute("categories_list",categoriesList);
        request.getRequestDispatcher("./manage/productClass.jsp").forward(request,response);
    }
}
