
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
public class Task1d_PrintAllDivisors {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        for (int i = 1; i <= number; i++) {

            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }
}
