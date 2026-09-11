package com.bhavesh.roovia.service.checkout;

import com.bhavesh.roovia.entity.Booking;

public interface CheckoutService {

    String getCheckoutSession(Booking booking, String successUrl, String failureUrl);

}
