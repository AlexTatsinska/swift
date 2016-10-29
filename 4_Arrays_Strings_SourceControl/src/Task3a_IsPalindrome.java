
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
public class Task3a_IsPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        String strMirror = "";
        for (int i = c.length - 1; i >= 0; i--) {
            strMirror = strMirror + c[i];
        }
        System.out.println(str.equals(strMirror));
    }

}
