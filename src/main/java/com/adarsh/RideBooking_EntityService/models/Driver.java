package com.adarsh.RideBooking_EntityService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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

    @Column(nullable=false)
    private String aadharCard;

    @Column(nullable=false,unique = true)
    private String mobileNumber;

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    private Car car;

    @Enumerated(EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    private Boolean isAvailable;

    @OneToOne
    private ExactLocation lastLocation;

    @DecimalMin(value = "0.0", inclusive = true, message = "Rating must be at least 0.0")
    @DecimalMax(value = "5.0", inclusive = true, message = "Rating must be at most 5.0")
    private Double driverRating;


    @OneToMany(mappedBy = "driver")                     // 1 driver can have many bookings
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings= new ArrayList<>();

}