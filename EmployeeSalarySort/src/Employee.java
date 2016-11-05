
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
    byte age;
    String email;
    
    Employee(String name, float salary, String position, String department,byte age,String email){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = age;
        this.email = email;
    }
    Employee(String name, float salary, String position, String department){
       this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        age = -1;
        email = "n/a";       
    }
    Employee(String name, float salary, String position, String department,byte age){
       this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = age;
        email = "n/a";       
    }
    Employee(String name, float salary, String position, String department,String email){
       this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        age = -1;
        this.email = email;       
    }
    
    
   
}
