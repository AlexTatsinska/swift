
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
public class Task1_PeoplePresentation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Student student = null;
        Worker worker = null;
        while (!input.equals("END")) {
            String[] split = input.split(" ");
            if (split.length == 5) {
                String firstName = split[0];
                String lastName = split[1];
                String facultyNumber = split[2];
                int lectureCount = Integer.parseInt(split[3]);
                int exerciseCount = Integer.parseInt(split[4]);

                student = new Student(firstName, lastName, facultyNumber, lectureCount, exerciseCount);
                if (student.checkNameBegin(firstName) == false) {
                    System.out.println("Expected upper case letter at first position of firstName.");
                    input = "END";
                }
                if (student.checkNameLength(firstName) == false) {
                    System.out.println("Expected length for firstName is between 2 and 30 symbols.");
                    input = "END";
                }
                if (student.checkNameEssence(firstName) == false) {
                    System.out.println("Expected only Latin letters in firstName.");
                    input = "END";
                }
                if (student.checkNameBegin(lastName) == false) {
                    System.out.println("Expected upper case letter at first position of lastName.");
                    input = "END";
                }
                if (student.checkNameLength(lastName) == false) {
                    System.out.println("Expected length for lastName is between 2 and 30 symbols.");
                    input = "END";
                }
                if (student.checkNameEssence(lastName) == false) {

                    System.out.println("Expected only Latin letters in lastName.");
                    input = "END";
                }
                if (student.checkFacultyNumber(facultyNumber) == false) {
                    System.out.println("Expected length for faculty number is between 5 and 10 symbols.");
                    input = "END";
                }
                if (student.checkLectureCount(lectureCount) == false) {
                    System.out.println("Expected positive number for lectureCount.");
                    input = "END";
                }
                if (student.checkExerciseCount(exerciseCount) == false) {
                    System.out.println("Expected positive number for exerciseCount.");
                    input = "END";
                }
                student.getPrintInfoStudent();
                input = sc.nextLine();

            }
            if (split.length == 4) {
                String firstName = split[0];
                String lastName = split[1];
                double weekSalary = Double.parseDouble(split[2]);
                int workHoursPerDay = Integer.parseInt(split[3]);
                worker = new Worker(firstName, lastName, weekSalary, workHoursPerDay);

                if (worker.checkNameBegin(firstName) == false) {
                    System.out.println("Expected upper case letter at first position of firstName.");
                    input = "END";
                }
                if (worker.checkNameLength(firstName) == false) {
                    System.out.println("Expected length for firstName is between 2 and 30 symbols.");
                    input = "END";
                }
                if (worker.checkNameEssence(firstName) == false) {
                    System.out.println("Expected only Latin letters in firstName.");
                    input = "END";
                }
                if (worker.checkNameBegin(lastName) == false) {
                    System.out.println("Expected upper case letter at first position of lastName.");
                    input = "END";
                }
                if (worker.checkNameLength(lastName) == false) {
                    System.out.println("Expected length for lastName is between 2 and 30 symbols.");
                    input = "END";
                }
                if (worker.checkNameEssence(lastName) == false) {

                    System.out.println("Expected only Latin letters in lastName.");
                    input = "END";
                }
                if (worker.checkWeekSalary(weekSalary) == false) {
                    System.out.println("Expected positive number for weekSalary.");
                    input = "END";
                }
                if (worker.checkWorkHoursPerDay(workHoursPerDay) == false) {
                    System.out.println("Expected positive number for weekSalary.");
                    input = "END";
                }
                worker.getPrintInfoWorker();
                input = sc.nextLine();
            }
        }
    }
}
