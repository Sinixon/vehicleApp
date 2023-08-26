package com.example.vehicleApp.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Objects;
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

    public void deleteVehicle(Long vehicleId) {
        boolean exists = vehicleRepository.existsById(vehicleId);

        if (!exists) {
            //Make better message? Id says nothing.
            throw new IllegalStateException("Vehicle with id " + vehicleId + " does not exists");
        }
        vehicleRepository.deleteById(vehicleId);
    }

    @Transactional
    public void updateVehicle(Long vehicleId, String name) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalStateException("Vehicle with name " + name + " does not exists."));

        if (name != null && name.length() > 0 && !Objects.equals(vehicle.getName(), name)) {
            vehicle.setName(name);
        }
    }

    @Transactional
    public void updateVehicleAvailable(Long vehicleId, String name, int available) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalStateException("Vehicle with name " + name + " does not exists."));

        if (name != null && name.length() > 0 && !Objects.equals(vehicle.getName(), name)) {
            vehicle.setName(name);
        }

        if (available >= 0) {
            if (available > vehicle.getTotal()) {
                throw new IllegalStateException("The amount of vehicles available cannot exceed the total amount of vehicles present");
            }
            vehicle.setAvailable(available);
        }

    }

    @Transactional
    public void updateVehicleTotal(Long vehicleId, String name, int total) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalStateException("Vehicle with name " + name + " does not exists."));

        if (name != null && name.length() > 0 && !Objects.equals(vehicle.getName(), name)) {
            vehicle.setName(name);
        }

        if (total > 0) {
            if (vehicle.getAvailable() > total) {
                throw new IllegalStateException("The amount of vehicles available cannot exceed the total amount of vehicles present");
            }
            vehicle.setTotal(total);
        }

    }

    @Transactional
    public void updateVehicle(Long vehicleId, String name, int available, int total) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalStateException("Vehicle with name " + name + " does not exists."));

        if (name != null && name.length() > 0 && !Objects.equals(vehicle.getName(), name)) {
            vehicle.setName(name);
        }

        // Check if total amount of the vehicle being updated is atleast 1 and available is atleast 0 or more
        if (available >= 0 && total > 0) {
            if (available > total) {
                throw new IllegalStateException("The amount of vehicles available cannot exceed the total amount of vehicles present");
            }
            vehicle.setAvailable(available);
            vehicle.setTotal(total);
        }
    }


}
