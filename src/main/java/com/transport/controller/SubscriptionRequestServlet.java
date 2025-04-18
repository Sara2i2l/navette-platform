package com.transport.controller;

import com.transport.model.User;
import com.transport.model.ShuttleOffer;
import com.transport.model.SubscriptionRequest;
import com.transport.persistence.ShuttleOfferDAO;
import com.transport.persistence.SubscriptionRequestDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SubscriptionRequestServlet", urlPatterns = {"/subscribe"})
public class SubscriptionRequestServlet extends HttpServlet {

    private SubscriptionRequestDAO subRequestDAO;

    @Override
    public void init() throws ServletException {
        subRequestDAO = new SubscriptionRequestDAO();
    }

    /**
     * Handle subscription via POST.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1) Ensure user is logged in
        HttpSession session = req.getSession(false);
        User user = (session != null)
                ? (User) session.getAttribute("loggedInUser")
                : null;
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/loginUser");
            return;
        }

        // 2) Parse the offerId
        String offerIdStr = req.getParameter("offerId");
        if (offerIdStr == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Offer ID is required");
            return;
        }
        Long offerId = Long.parseLong(offerIdStr);

        // 3) Load the offer
        ShuttleOfferDAO offerDAO = new ShuttleOfferDAO();
        ShuttleOffer offer = offerDAO.findById(offerId);
        if (offer == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Offer not found");
            return;
        }

        // 4) Build and persist the SubscriptionRequest
        SubscriptionRequest reqEntity = new SubscriptionRequest();
        reqEntity.setUser(user);
        reqEntity.setDepartureCity(offer.getDepartureCity());
        reqEntity.setArrivalCity(offer.getArrivalCity());
        reqEntity.setStartDate(offer.getStartDate());
        reqEntity.setEndDate(offer.getEndDate());
        reqEntity.setDepartureTime(offer.getDepartureTime());
        reqEntity.setArrivalTime(offer.getArrivalTime());
        subRequestDAO.create(reqEntity);

        // 5) Increment the offer’s subscriberCount
        offer.setSubscriberCount(offer.getSubscriberCount() + 1);
        offerDAO.update(offer);

        // 6) Redirect back
        resp.sendRedirect(req.getContextPath() + "/searchOffers");
    }

    /**
     * Delegate GET to POST so that a GET request to /subscribe also works.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
