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
import gamer.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlexT
 */
public class MySqlLeak {

    private String dbmsConnString;
    private String userName;
    private String password;

    public MySqlLeak(String dbmsConnString, String userName, String password) {
        this.dbmsConnString = dbmsConnString;
        this.userName = userName;
        this.password = password;
    }

    public void insertLeak(String leakName) throws DALException, SQLException {

        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_leak(?)}")) {
            statement.setString("leaks_name", leakName);
            statement.execute();

        } catch (SQLException ex) {
            throw new DALException("Error during add new leak!", ex);
        }
    }

    public List<Leak> getAllLeaks() throws DALException, SQLException {
        Leak leak = null;
        List<Leak> leaks = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        String sql = "SELECT * FROM notes_database.leaks l order by l.leaks_name";

        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String leakName = rs.getString("leaks_name");

                    leak = new Leak(leakName);
                    leaks.add(leak);
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in leak surch!", ex);
        }
        return leaks;
    }

    public int getLeakId(String leakName) throws DALException, SQLException {
        int leakID = 0;
        StringBuilder result = new StringBuilder();
        String sql = "select\n"
                + "l.leaks_id\n"
                + "from\n"
                + "notes_database.leaks l\n"
                + "where \n"
                + "l.leaks_name like ?";

        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, leakName);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    leakID = rs.getInt("l.leaks_id");
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in leak surch!", ex);
        }
        return leakID;
    }

    public List<Leak> getLeaks(int gamerId) throws DALException, SQLException {
        Leak leak = null;
        List<Leak> leaks = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        String sql = "select\n"
                + "l.leaks_name\n"
                + "from\n"
                + "notes_database.leaks l\n"
                + "join notes_database.gamer_leaks gl on gl.leaks_id = l.leaks_id\n"
                + "where \n"
                + "gl.gamer_id = ?";

        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, gamerId);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    leak = new Leak(rs.getString("l.leaks_name"));
                    leaks.add(leak);
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in leak surch!", ex);
        }
        return leaks;
    }

    public void insertGamerLeak(int leakID, int gamerID) throws DALException, SQLException {

        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_gamer_leak(?,?)}")) {
            statement.setInt("leaks_id", leakID);
            statement.setInt("gamer_id", gamerID);
            statement.execute();

        } catch (SQLException ex) {
            throw new DALException("Error during add new leak to gamer!", ex);
        }
    }
}
