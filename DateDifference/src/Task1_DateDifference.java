
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
public class Task1_DateDifference {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        String[] split = date.split(" ");
        String date1 = sc.nextLine();
        String[] split1 = date1.split(" ");

        SwiftDate first = new SwiftDate(Short.parseShort(split[0]), Byte.parseByte(split[1]), Byte.parseByte(split[2]));
        SwiftDate second = new SwiftDate(Short.parseShort(split1[0]), Byte.parseByte(split1[1]), Byte.parseByte(split1[2]));

        System.out.println(first.getDaysDiference(second));
        first.printInfo();
        second.printInfo();

    }
}
