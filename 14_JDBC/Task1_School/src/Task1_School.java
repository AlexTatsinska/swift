
import java.sql.SQLException;
import java.time.LocalDate;
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
public class Task1_School {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        //int id = sc.nextInt();
        System.out.println("Teacher with id = 3:");
        System.out.println(MySqlSchoolData.getTeacher(3));
        System.out.println("Teachers with salary between 1700 and 1900:");
        System.out.println(MySqlSchoolData.getTeachers(1700, 1900));
        // MySqlSchoolData.insertStudent("Georgi Sirakov", "2000-11-18");
        System.out.println("Student with id = 3:");
        System.out.println(MySqlSchoolData.getStudent(3));
    }

}
