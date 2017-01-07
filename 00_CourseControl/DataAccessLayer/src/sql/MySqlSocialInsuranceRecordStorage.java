package sql;

import exception.DALException;
import interfaces.SocialInsuranceRecordStorage;
import insurance.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlSocialInsuranceRecordStorage implements SocialInsuranceRecordStorage {

    private String dbmsConnString;
    private String userName;
    private String password;

    public MySqlSocialInsuranceRecordStorage(String dbmsConnString, String userName, String password) {
        this.dbmsConnString = dbmsConnString;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void insertSocialInsurance(SocialInsuranceRecord socialInsurance) throws DALException {
        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_social_insurance(?,?,?)}")) {

            statement.setInt("year", socialInsurance.getYear());
            statement.setInt("month", socialInsurance.getMonth());
            statement.setDouble("amount", socialInsurance.getAmount());

            statement.executeQuery();
        } catch (SQLException ex) {
            throw new DALException("Error during address import!", ex);
        }
    }

}
