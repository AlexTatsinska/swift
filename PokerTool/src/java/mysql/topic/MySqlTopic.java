/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.topic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import exception.DALException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import topic.Topic;

/**
 *
 * @author AlexT
 */
public class MySqlTopic {
    private String dbmsConnString;
    private String userName;
    private String password;

    public MySqlTopic(String dbmsConnString, String userName, String password) {
        this.dbmsConnString = dbmsConnString;
        this.userName = userName;
        this.password = password;
    }
    public void insertNewTopic(Topic topic) throws DALException {
        try (Connection con = DriverManager.getConnection(dbmsConnString, userName, password);
                CallableStatement statement = con.prepareCall("{call insert_topic(?)}")) {
            
                statement.setString("topic_name", topic.getTopicName());
                
                statement.execute();
            
        } catch (SQLException ex) {
            throw new DALException("Error during add new topic!", ex);
        }
    }
    
    /**
     *
     * @return
     * @throws DALException
     */
    public List<Topic> getTopics() throws DALException {
        List<Topic> topics = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        String sql = "SELECT "
                + "distinct "
                + "topic_name "
                + "FROM "
                + "poker_tool_database.topic";
        try (Connection conn = DriverManager.getConnection(dbmsConnString, userName, password);
                PreparedStatement statement = conn.prepareStatement(sql)) {
            

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String topicName = rs.getString("topic_name");
                    
                    topics.add(new Topic(topicName));
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Error in social insurance surch!", ex);
        }
        return topics;
    }
}
