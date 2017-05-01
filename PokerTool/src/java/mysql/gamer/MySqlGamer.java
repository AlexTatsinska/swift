/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.gamer;

import exception.DALException;
import gamer.*;
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
public class MySqlGamer {

    private String dbmsConnString;
    private String userName;
    private String password;

    public MySqlGamer(String dbmsConnString, String userName, String password) {
        this.dbmsConnString = dbmsConnString;
        this.userName = userName;
        this.password = password;
    }

    public Gamer getGamer(String surchGamerName) throws DALException, SQLException {
        Gamer gamer = null;
        StringBuilder result = new StringBuilder();
        String sql = "select\n"
                + "gamer_id,\n"
                + "gamer_name\n"
                + "from\n"
                + "poker_tool_database.gamer g\n"
                + "where \n"
                + "g.gamer_name like ?";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, surchGamerName);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    int gamerId=rs.getInt("gamer_id");
                    String gamerName = rs.getString("gamer_name");

                    gamer = new Gamer(gamerId,gamerName);
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in gamer surch!", ex);
        }
        return gamer;
    }
}
