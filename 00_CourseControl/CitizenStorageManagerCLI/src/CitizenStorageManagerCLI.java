
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
        //final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/citizen_registrations";
        //final String DBMS_USERNAME = "root";
        //final String DBMS_PASSWORD = "SwiftTraining1";
        // String url = DBMS_CONN_STRING+","+DBMS_USERNAME+","+DBMS_PASSWORD;
        Address newAddress = new Address("България", "Козлодуй", "Жк. 2", "3320", " ", "25", 4, 15);
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

    }
}
