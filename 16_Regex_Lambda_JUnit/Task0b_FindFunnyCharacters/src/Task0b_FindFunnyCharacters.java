
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
public class Task0b_FindFunnyCharacters {

    public static void main(String[] args) {
        String input = "123hjrt123~!@#$%^&*()_+-=/\\";
        String pattern = "[^\\w\\s]";

        printAllRegexMatches(input, pattern);

    }

    private static void printAllRegexMatches(String input, String pattern) {
        Pattern regex = Pattern.compile(pattern);

        Matcher matcher = regex.matcher(input);

        while (matcher.find()) {
            System.out.printf("Found match [%s] at index [%d]%n", matcher.group(), matcher.start());
        }
    }

}
