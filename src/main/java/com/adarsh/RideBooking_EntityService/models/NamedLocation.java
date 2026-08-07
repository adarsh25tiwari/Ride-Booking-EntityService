package com.adarsh.RideBooking_EntityService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NamedLocation extends BaseModel {

    private String name;

    private String pinCode;

    private String city;

    private String state;

    private String country;

    @OneToOne
    private ExactLocation exactLocation;
}
