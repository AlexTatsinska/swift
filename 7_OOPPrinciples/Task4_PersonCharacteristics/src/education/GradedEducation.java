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
public abstract class GradedEducation extends Education{
    private float finalGrade;

    public GradedEducation(float finalGrade, boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate, String institutionName) {
        super(graduated, enrollmentDate, graduationDate, institutionName);
        this.finalGrade = finalGrade;
    }
    
    
    
}
