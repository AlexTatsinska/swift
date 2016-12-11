
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
public class Student {

    private int id;
    private String name;
    private LocalDate enrollmentDate;

    public Student(String name, LocalDate enrollmentDate) {
        this.name = name;
        this.enrollmentDate = enrollmentDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

}
