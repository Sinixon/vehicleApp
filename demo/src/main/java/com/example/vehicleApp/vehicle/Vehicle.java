package com.example.vehicleApp.vehicle;

public class Vehicle {
    private Long id;
    private String name;
    private int available;
    private int total;

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
