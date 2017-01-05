
import sql.*;
import address.*;
import education.*;
import insurance.*;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import personaldetails.*;


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

        List<Citizen> people = new ArrayList<>();
        MySqlAddressStorage addAddress = new MySqlAddressStorage();
        MySqlPersonStorage addPerson = new MySqlPersonStorage();
        MySqlEducationStorage addEducation = new MySqlEducationStorage();
        MySqlSocialInsuranceRecordStorage addSocialInsurance = new MySqlSocialInsuranceRecordStorage();
        MySqlDeleteDatabase deleteDatabase = new MySqlDeleteDatabase();

        deleteDatabase.deleteDatabase();

        System.out.println("Database is empty! Please insert how rows will be added:");

        // System.out.println("Insert Import file path or N for import from console");
        Scanner sc = new Scanner(System.in, "UTF-8");
        int n = sc.nextInt();
        sc.nextLine();

        int count = 0;
        float finalGrade = -1;

        while (count < n) {
            String input = sc.nextLine();
            String inputInsurance = sc.nextLine();
            createPerson(people, input, inputInsurance);

            count++;

        }

        for (Citizen person : people) {
            addPerson.insertPerson(person);
            if (person.getAddress().getFloor() == null) {
                addAddress.insertShortAddress(person.getAddress());
            } else {
                addAddress.insertAddress(person.getAddress());
            }
            for (Education education : person.getEducations()) {
                addEducation.insertEducation(education, finalGrade);
            }
            for (SocialInsuranceRecord socialInsurance : person.getSocialInsuranceRecords()) {
                addSocialInsurance.insertSocialInsurance(socialInsurance);
            }
            /*if (graduationDate.isBefore(LocalDate.now())) {
                                finalGrade = Float.parseFloat(split[++i]);
                            } else {
                                finalGrade = -1;
                            }
                            addEducation.insertEducation(sEducation, finalGrade);*/

        }

    }

    public static void createPerson(List<Citizen> people, String input, String inputInsurance) {

        Scanner sc = new Scanner(System.in, "UTF-8");
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        Address address = null;
        Citizen person = null;
        SocialInsuranceRecord insurance = null;
        String institution;
        LocalDate enrollmentDate;
        LocalDate graduationDate;
        float finalGrade;

        String[] split = input.split(";");

        String firstName = split[0];
        String middleName = split[1];
        String lastName = split[2];
        String gender = split[3];
        short height = Short.parseShort(split[5]);
        LocalDate birthDate = LocalDate.parse(split[4], formatter);

        if (gender.equals("F")) {
            person = new Citizen(firstName, middleName, lastName, Gender.Female, height, birthDate);
        } else {
            person = new Citizen(firstName, middleName, lastName, Gender.Male, height, birthDate);
        }
        // addPerson.insertPerson(person);

        String country = split[6];
        String city = split[7];
        String municipality = split[8];
        String zip = split[9];
        String street = split[10];
        String number = split[11];

        if (split.length > 12 && !split[12].equals("")) {
            int floor = Integer.parseInt(split[12]);
            int apartmentNumber = Integer.parseInt(split[13]);

            address = new Address(country, city, municipality, zip, street, number, floor, apartmentNumber);
            person.setAddress(address);
//addAddress.insertAddress(newAddress);
        } else {
            address = new Address(country, city, municipality, zip, street, number);
            person.setAddress(address);
            //addAddress.insertShortAddress(newAddress);
        }

        if (split.length > 13) {
            for (int i = 14; i < split.length; i++) {
                switch (split[i]) {
                    case "P":
                        PrimaryEducation pEducation = null;
                        institution = split[++i];
                        enrollmentDate = LocalDate.parse(split[++i], formatter);
                        graduationDate = LocalDate.parse(split[++i], formatter);
                        finalGrade = -1;
                        pEducation = new PrimaryEducation(institution, enrollmentDate, graduationDate);
                        person.addEducation(pEducation);
                        //addEducation.insertEducation(pEducation, finalGrade);
                        break;
                    case "S":
                        SecondaryEducation sEducation = null;
                        institution = split[++i];
                        enrollmentDate = LocalDate.parse(split[++i], formatter);
                        graduationDate = LocalDate.parse(split[++i], formatter);
                        sEducation = new SecondaryEducation(institution, enrollmentDate, graduationDate);
                        person.addEducation(sEducation);
                        /*if (graduationDate.isBefore(LocalDate.now())) {
                                finalGrade = Float.parseFloat(split[++i]);
                            } else {
                                finalGrade = -1;
                            }
                            addEducation.insertEducation(sEducation, finalGrade);*/
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
                        /*if (graduationDate.isBefore(LocalDate.now())) {
                                finalGrade = Float.parseFloat(split[++i]);
                            } else {
                                finalGrade = -1;
                            }*/
                        hEducation = new HigherEducation(institution, enrollmentDate, graduationDate, degree);
                        person.addEducation(hEducation);
                        //addEducation.insertEducation(hEducation, finalGrade);
                        break;
                }
            }
        }

        String[] insuranceSplit = inputInsurance.split(";");
        for (int i = 0; i < insuranceSplit.length; i++) {
            int year = Integer.parseInt(insuranceSplit[i]);
            int month = Integer.parseInt(insuranceSplit[++i]);
            double amount = Double.parseDouble(insuranceSplit[++i]);
            insurance = new SocialInsuranceRecord(year, month, amount);
            person.addSocialInsuranceRecord(insurance);
            //addSocialInsurance.insertSocialInsurance(newInsurance);
        }
        people.add(person);

    }
}
