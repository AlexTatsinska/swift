
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
public class Task1f_ToBinaryAndHexa {

    public static void main(String[] atgs) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int newNumber = number;
        String binaryNum = "";
        String hexaNum = "";

        while (number != 0) {
            if (number % 2 == 0) {
                binaryNum = "0" + binaryNum;
                number = number / 2;
            } else {
                binaryNum = "1" + binaryNum;
                number = number / 2;
            }
        }
        System.out.println(binaryNum);

        while (newNumber != 0) {

            switch (newNumber) {
                case 10:
                    hexaNum = 'A' + hexaNum;
                    newNumber = newNumber / 16;
                    break;
                case 11:
                    hexaNum = 'B' + hexaNum;
                    newNumber = newNumber / 16;
                    break;
                case 12:
                    hexaNum = 'C' + hexaNum;
                    newNumber = newNumber / 16;
                    break;
                case 13:
                    hexaNum = 'D' + hexaNum;
                    newNumber = newNumber / 16;
                    break;
                case 14:
                    hexaNum = 'E' + hexaNum;
                    newNumber = newNumber / 16;
                    break;
                case 15:
                    hexaNum = 'F' + hexaNum;
                    newNumber = newNumber / 16;
                    break;
                default:
                    hexaNum = Integer.toString(newNumber % 16) + hexaNum;
                    newNumber = newNumber / 16;
                    break;
            }
        }
        System.out.println(hexaNum);
    }
}
