
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
public class Task1e_IsPrime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int numberOfDivisors = 0;

        for (int i = 1; i <= number; i++) {

            if (number % i == 0) {
                numberOfDivisors = numberOfDivisors + 1;

            }

        }
        if (numberOfDivisors != 2) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }

    }

}
