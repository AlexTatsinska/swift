package interfaces;

import address.Address;
import exception.DALException;

public interface AddressStorage {

    public void insertAddress(Address address, int personId) throws DALException;

    public Address getAddressByPersonId(int person_id) throws DALException;

}
