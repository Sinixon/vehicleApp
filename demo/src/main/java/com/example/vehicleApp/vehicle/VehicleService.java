package com.example.vehicleApp.vehicle;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleService {
    public List<Vehicle> getVehicles() {
        return List.of(
                new Vehicle(1L,
                        "Recon",
                        3,
                        10)
        );
    }
}
