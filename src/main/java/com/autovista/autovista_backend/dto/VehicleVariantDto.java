package com.autovista.autovista_backend.dto;

import java.math.BigDecimal;

public class VehicleVariantDto {
    private String name;
    private String fuelType;
    private String transmission;
    private BigDecimal price;
    public VehicleVariantDto(String name,String fuelType,String transmission,BigDecimal price){
        this.name=name;
        this.fuelType=fuelType;
        this.transmission=transmission;
        this.price=price;
    }
    public String getName(){return name;}
    public String getFuelType(){return fuelType;}
    public String getTransmission(){return transmission;}
    public BigDecimal getPrice(){return price;}
}
