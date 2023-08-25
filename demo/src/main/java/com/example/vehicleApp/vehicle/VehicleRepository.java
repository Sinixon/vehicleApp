package com.example.vehicleApp.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // Using upper so it isn't possible to for instance add a vehicle named Test and test.
    @Query("SELECT v FROM Vehicle v WHERE UPPER(v.name) = UPPER(?1)")
    Optional<Vehicle> findVehicleByName(String name);
}
