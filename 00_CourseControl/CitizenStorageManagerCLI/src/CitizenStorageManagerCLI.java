
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
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.M.yyyy");
        MySqlAddressStorage addAddress = new MySqlAddressStorage();
        MySqlPersonStorage addPerson = new MySqlPersonStorage();
        MySqlEducationStorage addEducation = new MySqlEducationStorage();
        MySqlSocialInsuranceRecordStorage addSocialInsurance = new MySqlSocialInsuranceRecordStorage();

//        Даниела;Гоцева;Христова;F;4.2.1957;202;България;София;Илинден;1012;Васил Левски;55;11;73;P;СОУ Добри Чинтулов;15.9.1963;15.6.1970;S;НПМГ;15.9.1970;30.6.1975;5.581;B;Свищовска академия;1.10.1976;1.6.1980;5.074
        Scanner sc = new Scanner(System.in, "UTF-8");
        String input = sc.nextLine();

        String[] split = input.split(";");
        Address newAddress = null;
        Citizen newPerson = null;
        Education newEducation = null;
        String institution;
        LocalDate enrollmentDate;
        LocalDate graduationDate;
        
        String country = split[6];
        String city = split[7];
        String municipality = split[8];
        String zip = split[9];
        String street = split[10];
        String number = split[11];

        if (!split[12].equals("") && !split[13].equals("")) {
            int floor = Integer.parseInt(split[12]);
            int apartmentNumber = Integer.parseInt(split[13]);
            newAddress = new Address(country, city, municipality, zip, street, number, floor, apartmentNumber);
            addAddress.insertAddress(newAddress);
        } else {
            newAddress = new Address(country, city, municipality, zip, street, number);
            addAddress.insertShortAddress(newAddress);
        }

        String firstName = split[0];
        String middleName = split[1];
        String lastName = split[2];
        String gender = split[3];
        short height = Short.parseShort(split[5]);
        LocalDate birthDate = LocalDate.parse(split[4], formatter);

        if (gender.equals("F")) {
            newPerson = new Citizen(firstName, middleName, lastName, Gender.Female, height, birthDate);
        } else {
            newPerson = new Citizen(firstName, middleName, lastName, Gender.Male, height, birthDate);
        }
        addPerson.insertPerson(newPerson);
        
        for (int i = 14; i < split.length; i++) {
            switch (split[i]) {
                case "P":
                 PrimaryEducation pEducation= null;
                 institution = split[++i];
                // System.out.println(split[++i]);
                 enrollmentDate = LocalDate.parse(split[++i], formatter);
                 graduationDate= LocalDate.parse(split[++i], formatter);
                 pEducation = new PrimaryEducation(institution,enrollmentDate,graduationDate);
                 //System.out.println(pEducation.getDegree().toString());
                 addEducation.insertEducation(pEducation);
                    break;

            }
        }
        
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
