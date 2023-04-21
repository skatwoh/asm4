package com.example.Servlet;

import com.example.Entity.XeDap;
import com.example.Repository.XeDapRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/view")
public class UpdateAdmin extends HttpServlet {
    private XeDapRepo xeDapRepo = new XeDapRepo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        XeDap xeDap = xeDapRepo.getById(Long.parseLong(id));
        req.setAttribute("xeDap", xeDap);
        req.getRequestDispatcher("/view/update-admin.jsp").forward(req,resp);
    }
}
