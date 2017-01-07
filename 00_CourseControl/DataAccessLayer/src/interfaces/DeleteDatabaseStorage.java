/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import exception.DALException;

/**
 *
 * @author AlexT
 */
public interface DeleteDatabaseStorage {
    
    public void deleteDatabase()throws DALException;
    
}
