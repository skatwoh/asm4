package com.example.Servlet;

import com.example.Entity.XeDap;
import com.example.Repository.XeDapRepo;
import com.example.Service.Imp.IXeDapService;
import com.example.Service.XeDapService;
import com.example.Util.HIbernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.io.IOException;
import java.util.List;

@WebServlet("/user/loc")
public class LocUser extends HttpServlet {

    private final XeDapService xeDapService = new IXeDapService();
    private XeDapRepo xeDapRepo = new XeDapRepo();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = HIbernateUtil.getFactory().openSession();
        Criteria criteria = session.createCriteria(XeDap.class);
        if (req.getParameter("hang") != null) {
            criteria.add(Restrictions.ilike("hang", req.getParameter("hang"), MatchMode.ANYWHERE));
        }
        if (req.getParameter("dong") != null) {
            criteria.add(Restrictions.ilike("dong", req.getParameter("dong"), MatchMode.ANYWHERE));
        }
        if (req.getParameter("ten") != null) {
            criteria.add(Restrictions.ilike("ten", req.getParameter("ten"), MatchMode.ANYWHERE));
        }
        List<XeDap> xeDapList = criteria.list();
        req.setAttribute("listXeDapU", xeDapList);
        req.getRequestDispatcher("/view/user-view.jsp").forward(req, resp);
    }


}
