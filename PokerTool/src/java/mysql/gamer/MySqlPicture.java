/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.gamer;

import exception.DALException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AlexT
 */
public class MySqlPicture {
    private String dbmsConnString;
    private String userName;
    private String password;

    public MySqlPicture(String dbmsConnString, String userName, String password) {
        this.dbmsConnString = dbmsConnString;
        this.userName = userName;
        this.password = password;
    }
    public void insertNewPicture(int gamerId, String pictureLink) throws DALException {
        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_picture(?,?)}")) {
            
                statement.setInt("gamer_id", gamerId);
                statement.setString("picture_link", pictureLink);
                
                statement.execute();
            
        } catch (SQLException ex) {
            throw new DALException("Error during add new picture!", ex);
        }
    }
    
}
