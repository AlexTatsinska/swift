/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class MaintenanceEmployee extends Employee {

    public MaintenanceEmployee(String name, String phone, double salary) {
        super(name, phone, salary);
    }
    @Override
    public double work(Person[] people) {
        double balance = 0;
/*+2 за всички*/
        int tolerance;
        balance = balance -super.getSalaryPerHour();
        for(int i=0;i<people.length;i++){
            if(people[i]!=null){               
                    tolerance = 2;
                    people[i].changeTolerance(tolerance);                
            } else{
                break;
            }           
        }        
        return balance;
    }


}
