package com.bhavesh.roovia.dto.hotel;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class HotelInfoRequestDto {

    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date cannot be in the past")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @Future(message = "End date must be in the future")
    private LocalDate endDate;

    @NotNull(message = "Rooms count is required")
    @Min(value = 1, message = "At least 1 room is required")
    private Long roomsCount;

    @AssertTrue(message = "End date must be after start date")
    private boolean isEndDateValid() {
        if (startDate == null || endDate == null) {
            return true; // let @NotNull handle nulls
        }
        return endDate.isAfter(startDate);
    }
}

