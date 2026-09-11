package com.bhavesh.roovia.service.booking;

import com.bhavesh.roovia.dto.booking.BookingDto;
import com.bhavesh.roovia.dto.booking.BookingRequest;
import com.bhavesh.roovia.dto.booking.GuestDto;
import com.bhavesh.roovia.dto.hotel.HotelReportDto;
import com.bhavesh.roovia.entity.enums.BookingStatus;
import com.stripe.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<Long> guestIdList);

    String initiatePayments(Long bookingId);

    void capturePayment(Event event);

    void cancelBooking(Long bookingId);

    BookingStatus getBookingStatus(Long bookingId);

    List<BookingDto> getAllBookingsByHotelId(Long hotelId);

    HotelReportDto getHotelReport(Long hotelId, LocalDate startDate, LocalDate endDate);

    List<BookingDto> getMyBookings();
}
