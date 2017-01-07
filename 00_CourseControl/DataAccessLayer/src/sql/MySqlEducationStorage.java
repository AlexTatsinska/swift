package sql;

import interfaces.EducationStorage;
import education.*;
import exception.DALException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class MySqlEducationStorage implements EducationStorage {

    private String dbmsConnString;
    private String userName;
    private String password;

    public MySqlEducationStorage(String dbmsConnString, String userName, String password) {
        this.dbmsConnString = dbmsConnString;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void insertEducation(Education education, float finalGrade) throws DALException {
        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_education(?,?,?,?,?,?)}")) {
            statement.setString("type", education.getDegree().toString());
            statement.setString("institution_name", education.getInstitutionName());
            statement.setDate("enrollment_date", (Date.valueOf(education.getEnrollmentDate())));
            statement.setDate("graduation_date", (Date.valueOf(education.getGraduationDate())));
            if (education.getGraduationDate().isBefore(LocalDate.now())) {
                statement.setInt("graduated", 1);
            } else {
                statement.setInt("graduated", 0);
            }
            statement.setDouble("final_grade", finalGrade);

            statement.executeQuery();
        } catch (SQLException ex) {
            throw new DALException("Error during educations import!", ex);
        }
    }
}
