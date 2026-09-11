package com.bhavesh.roovia.dto.hotel;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelReportDto {

    @PositiveOrZero(message = "Booking count must not be negative")
    private Long bookingCount;

    @PositiveOrZero(message = "Total revenue must not be negative")
    private BigDecimal totalRevenue;

    @PositiveOrZero(message = "Average revenue must not be negative")
    private BigDecimal avgRevenue;
}