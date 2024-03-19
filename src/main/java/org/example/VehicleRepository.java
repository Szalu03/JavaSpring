package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class VehicleRepository implements IVehicleRepository {
    List<Vehicle> vehicles = new ArrayList<>();
    String filename;

    public VehicleRepository(String filename) {
        this.filename = filename;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    vehicles.add(new Car(parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4])));
                } else if (parts.length == 7) {
                    vehicles.add(new Motorcycle(parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), parts[6]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rentVehicle(int id) {
        for (Vehicle v : vehicles) {
            if (v.id == id) {
                v.rented = true;
                save();
                break;
            }
        }
    }

    @Override
    public void returnVehicle(int id) {
        for (Vehicle v : vehicles) {
            if (v.id == id) {
                v.rented = false;
                save();
                break;
            }
        }
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public void save() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Vehicle v : vehicles) {
                pw.println(v.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}