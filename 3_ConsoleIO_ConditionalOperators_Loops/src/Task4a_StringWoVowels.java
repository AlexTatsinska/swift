
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
public class Task4a_StringWoVowels {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();

        for (int i = 0; i < c.length; i++) {
           /* if (c[i] == 'a') {
                System.out.print("");
            } else if (c[i] == 'e') {
                System.out.print("");
            } else if (c[i] == 'i') {
                System.out.print("");
            } else if (c[i] == 'o') {
                System.out.print("");
            } else if (c[i] == 'u') {
                System.out.print("");
            } else {
                System.out.print(c[i]);
            }*/
            switch (c[i]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.print("");
                    break;
                default:
                    System.out.print(c[i]);
                    break;
                                   
           }
        }
    }
}
