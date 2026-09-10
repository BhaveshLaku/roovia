package com.bhavesh.roovia.strategy;

import com.bhavesh.roovia.entity.Inventory;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;


@RequiredArgsConstructor
public class HolidayPricingStrategy implements PricingStrategy {

    private final PricingStrategy wrapped;

    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        BigDecimal price = wrapped.calculatePrice(inventory);
        boolean isTodayHoliday = true; //Call an API or check with local date
        if (isTodayHoliday) {
            return price.multiply(BigDecimal.valueOf(1.25));
        }
        return price;
    }
}
