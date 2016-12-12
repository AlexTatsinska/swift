
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class Task1_FilterFiles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int counter = 1;
        sc.nextLine();

        while (counter <= n) {
            String input = sc.nextLine();

            String pattern = ".gif$|.jpg$|.png$|.bmp$";

            printAllRegexMatches(input, pattern);
            counter++;
        }
    }

    private static void printAllRegexMatches(String input, String pattern) {
        Pattern regex = Pattern.compile(pattern);

        Matcher matcher = regex.matcher(input);

        while (matcher.find()) {
            System.out.printf("%s %s%n", input.substring(input.indexOf(input), input.indexOf(".")), input.substring(input.indexOf(".") + 1));
        }
    }
}
