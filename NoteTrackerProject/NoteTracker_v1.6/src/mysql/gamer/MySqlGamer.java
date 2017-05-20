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
import java.sql.Statement;
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

    public void insertLastSearchedGamer(int gamerId) throws DALException {
        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_last_searched_id(?)}")) {

            statement.setInt("gamer_id", gamerId);

            statement.execute();

        } catch (SQLException ex) {
            throw new DALException("Error during add last searched gamer!", ex);
        }
    }

    public Gamer getGamer(String surchGamerName) throws DALException, SQLException {
        Gamer gamer = null;
        StringBuilder result = new StringBuilder();
        String sql = "select\n"
                + "gamer_id,\n"
                + "gamer_name\n"
                + "from\n"
                + "note_tracker_database.gamer g\n"
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

    public String getNotes(int surchGamerID) throws DALException, SQLException {
        String note = null;
        StringBuilder result = new StringBuilder();
        String sql = "select\n"
                + "distinct\n"
                + "nt.note\n"
                + "from\n"
                + "note_tracker_database.notes nt\n"
                + "where\n"
                + "nt.gamer_id = ?\n"
                + "and nt.note_id = (select\n"
                + "		     distinct\n"
                + "		     max(nt.note_id)\n"
                + "		     from\n"
                + "		     note_tracker_database.notes nt\n"
                + "		     where\n"
                + "		     nt.gamer_id = ?\n"
                + "		     )";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, surchGamerID);
            statement.setInt(2, surchGamerID);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    note = rs.getString("note");

                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in notes surch!", ex);
        }
        return note;
    }

    public List<Gamer> getAllGamers() throws DALException, SQLException {
        Gamer gamer = null;
        List<Gamer> gamers = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        String sql = "select\n"
                + "distinct\n"
                + "g.gamer_id,\n"
                + "g.gamer_name\n"
                + "from \n"
                + "note_tracker_database.gamer g\n"
                + "join note_tracker_database.last_searched_gamers lsg on lsg.gamer_id = g.gamer_id\n"
                + "order by g.gamer_name";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    int gamerId = rs.getInt("gamer_id");
                    String gamerName = rs.getString("gamer_name");

                    gamer = new Gamer(gamerId, gamerName);
                    gamers.add(gamer);
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in gamer surch!", ex);
        }
        return gamers;
    }

    public void deleteAllGamers() throws DALException, SQLException {

        String sql = "Delete  \n"
                + "FROM \n"
                + "note_tracker_database.last_searched_gamers";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                Statement statement = conn.createStatement()) {

            statement.execute(sql);

        } catch (SQLException ex) {
            throw new DALException("Error in gamer delete!", ex);
        }
    }

    public void deleteNotes(int gamerId) throws DALException, SQLException {

        String sql = "Delete \n"
                + "FROM \n"
                + "note_tracker_database.notes\n"
                + "where\n"
                + "gamer_id = ?";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, gamerId);
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DALException("Error in gamer notes delete!", ex);
        }
    }
    public void deleteFromHystory(int gamerId) throws DALException, SQLException {

        String sql = "Delete \n"
                + "FROM \n"
                + "note_tracker_database.last_searched_gamers\n"
                + "where\n"
                + "gamer_id = ?";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, gamerId);
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DALException("Error in gamer history record delete!", ex);
        }
    }

    public void deleteGamer(int gamerId) throws DALException, SQLException {

        String sql = "Delete \n"
                + "FROM \n"
                + "note_tracker_database.gamer\n"
                + "where\n"
                + "gamer_id = ?";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, gamerId);
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DALException("Error in gamer delete!", ex);
        }
    }

    public List<Gamer> loadAllGamers() throws DALException, SQLException {
        Gamer gamer = null;
        List<Gamer> gamers = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        String sql = "SELECT * FROM note_tracker_database.gamer";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    int gamerId = rs.getInt("gamer_id");
                    String gamerName = rs.getString("gamer_name");

                    gamer = new Gamer(gamerId, gamerName);
                    gamers.add(gamer);
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in all gamers surch!", ex);
        }
        return gamers;
    }
}
