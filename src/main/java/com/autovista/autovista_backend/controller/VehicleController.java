package com.autovista.autovista_backend.controller;

import com.autovista.autovista_backend.dto.VehicleDetailDto;
import com.autovista.autovista_backend.dto.VehicleResponseDto;
import com.autovista.autovista_backend.model.Vehicle;
import com.autovista.autovista_backend.model.VehicleType;
import com.autovista.autovista_backend.service.VehicleService;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Entity → Specification → Repository → Service → DTO → Controller → JSON

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;
    public VehicleController(VehicleService vehicleService){
        this.vehicleService=vehicleService;
    }
    @GetMapping
//    public List<Vehicle> getAllVehicle(){
//        return vehicleService.getAllVehicle();
//    }
    public Page<VehicleResponseDto> getVehicles(
            @RequestParam(required = false)VehicleType type,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String search,
            Pageable pageable
            ){
        return vehicleService.filterVehicles(type, brand, search, pageable);
    }
    @GetMapping("/{id}")
    public VehicleDetailDto getVehicleById(@PathVariable Long id){
        return vehicleService.getVehicleById(id);
    }
    @GetMapping("/{id}/brochure")
    public ResponseEntity<Resource> downloadBrochure(@PathVariable Long id) throws Exception {
        Resource resource = vehicleService.getVehicleBrochure(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
