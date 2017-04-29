<%-- 
    Document   : index
    Created on : Apr 5, 2017, 11:04:08 PM
    Author     : AlexT
--%>
<%@page import="mysql.*"%>
<%@page import="topic.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    static final String dbmsConnString = "jdbc:mysql://localhost:3306/poker_tool_database";
    static final String userName = "root";
    static final String password = "SwiftTraining1";
    String fileName = null;
    String topicName = null;
    String subTopic = null;
    String newTopicName = null;
    String newSubTopicName = null;
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Poker Tool</title>
    </head>
    <body>

        <form name="addFileForm" action="administration.jsp">
            <select name="selectTopic">
                <% Class.forName("com.mysql.jdbc.Driver");
                    MySqlTopic getTopicName = new MySqlTopic(dbmsConnString, userName, password);
                    for (Topic topic : getTopicName.getTopics()) {%>
                <option><%=topic.getTopicName()%></option>
                <% }%>

            </select>

            <select name="selectSubTopic">
                <% Class.forName("com.mysql.jdbc.Driver");
                    MySqlSubTopic getSubTopicName = new MySqlSubTopic(dbmsConnString, userName, password);
                    for (SubTopic subTopic : getSubTopicName.getSubTopics()) {%>
                <option><%=subTopic.getSubTopicName()%></option>
                <% }%>                
            </select>
            <input type="file" name="fileName" value="" width="255" />
            <input type="submit" value="Add File" name="addFileButton" />
            <font color="white"><h1> </h1></font> 

            <input type="submit" value="Open new topic form" name="openNewTopicFormButton" />
            <input type="submit" value="Open new sub-topic form" name="openNewSubTopicFormButton" />

            <font color="white"><h1></h1></font> 

            <% if (request.getParameter("openNewTopicFormButton") != null) {%>
            <label>New topic name: </label><input type="text" name="newTopicName" value="" />
            <input type="submit" value="Add new topic" name="addNewTopicButton" />
            <%}%>

            <% if (request.getParameter("openNewSubTopicFormButton") != null) {%>
            <label>New sub-topic name: </label><input type="text" name="newSubTopicName" value="" />
            <input type="submit" value="Add new sub-topic" name="addNewSubTopicButton" />
            <%}%>

        </form>  





        <%
            if (request.getParameter("fileName") != null && !request.getParameter("fileName").equals("")) {
                fileName = request.getParameter("fileName");
                topicName = request.getParameter("selectTopic");
                subTopic = request.getParameter("selectSubTopic");
            } else if (session.getAttribute("personId") != null) {
                fileName = (session.getAttribute("filepath").toString());
                topicName = request.getParameter("selectTopic");
                subTopic = request.getParameter("selectSubTopic");
            } else if (session.getAttribute("addNewTopicName") != null) {
                newTopicName = session.getAttribute("addNewTopicName").toString();
            } else if (session.getAttribute("addNewSubTopicName") != null) {
                newSubTopicName = session.getAttribute("addNewSubTopicName").toString();
            }

        %>
        <% if (fileName != null && !fileName.equals("")) {%>
        <font color="blue"><h1><%=fileName%></h1></font>
        <font color="red"><h1><%=topicName%></h1></font>
        <font color="green"><h1><%=subTopic%></h1></font>
            <%}%>
            <%
                if (fileName != null && !fileName.equals("")) {
                    session.setAttribute("filepath", fileName);
                    session.setAttribute("selectTopic", topicName);
                    session.setAttribute("selectSubTopic", subTopic);
                }
            %>




        <% if (request.getParameter("newTopicName") != null && !request.getParameter("newTopicName").equals("")) {
                newTopicName = request.getParameter("newTopicName").toString();
                session.setAttribute("addNewTopicName", newTopicName);
            }

        %>
        <%if (newTopicName != null) {
                Class.forName("com.mysql.jdbc.Driver");
                MySqlTopic addNewTopic = new MySqlTopic(dbmsConnString, userName, password);
                Topic topic = new Topic(newTopicName);
                addNewTopic.insertNewTopic(topic);
                session.removeAttribute("addNewTopicName");
                newTopicName = null;
            }%>
        <% if (request.getParameter("newSubTopicName") != null && !request.getParameter("newSubTopicName").equals("")) {
                newSubTopicName = request.getParameter("newSubTopicName").toString();
                session.setAttribute("addNewSubTopicName", newSubTopicName);
            }

        %>
        <%if (newSubTopicName != null) {
                Class.forName("com.mysql.jdbc.Driver");
                MySqlSubTopic addNewSubTopic = new MySqlSubTopic(dbmsConnString, userName, password);
                SubTopic subTopic = new SubTopic(newSubTopicName);
                addNewSubTopic.insertNewSubTopic(subTopic);
                session.removeAttribute("addNewSubTopicName");
                newSubTopicName = null;
            }%>
    </body>
</html>
