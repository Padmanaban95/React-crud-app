package com.balaji.vehicles.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.balaji.vehicles.demo.model.vehicle;
import com.balaji.vehicles.demo.repo.vehiclerepo;
@CrossOrigin(origins = "http://localhost:5432")
@RestController
@RequestMapping("/vehicles")
public class vehiclecon {
  @Autowired
  vehiclerepo vehrepository;
  @GetMapping("/vehicles")
  public ResponseEntity<List<vehicle>> getAllvehicles(@RequestParam(required = false) String model) {
    try {
      List<vehicle> vehicles = new ArrayList<vehicle>();
      if (model == null)
        vehrepository.findAll().forEach(vehicles::add);
      else
        vehrepository.findBymodel(model).forEach(vehicles::add);
      if (vehicles.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(vehicles, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/vehicles/{id}")
  public ResponseEntity<vehicle> getvehicleById(@PathVariable("id") long id) {
    Optional<vehicle> vehData = vehrepository.findById(id);
    if (vehData.isPresent()) {
      return new ResponseEntity<>(vehData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/vehicles")
  public ResponseEntity<vehicle> createvehicle(@RequestBody vehicle vehicles) {
    try {
      vehicle _vehi = vehrepository
          .save(new vehicle(vehicles.getId(), vehicles.getyear(), vehicles.getmake(), vehicles.getmodel()));
      return new ResponseEntity<>(_vehi, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @PutMapping("/vehicles")
  public ResponseEntity<vehicle> updatevehicle(@PathVariable("id") long id, @RequestBody vehicle vehicles) {
    Optional<vehicle> vehiData = vehrepository.findById(id);
    if (vehiData.isPresent()) {
      vehicle _vehic = vehiData.get();
      _vehic.setyear(vehicles.getyear());
      _vehic.setmake(vehicles.getmake());
      _vehic.setmodel(vehicles.getmodel());
      return new ResponseEntity<>(vehrepository.save(_vehic), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @DeleteMapping("/vehicles/{id}")
  public ResponseEntity<HttpStatus> deletevehicle(@PathVariable("id") long id) {
    try {
      vehrepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}

    

