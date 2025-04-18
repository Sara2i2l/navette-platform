package com.transport.test;

import com.transport.persistence.TransportCompanyDAO;
import com.transport.model.TransportCompany;

public class TestDAO {
    public static void main(String[] args) {
        TransportCompanyDAO dao = new TransportCompanyDAO();

        // Create a sample company
        TransportCompany company = new TransportCompany();
        company.setName("TransLuxe");

        dao.create(company);

        // Retrieve and print all companies
        for (TransportCompany tc : dao.findAll()) {
            System.out.println("Company ID: " + tc.getId() + ", Name: " + tc.getName());
        }
    }
}
