/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.gamer;

import exception.DALException;
import gamer.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

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

    public void insertNewPicture(int gamerId, String pictureLink) throws DALException, FileNotFoundException {
         FileInputStream fis = null;
        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_picture(?,?)}")) {
           File file = new File(pictureLink);
           fis = new FileInputStream(file);
            statement.setInt("gamer_id", gamerId);
            statement.setBinaryStream("picture_link", fis, (int) file.length());
            statement.execute();

        } catch (SQLException ex) {
            throw new DALException("Error during add new picture!", ex);
        }
    }

    public List<Image> getPictures(int surchGamerID) throws DALException, SQLException, IOException {
       // Picture picture = null;
        BufferedImage bimg = null;
        Image  image = null;
        List<Image> pictures = new ArrayList<>();
       // File image = null;
        StringBuilder result = new StringBuilder();
        String sql = "select\n"
                + "distinct\n"
                + "gp.picture_link\n"
                + "from\n"
                + "note_tracker_database.gamer_picture gp\n"
                + "where\n"
                + "gp.gamer_id =  ?";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, surchGamerID);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                   
					bimg = ImageIO.read(rs.getBinaryStream("picture_link"));
					int width = bimg.getWidth();
					int height = bimg.getHeight();
                                        image = bimg;
                                        pictures.add(image);
                                                           
                }
            }
            
        } catch (SQLException ex) {
            throw new DALException("Error in pictures surch!", ex);
        }
        return pictures;
}
    
    public void deletePictures(int gamerId) throws DALException, SQLException {

        String sql = "Delete \n"
                + "FROM \n"
                + "note_tracker_database.gamer_picture\n"
                + "where\n"
                + "gamer_id = ?";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, gamerId);
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DALException("Error in gamer pictures delete!", ex);
        }
    }

}
