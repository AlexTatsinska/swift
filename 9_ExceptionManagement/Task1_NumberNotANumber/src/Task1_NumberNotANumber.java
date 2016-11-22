
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
public class Task1_NumberNotANumber {

    public static void main(String[] args) {
        /*Напишете програма Task1_NumberNotANumber, която да чете от клавиатурата редове, до въвеждането на команда „END“. 
След всеки въведен ред, програмата да отпечатва “Number”, ако реда е представлявал само едно число и “Not a number”, 
ако реда не е бил число. 
Единствената позволена операция, свързана с проверка на число, е Integer.parseInt().*/
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("END")) {
            try {
                Integer.parseInt(input);
                System.out.println("Number");
                input = sc.nextLine();
            } catch (NumberFormatException ex) {
                System.out.println("Not a number");
                input = sc.nextLine();
            }
        }
    }
}
