
import mysql.topic.MySqlSubTopic;
import exception.*;
import gamer.Gamer;
import topic.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import mysql.gamer.*;


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

    public static void main(String args[]) throws DALException, SQLException {
        String dbmsConnString = "jdbc:mysql://localhost:3306/poker_tool_database";
        String userName = "root";
        String password = "SwiftTraining1";
        String fileName = null;
        String topicName = "qweryu";
        String newSubTopicName = "qweryu";
        Gamer gamer = null;
//        MySqlTopic addNewTopic = new MySqlTopic(dbmsConnString, userName, password);
//
//        Topic topic = new Topic(topicName);
//        addNewTopic.insertNewTopic(topic);
       // MySqlSubTopic addNewSubTopic = new MySqlSubTopic(dbmsConnString, userName, password);
        //SubTopic subTopic = new SubTopic(newSubTopicName);
        //addNewSubTopic.insertNewSubTopic(subTopic);
        MySqlGamer mySqlGamer = new MySqlGamer(dbmsConnString, userName, password);
       // gamer = mySqlGamer.getGamer("first gamer");
        mySqlGamer.insertNewNote(1, topicName);
        //System.out.println(gamer.getGamerName());

    }

}
