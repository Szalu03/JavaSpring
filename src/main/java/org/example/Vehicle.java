package org.example;

import java.util.*;
import java.io.*;

abstract class Vehicle {
    static int counter = 0;
    int id;
    String brand;
    String model;
    int year;
    double price;
    boolean rented;

    public Vehicle(String brand, String model, int year, double price) {
        this.id = counter++;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.rented = false;
    }

    public String toCSV() {
        return id + ";" + brand + ";" + model + ";" + year + ";" + price + ";" + rented;
    }

    @Override
    public String toString() {
        return "Vehicle [id=" + id + ", brand=" + brand + ", model=" + model + ", year=" + year + ", price=" + price + ", rented=" + rented + "]";
    }
}