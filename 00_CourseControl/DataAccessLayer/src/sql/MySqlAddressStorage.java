package sql;


import interfaces.AddressStorage;
import address.Address;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import address.Address;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class MySqlAddressStorage implements AddressStorage {

    static final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/citizen_registrations?useUnicode=true&characterEncoding=UTF-8";
    static final String DBMS_USERNAME = "root";
    static final String DBMS_PASSWORD = "SwiftTraining1";

    @Override
    public void insertAddress(Address address) throws SQLException {
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                CallableStatement statement = con.prepareCall("{call insert_address(?,?,?,?,?,?,?,?)}")) {

            statement.setString("country", address.getCountry());
            statement.setString("city", address.getCity());
            statement.setString("municipality", address.getMunicipality());
            statement.setString("postal_code", address.getPostalCode());
            statement.setString("street", address.getStreet());
            statement.setString("number", address.getNumber());
            if(address.getFloor() != null){
            statement.setInt("floor", address.getFloor());
            statement.setInt("apartmentNo", address.getApartmentNo());
            }
            else{
             statement.setInt("floor", 0);
            statement.setInt("apartmentNo", 0);   
            }
            statement.executeQuery();
        }
    }

}
