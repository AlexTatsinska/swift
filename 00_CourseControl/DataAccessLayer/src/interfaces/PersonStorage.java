package interfaces;

import exception.DALException;
import java.sql.SQLException;
import personaldetails.Citizen;

public interface PersonStorage {
   
    public void insertPerson(Citizen person) throws DALException;

}
