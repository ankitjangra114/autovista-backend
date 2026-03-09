package com.autovista.autovista_backend.repository;

import com.autovista.autovista_backend.model.Vehicle;
import com.autovista.autovista_backend.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>, JpaSpecificationExecutor<Vehicle> {
    List<Vehicle> findByVehicleType(VehicleType vehicleType);
    List<Vehicle> findByBrand(String brand);
    List<Vehicle> findByNameContainingIgnoreCase(String name);
}
