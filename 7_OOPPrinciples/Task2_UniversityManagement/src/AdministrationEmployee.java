/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class AdministrationEmployee extends Employee {

    private String[] disciplines;

    public AdministrationEmployee(String name, String phone, double salary, String[] disciplines) {
        super(name, phone, salary);
        this.disciplines = disciplines;
    }
    @Override
    public double work(Person[] people) {
        double balance = 0;
/*+3 за всеки студент
+3 за всеки учител
+1 за поддръжката*/
        int tolerance;
        balance = balance -this.getSalaryPerHour();
        for(int i=0;i<people.length;i++){
            if(people[i]!=null){
                if(people[i] instanceof MaintenanceEmployee){
                    tolerance = 1;
                    people[i].changeTolerance(tolerance);
                } else if (people[i] instanceof Teacher){
                    tolerance = 3;
                    people[i].changeTolerance(tolerance);
                }
                else if (people[i] instanceof Student){
                    tolerance = 3;
                    people[i].changeTolerance(tolerance);
                }
            } else{
                break;
            }           
        }        
        return balance;
    }


}
