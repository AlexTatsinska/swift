package sql;

import interfaces.SocialInsuranceRecordStorage;
import insurance.SocialInsuranceRecord;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

            statement.executeQuery();
        }
    }
    
}
