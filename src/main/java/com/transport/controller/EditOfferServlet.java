package com.transport.controller;

import com.transport.model.ShuttleOffer;
import com.transport.persistence.ShuttleOfferDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet(name = "EditOfferServlet", urlPatterns = {"/editOffer"})
public class EditOfferServlet extends HttpServlet {

    private ShuttleOfferDAO offerDAO;

    @Override
    public void init() throws ServletException {
        offerDAO = new ShuttleOfferDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        if (idStr == null) {
            resp.sendRedirect(req.getContextPath() + "/companyDashboard");
            return;
        }

        Long id = Long.parseLong(idStr);
        ShuttleOffer offer = offerDAO.findById(id);
        if (offer == null) {
            resp.sendRedirect(req.getContextPath() + "/companyDashboard");
            return;
        }

        req.setAttribute("offer", offer);
        req.getRequestDispatcher("/WEB-INF/views/editOffer.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        ShuttleOffer offer = offerDAO.findById(id);
        if (offer == null) {
            resp.sendRedirect(req.getContextPath() + "/companyDashboard");
            return;
        }

        // Update fields from the form
        offer.setDepartureCity(req.getParameter("departureCity"));
        offer.setArrivalCity(req.getParameter("arrivalCity"));
        offer.setStartDate(LocalDate.parse(req.getParameter("startDate")));
        offer.setEndDate(LocalDate.parse(req.getParameter("endDate")));
        offer.setDepartureTime(LocalTime.parse(req.getParameter("departureTime")));
        offer.setArrivalTime(LocalTime.parse(req.getParameter("arrivalTime")));
        offer.setAutocarDescription(req.getParameter("autocarDescription"));
        offer.setSubscriberTarget(Integer.parseInt(req.getParameter("subscriberTarget")));

        offerDAO.update(offer);
        resp.sendRedirect(req.getContextPath() + "/companyDashboard");
    }
}
