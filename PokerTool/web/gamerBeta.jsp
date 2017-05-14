<%-- 
    Document   : gamerBeta
    Created on : May 1, 2017, 5:30:11 PM
    Author     : AlexT
--%>

<%@page import="mysql.gamer.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="gamer.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    static final String dbmsConnString = "jdbc:mysql://localhost:3306/poker_tool_database";
    static final String userName = "root";
    static final String password = "SwiftTraining1";
    String gamerName = null;
    String pictureLink = null;
    String note = null;
    int gamerId;
    Gamer gamer = null;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gamer</title>
    </head>
    <body>
        <style>
        </style>
    </body>
</html>
<form name="gamersForm" action="gamerBeta.jsp">          
    <br><label>Gamer name:</label>&nbsp;<input type="text" name="surchGamer" value="" />&nbsp;<input type="submit" value="Search gamer" name="surchGamerButon" />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>New gamer name:</label>&nbsp;<input type="text" name="addNewGamer" value="" />&nbsp;<input type="submit" value="Add new gamer" name="addGamerButton" /></br> 


    <% if (request.getParameter("surchGamerButon") != null) {
            gamerName = request.getParameter("surchGamer");
            Class.forName("com.mysql.jdbc.Driver");
            MySqlGamer mySqlGamer = new MySqlGamer(dbmsConnString, userName, password);
            gamer = mySqlGamer.getGamer(gamerName);
            if (gamer == null) {%>
    <h1>Search gamer not exist! Please try again!</h1>
    <% } else
                               gamerId = gamer.getGamerId();
                       }%>
    <% if (request.getParameter("openGamerButton") != null) {
            gamerName = request.getParameter("openGamerButton");
            Class.forName("com.mysql.jdbc.Driver");
            MySqlGamer mySqlGamer = new MySqlGamer(dbmsConnString, userName, password);
            gamer = mySqlGamer.getGamer(gamerName);
            gamerId = gamer.getGamerId();
                }%>

    <%if (gamer != null) {
            Class.forName("com.mysql.jdbc.Driver");
            MySqlGamer mySqlGamer = new MySqlGamer(dbmsConnString, userName, password);
            MySqlPicture mySqlPicture = new MySqlPicture(dbmsConnString, userName, password);
            gamer.setGamerNote(mySqlGamer.getNotes(gamer.getGamerId()));
            gamer.setGamerPictures(mySqlPicture.getPictures(gamer.getGamerId()));
    %>
    <br><table border="3">
        <thead>   
        <td><font color="blue" size=7><%=gamer.getGamerName()%></font>
            <br>
            <% for (Picture picture : gamer.getGamerPictures()) {%>

            <img src="<%=picture.getPictureLink()%>"/>&nbsp;
            <%}%> 
            </br>
            <br><textarea name="addNote" rows="10" cols="70">
                <% for (String note : gamer.getGamerNote()) {%>
                <%=note.trim()%> 
                <%}%>
            </textarea>
            </br><br><input type="submit" value="Save note" name="addNoteButton" /></br>
            <br><label>Add picture:</label>&nbsp;<input type="file" name="addNewPicture" value="" />&nbsp;<input type="submit" value="Add picture" name="addNewPictureButton" /></br>
        </td>                 
        <td>   
            <%for (Gamer gamer : mySqlGamer.getAllGamers()) {%>  
            <br>
            <input type="submit" value="<%=gamer.getGamerName()%>" name="openGamerButton" width="100" height="100"/>
            <%}%> 
            </br>
        </td>
        </thead>                
    </table>
    </br>

    <%}%>
    <% if (request.getParameter("addGamerButton") != null) {
            gamerName = request.getParameter("addNewGamer");
            Class.forName("com.mysql.jdbc.Driver");
            MySqlGamer mySqlGamer = new MySqlGamer(dbmsConnString, userName, password);
            mySqlGamer.insertNewGamer(gamerName);
    %>
    <h1>Gamer <font color="green"><%=gamer.getGamerName()%></font> is added!</h1>
        <%}%>

    <% if (request.getParameter("addNewPictureButton") != null) {
            pictureLink = request.getParameter("addNewPicture");
            Class.forName("com.mysql.jdbc.Driver");
            gamerId = gamer.getGamerId();
            MySqlPicture mySqlPicture = new MySqlPicture(dbmsConnString, userName, password);
            mySqlPicture.insertNewPicture(gamerId, pictureLink);
        }%>
    <% if (request.getParameter("addNoteButton") != null) {
            note = request.getParameter("addNote").trim();
            Class.forName("com.mysql.jdbc.Driver");
            gamerId = gamer.getGamerId();
            MySqlGamer mySqlGamer = new MySqlGamer(dbmsConnString, userName, password);
            mySqlGamer.insertNewNote(gamerId, note);
        }%>

</form>   