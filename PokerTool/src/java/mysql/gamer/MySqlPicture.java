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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
        Picture picture = null;
        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_picture(?,?)}")) {
picture = new Picture(pictureLink);
System.out.println(picture.copyFile(pictureLink));
            statement.setInt("gamer_id", gamerId);
            statement.setString("picture_link", pictureLink);

            statement.execute();
//            statement.setInt("gamer_id", gamerId);
//            File image = new File(pictureLink);
//            FileInputStream fis = new FileInputStream(image);
//            statement.setBinaryStream(2, fis, (int) image.length());
//            statement.execute();

        } catch (SQLException ex) {
            throw new DALException("Error during add new picture!", ex);
        }
    }

    public List<Picture> getPictures(int surchGamerID) throws DALException, SQLException {
        Picture picture = null;
        List<Picture> pictures = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        String sql = "select\n"
                + "distinct\n"
                + "gp.picture_link\n"
                + "from\n"
                + "poker_tool_database.gamer_picture gp\n"
                + "where\n"
                + "gp.gamer_id =  ?";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, surchGamerID);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String pictureLink = rs.getString("picture_link");

                    picture = new Picture(pictureLink);
                    pictures.add(picture);
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in pictures surch!", ex);
        }
        return pictures;
    }
/*public Image getPictures(int surchGamerID) throws DALException, SQLException, IOException {
       // Picture picture = null;
        BufferedImage bimg = null;
        Image  image = null;
       // List<File> pictures = new ArrayList<>();
       // File image = null;
        StringBuilder result = new StringBuilder();
        String sql = "select\n"
                + "distinct\n"
                + "gp.picture_link\n"
                + "from\n"
                + "poker_tool_database.gamer_picture gp\n"
                + "where\n"
                + "gp.gamer_id =  ?";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, surchGamerID);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                   // String pictureLink = rs.getString("picture_link");

                   // picture = new Picture(pictureLink);
                    //int img_id = rs.getInt(1);					
					//String img_title = rs.getString(2);
					//String img_location = rs.getString(4);
					//String img_name = rs.getString(5);
					//is = rs.getBinaryStream("picture_link");
					bimg = ImageIO.read(rs.getBinaryStream("picture_link"));
					int width = bimg.getWidth();
					int height = bimg.getHeight();
                                        image = bimg;
                                        
                   // pictures.add(picture);
                }
            }
            
        } catch (SQLException ex) {
            throw new DALException("Error in pictures surch!", ex);
        }
        return image;
}*/
}
