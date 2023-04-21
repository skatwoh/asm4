package com.example.Servlet;

import com.example.Repository.XeDapRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/xoa")
public class Xoa extends HttpServlet {

    private XeDapRepo xeDapRepo = new XeDapRepo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idX");
        xeDapRepo.delete(Long.parseLong(id));
        resp.sendRedirect("/admin");
    }
}
