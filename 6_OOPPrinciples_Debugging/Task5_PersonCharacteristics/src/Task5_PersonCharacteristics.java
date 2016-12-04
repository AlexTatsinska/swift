
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
        sc.nextLine();
        Person newPerson = null;
        SecondaryEducation newEducation = null;
        List<Person> people = new ArrayList<>();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");//From Lybo's solution
        /*<първо_име>;<последно_име>;<пол>;<височина>;<дата_на_раждане>;
        <име_на_институция>;<дата_на_започване_на_образование>;<дата_на_завършване>;[<оценка_ако_е_завършил>]*/
        for (int i = 0; i < n; i++) {           
            String input = sc.nextLine();
            String[] split = input.split(";");
            String fName = split[0];
            String lName = split[1];             
            String gender = (split[2].trim());
            short height = Short.parseShort(split[3].trim());
            LocalDate dateOfBirth = LocalDate.parse(split[4].trim(), formatter);
            String institutionName = split[5].trim();
            LocalDate enrollmentDate = LocalDate.parse(split[6].trim(), formatter);
            LocalDate graduationDate = LocalDate.parse(split[7].trim(), formatter);            
            if(split.length==8){
            newPerson = new Person(fName, lName, dateOfBirth, height, gender);
            newEducation= new SecondaryEducation(enrollmentDate, graduationDate,institutionName);
            }else{
            newPerson = new Person(fName, lName, dateOfBirth, height, gender);
            newEducation= new SecondaryEducation(enrollmentDate, graduationDate,institutionName);
            newEducation.setGraduated(Float.parseFloat(split[8].trim()));
            newPerson.addEducation(newEducation);
            }
            people.add(newPerson);
        }
        for (Person person : people) {
                        System.out.println(person.getPrintInfo());

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
