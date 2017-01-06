package interfaces;

import address.Address;
import java.sql.Connection;
import java.sql.SQLException;

public interface AddressStorage {

    public void insertAddress(Address address) throws SQLException;

}
