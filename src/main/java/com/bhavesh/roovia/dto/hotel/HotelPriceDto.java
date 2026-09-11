package com.bhavesh.roovia.dto.hotel;

import com.bhavesh.roovia.entity.Hotel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelPriceDto {

    @NotNull(message = "Hotel is required")
    @Valid
    private Hotel hotel;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must not be negative")
    private Double price;
}
