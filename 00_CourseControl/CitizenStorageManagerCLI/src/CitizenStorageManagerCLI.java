
import sql.*;
import address.*;
import education.*;
import insurance.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import personaldetails.*;

public class CitizenStorageManagerCLI {

    public static void main(String[] args) throws SQLException, FileNotFoundException {

        List<Citizen> people = new ArrayList<>();
        MySqlAddressStorage addAddress = new MySqlAddressStorage();
        MySqlPersonStorage addPerson = new MySqlPersonStorage();
        MySqlEducationStorage addEducation = new MySqlEducationStorage();
        MySqlSocialInsuranceRecordStorage addSocialInsurance = new MySqlSocialInsuranceRecordStorage();
        MySqlDeleteDatabase deleteDatabase = new MySqlDeleteDatabase();

        deleteDatabase.deleteDatabase();

        System.out.println("Database is empty! Import started!");

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
        int counter = 0;
        float finalGrade;

        while (counter < n) {
            String input = sc.nextLine();
            String inputInsurance = sc.nextLine();
            createPerson(people, input, inputInsurance);
            counter++;
        }

        for (Citizen person : people) {
            addPerson.insertPerson(person);
            addAddress.insertAddress(person.getAddress());
        
            for (Education education : person.getEducations()) {
                if (education instanceof GradedEducation && education.getGraduationDate().isBefore(LocalDate.now())) {
                    finalGrade = ((GradedEducation) education).getFinalGrade();

                } else {
                    finalGrade = 0;
                }
                addEducation.insertEducation(education, finalGrade);
            }
            for (SocialInsuranceRecord socialInsurance : person.getSocialInsuranceRecords()) {
                addSocialInsurance.insertSocialInsurance(socialInsurance);
            }
        }
    }

    public static void createPerson(List<Citizen> people, String input, String inputInsurance) {

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
        } else {
            address = new Address(country, city, municipality, zip, street, number);
            person.setAddress(address);
        }

        if (split.length > 13) {
            for (int i = 14; i < split.length; i++) {
                switch (split[i]) {
                    case "P":
                        PrimaryEducation pEducation = null;
                        institution = split[++i];
                        enrollmentDate = LocalDate.parse(split[++i], formatter);
                        graduationDate = LocalDate.parse(split[++i], formatter);
                        pEducation = new PrimaryEducation(institution, enrollmentDate, graduationDate);
                        person.addEducation(pEducation);
                        break;
                    case "S":
                        SecondaryEducation sEducation = null;
                        institution = split[++i];
                        enrollmentDate = LocalDate.parse(split[++i], formatter);
                        graduationDate = LocalDate.parse(split[++i], formatter);
                        sEducation = new SecondaryEducation(institution, enrollmentDate, graduationDate);
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
                        HigherEducation hEducation = null;
                        institution = split[++i];
                        enrollmentDate = LocalDate.parse(split[++i], formatter);
                        graduationDate = LocalDate.parse(split[++i], formatter);

                        hEducation = new HigherEducation(institution, enrollmentDate, graduationDate, degree);
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
            insurance = new SocialInsuranceRecord(year, month, amount);
            person.addSocialInsuranceRecord(insurance);
        }
        people.add(person);
    }
}
