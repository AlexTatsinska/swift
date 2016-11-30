
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Task1_UniqueNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();
        int n = sc.nextInt();
        int counter = 0;
        
        while (counter < n){
            int input = sc.nextInt();
            uniqueNumbers.add(input);
            counter++;       
    }
        for (Integer i : uniqueNumbers) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
    
}
