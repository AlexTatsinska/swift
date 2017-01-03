package interfaces;


import education.Education;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public interface EducationStorage {
    public void insertEducation(Education education, float finalGrade) throws SQLException;
    public void insertShortEducation(Education education) throws SQLException;
}
