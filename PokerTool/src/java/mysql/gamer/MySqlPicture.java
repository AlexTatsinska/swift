/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.gamer;

import exception.DALException;
import gamer.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Picture> getGamer(int surchGamerID) throws DALException, SQLException {
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
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in pictures surch!", ex);
        }
        return pictures;
    }

}
