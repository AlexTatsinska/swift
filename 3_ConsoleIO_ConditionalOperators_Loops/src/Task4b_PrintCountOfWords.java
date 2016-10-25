
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
public class Task4b_PrintCountOfWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        int count = 1;

        for (int i = 0; i < c.length; i++) {

            switch (c[i]) {
                case ' ':
                    count = count + 1;

                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    count = count-1;
                    break;

            }
        }
        System.out.println(count);
    }

}
