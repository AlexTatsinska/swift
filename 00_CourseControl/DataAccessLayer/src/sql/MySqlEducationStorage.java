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
import java.util.List;

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
    public void insertEducation(List<Education> educations) throws DALException {
        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_education(?,?,?,?,?,?)}")) {
            for (Education education : educations) {
                    statement.setString("type", education.getDegree().toString());
                    statement.setString("institution_name", education.getInstitutionName());
                    statement.setDate("enrollment_date", (Date.valueOf(education.getEnrollmentDate())));
                    statement.setDate("graduation_date", (Date.valueOf(education.getGraduationDate())));
                    if (education.getGraduationDate().isBefore(LocalDate.now())) {
                        statement.setInt("graduated", 1);
                    } else {
                        statement.setInt("graduated", 0);
                    }
                    if (education instanceof GradedEducation && education.getGraduationDate().isBefore(LocalDate.now())) {
                        statement.setDouble("final_grade", ((GradedEducation) education).getFinalGrade());

                    } else {
                        statement.setDouble("final_grade", 0);
                    }

                
                statement.executeQuery();
            }
        } catch (SQLException ex) {
            throw new DALException("Error during educations import!", ex);
        }
    }
}
