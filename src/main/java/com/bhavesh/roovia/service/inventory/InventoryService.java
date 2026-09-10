package com.bhavesh.roovia.service.inventory;

import com.bhavesh.roovia.dto.hotel.HotelPriceResponseDto;
import com.bhavesh.roovia.dto.hotel.HotelSearchRequest;
import com.bhavesh.roovia.dto.inventory.InventoryDto;
import com.bhavesh.roovia.dto.inventory.UpdateInventoryRequestDto;
import com.bhavesh.roovia.entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceResponseDto> searchHotels(HotelSearchRequest hotelSearchRequest);

    List<InventoryDto> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto);
}
