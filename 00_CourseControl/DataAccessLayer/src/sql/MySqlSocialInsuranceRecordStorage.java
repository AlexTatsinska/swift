package sql;


import interfaces.SocialInsuranceRecordStorage;
import insurance.SocialInsuranceRecord;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class MySqlSocialInsuranceRecordStorage implements SocialInsuranceRecordStorage {
    static final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/citizen_registrations";
    static final String DBMS_USERNAME = "root";
    static final String DBMS_PASSWORD = "SwiftTraining1";

    @Override
    public void insertSocialInsurance(SocialInsuranceRecord socialInsurance) throws SQLException {
       try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                CallableStatement statement = con.prepareCall("{call insert_social_insurance(?,?,?)}")) {

            statement.setInt("year", socialInsurance.getYear());
            statement.setInt("month", socialInsurance.getMonth());
            statement.setDouble("amount", socialInsurance.getAmount());
           // statement.setInt("person_id", 0);

            statement.executeQuery();
        }
    }
    
}
