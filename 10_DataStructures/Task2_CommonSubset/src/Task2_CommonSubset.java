
import java.util.ArrayList;
import java.util.List;
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
public class Task2_CommonSubset {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int counter = 0;
        List<Integer> listN = new ArrayList<>();
        List<Integer> listM = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            listN.add(input);
        }
        for (int i = 0; i < m; i++) {
            int input = sc.nextInt();
            listM.add(input);
        }
        for (Integer i : listN) {
            for (Integer j : listM) {
                if (i == j) {
                    System.out.print(i + " ");
                }
            }
        }
        if (counter == 0) {
            System.out.print("NO");
        }
    }
}
