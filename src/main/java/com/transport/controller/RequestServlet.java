package com.transport.controller;

import com.transport.model.User;
import com.transport.model.SubscriptionRequest;
import com.transport.persistence.SubscriptionRequestDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;           // HttpServlet, HttpServletRequest, HttpServletResponse, HttpSession
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;



@WebServlet(name="RequestServlet", urlPatterns={"/createRequest"})
public class RequestServlet extends HttpServlet {
    private SubscriptionRequestDAO reqDAO;
    @Override public void init(){ reqDAO = new SubscriptionRequestDAO(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/createRequest.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = session!=null ? (User)session.getAttribute("loggedInUser") : null;
        if(user==null){
            resp.sendRedirect(req.getContextPath()+"/loginUser");
            return;
        }
        // Extract fields
        SubscriptionRequest r = new SubscriptionRequest();
        r.setUser(user);
        r.setDepartureCity(req.getParameter("departureCity"));
        r.setArrivalCity(req.getParameter("arrivalCity"));
        r.setStartDate(LocalDate.parse(req.getParameter("startDate")));
        r.setEndDate(LocalDate.parse(req.getParameter("endDate")));
        r.setDepartureTime(LocalTime.parse(req.getParameter("departureTime")));
        r.setArrivalTime(LocalTime.parse(req.getParameter("arrivalTime")));
        reqDAO.create(r);
        resp.sendRedirect(req.getContextPath()+"/userDashboard");
    }
}
