package com.autovista.autovista_backend.dto;

import com.autovista.autovista_backend.model.VehicleType;

import java.math.BigDecimal;
import java.util.List;

public class VehicleDetailDto {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private String fuelType;
    private String transmission;
    private String description;
    private String thumbnailUrl;
    private VehicleType vehicleType;
    private List<String> images;
    public VehicleDetailDto(Long id,
                            String name,
                            String brand,
                            BigDecimal price,
                            String fuelType,
                            String transmission,
                            String description,
                            String thumbnailUrl,
                            VehicleType vehicleType,
                            List<String> images){
        this.id=id;
        this.name=name;
        this.brand=brand;
        this.price=price;
        this.fuelType=fuelType;
        this.transmission=transmission;
        this.description=description;
        this.thumbnailUrl=thumbnailUrl;
        this.vehicleType=vehicleType;
        this.images=images;
    }
    public Long getId(){return id;}
    public String getName(){return name;}
    public String getBrand(){return brand;}
    public BigDecimal getPrice(){return price;}
    public String getFuelType(){return fuelType;}
    public String getTransmission(){return transmission;}
    public String getDescription(){return description;}
    public String getThumbnailUrl(){return thumbnailUrl;}
    public VehicleType getVehicleType(){return vehicleType;}
    public List<String> getImages(){return images;}
}
