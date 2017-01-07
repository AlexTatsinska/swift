package interfaces;

import address.Address;
import exception.DALException;
import java.sql.Connection;
import java.sql.SQLException;

public interface AddressStorage {

    public void insertAddress(Address address) throws DALException;

}
