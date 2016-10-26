
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
public class Task4d_SumOfNumbersInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        int sum = 0;
        String symbol = "";
        String newStr = "";

        for (int i = 0; i < c.length; i++) {
            switch (c[i]) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                    //symbol = c[i];
                    newStr = newStr + c[i];
                    break;
                default:
                    newStr = newStr + '.';
            }
        }
        System.out.println(newStr);
        char[] c1 = newStr.toCharArray();
        for (int j = 0; j < c1.length; j++) {
            if (c1[j] != '.') {
                symbol = symbol + c1[j];
                //System.out.println(symbol);
            } else {
                sum = sum + Integer.parseInt(symbol);
                symbol = "";
                //System.out.println(sum);
            }

        }
        System.out.println(sum);

    }

}
