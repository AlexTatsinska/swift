
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
        String inputInfo = "";
        String input = sc.nextLine();
        Calculator calc = null;
        while (!"END".equals(input)) {
            inputInfo = inputInfo + ";" + input;
            input = sc.nextLine();
        }
        String[] splitInputInfo = inputInfo.split(";");

        Calculator[] calculatorArr = new Calculator[splitInputInfo.length];

        for (int i = 0; i < splitInputInfo.length; i++) {
            String command = "";
            double a = 0;
            double b = 0;
            String[] split = splitInputInfo[i].split(" ");
            for (int j = 0; j < split.length; j++) {

                if (j == 0) {
                    command = split[0].trim();
                }
                if (j == 1) {
                    a = Double.parseDouble(split[1].trim());
                }
                if (j == 2) {
                    b = Double.parseDouble(split[2].trim());
                }

            }
            calc = new Calculator(a, b, command);
            calculatorArr[i] = calc;
        }
        for (int i = 0; i < calculatorArr.length; i++) {

            if ((calculatorArr[i].command).equals("SUM")) {
                System.out.printf("%.3f%n", calculatorArr[i].sum());

            }
            if ((calculatorArr[i].command).equals("SUB")) {
                System.out.printf("%.3f%n", calculatorArr[i].subtract());
            }
            if ((calculatorArr[i].command).equals("MUL")) {
                System.out.printf("%.3f%n", calculatorArr[i].multiply());
            }
            if ((calculatorArr[i].command).equals("DIV")) {
                System.out.printf("%.3f%n", calculatorArr[i].divide());
            }
            if ((calculatorArr[i].command).equals("PER")) {
                System.out.printf("%.3f%n", calculatorArr[i].percentage());
            }

        }

    }
}
