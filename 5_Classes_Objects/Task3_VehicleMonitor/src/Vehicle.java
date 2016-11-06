
import java.time.Year;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class Vehicle {

    String type;
    String model;
    int power;
    double fuelConsumption;
    short yearProduced;
    int distance;
    String licenseNo;
    int weight;
    String color;

    Vehicle(String type, String model, int power, double fuelConsumption, short yearProduced,int distance, String licenseNo, int weight, String color) {
        this.type = type;
        this.model = model;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.yearProduced = yearProduced;
        this.distance=distance;
        this.licenseNo = licenseNo;
        this.weight = weight;
        this.color = color;
    }

    Vehicle(String type, String model, int power, double fuelConsumption, short yearProduced,int distance, String licenseNo, int weight) {
        this.type = type;
        this.model = model;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.yearProduced = yearProduced;
        this.distance=distance;
        this.licenseNo = licenseNo;
        this.weight = weight;
        this.color = "n/a";
    }

    Vehicle(String type, String model, int power, double fuelConsumption, short yearProduced,int distance, String licenseNo, String color) {
        this.type = type;
        this.model = model;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.yearProduced = yearProduced;
        this.distance=distance;
        this.licenseNo = licenseNo;
        this.weight = 0;
        this.color = color;
    }

    Vehicle(String type, String model, int power, double fuelConsumption, short yearProduced,int distance, String licenseNo) {
        this.type = type;
        this.model = model;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.yearProduced = yearProduced;
        this.distance=distance;
        this.licenseNo = licenseNo;
        this.weight = 0;
        this.color = "n/a";
    }

   

    double calculateTripPrice(double fuelPrice, double distance) {
        double result;
        result = (fuelConsumption / 100) * fuelPrice * distance;
        return result;
    }

    double getInsurancePrice() {
        double insurancePrice = 0;
        int year = Year.now().getValue();
        if (type == "car") {
            insurancePrice = (0.16 * power) * (1.25 * (year - yearProduced)) * (0.05 * fuelConsumption) * 1;
            return insurancePrice;
        } else if (type == "suv") {
            insurancePrice = (0.16 * power) * (1.25 * (year - yearProduced)) * (0.05 * fuelConsumption) * 1.12;
            return insurancePrice;
        } else if (type == "truck") {
            insurancePrice = (0.16 * power) * (1.25 * (year - yearProduced)) * (0.05 * fuelConsumption) * 1.20;
            return insurancePrice;
        } else if (type == "motorycle") {
            insurancePrice = (0.16 * power) * (1.25 * (year - yearProduced)) * (0.05 * fuelConsumption) * 1.50;
            
        }
        return insurancePrice;
    }
}
