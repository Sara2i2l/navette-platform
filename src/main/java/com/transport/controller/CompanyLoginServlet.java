package com.transport.controller;

import com.transport.model.TransportCompany;
import com.transport.persistence.TransportCompanyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CompanyLoginServlet", urlPatterns = {"/loginCompany"})
public class CompanyLoginServlet extends HttpServlet {

    private TransportCompanyDAO companyDAO;

    @Override
    public void init() throws ServletException {
        companyDAO = new TransportCompanyDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Show login form
        req.getRequestDispatcher("/WEB-INF/views/companyLogin.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        TransportCompany company = companyDAO.findByEmail(email);
        if (company != null && company.getPassword().equals(password)) {
            // Successful login: store in session
            HttpSession session = req.getSession();
            session.setAttribute("loggedInCompany", company);
            // Optional: set session timeout
            session.setMaxInactiveInterval(30 * 60); // 30 min
            resp.sendRedirect(req.getContextPath() + "/companyDashboard");
        } else {
            // Login failed: show error
            req.setAttribute("error", "Email ou mot de passe invalide");
            req.getRequestDispatcher("/WEB-INF/views/companyLogin.jsp")
                    .forward(req, resp);
        }
    }
}
