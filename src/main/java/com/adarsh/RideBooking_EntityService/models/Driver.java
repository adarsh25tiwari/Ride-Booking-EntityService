package com.adarsh.RideBooking_EntityService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","bookings"})
public class Driver extends BaseModel{

    @Column(nullable=false)
    private String name;

    @Column(nullable=false,unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable = false,unique = true)
    private String licenceNumber;

    private String aadharCard;

    @Column(unique = true)
    private String mobileNumber;

    @OneToMany(mappedBy = "driver")    // 1 driver can have many bookings
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings= new ArrayList<>();

}