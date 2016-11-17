/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class Student extends Person{
    private String facultyNumber;
    private String[] disciplines;
    
    public Student(String name, String phone, String facultyNumber, String[] disciplines) {
        super(name, phone);
        this.facultyNumber=facultyNumber;
        this.disciplines = disciplines;
    }
    
}
