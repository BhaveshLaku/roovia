package com.bhavesh.roovia.strategy;

import com.bhavesh.roovia.entity.Inventory;

import java.math.BigDecimal;

//

public class BasePricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        return inventory.getRoom().getBasePrice();
    }
}
