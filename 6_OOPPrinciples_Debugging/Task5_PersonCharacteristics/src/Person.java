
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.List;

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

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private short height;
    private String gender;
    private SecondaryEducation education;

    Person(String firstName, String lastName, LocalDate dateOfBirth, short height, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public short getHeight() {
        return height;
    }

    public void setHeight(short height) {
        this.height = height;
    }

    public void addEducation(SecondaryEducation education) {
        this.education = education;
    }

    public short getAge() {   //From Lybo's solution
        return (short) dateOfBirth.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public boolean isUnderAged() {
        return getAge() < 18;
    }

    public String getPrintInfo() {
        String result;
        String heOrShe;
        String hisOrHer;
        if (gender == "M") {
            heOrShe = "He";
            hisOrHer = "His";
        } else {
            heOrShe = "She";
            hisOrHer = "Her";
            //   System.out.println(firstName + " " + lastName + " is " + getAge() + " years old. Her weight is " + weight + " and she is " + height + " cm tall. She is a " + profession + " with an average grade of " + getAvrGrade() + "." + firstName + " " + lastName + " is under-aged.");
        }
        if (getAge() < 18) {
          if(education.isGraduated()==true){
        result = firstName+" "+lastName+ " " + lastName + " is " + getAge() + " years old. "+heOrShe+"  was born in "+dateOfBirth.getYear()+". "+heOrShe+" started "+education.getInstitutionName()+" on "+education.getEnrollmentDate()+" and finished on "+education.getGraduationDate()+" with a grade of "+education.getFinalGrade()+ "." + firstName + " " + lastName + " is under-aged.";        
          } else {
         result = firstName+" "+lastName+ " " + lastName + " is " + getAge() + " years old. "+heOrShe+"  was born in "+dateOfBirth.getYear()+". "+heOrShe+" started "+education.getInstitutionName()+" on "+education.getEnrollmentDate()+" and is supposed to graduate on "+education.getGraduationDate()+"." + firstName + " " + lastName + " is under-aged.";      
          }
        } else {
            if(education.isGraduated()==true){
        result = firstName+" "+lastName+ " " + lastName + " is " + getAge() + " years old. "+heOrShe+"  was born in "+dateOfBirth.getYear()+". "+heOrShe+" started "+education.getInstitutionName()+" on "+education.getEnrollmentDate()+" and finished on "+education.getGraduationDate()+" with a grade of "+education.getFinalGrade()+ ".";        
          } else {
         result = firstName+" "+lastName+ " " + lastName + " is " + getAge() + " years old. "+heOrShe+"  was born in "+dateOfBirth.getYear()+". "+heOrShe+" started "+education.getInstitutionName()+" on "+education.getEnrollmentDate()+" and is supposed to graduate on "+education.getGraduationDate()+".";      
          }
        }
        return result;
    }

}
