
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
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
public class MySqlPersonStorage implements PersonStorage {

    static final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/citizen_registrations";
    static final String DBMS_USERNAME = "root";
    static final String DBMS_PASSWORD = "SwiftTraining1";

    @Override
    public void insertPerson(Citizen person) throws SQLException {
       // final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                CallableStatement statement = con.prepareCall("{call insert_person(?,?,?,?,?,?,?)}")) {

            statement.setString("first_name", person.getFirstName());
            statement.setString("middle_name", person.getMiddleName());
            statement.setString("last_name", person.getLastName());
            statement.setString("gender", "Мъж");
            statement.setInt("height", person.getHeight());
            statement.setDate("birth_date", (Date.valueOf(person.getDateOfBirth())));
            statement.setInt("current_address", 0);
            

            statement.executeQuery();
        }
    }
}
