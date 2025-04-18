package com.transport.controller;

import com.transport.model.ShuttleOffer;
import com.transport.persistence.ShuttleOfferDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "OfferSearchServlet", urlPatterns = {"/searchOffers"})
public class OfferSearchServlet extends HttpServlet {

    private ShuttleOfferDAO offerDAO;

    @Override
    public void init() throws ServletException {
        offerDAO = new ShuttleOfferDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Retrieve search parameters
        String departure = req.getParameter("departure");
        String arrival = req.getParameter("arrival");

        System.out.println("Search parameters: departure = " + departure + ", arrival = " + arrival);
        List<ShuttleOffer> offers = offerDAO.searchByCities(departure, arrival);
        System.out.println("Number of offers found: " + offers.size());

        // If both parameters are provided and non-empty, perform the search
        if (departure != null && !departure.trim().isEmpty()
                && arrival != null && !arrival.trim().isEmpty()) {
            offers = offerDAO.searchByCities(departure.trim(), arrival.trim());
            req.setAttribute("offers", offers);
        }

        // Forward to JSP which displays the search form and (if available) the search results
        req.getRequestDispatcher("/WEB-INF/views/offers.jsp").forward(req, resp);
    }
}
