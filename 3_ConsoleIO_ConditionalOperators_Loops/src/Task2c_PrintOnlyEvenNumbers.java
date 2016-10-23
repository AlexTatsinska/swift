
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
public class Task2c_PrintOnlyEvenNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int inputNumber;
        
        for (int i = 0; i < number; i++){
            inputNumber = sc.nextInt();
            if (inputNumber%2 == 0){
                System.out.print(inputNumber+" ");
            }
        }
    }
    
}
