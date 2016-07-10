package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductCategoryDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.model.EbProductCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

        addCookie(request,response);

        EbProductCategoryDao epcd = new EbProductCategoryDao();
        List<EbProductCategory> epc_list = epcd.getProductClassesList();
        request.setAttribute("category_list",epc_list);

        request.getRequestDispatcher("/product-view.jsp").forward(request,response);
    }

    /**
     *  将当前浏览商品id存储在cookie中
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void addCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String list = "";
        Cookie[] cookies = request.getCookies(); // 从客户端获得cookie集合
        // 遍历cookies集合
        if(cookies != null && cookies.length > 0) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("productViewCookie")) {
                    list = cookie.getValue();
                }
            }
        }
        list += request.getParameter("p_id") + ",";
        // 如果浏览记录超过1000条，清零
        String[] items = list.split(",");
        if(items != null && items.length > 0) {
            if(items.length > 1000) {
                list = "";
            }
        }
        Cookie cookie = new Cookie("productViewCookie",list);
        response.addCookie(cookie);
    }


}
