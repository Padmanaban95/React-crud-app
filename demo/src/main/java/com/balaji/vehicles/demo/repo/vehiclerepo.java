package com.balaji.vehicles.demo.repo;
import java.util.List;
import com.balaji.vehicles.demo.model.vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface vehiclerepo extends JpaRepository<vehicle, Long> {
   
    List<vehicle> findBymodel(String model);
  }