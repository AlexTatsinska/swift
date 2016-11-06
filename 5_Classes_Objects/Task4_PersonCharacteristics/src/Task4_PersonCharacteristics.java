
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
public class Task4_PersonCharacteristics {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Person person = null;
        Person[] personArr = new Person[n];
        for (int i = 0;i<n;i++){
            System.out.println("Input Info: ");
            String input = sc.nextLine();
            String[] split = input.split(",");
            String fName = split[0];
            String lName = split[1];
            short bornYear = Short.parseShort(split[2].trim());
            float weight = Float.parseFloat(split[3].trim());
            short height = Short.parseShort(split[4].trim());
            String profession = split[5].trim();
            String gender = (split[6].trim());
            float[] grade = new float[4];
            int splitIndex = 7;
            for (int j=0;j<4;j++){               
                grade[j]=Float.parseFloat(split[splitIndex].trim());
                splitIndex++;
            }   
            
            person = new Person(fName,lName,bornYear,weight,height,profession,gender,grade);
            personArr[i] = person;
        }
        for(int i=0;i<personArr.length;i++){
            personArr[i].getPrintInfo();
            
        }
        
    }/*String firstName;
    String lastName;
    short bornYear;
    float weight;
    short height;
    String profession;
    char gender;
    float[] grade;
    byte age;*/
    
}
