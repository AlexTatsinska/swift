
import sql.*;
import address.*;
import education.*;
import exception.*;
import insurance.*;
import interfaces.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import personaldetails.*;

public class CitizenStorageManagerCLI {

    public static void main(String[] args) throws FileNotFoundException, DALException {

        String dbmsConnString = "jdbc:mysql://localhost:3306/citizen_registrations?useUnicode=true&characterEncoding=UTF-8";
        String userName = "root";
        String password = "SwiftTraining1";
        List<Citizen> people = new ArrayList<>();
        AddressStorage addAddress = new MySqlAddressStorage(dbmsConnString, userName, password);
        PersonStorage addPerson = new MySqlPersonStorage(dbmsConnString, userName, password);
        EducationStorage addEducation = new MySqlEducationStorage(dbmsConnString, userName, password);
        SocialInsuranceRecordStorage addSocialInsurance = new MySqlSocialInsuranceRecordStorage(dbmsConnString, userName, password);
        DeleteDatabaseStorage deleteDatabase = new MySqlDeleteDatabaseStorage(dbmsConnString, userName, password);        

        Scanner sc = new Scanner(System.in, "UTF-8");

        if (args.length > 0 && !args[0].isEmpty()) {
            File file = new File(args[0]);
            if (file.isFile()) {
                try {
                    sc = new Scanner(new FileInputStream(args[0]));
                } catch (FileNotFoundException ex) {
                    System.out.println("File " + file.getName() + " was not found.");
                    return;
                }
            }
        }
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String inputInsurance = sc.nextLine();
            createPerson(people, input, inputInsurance);
        }
        
        deleteDatabase.deleteDatabase();

        System.out.println("Database is empty! Import started!");

        for (Citizen person : people) {
            addPerson.insertPerson(person);
            addAddress.insertAddress(person.getAddress());
            addEducation.insertEducation(person.getEducations());
            addSocialInsurance.insertSocialInsurance(person.getSocialInsuranceRecords());
        }
        System.out.println("Import successful!");
    }

    public static void createPerson(List<Citizen> people, String input, String inputInsurance) {

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        Citizen person = null;
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

        String country = split[6];
        String city = split[7];
        String municipality = split[8];
        String zip = split[9];
        String street = split[10];
        String number = split[11];

        if (split.length > 12 && !split[12].equals("")) {
            int floor = Integer.parseInt(split[12]);
            int apartmentNumber = Integer.parseInt(split[13]);

            Address address = new Address(country, city, municipality, zip, street, number, floor, apartmentNumber);
            person.setAddress(address);
        } else {
            Address address = new Address(country, city, municipality, zip, street, number);
            person.setAddress(address);
        }

        if (split.length > 13) {
            for (int i = 14; i < split.length; i++) {
                switch (split[i]) {
                    case "P":
                        institution = split[++i];
                        enrollmentDate = LocalDate.parse(split[++i], formatter);
                        graduationDate = LocalDate.parse(split[++i], formatter);
                        PrimaryEducation pEducation = new PrimaryEducation(institution, enrollmentDate, graduationDate);
                        person.addEducation(pEducation);
                        break;
                    case "S":
                        institution = split[++i];
                        enrollmentDate = LocalDate.parse(split[++i], formatter);
                        graduationDate = LocalDate.parse(split[++i], formatter);
                        SecondaryEducation sEducation = new SecondaryEducation(institution, enrollmentDate, graduationDate);
                        if (graduationDate.isBefore(LocalDate.now())) {
                            finalGrade = Float.parseFloat(split[++i]);
                            ((GradedEducation) sEducation).gotGraduated(finalGrade);
                        }
                        person.addEducation(sEducation);
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
                        institution = split[++i];
                        enrollmentDate = LocalDate.parse(split[++i], formatter);
                        graduationDate = LocalDate.parse(split[++i], formatter);

                        HigherEducation hEducation = new HigherEducation(institution, enrollmentDate, graduationDate, degree);
                        if (graduationDate.isBefore(LocalDate.now())) {
                            finalGrade = Float.parseFloat(split[++i]);
                            ((GradedEducation) hEducation).gotGraduated(finalGrade);
                        }
                        person.addEducation(hEducation);
                        break;
                }
            }
        }

        String[] insuranceSplit = inputInsurance.split(";");
        for (int i = 0; i < insuranceSplit.length; i++) {
            int year = Integer.parseInt(insuranceSplit[i]);
            int month = Integer.parseInt(insuranceSplit[++i]);
            double amount = Double.parseDouble(insuranceSplit[++i]);
            SocialInsuranceRecord insurance = new SocialInsuranceRecord(year, month, amount);
            person.addSocialInsuranceRecord(insurance);
        }
        people.add(person);
    }
}
