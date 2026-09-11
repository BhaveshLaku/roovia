package com.bhavesh.roovia.dto.hotel;

import com.bhavesh.roovia.entity.HotelContactInfo;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelPriceResponseDto {

    private Long id;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    private HotelContactInfo contactInfo;

    @PositiveOrZero(message = "Price must not be negative")
    private Double price;
}
