package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbNoteDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNote;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Flower on 2016/7/8.
 */
@WebServlet(name = "NewsViewController")
public class NewsViewController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf-8");
        EbNewsDao ebNewsDao = new EbNewsDao();
        String n_id = request.getParameter("news_id");
        int id = 0;
        if(n_id != null && !"".equals(n_id)) {
            id = Integer.parseInt(n_id);
        }
        EbNews news = ebNewsDao.getNewsById(id);
        request.setAttribute("news", news);

        EbNoteDao noteDao = new EbNoteDao();
        List<EbNote> recent_note_list = noteDao.getRecentNote();
        request.setAttribute("recent_note_list",recent_note_list);

        EbNewsDao newsDao = new EbNewsDao();
        List<EbNews> recent_news_list = newsDao.getRecentNews();
        request.setAttribute("recent_news_list",recent_news_list);

        request.getRequestDispatcher("/news-view.jsp").forward(request,response);
    }
}
