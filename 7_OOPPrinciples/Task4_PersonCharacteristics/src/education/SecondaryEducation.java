package education;


import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class SecondaryEducation extends GradedEducation {

    public SecondaryEducation(float finalGrade, boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate, String institutionName) {
        super(finalGrade, graduated, enrollmentDate, graduationDate, institutionName);
    }

    
    
    

    
    @Override
    public float getDegree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean gotGraduated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
