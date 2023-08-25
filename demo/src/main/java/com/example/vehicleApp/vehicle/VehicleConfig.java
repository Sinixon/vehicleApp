package com.example.vehicleApp.vehicle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VehicleConfig {
    @Bean
    CommandLineRunner commandLineRunner(VehicleRepository repository) {
        return args -> {
            Vehicle recon = new Vehicle(
                    "Recon",
                    3,
                    10
            );

            Vehicle jeep = new Vehicle(
                    "Jeep",
                    1,
                    2
            );

            repository.saveAll(List.of(recon, jeep));
        };
    }
}
