<%-- 
    Document   : user
    Created on : Apr 30, 2017, 12:59:10 PM
    Author     : AlexT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    static final String dbmsConnString = "jdbc:mysql://localhost:3306/poker_tool_database";
    static final String userName = "root";
    static final String password = "SwiftTraining1";
    String groupName = null;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gamers</title>
        <style>
            body {
                background-color: GhostWhite;
            }
            table {
                border-collapse: collapse;
                width: auto;
            }

            th, td {
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even){background-color: #f2f2f2}
        </style>
    </head>
    <body>
        <form name="gamersForm" action="gamers.jsp">
            <input type="submit" value="Open group" name="openGroupButton" />&nbsp;<input type="submit" value="Create new group" name="createNewGroupButton" />
            <% if (request.getParameter("openGroupButton") != null) {%>
            <br><label>Select group:</label>&nbsp;<select name="selectGroup">
                <option>group1</option>
                <option>group2</option>
                <option>group3</option>
            </select>&nbsp;<input type="submit" value="Open selected group" name="openSelectedGroupButton" />
            </br>
            <%}%>
            <% if (request.getParameter("createNewGroupButton") != null) {%>
            <br><label>New group name:</label>&nbsp;<input type="text" name="newGroupName" value="" />&nbsp;<input type="submit" value="Add new group" name="addNewGroupButon" /></br>
            <%}%>
            <% if (request.getParameter("openSelectedGroupButton") != null) {
                    groupName = request.getParameter("selectGroup");
                    session.setAttribute("selectedGroup", groupName);%>            
            <%}%>

        </form>   
    </body>
</html>
