package com.adarsh.RideBooking_EntityService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Color extends  BaseModel {

    @Column(nullable = false)
    private String colorName;
}
