/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Worker extends Person {

    private double weekSalary;
    private int workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, int workHoursPerDay) {
        super(firstName, lastName);
        this.weekSalary = weekSalary;
        this.workHoursPerDay = workHoursPerDay;
    }

    boolean checkWeekSalary(double weekSalary) {
        boolean result = true;
        if (weekSalary > 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    boolean checkWorkHoursPerDay(int workHoursPerDay) {
        boolean result = true;
        if (workHoursPerDay > 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    double salaryPerHour() {
        double salaryPerHour = weekSalary / (workHoursPerDay * 5);
        return salaryPerHour;
    }

    void getPrintInfoWorker() {
        System.out.println("First name: " + super.getFirstName());
        System.out.println("Last name: " + super.getLastName());
        System.out.println("Occupation: Worker");
        System.out.println("Hours per day: " + workHoursPerDay);
        System.out.println("Salary per hour: " + salaryPerHour());
        System.out.println();

    }
}
