/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Calculator {

    double a;
    double b;
    String command;

    Calculator(double a, double b, String command) {

        this.a = a;
        this.b = b;
        this.command = command;

    }

    double sum() {
        double sum = a + b;
        return sum;
    }

    double subtract() {
        double substract = a - b;
        return substract;
    }

    double multiply() {
        double multiply = a * b;
        return multiply;
    }

    double divide() {
        double divide = a / b;
        return divide;
    }

    double percentage() {
        double percentage = (b % a);
        return percentage;
    }

}
