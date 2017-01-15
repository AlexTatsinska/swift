package sql;

import interfaces.EducationStorage;
import education.*;
import exception.DALException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
                statement.setBoolean("graduated", education.isGraduated());

                if (education instanceof GradedEducation && education.getGraduationDate().isBefore(LocalDate.now())) {
                    statement.setDouble("final_grade", ((GradedEducation) education).getFinalGrade());
                } else {
                    statement.setDouble("final_grade", 0);
                }
                statement.execute();
            }
        } catch (SQLException ex) {
            throw new DALException("Error during educations import!", ex);
        }
    }

    @Override
    public Education getEducationsByPersonID(int person_id) throws DALException {
        Education education = null;
        StringBuilder result = new StringBuilder();
        String sql = "select\n"
                + "distinct\n"
                + "ed.type,\n"
                + "ed.institution_name,\n"
                + "ed.enrollment_date,\n"
                + "ed.graduation_date,\n"
                + "ed.graduated,\n"
                + "ed.final_grade\n"
                + "from\n"
                + "people pe\n"
                + "join educations ed on ed.person_id = pe.id\n"
                + "where\n"
                + "pe.id = ?\n"
                + "order by\n"
                + "ed.graduation_date asc";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, person_id);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String degree = rs.getString("type");
                    String institution = rs.getString("institution_name");
                    LocalDate enrollmentDate = rs.getDate("enrollment_date").toLocalDate();
                    LocalDate graduationDate = rs.getDate("graduation_date").toLocalDate();
                    Boolean graduated = rs.getBoolean("graduated");
                    Float finalGrade = rs.getFloat("final_grade");
                    
                    switch (degree) {
                    case "Primary":                        
                        PrimaryEducation pEducation = new PrimaryEducation(institution, enrollmentDate, graduationDate);
                        education = pEducation;
                        break;
                    case "Secondary":                        
                        SecondaryEducation sEducation = new SecondaryEducation(institution, enrollmentDate, graduationDate);
                        if (graduationDate.isBefore(LocalDate.now())) {                          
                            ((GradedEducation) sEducation).gotGraduated(finalGrade);
                        }
                        education = sEducation;
                        break;
                    case "B":
                    case "M":
                    case "D":
                        EducationDegree educationDegree = null;
                        if (degree.equals("Bachelor")) {
                            educationDegree = EducationDegree.Bachelor;
                        } else if (degree.equals("Master")) {
                            educationDegree = EducationDegree.Master;
                        } else {
                            educationDegree = EducationDegree.Doctorate;
                        }                        
                        HigherEducation hEducation = new HigherEducation(institution, enrollmentDate, graduationDate, educationDegree);
                        if (graduationDate.isBefore(LocalDate.now())) {
                            ((GradedEducation) hEducation).gotGraduated(finalGrade);
                        }
                        education = hEducation;
                        break;
                }                   
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in education surch!", ex);
        }
        return education;
    }
}
