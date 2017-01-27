
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
           
            switch (c[i]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':                    
                    break;
                default:
                    System.out.print(c[i]);
                    break;
                                   
           }
        }
    }
}
