package com.transport.controller;

import com.transport.model.TransportCompany;
import com.transport.model.ShuttleOffer;
import com.transport.persistence.ShuttleOfferDAO;

import com.transport.model.ShuttleOffer;
import com.transport.persistence.ShuttleOfferDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "CompanyDashboardServlet", urlPatterns = {"/companyDashboard"})
public class CompanyDashboardServlet extends HttpServlet {

    private ShuttleOfferDAO offerDAO;

    @Override
    public void init() throws ServletException {
        offerDAO = new ShuttleOfferDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        TransportCompany company = session != null
                ? (TransportCompany) session.getAttribute("loggedInCompany")
                : null;

        if (company == null) {
            // Not logged in → redirect to login
            resp.sendRedirect(req.getContextPath() + "/loginCompany");
            return;
        }

        // Logged in: fetch offers for this company
        List<ShuttleOffer> offers = offerDAO.findByCompanyId(company.getId());
        req.setAttribute("offers", offers);
        req.setAttribute("companyName", company.getName()); // optional, for greeting
        req.getRequestDispatcher("/WEB-INF/views/companyDashboard.jsp")
                .forward(req, resp);
    }

}
