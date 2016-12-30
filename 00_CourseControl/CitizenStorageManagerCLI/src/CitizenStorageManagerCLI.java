
import address.Address;
import education.Education;
import education.GradedEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;
import insurance.SocialInsuranceRecord;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import personaldetails.Citizen;
import personaldetails.Gender;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class CitizenStorageManagerCLI {

    public static void main(String[] args) throws SQLException {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        MySqlAddressStorage address = new MySqlAddressStorage();
        MySqlPersonStorage person = new MySqlPersonStorage();
        MySqlEducationStorage addEducation = new MySqlEducationStorage();
        MySqlSocialInsuranceRecordStorage addSocialInsurance = new MySqlSocialInsuranceRecordStorage();

//        Даниела;Гоцева;Христова;F;4.2.1957;202;България;София;Илинден;1012;Васил Левски;55;11;73;P;СОУ Добри Чинтулов;15.9.1963;15.6.1970;S;НПМГ;15.9.1970;30.6.1975;5.581;B;Свищовска академия;1.10.1976;1.6.1980;5.074
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        String[] split = input.split(";");
        Address newAddress = null;
        String country = split[6]; 
        String city = split[7];
        String municipality = split[8];
        String zip = split[9];
        String street = split[10];
        String number = split[11];
        int floor = Integer.parseInt(split[12]);
        int apatmentNumber = Integer.parseInt(split[13]);
        newAddress = new Address(country, city, municipality, zip, street, number, floor, apatmentNumber);
        address.insertAddress(newAddress);
        /* Address newAddress = new Address("България", "Козлодуй", "Жк. 2", "3320", " ", "25", 4, 15);
        address.insertAddress(newAddress);
        //LocalDate date = LocalDate.parse("1987-06-02", formatter);
        Citizen newPerson = new Citizen("Стоян","Андреев","Димитров",Gender.Male,180,LocalDate.parse("1976-02-17", formatter));
        person.insertPerson(newPerson);
        PrimaryEducation education = new PrimaryEducation("СОУ Кирил и Методий",LocalDate.parse("1996-09-15", formatter),LocalDate.parse("2000-06-30", formatter));
        Education newEducation = education;
        addEducation.insertEducation(newEducation);
        SocialInsuranceRecord newSocialInsurance= new SocialInsuranceRecord(2015,11,322);
       // System.out.println(newSocialInsurance.getYear());
        addSocialInsurance.insertSocialInsurance(newSocialInsurance);
         */
    }
}
