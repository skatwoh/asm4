package com.example.Servlet;

import com.example.Entity.Account;
import com.example.Service.Imp.ILoginService;
import com.example.Service.Imp.IXeDapService;
import com.example.Service.LoginService;
import com.example.Service.XeDapService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {"/login",
})
public class Login extends HttpServlet {

    private LoginService loginService = new ILoginService();
    private final XeDapService xeDapService = new IXeDapService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/login")) {
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = loginService.loginAccount(username);

        if(account != null && account.getRoles().equals("admin") && account.getPassword().equals(password)){
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("/admin");

        } else if(account != null && account.getRoles().equals("staff") && account.getPassword().equals(password)) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("/user");
        } else {
            req.setAttribute("errMessage", "Sai TK hoặc MK!");
            req.getRequestDispatcher("/view/login.jsp").forward(req,resp);
        }
    }
}
