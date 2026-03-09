package com.autovista.autovista_backend.dto;

import com.autovista.autovista_backend.model.VehicleType;

import java.math.BigDecimal;

public class VehicleResponseDto {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private String thumbnailUrl;
    private VehicleType vehicleType;
    public VehicleResponseDto(Long id,
                              String name,
                              String brand,
                              BigDecimal price,
                              String thumbnailUrl,
                              VehicleType vehicleType){
        this.id=id;
        this.name=name;
        this.brand=brand;
        this.price=price;
        this.thumbnailUrl=thumbnailUrl;
        this.vehicleType=vehicleType;
    }
    public Long getId(){return id;}
    public String getName(){return name;}
    public String getBrand(){return brand;}
    public BigDecimal getPrice(){return price;}
    public String getThumbnailUrl(){return thumbnailUrl;}
    public VehicleType getVehicleType(){return vehicleType;}
}
