
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
public class SecondaryEducation {

    private float finalGrade;
    private boolean graduated;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
    private String institutionName;

    public SecondaryEducation(LocalDate enrollmentDate, LocalDate graduationDate, String institutionName) {
        this.enrollmentDate = enrollmentDate;
        this.graduationDate = graduationDate;
        this.institutionName = institutionName;
        this.graduated = false;
    }

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
