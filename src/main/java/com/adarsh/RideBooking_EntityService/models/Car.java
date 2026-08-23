package com.adarsh.RideBooking_EntityService.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car extends BaseModel {

    @Column(nullable = false, unique = true)
    private String numberPlate;

    @Column(nullable = false)
    private String carName;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Column(nullable = false)
    private String companyName;

    @OneToOne
    private Color color;

    @OneToOne
    private Driver driver;
}
