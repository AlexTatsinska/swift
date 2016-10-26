
import java.time.Year;
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
public class Task5_PersonCharacteristics {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int year = Year.now().getValue();

        for (int i = 0; i < n; i++) {
            System.out.println("First name: ");
            String firstName = sc.next();
            char[] c = firstName.toCharArray();
            for (int j = 0; j < c.length; j++) {
                switch (c[j]) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        System.out.println("Not vald data! Try again:");
                        firstName = sc.next();
                        break;
                }

            }
            System.out.println("Last name: ");
            String lastName = sc.next();
            c = lastName.toCharArray();
            for (int j = 0; j < c.length; j++) {
                switch (c[j]) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        System.out.println("Not vald data! Try again:");
                        lastName = sc.next();
                        break;
                }

            }
            System.out.println("Born year: ");
            short bornYear = sc.nextShort();
            if (bornYear < 0 || bornYear > year) {
                System.out.println("Not vald data! Try again:");
                bornYear = sc.nextShort();
            }
            System.out.println("Weight: ");
            float weight = sc.nextFloat();
            if (weight < 0 || weight > 500) {
                System.out.println("Not vald data! Try again:");
                weight = sc.nextFloat();
            }
            System.out.println("Height: ");
            short height = sc.nextShort();
            if (height < 50 || height > 300) {
                System.out.println("Not vald data! Try again:");
                height = sc.nextShort();
            }
            System.out.println("Profession: ");
            String profession = sc.next();
            c = profession.toCharArray();
            for (int j = 0; j < c.length; j++) {
                switch (c[j]) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        System.out.println("Not vald data! Try again:");
                        profession = sc.next();
                        break;
                }

            }

            byte age = (byte) (year - bornYear);
            //System.out.println(year);
            if (age < 18) {
                System.out.println(firstName + " " + lastName + " is " + age + " years old. His weight is " + weight + " and he is " + height + " cm tall. He is a " + profession + "." + firstName + " " + lastName + " is under-aged.");
            } else {
                System.out.println(firstName + " " + lastName + " is " + age + " years old. His weight is " + weight + " and he is " + height + " cm tall. He is a " + profession + ".");
            }

        }
    }

}
