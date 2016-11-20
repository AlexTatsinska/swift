/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Student extends Person {

    private String facultyNumber;
    private String[] disciplines;

    public Student(String name, String phone, String facultyNumber, String[] disciplines) {
        super(name, phone);
        this.facultyNumber = facultyNumber;
        this.disciplines = disciplines;
    }

    @Override
    public double work(Person[] people) {
        double balance = 0;
        /*Студент
+2 за студента
-1 за поддръжката*/
        int tolerance = 2;
        super.changeTolerance(tolerance);
        for(int i=0;i<people.length;i++){
            if(people[i]!=null){
                if(people[i] instanceof MaintenanceEmployee){
                    tolerance = -1;
                    people[i].changeTolerance(tolerance);
                }
            }
            
        }
        if (super.getTolerance() >= 50) {
            balance = balance + 10;
        }
        return balance;
    }

}
