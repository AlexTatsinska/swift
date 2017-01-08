package interfaces;

import education.Education;
import exception.DALException;
import java.sql.SQLException;
import java.util.List;

public interface EducationStorage {

    public void insertEducation(List <Education> educations) throws DALException;    
}
