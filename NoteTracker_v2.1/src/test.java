
import exception.DALException;
import gamer.Gamer;
import gamer.Picture;
import java.io.IOException;
import java.sql.*;
import mysql.gamer.MySqlGamer;
import mysql.gamer.MySqlLeak;
import mysql.gamer.MySqlPicture;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexT
 */
public class test {
    public static void main(String args[]) throws DALException, SQLException, IOException{
        final String dbmsConnString = "jdbc:mysql://localhost:3306/notes_database";
        final String userName = "root";
        final String password = "SwiftTraining1";
        MySqlGamer mySqlGamer = new MySqlGamer(dbmsConnString, userName, password);
        MySqlPicture mySqlPicture = new MySqlPicture(dbmsConnString, userName, password);
        MySqlLeak mySqlLeak = new MySqlLeak(dbmsConnString, userName, password);
        String leakName = "test";
        //mySqlLeak.insertGamerLeak(23, 7);
        //System.out.println(mySqlLeak.getLeakId(leakName));
        //mySqlGamer.insertLastSearchedGamer(25);
        //for(Gamer gamer:mySqlGamer.getLastSearchedGamers()){
         //   System.out.println(gamer.getGamerName());
        //}
        for (Picture image : mySqlPicture.getPictures(23)) {
            System.out.println(image.getPictureName());
        }
        
        
        
    }
}
