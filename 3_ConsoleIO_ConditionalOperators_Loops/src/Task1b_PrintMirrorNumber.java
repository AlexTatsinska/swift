
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
public class Task1b_PrintMirrorNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int mirrorNumber;

        do {
            mirrorNumber = number % 10;
            number = number / 10;
            System.out.print(mirrorNumber);
        } while (number > 0);
    }
    
}
