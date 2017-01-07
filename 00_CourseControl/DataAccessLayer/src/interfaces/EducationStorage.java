package interfaces;

import education.Education;
import exception.DALException;
import java.sql.SQLException;

public interface EducationStorage {

    public void insertEducation(Education education, float finalGrade) throws DALException;    
}
