
import java.util.Arrays;
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
public class Task3b_PrintLetterCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str1 = str.toLowerCase();
        char[] c = str1.toCharArray();
        int counter = 0;
        char check = ' ';

        for (int i = 0; i < c.length; i++) {
            Arrays.sort(c);
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i] != '@') {
                for (int j = 0; j < c.length; j++) {

                    if (c[i] == c[j]) {
                        counter++;
                        check = c[i];
                    }

                }
                System.out.println(c[i] + "-" + counter);
                counter = 0;
                for (int k = 0; k < c.length; k++) {
                    if (c[k] == check) {
                        c[k] = '@';
                    }
                }
            }
        }

    }

}
