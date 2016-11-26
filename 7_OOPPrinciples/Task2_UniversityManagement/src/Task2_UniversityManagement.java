
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        double balance = 500;

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Person newPerson = null;
        List<Person> people = new ArrayList<>();

        while (!input.equals("END")) {
            //NEW <MAINT|ADMIN|TEACH|STUD> <name> <phoneNo> [<facultyNo>] [<предмет1> <предмет2> ... <предметN>]
            String[] split = input.split(" ");
            switch (split[0]) {
                case "NEW":
                    String command = split[1];
                    String name = split[2];
                    String phone = split[3];
                    switch (command) {
                        case "MAINT":
                            newPerson = new MaintenanceEmployee(name, phone);
                            break;
                        case "ADMIN":
                            newPerson = new AdministrationEmployee(name, phone, Arrays.copyOfRange(split, 5, split.length - 1));
                            break;
                        case "TEACH":
                            newPerson = new Teacher(name, phone, Arrays.copyOfRange(split, 5, split.length - 1));
                            break;
                        case "STUD":
                            String facultyNumber = split[4];
                            newPerson = new Student(name, phone, facultyNumber, Arrays.copyOfRange(split, 5, split.length - 1));
                            break;
                    }
                    people.add(newPerson);
                    break;
                case "WORK":
                    balance += findPerson(people, split[1]).work(people);
                    if (balance <= 0) {
                        System.out.println("Bankrupcy");
                        return;
                    }
                    if (anyUntolerant(people)) {
                        return;
                    }
                    break;
                case "IDLE":
                    for (Person person : people) {
                        person.increaseTolerance(-5);
                    }
                    if (anyUntolerant(people)) {
                        return;
                    }
                    break;
                default:
                    break;
            }
            input = sc.nextLine();
        }
    }

    private static boolean anyUntolerant(List<Person> people) {
        for (Person person : people) {
            if (person.getTolerance() <= 0) {
                System.out.println(person.getName() + " is not happy.");
                return true;
            }
        }
        return false;
    }

    private static Person findPerson(List<Person> people, String name) {
        return people.stream().filter(x -> x.getName().equals(name)).findFirst().get();
    }
}
