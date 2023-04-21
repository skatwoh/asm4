package com.example.Servlet;

import com.example.Entity.XeDap;
import com.example.Repository.XeDapRepo;
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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet( value = {
        "/admin",
        "/admin/add",
        "/admin/update"
})
public class Admin extends HttpServlet {

    private LoginService loginService = new ILoginService();
    private final XeDapService xeDapService = new IXeDapService();
    private final XeDapRepo xeDapRepo = new XeDapRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/admin")) {
            List<XeDap> listXeDap = xeDapService.hienThi();
            req.setAttribute("listXeDaps", listXeDap);
            req.getRequestDispatcher("/view/admin-view.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/admin/add")){
            String ten = req.getParameter("ten");
            String moTa = req.getParameter("moTa");
            BigDecimal gia = BigDecimal.valueOf(Long.parseLong(req.getParameter("gia")));
            Integer soLuong = Integer.parseInt(req.getParameter("soLuong"));
            String nguoiTao = req.getParameter("nguoiTao");
            String thoiGianTao = req.getParameter("thoiGianTao");
            Date thoiDiemTao = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                thoiDiemTao = sdf.parse(thoiGianTao);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String nguoiDoi = req.getParameter("nguoiDoi");
            String thoiGianDoi = req.getParameter("thoiGianDoi");
            Date thoiDiemDoi = new Date();
            try {
                thoiDiemDoi= sdf.parse(thoiGianDoi);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Boolean daXoa = Boolean.parseBoolean(req.getParameter("daXoa"));
            String hang = req.getParameter("hang");
            String dong = req.getParameter("dong");
             XeDap xeDap = new XeDap(ten,moTa,gia,soLuong,nguoiTao,thoiDiemTao,nguoiDoi,thoiDiemDoi,daXoa,hang,dong);
             xeDapService.add(xeDap);
             resp.sendRedirect("/admin");
        } else if (uri.contains("/admin/update")) {
            Long id = Long.parseLong(req.getParameter("id"));
            String ten = req.getParameter("ten");
            String moTa = req.getParameter("moTa");
            BigDecimal gia = BigDecimal.valueOf(Long.parseLong(req.getParameter("gia")));
            Integer soLuong = Integer.parseInt(req.getParameter("soLuong"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String nguoiTao = req.getParameter("nguoiTao");
            String thoiGianTao = req.getParameter("thoiGianTao");
            Date thoiDiemTao = new Date();
            try {
                thoiDiemTao = sdf.parse(thoiGianTao);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String nguoiDoi = req.getParameter("nguoiDoi");
            String thoiGianDoi = req.getParameter("thoiGianDoi");
            Date thoiDiemDoi = new Date();
            try {
                thoiDiemDoi= sdf.parse(thoiGianDoi);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Boolean daXoa = Boolean.parseBoolean(req.getParameter("daXoa"));
            String hang = req.getParameter("hang");
            String dong = req.getParameter("dong");
            XeDap xeDap = new XeDap(id,ten,moTa,gia,soLuong,nguoiTao,thoiDiemTao,nguoiDoi,thoiDiemDoi,daXoa,hang,dong);
            xeDapRepo.update(xeDap);
            resp.sendRedirect("/admin");
        }
    }
}
