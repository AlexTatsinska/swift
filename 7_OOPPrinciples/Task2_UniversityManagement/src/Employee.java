/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Employee extends Person{
   private double salaryPerHour;

    public Employee(String name, String phone) {
        super(name, phone);
        this.salaryPerHour = 0.00;
        
    }
    
}
