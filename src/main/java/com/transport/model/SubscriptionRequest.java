package com.transport.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "subscription_request", uniqueConstraints = {
        @UniqueConstraint(
                name = "unique_request",
                columnNames = {"user_id", "departureCity", "arrivalCity", "startDate", "endDate", "departureTime", "arrivalTime"}
        )
})
public class SubscriptionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String departureCity;
    private String arrivalCity;

    private LocalDate startDate;
    private LocalDate endDate;

    private LocalTime departureTime;
    private LocalTime arrivalTime;

    private int interestedCount = 1;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
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

    public int getInterestedCount() {
        return interestedCount;
    }
    public void setInterestedCount(int interestedCount) {
        this.interestedCount = interestedCount;
    }
}
