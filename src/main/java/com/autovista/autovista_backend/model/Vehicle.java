package com.autovista.autovista_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="vehicle")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String brand;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleType vehicleType;
    private BigDecimal price;
    private String fuelType;
    private String transmission;
    @Column(length = 2000)
    private String description;
    private String thumbnailUrl;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<VehicleImage> images;
    @OneToOne(mappedBy = "vehicle",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private VehicleDocument document;
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public VehicleType getVehicleType() { return vehicleType; }
    public BigDecimal getPrice() { return price; }
    public String getFuelType() { return fuelType; }
    public String getTransmission() { return transmission; }
    public String getDescription() { return description; }
    public String getThumbnailUrl() { return thumbnailUrl; }
    public List<VehicleImage> getImage(){return images;}
    public VehicleDocument getDocument(){return document;}
}
