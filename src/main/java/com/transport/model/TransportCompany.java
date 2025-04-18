package com.transport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "transport_company")
public class TransportCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;



    @OneToMany(mappedBy = "company")
    private List<ShuttleOffer> shuttleOffers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShuttleOffer> getShuttleOffers() {
        return shuttleOffers;
    }

    public void setShuttleOffers(List<ShuttleOffer> shuttleOffers) {
        this.shuttleOffers = shuttleOffers;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
