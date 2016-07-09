package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductCategoryDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.model.EbProductCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Flower on 2016/7/7.
 */
@WebServlet(name = "EbProductViewController")
public class ProductViewController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf-8");

        EbProductDao ebProductDao = new EbProductDao();
        String ep_id = request.getParameter("p_id");
        EbProduct product = ebProductDao.getProductDetail(ep_id);
        request.setAttribute("product", product);

        EbProductCategoryDao epcd = new EbProductCategoryDao();
        List<EbProductCategory> epc_list = epcd.getCategories();
        request.setAttribute("category_list",epc_list);

        request.getRequestDispatcher("/product-view.jsp").forward(request,response);

    }
}
