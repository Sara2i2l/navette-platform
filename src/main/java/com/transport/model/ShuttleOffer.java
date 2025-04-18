package com.transport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name = "shuttle_offer")
public class ShuttleOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private TransportCompany company;
    // Subscription period
    private LocalDate startDate;
    private LocalDate endDate;

    // Departure and arrival times
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    // Cities
    private String departureCity;
    private String arrivalCity;

    // Additional details about the autocar, such as description
    private String autocarDescription;

    // Target and actual subscriber counts
    private int subscriberTarget;
    private int subscriberCount;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransportCompany getCompany() {
        return company;
    }

    public void setCompany(TransportCompany company) {
        this.company = company;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getAutocarDescription() {
        return autocarDescription;
    }

    public void setAutocarDescription(String autocarDescription) {
        this.autocarDescription = autocarDescription;
    }

    public int getSubscriberTarget() {
        return subscriberTarget;
    }

    public void setSubscriberTarget(int subscriberTarget) {
        this.subscriberTarget = subscriberTarget;
    }

    public int getSubscriberCount() {
        return subscriberCount;
    }

    public void setSubscriberCount(int subscriberCount) {
        this.subscriberCount = subscriberCount;
    }
}
