/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Teacher extends Employee {

    private String[] disciplines;

    public Teacher(String name, String phone,double salary, String[] disciplines) {
        super(name, phone,salary);
        this.disciplines = disciplines;

    }

   @Override
    public double work(Person[] people) {
        double balance = 0;
/*+3 за всеки студент
-3 за поддръжката
-1 за всяко административно лице*/
        int tolerance;
        balance = balance -this.getSalaryPerHour();
        for(int i=0;i<people.length;i++){
            if(people[i]!=null){
                if(people[i] instanceof MaintenanceEmployee){
                    tolerance = -3;
                    people[i].changeTolerance(tolerance);
                } else if (people[i] instanceof AdministrationEmployee){
                    tolerance = -1;
                    people[i].changeTolerance(tolerance);
                }
                else if (people[i] instanceof Student){
                    tolerance = 3;
                    people[i].changeTolerance(tolerance);
                }
            } else break;           
        }        
        return balance;
    }

}
