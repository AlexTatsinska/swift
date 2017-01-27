
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
        String[] c = str.split(" ");
        int sum = 0;        

        for (int i = 0; i < c.length; i++) {
            
                  if(c[i].contains("0")||c[i].contains("1")||c[i].contains("2")||c[i].contains("3")||
                          c[i].contains("4")||c[i].contains("5")||c[i].contains("6")||c[i].contains("7")||
                          c[i].contains("8")||c[i].contains("9")){
                      sum = sum+Integer.parseInt(c[i]);
                  }
        }
        System.out.println(sum);
    }

}
