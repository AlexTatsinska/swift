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
    protected int lectureCount;
    protected int exerciseCount;

    public Student(String firstName, String lastName, String facultyNumber, int lectureCount, int exerciseCount) {
        super(firstName, lastName);
        this.facultyNumber = facultyNumber;
        this.lectureCount = lectureCount;
        this.exerciseCount = exerciseCount;
    }

    double hoursPerDay() {
        double hoursPerDay = ((((lectureCount * 120) / 60) + (((exerciseCount * 90) / 60) + (exerciseCount * 90) % 60)) / 5);
        return hoursPerDay;
    }

    boolean checkFacultyNumber(String facultyNumber) {
        boolean result = true;
        if ((facultyNumber.length() >= 5) && (facultyNumber.length() <= 10)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    boolean checkLectureCount(int lectureCount) {
        boolean result = true;
        if (lectureCount > 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    boolean checkExerciseCount(int exerciseCount) {
        boolean result = true;
        if (lectureCount > 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    void getPrintInfoStudent() {
        System.out.println("First name: " + super.getFirstName());
        System.out.println("Last name: " + super.getLastName());
        System.out.println("Occupation: Student");
        System.out.println("Faculty number: " + facultyNumber);
        System.out.println("Hours per day: " + hoursPerDay());
        System.out.println();

    }

}
