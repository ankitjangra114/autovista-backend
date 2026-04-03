package com.autovista.autovista_backend.dto;

import java.math.BigDecimal;

public class VariantPricingDto {
    private BigDecimal exShowroom;
    private BigDecimal rtoCharges;
    private BigDecimal insurance;
    private BigDecimal otherCharges;
    private BigDecimal onRoadPrice;
    public VariantPricingDto(BigDecimal exShowroom, BigDecimal rtoCharges, BigDecimal insurance, BigDecimal otherCharges, BigDecimal onRoadPrice) {
        this.exShowroom = exShowroom;
        this.rtoCharges = rtoCharges;
        this.insurance = insurance;
        this.otherCharges = otherCharges;
        this.onRoadPrice = onRoadPrice;
    }
    public BigDecimal getExShowroom() {return exShowroom;}
    public BigDecimal getRtoCharges() {return rtoCharges;}
    public BigDecimal getInsurance() {return insurance;}
    public BigDecimal getOtherCharges() {return otherCharges;}
    public BigDecimal getOnRoadPrice() {return onRoadPrice;}
}
