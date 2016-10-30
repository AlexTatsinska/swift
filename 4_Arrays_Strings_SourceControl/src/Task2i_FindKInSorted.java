
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
public class Task2i_FindKInSorted {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int check = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = (arr.length / 2); i < arr.length; i++) {
            if (arr[i] > k) {
                for (int j = 0; j <= (arr.length / 2); j++) {
                    if (arr[j] == k) {
                        check = j;
                        j = arr.length / 2;
                    }
                }
            } else if (arr[i] == k) {
                check = i;
                i = arr.length - 1;
            }
        }
        if (check != 0) {
            System.out.println(check);
        } else {
            System.out.println("No");
        }
    }

}
