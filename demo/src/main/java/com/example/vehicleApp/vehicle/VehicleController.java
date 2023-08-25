package com.example.vehicleApp.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }
    @PostMapping
    public void registerNewVehicle(@RequestBody Vehicle vehicle) {
        // TODO: Build a check that available <= total & total > 0 & available >= 0
        vehicleService.addNewVehicle(vehicle);
    }
    @DeleteMapping(path = "{vehicleId}")
    public void deleteVehicle(@PathVariable("vehicleId") Long vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
    }

    @PutMapping(path = "{vehicleId}")
    public void updateVehicle(@PathVariable("vehicleId") Long vehicleId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) Integer available,
                              @RequestParam(required = false) Integer total) {
        vehicleService.updateStudent(vehicleId, name, available, total);
    }
}
