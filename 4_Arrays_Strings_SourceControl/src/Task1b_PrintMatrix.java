
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
public class Task1b_PrintMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[][] arr = new int[n][n];
        int number = 0;

        for (int row = 0; row < arr.length; row++) {
            if ((row + 1) % 2 != 0) {
                for (int col = 0; col < arr[row].length; col++) {
                    arr[col][row] = ++number;
                }
            } else {
                number = number + n;
                for (int col = 0; col < arr[row].length; col++) {
                    arr[col][row] = number--;                 
                }
                number = number + n;
            }
        }
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
}
