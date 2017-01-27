
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
public class Employee {

    String name;
    float salary;
    String position;
    String department;
    int age;
    String email;

    Employee(String name, float salary, String position, String department, int age, String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = age;
        this.email = email;
    }

     Employee(String name, float salary, String position, String department){
        this(name, salary, position, department, -1, null);
    }

    Employee(String name, float salary, String position, String department, String email) {
        this(name, salary, position, department, -1, email);
    }

    Employee(String name, float salary, String position, String department, int age) {
        this(name, salary, position, department, age, null);
    }   

}
