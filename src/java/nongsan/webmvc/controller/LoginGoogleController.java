/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nongsan.webmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nongsan.webmvc.dao.impl.LoginDao;
import nongsan.webmvc.dao.impl.UserDaoImpl;
import nongsan.webmvc.model.User;
import nongsan.webmvc.service.UserService;
import nongsan.webmvc.service.impl.UserServicesImpl;

/**
 *
 * @author HP
 */
public class LoginGoogleController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    UserService userService = new UserServicesImpl();
    UserDaoImpl userDaoImpl=new UserDaoImpl();
    public LoginGoogleController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/client/login.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        
        LoginDao loginDao = new LoginDao();
        
        String username = request.getParameter("ggname");
        String getEmail = request.getParameter("ggemail");
        try {
            User u = loginDao.checkLogin2(username);
            if (u != null) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect(request.getContextPath() + "/");
            } else {
                User u1=new User();
                u1.setName(username);
		u1.setEmail(getEmail);
		u1.setPhone("google");
		u1.setUsername(username);
		u1.setPassword("google");
		u1.setCreated("2021-06-17");
                loginDao.insertAccount(u1);
//                userDaoImpl.insert(u1);
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect(request.getContextPath() + "/");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        LoginDao loginDao = new LoginDao();
//        try {
//            User u = loginDao.checkLogin(username, password);
//            if (u != null) {
//                HttpSession session = request.getSession();
//                session.setAttribute("username", username);
//                response.sendRedirect(request.getContextPath() + "/");
//            } else {
//                request.setAttribute("errorMsg", "Tài khoản đăng nhập hoặc mật khẩu sai !!!");
//                RequestDispatcher rd = request.getRequestDispatcher("/view/client/login.jsp");
//                rd.forward(request, response);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
