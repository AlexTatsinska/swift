
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
public class Task1_CalculatorClient {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int counter = 1;
        // Calculator[] calculatorArr ;  

        for (int i = 0; i < counter; i++) {

            String input = sc.nextLine();
            if (input != "END") {

                String[] split = input.split(" ");

                Calculator calc = null;
                String command = split[0];
                double a = Double.parseDouble(split[1]);
                double b = Double.parseDouble(split[2]);
                Calculator[] calculatorArr = new Calculator[counter];
                calc = new Calculator(a, b, command);
                calculatorArr[i] = calc;
                counter++;
                if ((calculatorArr[i].command).equals("SUM")) {
                    System.out.println(calculatorArr[i].sum());

                }
                if ((calculatorArr[i].command).equals("SUB")) {
                    System.out.println(calculatorArr[i].subtract());
                }
                if ((calculatorArr[i].command).equals("MUL")) {
                    System.out.println(calculatorArr[i].multiply());
                }
                if ((calculatorArr[i].command).equals("DIV")) {
                    System.out.println(calculatorArr[i].divide());
                }
                if ((calculatorArr[i].command).equals("PER")) {
                    System.out.println(calculatorArr[i].percentage());
                }
            }

        }

    }
}
