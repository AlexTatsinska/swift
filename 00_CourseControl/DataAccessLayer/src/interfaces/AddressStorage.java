package interfaces;

import address.Address;
import exception.DALException;
import java.sql.Connection;
import java.sql.SQLException;

public interface AddressStorage {

    public void insertAddress(Address address, int personId) throws DALException;
    public Address getAddressByPersonId(int person_id) throws DALException;

}
