package com.bhavesh.roovia.service.hotel;

import com.bhavesh.roovia.dto.hotel.HotelDto;
import com.bhavesh.roovia.dto.hotel.HotelInfoDto;
import com.bhavesh.roovia.dto.hotel.HotelInfoRequestDto;

import java.util.List;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activateHotel(Long hotelId);

    HotelInfoDto getHotelInfoById(Long hotelId, HotelInfoRequestDto hotelInfoRequestDto);

    List<HotelDto> getAllHotels();
}
