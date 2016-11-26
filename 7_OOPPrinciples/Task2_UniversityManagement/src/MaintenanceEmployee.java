
import java.util.List;

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

    final static double SALARY = 15;
    
    public MaintenanceEmployee(String name, String phone) {
        super(name, phone, SALARY);
    }
        
    /*+2 за всички*/
    @Override
    public double work(List<Person> people) {
        for (Person person : people) {
            person.increaseTolerance(2);
        }
        return this.getSalaryPerHour();
    }

}
