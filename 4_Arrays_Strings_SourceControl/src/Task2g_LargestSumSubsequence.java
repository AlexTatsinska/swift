
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
public class Task2g_LargestSumSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;

         for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i];
            if(sum<=0){
                sum=0;
                for(int j = i+1;j<arr.length;j++){
                    sum=sum+arr[j];
                    System.out.print(arr[j]+" ");
                }
            }
        }
    }
}
