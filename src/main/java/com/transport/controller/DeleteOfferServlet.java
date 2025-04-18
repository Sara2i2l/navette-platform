package com.transport.controller;

import com.transport.persistence.ShuttleOfferDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "DeleteOfferServlet", urlPatterns = {"/deleteOffer"})
public class DeleteOfferServlet extends HttpServlet {

    private ShuttleOfferDAO offerDAO;

    @Override
    public void init() throws ServletException {
        offerDAO = new ShuttleOfferDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        if (idStr != null) {
            Long id = Long.parseLong(idStr);
            offerDAO.delete(id);
        }
        resp.sendRedirect(req.getContextPath() + "/companyDashboard");
    }
}
