
import java.util.Arrays;
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
public class Task2_EmployeeSalarySort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String input = null;
        Employee[] newEmployer = new Employee[n];
        float[] salaryArr = new float[n];

        for (int i = 0; i < n; i++) {
            input = sc.nextLine();

            String[] split = input.split(",");
            String name = split[0].trim();
            float salary = Float.parseFloat(split[1].trim());
            String position = split[2].trim();
            String department = split[3].trim();

            String email = "n/a";
            int age = -1;

            Employee employee = null;

            if (split.length == 5) {
                if (split[4].contains("@")) {
                    email = split[4].trim();
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    age = Integer.parseInt(split[4].trim());
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (split.length == 6) {
                email = split[5].trim();
                age = Integer.parseInt(split[4].trim());
                employee = new Employee(name, salary, position, department, age, email);
            } else if (split.length == 4) {
                employee = new Employee(name, salary, position, department);
            }
            newEmployer[i] = employee;
            salaryArr[i] = salary;

        }
        Arrays.sort(salaryArr);

        for (int i = salaryArr.length - 1; i > salaryArr.length - 4; i--) {
            for (int j = 0; j < newEmployer.length; j++) {
                if (salaryArr[i] == newEmployer[j].salary) {
                    if (newEmployer[j].email != "n/a") {
                        System.out.println(newEmployer[j].name + " " + newEmployer[j].department + " " + newEmployer[j].position + " " + newEmployer[j].email);
                    } else {
                        System.out.println(newEmployer[j].name + " " + newEmployer[j].department + " " + newEmployer[j].position);
                    }
                }

            }

        }

    }
}
