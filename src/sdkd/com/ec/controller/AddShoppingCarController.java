package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbShoppingCarDao;
import sdkd.com.ec.model.EbShoppingCar;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by qin on 2016-07-08.
 */
public class AddShoppingCarController extends HttpServlet {
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
            int product_id = Integer.valueOf(request.getParameter("id")) ;
            int user_id = curr_user.getEu_user_id();
            ecd.addProduct(product_id,user_id);


            response.sendRedirect("show_shoppingcar");
        }

    }
}
