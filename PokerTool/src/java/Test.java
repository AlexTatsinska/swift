
import exception.*;
import mysql.*;
import topic.*;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AlexT
 */
public class Test {

    public static void main(String args[]) throws DALException {
        String dbmsConnString = "jdbc:mysql://localhost:3306/poker_tool_database";
        String userName = "root";
        String password = "SwiftTraining1";
        String fileName = null;
        String topicName = "qweryu";
        String newSubTopicName = "qweryu";
//        MySqlTopic addNewTopic = new MySqlTopic(dbmsConnString, userName, password);
//
//        Topic topic = new Topic(topicName);
//        addNewTopic.insertNewTopic(topic);
        MySqlSubTopic addNewSubTopic = new MySqlSubTopic(dbmsConnString, userName, password);
        SubTopic subTopic = new SubTopic(newSubTopicName);
        addNewSubTopic.insertNewSubTopic(subTopic);

    }

}
