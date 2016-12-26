
import address.Address;
import java.sql.SQLException;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class CitizenStorageManagerCLI {
    
    public static void main(String[] args) throws SQLException{
    MySqlAddressStorage addr = new MySqlAddressStorage();
    //final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/citizen_registrations";
    //final String DBMS_USERNAME = "root";
    //final String DBMS_PASSWORD = "SwiftTraining1";
       // String url = DBMS_CONN_STRING+","+DBMS_USERNAME+","+DBMS_PASSWORD;
        Address address = new Address("Bulgaria", "Sofia","Mladost","1766","Malinov 77","25",7,111);
        addr.insertAddress(address);
        
    }
}
