package com.transport.controller;

import com.transport.model.User;
import com.transport.persistence.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name="UserRegisterServlet", urlPatterns={"/registerUser"})
public class UserRegisterServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/userRegister.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String email    = req.getParameter("email");
        String password = req.getParameter("password");

        User existing = userDAO.findByEmail(email);
        if (existing != null) {
            req.setAttribute("error", "Cet email est déjà utilisé");
            req.getRequestDispatcher("/WEB-INF/views/userRegister.jsp")
                    .forward(req, resp);
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password); // in prod, hash it!
        userDAO.create(user);

        // log in automatically
        HttpSession session = req.getSession();
        session.setAttribute("loggedInUser", user);
        session.setMaxInactiveInterval(30*60);

        resp.sendRedirect(req.getContextPath() + "/searchOffers");
    }
}
