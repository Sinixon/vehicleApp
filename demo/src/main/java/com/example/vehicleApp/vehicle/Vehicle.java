package com.example.vehicleApp.vehicle;

import jakarta.persistence.*;

@Entity
@Table
public class Vehicle {
    @Id
    @SequenceGenerator(
            name = "vehicle_sequence",
            sequenceName = "vehicle_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "vehicle_sequence"
    )

    private Long id;
    private String name;
    private int available;
    private int total;

    public Vehicle() {

    }

    public Vehicle(Long id,
                   String name,
                   int available,
                   int total) {
        this.id = id;
        this.name = name;
        this.available = available;
        this.total = total;
    }

    public Vehicle(String name,
                   int available,
                   int total) {
        this.name = name;
        this.available = available;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", total=" + total +
                '}';
    }
}
