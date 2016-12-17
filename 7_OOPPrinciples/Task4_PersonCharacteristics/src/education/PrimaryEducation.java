/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package education;

import java.time.LocalDate;

/**
 *
 * @author AlexT
 */
public class PrimaryEducation extends Education {

    public PrimaryEducation(boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate, String institutionName) {
        super(graduated, enrollmentDate, graduationDate, institutionName);
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
