package com.transport.controller;

import com.transport.model.ShuttleOffer;
import com.transport.persistence.ShuttleOfferDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.time.LocalDate;
@WebServlet(name = "InsertSampleOfferServlet", urlPatterns = {"/insertSampleOffers"})
public class InsertSampleOfferServlet extends HttpServlet {

    private ShuttleOfferDAO offerDAO;

    @Override
    public void init() throws ServletException {
        offerDAO = new ShuttleOfferDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Create a few sample shuttle offers
        ShuttleOffer offer1 = new ShuttleOffer();
        offer1.setDepartureCity("Casablanca");
        offer1.setArrivalCity("Rabat");
        offer1.setStartDate(LocalDate.now());
        offer1.setEndDate(LocalDate.now().plusDays(30));
        offer1.setDepartureTime(LocalTime.of(8, 0));
        offer1.setArrivalTime(LocalTime.of(9, 0));
        offer1.setAutocarDescription("Standard autocar, 40 seats");
        offer1.setSubscriberTarget(40);
        offer1.setSubscriberCount(0);
        offerDAO.create(offer1);

        ShuttleOffer offer2 = new ShuttleOffer();
        offer2.setDepartureCity("Casablanca");
        offer2.setArrivalCity("Fès");
        offer2.setStartDate(LocalDate.now());
        offer2.setEndDate(LocalDate.now().plusDays(30));
        offer2.setDepartureTime(LocalTime.of(10, 0));
        offer2.setArrivalTime(LocalTime.of(13, 0));
        offer2.setAutocarDescription("Comfort bus with Wi-Fi");
        offer2.setSubscriberTarget(30);
        offer2.setSubscriberCount(0);
        offerDAO.create(offer2);

        // Optionally, write a confirmation message
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("<html><body><h1>Sample offers inserted!</h1></body></html>");
    }
}
