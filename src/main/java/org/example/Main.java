package org.example;

public class Main {
    public static void main(String[] args) {
        VehicleRepository repo = new VehicleRepository("C:\\Users\\szala\\IdeaProjects\\zadaniespring1\\src\\main\\java\\org\\example\\vehicles.csv");


        Car car1 = new Car("Toyota", "Corolla", 2020, 20000);
        Car car2 = new Car("Honda", "Civic", 2021, 22000);
        repo.vehicles.add(car1);
        repo.vehicles.add(car2);
        Motorcycle moto1 = new Motorcycle("Yamaha", "MT-07", 2022, 7500, "Sport");
        Motorcycle moto2 = new Motorcycle("Honda", "CBR500R", 2023, 6500, "Sport");
        repo.vehicles.add(moto1);
        repo.vehicles.add(moto2);
        repo.save();
        UserInteraction ui = new UserInteraction(repo);
        ui.showVehicles();
    }
}