package org.example;

class Motorcycle extends Vehicle {
    String category;

    public Motorcycle(String brand, String model, int year, double price, String category) {
        super(brand, model, year, price);
        this.category = category;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ";" + category;
    }

    @Override
    public String toString() {
        return "Motorcycle [category=" + category + ", " + super.toString() + "]";
    }
}