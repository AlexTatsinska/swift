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
public class MySqlGamer {

    private String dbmsConnString;
    private String userName;
    private String password;

    public MySqlGamer(String dbmsConnString, String userName, String password) {
        this.dbmsConnString = dbmsConnString;
        this.userName = userName;
        this.password = password;
    }

    public void insertNewGamer(String newGamerName) throws DALException {
        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_gamer(?)}")) {

            statement.setString("gamer_name", newGamerName);

            statement.execute();

        } catch (SQLException ex) {
            throw new DALException("Error during add new gamer!", ex);
        }
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
                    int gamerId = rs.getInt("gamer_id");
                    String gamerName = rs.getString("gamer_name");

                    gamer = new Gamer(gamerId, gamerName);
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in gamer surch!", ex);
        }
        return gamer;
    }

    public void insertNewNote(int gamerId, String note) throws DALException {
        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_note(?,?)}")) {

            statement.setInt("gamer_id", gamerId);
            statement.setString("note", note);

            statement.execute();

        } catch (SQLException ex) {
            throw new DALException("Error during add new note!", ex);
        }
    }

    public List<String> getNotes(int surchGamerID) throws DALException, SQLException {
        List<String> notes = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        String sql = "select\n"
                + "distinct\n"
                + "nt.note\n"
                + "from\n"
                + "poker_tool_database.notes nt\n"
                + "where\n"
                + "nt.gamer_id = ?";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, surchGamerID);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String note = rs.getString("note");

                    notes.add(note);
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in notes surch!", ex);
        }
        return notes;
    }
}
