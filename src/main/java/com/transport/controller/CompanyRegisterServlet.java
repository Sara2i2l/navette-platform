package com.transport.controller;

import com.transport.model.TransportCompany;
import com.transport.persistence.TransportCompanyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CompanyRegisterServlet", urlPatterns = {"/registerCompany"})
public class CompanyRegisterServlet extends HttpServlet {

    private TransportCompanyDAO companyDAO;

    @Override
    public void init() throws ServletException {
        companyDAO = new TransportCompanyDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Show the registration form
        req.getRequestDispatcher("/WEB-INF/views/companyRegister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Extract form data
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Create and populate the company object
        TransportCompany company = new TransportCompany();
        company.setName(name);
        company.setEmail(email);
        company.setPassword(password); // 🔐 in a real app, you'd hash the password!

        // Save to the DB
        companyDAO.create(company);

        // Redirect to login page or dashboard
        resp.sendRedirect(req.getContextPath() + "/companyDashboard");
    }
}
