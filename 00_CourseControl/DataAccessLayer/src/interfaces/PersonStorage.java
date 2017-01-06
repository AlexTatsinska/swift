package interfaces;

import java.sql.SQLException;
import personaldetails.Citizen;

public interface PersonStorage {
   
    public void insertPerson(Citizen person) throws SQLException;

}
