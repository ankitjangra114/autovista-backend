package com.autovista.autovista_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_document")
public class VehicleDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String filePath;
    @OneToOne
    @JoinColumn(name="vehicle_id", nullable = false)
    private Vehicle vehicle;
    public Long getId(){return id;}
    public String getFileName(){return fileName;}
    public String getFilePath(){return filePath;}
    public Vehicle getVehicle(){return vehicle;}
    public void setFileName(String fileName){this.fileName=fileName;}
    public void setFilePath(String filePath){this.filePath=filePath;}
    public void setVehicle(Vehicle vehicle){this.vehicle=vehicle;}
}
