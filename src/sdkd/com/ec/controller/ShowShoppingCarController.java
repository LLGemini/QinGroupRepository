package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbShoppingCarDao;
import sdkd.com.ec.model.EbShoppingCar;
import sdkd.com.ec.model.EbUser;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by qin on 2016-07-07.
 */
public class ShowShoppingCarController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EbShoppingCarDao ecd = new EbShoppingCarDao();

        HttpSession session = request.getSession();
        EbUser curr_user = (EbUser)session.getAttribute("user");
        if(curr_user==null)
        {
            response.sendRedirect("login.jsp");
        }
        else
        {
            ;
            int user_id = curr_user.getEu_user_id();

            List<EbShoppingCar> shopping_car_list = ecd.getShoppingCarList();
            request.setAttribute("shopping_car_list",shopping_car_list);
            request.getRequestDispatcher("/shopping.jsp").forward(request,response);
        }



    }
}
