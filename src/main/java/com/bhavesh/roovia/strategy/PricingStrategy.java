package com.bhavesh.roovia.strategy;

import com.bhavesh.roovia.entity.Inventory;

import java.math.BigDecimal;


public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}
