package com.transport.controller;

import com.transport.model.User;
import com.transport.persistence.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name="UserLoginServlet", urlPatterns={"/loginUser"})
public class UserLoginServlet extends HttpServlet {
    private UserDAO userDAO;
    @Override public void init(){ userDAO = new UserDAO(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/userLogin.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass  = req.getParameter("password");

        User user = userDAO.findByEmail(email);
        if (user!=null && user.getPassword().equals(pass)) {
            HttpSession session = req.getSession();
            session.setAttribute("loggedInUser", user);
            session.setMaxInactiveInterval(30*60);
            resp.sendRedirect(req.getContextPath()+"/searchOffers");
        } else {
            req.setAttribute("error","Email ou mot de passe invalide");
            req.getRequestDispatcher("/WEB-INF/views/userLogin.jsp")
                    .forward(req, resp);
        }
    }
}
