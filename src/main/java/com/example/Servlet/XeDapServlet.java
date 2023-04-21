package com.example.Servlet;

import com.example.Entity.XeDap;
import com.example.Service.Imp.IXeDapService;
import com.example.Service.XeDapService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/xe-dap")
public class XeDapServlet extends HttpServlet {

    private final XeDapService xeDapService = new IXeDapService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<XeDap> listXeDap = xeDapService.hienThi();
        req.setAttribute("listXeDap", listXeDap);
        req.getRequestDispatcher("/view/guest-view.jsp").forward(req,resp);
    }
}
