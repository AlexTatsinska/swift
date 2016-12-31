
import address.Address;
import education.*;
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
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        MySqlAddressStorage addAddress = new MySqlAddressStorage();
        MySqlPersonStorage addPerson = new MySqlPersonStorage();
        MySqlEducationStorage addEducation = new MySqlEducationStorage();
        MySqlSocialInsuranceRecordStorage addSocialInsurance = new MySqlSocialInsuranceRecordStorage();

        Scanner sc = new Scanner(System.in, "UTF-8");
        String input = sc.nextLine();

        String[] split = input.split(";");
        Address newAddress = null;
        Citizen newPerson = null;
        Education newEducation = null;
        SocialInsuranceRecord newInsurance = null;
        String institution;
        LocalDate enrollmentDate;
        LocalDate graduationDate;

        String country = split[6];
        String city = split[7];
        String municipality = split[8];
        String zip = split[9];
        String street = split[10];
        String number = split[11];
//for (int i =0;i<split.length;i++){
        //   System.out.println(i+" "+split[i]);
//}
        if (!split[12].equals("")) {
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
        if (split.length > 14) {
            for (int i = 14; i < split.length; i++) {
                switch (split[i]) {
                    case "P":
                        PrimaryEducation pEducation = null;
                        institution = split[++i];
                        enrollmentDate = LocalDate.parse(split[++i], formatter);
                        graduationDate = LocalDate.parse(split[++i], formatter);
                        pEducation = new PrimaryEducation(institution, enrollmentDate, graduationDate);
                        addEducation.insertEducation(pEducation);
                        break;
                    case "S":
                        SecondaryEducation sEducation = null;
                        institution = split[++i];
                        enrollmentDate = LocalDate.parse(split[++i], formatter);
                        graduationDate = LocalDate.parse(split[++i], formatter);
                        sEducation = new SecondaryEducation(institution, enrollmentDate, graduationDate);
                        addEducation.insertEducation(sEducation);
                        break;
                    case "B":
                    case "M":
                    case "D":
                        EducationDegree degree = null;
                        if (split[i].equals("B")) {
                            degree = EducationDegree.Bachelor;
                        } else if (split[i].equals("M")) {
                            degree = EducationDegree.Master;
                        } else {
                            degree = EducationDegree.Doctorate;
                        }
                        HigherEducation hEducation = null;
                        institution = split[++i];
                        enrollmentDate = LocalDate.parse(split[++i], formatter);
                        graduationDate = LocalDate.parse(split[++i], formatter);
                        hEducation = new HigherEducation(institution, enrollmentDate, graduationDate, degree);
                        addEducation.insertEducation(hEducation);
                        break;
                }
            }
        }
        input = sc.nextLine();
        String[] insuranceSplit = input.split(";");
        for (int i = 0; i < insuranceSplit.length; i++) {
            int year = Integer.parseInt(insuranceSplit[i]);
            int month = Integer.parseInt(insuranceSplit[++i]);
            double amount = Double.parseDouble(insuranceSplit[++i]);
            newInsurance = new SocialInsuranceRecord(year, month, amount);
            addSocialInsurance.insertSocialInsurance(newInsurance);
        }

        /* 
        SocialInsuranceRecord newSocialInsurance= new SocialInsuranceRecord(2015,11,322);
       // System.out.println(newSocialInsurance.getYear());
        addSocialInsurance.insertSocialInsurance(newSocialInsurance);
         */
    }
}
