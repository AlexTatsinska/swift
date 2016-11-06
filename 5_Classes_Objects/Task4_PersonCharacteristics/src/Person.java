
import java.time.Year;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Person {
    String firstName;
    String lastName;
    short bornYear;
    float weight;
    short height;
    String profession;
    String gender;
    float[] grade;
   
    
    Person(String firstName, String lastName, short bornYear, float weight, short height, String profession, String gender, float[] grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornYear = bornYear;
        this.weight = weight;
        this.height = height;
        this.profession = profession;
        this.gender = gender;
        this.grade = grade;
        
    }
    double getAvrGrade(){
        double avrGrade;
        double sum=0;
        for (int i = 0;i<grade.length;i++){
            sum = sum+grade[i];
        }
        avrGrade = sum/grade.length;
        return avrGrade ;
    }
    int getAge(){
        int year = Year.now().getValue();
        int age = year-bornYear;
        return age;
    }
    void getPrintInfo(){
      if (getAge() < 18) {
                if (gender == "M") {
                    System.out.println(firstName + " " + lastName + " is " + getAge() + " years old. His weight is " + weight + " and he is " + height + " cm tall. He is a " + profession + " with an average grade of " + getAvrGrade()+ "." + firstName + " " + lastName + " is under-aged.");
                } else {
                    System.out.println(firstName + " " + lastName + " is " + getAge() + " years old. Her weight is " + weight + " and she is " + height + " cm tall. She is a " + profession + " with an average grade of " + getAvrGrade() + "." + firstName + " " + lastName + " is under-aged.");
                }
            } else if (gender == "M") {
                System.out.println(firstName + " " + lastName + " is " + getAge() + " years old. His weight is " + weight + " and he is " + height + " cm tall. He is a " + profession + " with an average grade of " + getAvrGrade() + ".");
            } else {
                System.out.println(firstName + " " + lastName + " is " + getAge()+ " years old. Her weight is " + weight + " and she is " + height + " cm tall. She is a " + profession + " with an average grade of " + getAvrGrade() + ".");
            }
}
    
}
