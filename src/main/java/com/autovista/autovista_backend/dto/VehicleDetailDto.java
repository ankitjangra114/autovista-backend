package com.autovista.autovista_backend.dto;

import com.autovista.autovista_backend.model.VehicleType;
import com.autovista.autovista_backend.model.VehicleVariant;

import java.math.BigDecimal;
import java.util.List;

public class VehicleDetailDto {
    private Long id;
    private String name;
    private String brand;
    private String description;
    private String thumbnailUrl;
    private VehicleType vehicleType;
    private List<String> images;
    private List<VehicleVariantDto> variants;
    public VehicleDetailDto(Long id,
                            String name,
                            String brand,
                            String description,
                            String thumbnailUrl,
                            VehicleType vehicleType,
                            List<String> images,
                            List<VehicleVariantDto> variants){
        this.id=id;
        this.name=name;
        this.brand=brand;
        this.description=description;
        this.thumbnailUrl=thumbnailUrl;
        this.vehicleType=vehicleType;
        this.images=images;
        this.variants=variants;
    }
    public Long getId(){return id;}
    public String getName(){return name;}
    public String getBrand(){return brand;}
    public String getDescription(){return description;}
    public String getThumbnailUrl(){return thumbnailUrl;}
    public VehicleType getVehicleType(){return vehicleType;}
    public List<String> getImages(){return images;}
    public List<VehicleVariantDto> getVariants(){
        return variants;
    }
}
