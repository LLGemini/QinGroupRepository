package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbNoteDao;
import sdkd.com.ec.dao.impl.EbProductCategoryDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.*;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qin on 2016-07-06.
 */
public class WelcomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        EbNoteDao noteDao = new EbNoteDao();
        List<EbNote> recent_note_list = noteDao.getRecentNote();
        request.setAttribute("recent_note_list",recent_note_list);

        EbNewsDao newsDao = new EbNewsDao();
        List<EbNews> recent_news_list = newsDao.getRecentNews();
        request.setAttribute("recent_news_list",recent_news_list);

        EbProductDao productDao = new EbProductDao( );
        List<EbProduct> hot_product_list = productDao.getHotProduct();
        request.setAttribute("hot_product_list",hot_product_list);

        List<EbProduct> bargin_product_list = productDao.getPromotionProduct();
        request.setAttribute("bargin_product_list",bargin_product_list);

        String cookieList = getCookie(request,response);
        List<EbProduct> recent_visited_product_list = productDao.getRecentVisitedProduct(cookieList);
        request.setAttribute("recent_visited_product_list",recent_visited_product_list);

        EbProductCategoryDao epcd = new EbProductCategoryDao();
        List<EbProductCategory> epc_list = epcd.getCategories();
        request.setAttribute("category_list",epc_list);

        //跳转
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    private String getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        return list;
    }
}
