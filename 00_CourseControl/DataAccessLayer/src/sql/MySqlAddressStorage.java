package sql;

import interfaces.AddressStorage;
import address.Address;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import address.Address;
import exception.DALException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlAddressStorage implements AddressStorage {

    private String dbmsConnString;
    private String userName;
    private String password;

    public MySqlAddressStorage(String dbmsConnString, String userName, String password) {
        this.dbmsConnString = dbmsConnString;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void insertAddress(Address address) throws DALException {
        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_address(?,?,?,?,?,?,?,?)}")) {

            statement.setString("country", address.getCountry());
            statement.setString("city", address.getCity());
            statement.setString("municipality", address.getMunicipality());
            statement.setString("postal_code", address.getPostalCode());
            statement.setString("street", address.getStreet());
            statement.setString("number", address.getNumber());
            if (address.getFloor() != null) {
                statement.setInt("floor", address.getFloor());
                statement.setInt("apartmentNo", address.getApartmentNo());
            } else {
                statement.setInt("floor", 0);
                statement.setInt("apartmentNo", 0);
            }
            statement.executeQuery();
        } catch (SQLException ex) {
            throw new DALException("Error during address import!", ex);
        }
    }

}
