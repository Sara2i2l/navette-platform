package com.transport.controller;

import com.transport.model.ShuttleOffer;
import com.transport.model.TransportCompany;
import com.transport.persistence.ShuttleOfferDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
@WebServlet(name = "CreateOfferServlet", urlPatterns = {"/createOffer"})
public class CreateOfferServlet extends HttpServlet {

    private ShuttleOfferDAO offerDAO;

    @Override
    public void init() throws ServletException {
        offerDAO = new ShuttleOfferDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/createOffer.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Retrieve form parameters
        String departureCity = req.getParameter("departureCity");
        String arrivalCity = req.getParameter("arrivalCity");
        String startDateStr = req.getParameter("startDate");   // expecting format yyyy-MM-dd
        String endDateStr = req.getParameter("endDate");       // expecting format yyyy-MM-dd
        String departureTimeStr = req.getParameter("departureTime"); // expecting format HH:mm
        String arrivalTimeStr = req.getParameter("arrivalTime");     // expecting format HH:mm
        String autocarDescription = req.getParameter("autocarDescription");
        String subscriberTargetStr = req.getParameter("subscriberTarget");

        // Convert string parameters to appropriate types
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);
        LocalTime departureTime = LocalTime.parse(departureTimeStr);
        LocalTime arrivalTime = LocalTime.parse(arrivalTimeStr);
        int subscriberTarget = Integer.parseInt(subscriberTargetStr);

        // Create a new ShuttleOffer instance and populate it
        ShuttleOffer offer = new ShuttleOffer();
        offer.setDepartureCity(departureCity);
        offer.setArrivalCity(arrivalCity);
        offer.setStartDate(startDate);
        offer.setEndDate(endDate);
        offer.setDepartureTime(departureTime);
        offer.setArrivalTime(arrivalTime);
        offer.setAutocarDescription(autocarDescription);
        offer.setSubscriberTarget(subscriberTarget);
        offer.setSubscriberCount(0); // initially no subscribers

        // For now, simulate a logged-in company. In a real app you'd get it from the session.
        TransportCompany company = new TransportCompany();
        company.setId(1L);  // Simulated company id; ensure it matches your test data
        // Optionally, you can set the company name if needed: company.setName("Your Company");
        offer.setCompany(company);

        // Persist the offer using our DAO
        offerDAO.create(offer);

        // Redirect to the dashboard or a confirmation page after creation
        resp.sendRedirect(req.getContextPath() + "/companyDashboard");
    }
}
