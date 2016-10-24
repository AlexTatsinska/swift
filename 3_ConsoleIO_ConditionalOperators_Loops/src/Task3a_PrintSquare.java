
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
public class Task3a_PrintSquare {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        
        for (int i=1;i<=number;i++){
            System.out.print("*"); 
        }
        System.out.println();
        
        for (int j=1;j<=number-2;j++){
          
            System.out.print("*");
            for (int k=1;k<=number-2;k++){
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        
        for (int l=1;l<=number;l++){
            System.out.print("*");
        }
    }
    
}
