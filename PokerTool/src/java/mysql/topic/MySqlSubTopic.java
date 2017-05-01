/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.topic;

import exception.DALException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import topic.*;

/**
 *
 * @author AlexT
 */
public class MySqlSubTopic {

    private String dbmsConnString;
    private String userName;
    private String password;

    public MySqlSubTopic(String dbmsConnString, String userName, String password) {
        this.dbmsConnString = dbmsConnString;
        this.userName = userName;
        this.password = password;
    }

    public void insertNewSubTopic(SubTopic subTopic) throws DALException {
        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_sub_topic(?)}")) {

            statement.setString("sub_topic_name", subTopic.getSubTopicName());

            statement.execute();

        } catch (SQLException ex) {
            throw new DALException("Error during add new sub topic!", ex);
        }
    }

    public List<SubTopic> getSubTopics() throws DALException {
        List<SubTopic> subTopics = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        String sql = "SELECT \n"
                + "distinct \n"
                + "sub_topic_name \n"
                + "FROM \n"
                + "poker_tool_database.sub_topic";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String subTopicName = rs.getString("sub_topic_name");

                    subTopics.add(new SubTopic(subTopicName));
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in social insurance surch!", ex);
        }
        return subTopics;
    }

}
