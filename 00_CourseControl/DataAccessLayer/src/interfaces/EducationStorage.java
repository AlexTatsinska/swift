package interfaces;

import education.Education;
import java.sql.SQLException;

public interface EducationStorage {

    public void insertEducation(Education education, float finalGrade) throws SQLException;    
}
