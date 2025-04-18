package com.transport.controller;

import com.transport.model.TransportCompany;
import com.transport.model.SubscriptionRequest;
import com.transport.persistence.SubscriptionRequestDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;           // HttpServlet, HttpServletRequest, HttpServletResponse, HttpSession
import java.io.IOException;
import java.util.List;


@WebServlet(name="CompanyRequestsServlet",urlPatterns={"/companyRequests"})
public class CompanyRequestsServlet extends HttpServlet {
    private SubscriptionRequestDAO reqDAO;
    @Override public void init(){ reqDAO = new SubscriptionRequestDAO(); }

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException{
        HttpSession s = req.getSession(false);
        TransportCompany c = s!=null ? (TransportCompany)s.getAttribute("loggedInCompany") : null;
        if(c==null){ resp.sendRedirect(req.getContextPath()+"/loginCompany"); return; }
        // For now, show all requests
        req.setAttribute("requests", reqDAO.findAll());
        req.getRequestDispatcher("/WEB-INF/views/companyRequests.jsp")
                .forward(req,resp);
    }
}
