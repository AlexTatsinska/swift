package interfaces;



import java.sql.SQLException;
import personaldetails.Citizen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public interface PersonStorage {
    public void insertPerson(Citizen person) throws SQLException;

}
