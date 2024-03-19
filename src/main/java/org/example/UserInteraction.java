package org.example;

class UserInteraction {
    IVehicleRepository repo;

    public UserInteraction(IVehicleRepository repo) {
        this.repo = repo;
    }

    public void rentVehicle(int id) {
        repo.rentVehicle(id);
    }

    public void returnVehicle(int id) {
        repo.returnVehicle(id);
    }

    public void showVehicles() {
        for (Vehicle v : repo.getVehicles()) {
            System.out.println(v);
        }
    }
}