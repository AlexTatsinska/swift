
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
        Object newUnivesity = null;
        Object[] university = new Object[500];
        int count = 0;
        while (!input.equals("END")) {
            //NEW <MAINT|ADMIN|TEACH|STUD> <name> <phoneNo> [<facultyNo>] [<предмет1> <предмет2> ... <предметN>]
            String[] split = input.split(" ");
            if (split[0].equals("NEW")) {
                String command = split[1];
                String name = split[2];
                String phone = split[3];
                switch (command) {
                    case "MAINT":
                        MaintenanceEmployee maintenanceEmployee = new MaintenanceEmployee(name, phone);
                        newUnivesity = maintenanceEmployee;
                        count++;
                        break;
                    case "ADMIN":
                        String[] disciplines = new String[split.length - 4];
                        for (int i = 0; i < disciplines.length; i++) {
                            for (int j = split.length - 5; j > 0; j--) {
                                disciplines[i] = split[j];
                            }
                        }
                        AdministrationEmployee administrationEmployee = new AdministrationEmployee(name, phone, disciplines);
                        newUnivesity = administrationEmployee;
                        count++;
                        break;
                    case "TEACH":
                        String[] disciplines1 = new String[split.length - 4];
                        for (int i = 0; i < disciplines1.length; i++) {
                            for (int j = split.length - 5; j > 0; j--) {
                                disciplines1[i] = split[j];
                            }
                        }
                        Teacher teacher = new Teacher(name, phone, disciplines1);
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
                for (int i =0;i<university.length;i++){
                    if((university[i])==null&&(count<=500)){
                        university[i]=newUnivesity;
                        break;
                    }
                    
                } input = sc.nextLine();
            } else if (split[0].equals("WORK")) {
                for(int i=0;i<university.length;i++){
                    if(university[i]!=null){
                          if((((Person) university[i]).getName()).equals(split[1])){
                              
                          }
                    }
                }
/*Работещ: Промяна при останалите:
Поддръжка
+2 за всички
Администрация
+3 за всеки студент
+3 за всеки учител
+1 за поддръжката
Учител
+3 за всеки студент
-3 за поддръжката
-1 за всяко административно лице
Студент
+2 за студента
-1 за поддръжката
Никой
-5 за всички*/

            } else if (split[0].equals("IDLE")) {
                for (int i = 0; i < university.length; i++) {
                    if (university[i] != null) {
                        int tolerance = -5;
                        if (university[i] instanceof Student) {
                            ((Student) university[i]).setTolerance(tolerance);
                            if (((Student) university[i]).getTolerance() == 0) {
                                System.out.println(((Student) university[i]).getName() + " is not happy.");
                                i = university.length;
                                input = "END";
                            }
                        } else if (university[i] instanceof Teacher) {
                            ((Teacher) university[i]).setTolerance(tolerance);
                            if (((Teacher) university[i]).getTolerance() == 0) {
                                System.out.println(((Teacher) university[i]).getName() + " is not happy.");
                                i = university.length;
                                input = "END";
                            }
                        } else if (university[i] instanceof MaintenanceEmployee) {
                            ((MaintenanceEmployee) university[i]).setTolerance(tolerance);
                            if (((MaintenanceEmployee) university[i]).getTolerance() == 0) {
                                System.out.println(((MaintenanceEmployee) university[i]).getName() + " is not happy.");
                                i = university.length;
                                input = "END";
                            }
                        } else if (university[i] instanceof AdministrationEmployee) {
                            ((AdministrationEmployee) university[i]).setTolerance(tolerance);
                            if (((AdministrationEmployee) university[i]).getTolerance() == 0) {
                                System.out.println(((MaintenanceEmployee) university[i]).getName() + " is not happy.");
                                i = university.length;
                                input = "END";
                            }
                        }
                    }
                }
            }
        }
    }

}
