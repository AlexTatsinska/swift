package interfaces;

import education.Education;
import exception.DALException;
import java.sql.SQLException;
import java.util.List;

public interface EducationStorage {

    public void insertEducation(List<Education> educations, int personId) throws DALException;
    public List<Education> getEducationsByPersonID(int personId) throws DALException;
    public void insertEducationWebPage(Education education, int personId)throws DALException;
}
