package sql;


import interfaces.EducationStorage;
import education.Education;
import education.GradedEducation;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class MySqlEducationStorage implements EducationStorage {

    static final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/citizen_registrations?useUnicode=true&characterEncoding=UTF-8";
    static final String DBMS_USERNAME = "root";
    static final String DBMS_PASSWORD = "SwiftTraining1";

    @Override
    public void insertEducation(Education education) throws SQLException {
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                CallableStatement statement = con.prepareCall("{call insert_education(?,?,?,?,?,?,?)}")) {
//type, institution_name, enrollment_date, graduation_date, graduated, final_grade
            statement.setString("type", education.getDegree().toString());
            statement.setString("institution_name", education.getInstitutionName());
            statement.setDate("enrollment_date", (Date.valueOf(education.getEnrollmentDate())));
            statement.setDate("graduation_date", (Date.valueOf(education.getGraduationDate())));
            

            if (education instanceof GradedEducation) {
                statement.setInt("graduated", 1);
                statement.setDouble("final_grade", 5.00);
                //statement.setDouble("final_grade", ((GradedEducation) education).getFinalGrade());
            } else {
                statement.setInt("graduated", 0);
                statement.setDouble("final_grade", 0.00);
            }
            statement.setInt("person_id", 0);

            statement.executeQuery();
        }
    }
    @Override
    public void insertShortEducation(Education education) throws SQLException {
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                CallableStatement statement = con.prepareCall("{call insert_short_education(?,?,?,?,?)}")) {
//type, institution_name, enrollment_date, graduation_date, graduated, final_grade
            statement.setString("type", education.getDegree().toString());
            statement.setString("institution_name", education.getInstitutionName());
            statement.setDate("enrollment_date", (Date.valueOf(education.getEnrollmentDate())));
            statement.setDate("graduation_date", (Date.valueOf(education.getGraduationDate())));
                     
            statement.executeQuery();
        }
    }

}