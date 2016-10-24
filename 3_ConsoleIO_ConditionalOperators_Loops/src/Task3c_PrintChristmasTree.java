
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
public class Task3c_PrintChristmasTree {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String tree = "*";
        
        for (int i=1;i<=number;i++){
            for (int j=1;j<=number-i;j++){
                System.out.print(" ");
            }
            System.out.println(tree);
            tree = tree+"**";
            
        }
        
        
           
    }
    
}
