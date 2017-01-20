package interfaces;

import exception.DALException;
import personaldetails.Citizen;

public interface PersonStorage {

    public void insertPerson(Citizen person) throws DALException;

    public Citizen getPresonById(int person_id) throws DALException;

}
