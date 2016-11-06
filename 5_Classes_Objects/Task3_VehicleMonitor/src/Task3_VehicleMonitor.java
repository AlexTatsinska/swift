
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class Task3_VehicleMonitor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*Напишете програма Task3_VehicleMonitor, която чете от стандартния вход числа N, F и N на брой
последващи описания на превозни средства.*/
        int n = sc.nextInt();
        double f = sc.nextDouble();
        sc.nextLine();
        
        String licenseNo = null;
        int counter = 0;
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        Vehicle[] vehicleArr = new Vehicle[n];
        Vehicle vehicle = null;

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] split = input.split(",");
            String type = split[0];
            String model = split[1];
            int power = Integer.parseInt(split[2].trim());
            double fuelConsumption = Double.parseDouble(split[3].trim());
            short yearProduced = Short.parseShort(split[4].trim());
            int distance = Integer.parseInt(split[5].trim());
            if (licenseNo == null) {
                licenseNo = "0000";
            } else if (counter < 9) {
                counter++;
                licenseNo = counter3 + "" + counter2 + "" + counter1 + "" + counter;
            } else if (counter1 < 9) {
                counter1++;
                licenseNo = counter3 + "" + counter2 + "" + counter1 + "" + counter;
            } else if (counter2 < 9) {
                counter2++;
                licenseNo = counter3 + "" + counter2 + "" + counter1 + "" + counter;
            } else if (counter3 < 9) {
                counter3++;
                licenseNo = counter3 + "" + counter2 + "" + counter1 + "" + counter;
            }
            if (split.length == 8) {
                int weight = Integer.parseInt(split[6].trim());
                String color = split[7].trim();
                vehicle = new Vehicle(type, model, power, fuelConsumption, yearProduced, distance, licenseNo, weight, color);
            }
            if (split.length == 6) {
                vehicle = new Vehicle(type, model, power, fuelConsumption, yearProduced, distance, licenseNo);
            }
            if (split.length == 7) {
                if (Integer.parseInt(split[6].trim()) > 0) {
                    int weight = Integer.parseInt(split[6].trim());
                    vehicle = new Vehicle(type, model, power, fuelConsumption, yearProduced,distance, licenseNo, weight);
                } else {
                    String color = split[6].trim();
                    vehicle = new Vehicle(type, model, power, fuelConsumption, yearProduced,distance, licenseNo, color);
                }
            }

            vehicleArr[i] = vehicle;
        }
        /*<РЕГ. НОМЕР> - <МОДЕЛ>, <ГОДИНА>, <ЦВЯТ> 
Insurance cost: <ЦЕНА ЗА ЗАСТРАХОВКА> - Тravel cost: <ЦЕНА НА ПЪТУВАНЕТО>*/
        for (int i=0;i<vehicleArr.length;i++){
            System.out.println(vehicleArr[i].licenseNo+"-"+vehicleArr[i].model+", "+vehicle.yearProduced+", "+vehicleArr[i].color);
            System.out.println("Insurance cost: "+vehicleArr[i].getInsurancePrice()+" -Travel cost: "+vehicleArr[i].calculateTripPrice(f,vehicleArr[i].distance) );
        }

    }

}
