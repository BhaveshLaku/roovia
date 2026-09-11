package com.bhavesh.roovia.dto.hotel;

import com.bhavesh.roovia.dto.room.RoomPriceResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HotelInfoDto {

    @NotNull
    @Valid
    private HotelDto hotel;

    @NotNull
    @Valid
    private List<RoomPriceResponseDto> rooms;
}