/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class AdministrationEmployee extends Employee {

    private String[] disciplines;

    public AdministrationEmployee(String name, String phone, String[] disciplines) {
        super(name, phone);
        this.disciplines = disciplines;
    }

}
