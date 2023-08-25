package com.example.vehicleApp.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
@Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }
    public void addNewVehicle(Vehicle vehicle) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByName(vehicle.getName());

        if (vehicleOptional.isPresent()) {
            throw new IllegalStateException("This vehicle is already defined.");
        }

        vehicleRepository.save(vehicle);
    }
}
