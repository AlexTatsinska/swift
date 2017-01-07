package sql;


import exception.DALException;
import interfaces.PersonStorage;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import personaldetails.Citizen;
import personaldetails.Gender;

public class MySqlPersonStorage implements PersonStorage {

    static final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/citizen_registrations?useUnicode=true&characterEncoding=UTF-8";
    static final String DBMS_USERNAME = "root";
    static final String DBMS_PASSWORD = "SwiftTraining1";

    @Override
    public void insertPerson(Citizen person) throws DALException {
      
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                CallableStatement statement = con.prepareCall("{call insert_person(?,?,?,?,?,?)}")) {

            statement.setString("first_name", person.getFirstName());
            statement.setString("middle_name", person.getMiddleName());
            statement.setString("last_name", person.getLastName());
            statement.setString("gender", person.getGender().toString());
            statement.setInt("height", person.getHeight());
            statement.setDate("birth_date", (Date.valueOf(person.getDateOfBirth())));                       

            statement.executeQuery();
        } catch (SQLException ex) {
            throw new DALException("Error during person import!", ex);
        }
    }
}
