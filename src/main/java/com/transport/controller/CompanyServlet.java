package com.transport.controller;

import com.transport.model.TransportCompany;
import com.transport.persistence.TransportCompanyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "CompanyServlet", urlPatterns = {"/companies"})
public class CompanyServlet extends HttpServlet {

    private TransportCompanyDAO companyDAO;

    @Override
    public void init() {
        companyDAO = new TransportCompanyDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {



        // Retrieve all companies
        List<TransportCompany> companies = companyDAO.findAll();

        // Send data to JSP
        req.setAttribute("companies", companies);
        req.getRequestDispatcher("/WEB-INF/views/companies.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        System.out.println("Submitted company name: " + name); // log submitted value
        if (name != null && !name.trim().isEmpty()) {
            TransportCompany tc = new TransportCompany();
            tc.setName(name.trim());
            companyDAO.create(tc);
        }

        // Redirect to GET so the form resubmission doesn't happen on refresh
        resp.sendRedirect(req.getContextPath() + "/companies");
    }



}
