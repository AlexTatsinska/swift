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
public abstract class Education {
    private boolean graduated;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
    private String institutionName;

    public Education(boolean graduated, LocalDate enrollmentDate, LocalDate graduationDate, String institutionName) {
        this.graduated = graduated;
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
        this.institutionName = institutionName;
    }
    
    
    public abstract float getDegree();
    public abstract boolean gotGraduated();
    
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setGraduated(float grade) {
        this.finalGrade = grade;
        this.graduated = true;
    }

    public float getFinalGrade() {
        float result;
        if (graduated) {
            result = finalGrade;
        } else {
            result = -1;
        }
        return result;
    }

    public boolean isGraduated() {
        return graduated;
    }

}
