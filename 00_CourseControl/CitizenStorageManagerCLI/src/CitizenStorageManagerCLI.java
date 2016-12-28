
import address.Address;
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
        MySqlAddressStorage addr = new MySqlAddressStorage();
        MySqlPersonStorage per = new MySqlPersonStorage();
        //final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/citizen_registrations";
        //final String DBMS_USERNAME = "root";
        //final String DBMS_PASSWORD = "SwiftTraining1";
        // String url = DBMS_CONN_STRING+","+DBMS_USERNAME+","+DBMS_PASSWORD;
        Address address = new Address("България", "Козлодуй", "Жк. 2А", "3320", " ", "77", 1, 31);
        addr.insertAddress(address);
        //LocalDate date = LocalDate.parse("1987-06-02", formatter);
        Citizen person = new Citizen("Петър","Ангелов","Тацински",Gender.Male,180,LocalDate.parse("1956-10-14", formatter));
        per.insertPerson(person);

    }
}
