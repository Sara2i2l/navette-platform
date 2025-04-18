package com.transport.controller;

import com.transport.model.User;
import com.transport.model.SubscriptionRequest;
import com.transport.persistence.SubscriptionRequestDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;           // HttpServlet, HttpServletRequest, HttpServletResponse, HttpSession
import java.io.IOException;
import java.util.List;


@WebServlet(name="UserDashboardServlet",urlPatterns={"/userDashboard"})
public class UserDashboardServlet extends HttpServlet {
    private SubscriptionRequestDAO reqDAO;
    @Override public void init(){ reqDAO = new SubscriptionRequestDAO(); }

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException,IOException{
        HttpSession s = req.getSession(false);
        User u = s!=null ? (User)s.getAttribute("loggedInUser") : null;
        if(u==null){ resp.sendRedirect(req.getContextPath()+"/loginUser"); return; }
        req.setAttribute("requests", reqDAO.findByUserId(u.getId()));
        req.getRequestDispatcher("/WEB-INF/views/userDashboard.jsp")
                .forward(req,resp);
    }
}
