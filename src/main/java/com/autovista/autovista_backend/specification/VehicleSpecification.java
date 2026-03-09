package com.autovista.autovista_backend.specification;

import com.autovista.autovista_backend.model.Vehicle;
import com.autovista.autovista_backend.model.VehicleType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class VehicleSpecification {
    public static Specification<Vehicle> filterVehicles(
            VehicleType type, String brand, String search
    ){
        return(root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(type!=null){
                predicates.add(criteriaBuilder.equal(root.get("vehicleType"),type));
            }
            if(brand!=null && !brand.isEmpty()){
                predicates.add(criteriaBuilder.equal(root.get("brand"),brand));
            }
            if(search!=null && !search.isEmpty()){
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%"+search.toLowerCase()+"%"
                ));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
