package com.autovista.autovista_backend.service;

import com.autovista.autovista_backend.dto.VehicleDetailDto;
import com.autovista.autovista_backend.dto.VehicleResponseDto;
import com.autovista.autovista_backend.dto.VehicleVariantDto;
import com.autovista.autovista_backend.exception.ResourceNotFoundException;
import com.autovista.autovista_backend.model.Vehicle;
import com.autovista.autovista_backend.model.VehicleType;
import com.autovista.autovista_backend.repository.VehicleRepository;
import com.autovista.autovista_backend.specification.VehicleSpecification;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository=vehicleRepository;
    }
    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }
    public List<Vehicle> getVehicleByType(VehicleType type){
        return vehicleRepository.findByVehicleType(type);
    }
    public List<Vehicle> getVehicleByBrand(String brand){
        return vehicleRepository.findByBrand(brand);
    }
    public List<Vehicle> searchVehicleByName(String name){
        return vehicleRepository.findByNameContainingIgnoreCase(name);
    }
    public Page<VehicleResponseDto> filterVehicles(
            VehicleType type, String brand, String search, Pageable pageable
    ){
        Specification<Vehicle> specification = VehicleSpecification.filterVehicles(type, brand, search);
        Page<Vehicle> vehiclePage= vehicleRepository.findAll(specification,pageable);
        return vehiclePage.map(vehicle ->
                new VehicleResponseDto(
                        vehicle.getId(),
                        vehicle.getName(),
                        vehicle.getBrand(),
                        vehicle.getPrice(),
                        vehicle.getThumbnailUrl(),
                        vehicle.getVehicleType()
                ));
    }
    public VehicleDetailDto getVehicleById(Long id){
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Vehicle not found with id: " + id));
        List<String> imageUrls = vehicle.getImage().stream()
                .map(image -> image.getImageUrl()).toList();
        List<VehicleVariantDto> variantDtos = vehicle.getVariants()
                .stream()
                .map(v->new VehicleVariantDto(
                        v.getName(),
                        v.getFuelType(),
                        v.getTransmission(),
                        v.getPrice()
                )).toList();
        return new VehicleDetailDto(
                vehicle.getId(),
                vehicle.getName(),
                vehicle.getBrand(),
                vehicle.getDescription(),
                vehicle.getThumbnailUrl(),
                vehicle.getVehicleType(),
                imageUrls,
                variantDtos
        );
    }
    public Resource getVehicleBrochure(Long id) throws Exception{
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Vehicle not found with id: "+id));
        if(vehicle.getDocument()==null){
            throw new ResourceNotFoundException("Brochure not available for vehicle id: "+id);
        }
        Path path = Paths.get(vehicle.getDocument().getFilePath());
        Resource resource = new UrlResource(path.toUri());
        if(!resource.exists()){
            throw new ResourceNotFoundException("File not found on server");
        }
        return resource;
    }
}
