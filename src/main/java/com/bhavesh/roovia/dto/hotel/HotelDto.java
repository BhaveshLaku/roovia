package com.bhavesh.roovia.dto.hotel;

import com.bhavesh.roovia.entity.HotelContactInfo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HotelDto {

    private Long id;

    @NotBlank(message = "Hotel name is required")
    @Size(max = 255, message = "Hotel name must not exceed 255 characters")
    private String name;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City must not exceed 100 characters")
    private String city;

    private String[] photos;

    private String[] amenities;

    @NotNull(message = "Contact info is required")
    @Valid
    private HotelContactInfo contactInfo;

    @NotNull(message = "Active status is required")
    private Boolean active;
}
