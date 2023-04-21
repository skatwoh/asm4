package com.example.Authen;

import com.example.Service.Imp.ILoginService;
import com.example.Service.LoginService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/user/*"
})
public class UserFilter implements Filter {

    private LoginService loginService = new ILoginService();
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession httpSession = req.getSession();

        String username = (String) httpSession.getAttribute("username");
        if(username==null){
            servletRequest.getRequestDispatcher("/error/error.jsp").forward(servletRequest,servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
