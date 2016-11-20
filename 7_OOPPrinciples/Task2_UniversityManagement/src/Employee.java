/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public abstract class Employee extends Person{
   private double salaryPerHour;

    public Employee(String name, String phone, double salary) {
        super(name, phone);
        this.salaryPerHour = salaryPerHour;
        
    }
   double getSalaryPerHour(){
       return salaryPerHour;
   }

   // @Override
   // public double work() {
   //     double balance = 0;
    //    balance = balance-salaryPerHour;
      //  return balance;    
      //      }
    
}
