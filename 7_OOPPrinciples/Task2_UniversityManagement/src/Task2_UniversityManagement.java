
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
        Object[] univercity = new Object[500];
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
                        univercity[count] = maintenanceEmployee;
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
                        univercity[count] = administrationEmployee;
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
                        univercity[count] = teacher;
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
                        univercity[count] = student;
                        count++;
                        break;
                }
            } else if (split[0].equals("WORK")) {

            } else if (split[0].equals("IDLE")) {
                for (int i = 0; i < univercity.length; i++) {
                    if (univercity[i] != null) {
                        int tolerance = -5;
                        if (univercity[i] instanceof Student) {
                            ((Student) univercity[i]).setTolerance(tolerance);
                            if (((Student) univercity[i]).getTolerance() == 0) {
                                System.out.println(((Student) univercity[i]).getName() + " is not happy.");
                                i = univercity.length;
                                input = "END";
                            }
                        }
                    }
                }
            }
        }
    }

}
