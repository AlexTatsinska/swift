
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
public class Task2c_PrintClusterCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int clusterCount = 0;
        int check = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    clusterCount++;
                    for (int k = j + 1; k < arr.length; k++) {
                        if (arr[j] == arr[k]) {
                            check++;
                        }
                    }
                }
            }
        }
        System.out.println(clusterCount - check);
    }

}
