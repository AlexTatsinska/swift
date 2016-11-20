
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
public class Task2_UniversityManagement {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Person newUnivesity = null;
        Person[] people = new Person[500];
        double balance = 500;
        int count = 0;
        while (!input.equals("END")) {
            //NEW <MAINT|ADMIN|TEACH|STUD> <name> <phoneNo> [<facultyNo>] [<предмет1> <предмет2> ... <предметN>]
            String[] split = input.split(" ");
            if (split[0].equals("NEW")) {
                double salary;
                String command = split[1];
                String name = split[2];
                String phone = split[3];
                switch (command) {
                    case "MAINT":
                        salary = 15;
                        MaintenanceEmployee maintenanceEmployee = new MaintenanceEmployee(name, phone, salary);
                        newUnivesity = maintenanceEmployee;
                        count++;
                        break;
                    case "ADMIN":
                        salary =19;
                        String[] disciplines = new String[split.length - 4];
                        for (int i = 0; i < disciplines.length; i++) {
                            for (int j = split.length - 5; j > 0; j--) {
                                disciplines[i] = split[j];
                            }
                        }
                        AdministrationEmployee administrationEmployee = new AdministrationEmployee(name, phone,salary, disciplines);
                        newUnivesity = administrationEmployee;
                        count++;
                        break;
                    case "TEACH":
                        salary = 25;
                        String[] disciplines1 = new String[split.length - 4];
                        for (int i = 0; i < disciplines1.length; i++) {
                            for (int j = split.length - 5; j > 0; j--) {
                                disciplines1[i] = split[j];
                            }
                        }
                        Teacher teacher = new Teacher(name, phone,salary, disciplines1);
                        newUnivesity = teacher;
                        count++;
                        break;
                    case "STUD":
                        String[] disciplines2 = new String[split.length - 4];
                        for (int i = 0; i < disciplines2.length; i++) {
                            for (int j = split.length - 6; j > 0; j--) {
                                disciplines2[i] = split[j];
                            }
                        }
                        String facultyNumber = split[4];
                        Student student = new Student(name, phone, facultyNumber, disciplines2);
                        newUnivesity = student;
                        count++;
                        break;
                }
                for (int i =0;i<people.length;i++){
                    if((people[i])==null&&(count<=500)){
                        people[i]=newUnivesity;
                        break;
                    }
                    
                } input = sc.nextLine();
            } else if (split[0].equals("WORK")) {
                for(int i=0;i<people.length;i++){
                    if(people[i]!=null){
                        if(balance>0){
                          if(people[i].getName().equals(split[1])){
                                people[i].work(people);
                            if ( people[i].getTolerance() <= 0) {
                                System.out.println(people[i].getName() + " is not happy.");                                
                                return; 
                                        }                                                                             
                            }                                     
                                  } else {
                                      System.out.println("Bankrupcy");
                                      return;
                                  }
                              }                             
                          }
                    }
else if (split[0].equals("IDLE")) {
                for (int i = 0; i < people.length; i++) {
                    if (people[i] != null) {
                        int tolerance = -5;
                        people[i].changeTolerance(tolerance);
                        if(people[i].getTolerance()<=0){
                           System.out.println(people[i].getName() + " is not happy."); 
                           return;
                        }
                    }
                }
            }
        }
    }
}
            


