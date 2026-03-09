package com.autovista.autovista_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="vehicle_image")
public class VehicleImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name="vehicle_id",nullable = false)
    private Vehicle vehicle;
    public Long getId(){return id;}
    public String getImageUrl(){return imageUrl;}
    public Vehicle getVehicle(){return vehicle;}
    public void setImageUrl(String imageUrl){this.imageUrl=imageUrl;}
    public void setVehicle(Vehicle vehicle) {this.vehicle = vehicle;}
}
