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
        <title>JSP Page</title>
    </head>
    <body>
        <form name="gamersForm" action="gamerBeta.jsp">          
            <br><label>Gamer name:</label>&nbsp;<input type="text" name="surchGamer" value="" />&nbsp;<input type="submit" value="Surch gamer" name="surchGamerButon" />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>New gamer name:</label>&nbsp;<input type="text" name="addNewGamer" value="" />&nbsp;<input type="submit" value="Add new gamer" name="addGamerButton" /></br> 


            <% if (request.getParameter("surchGamerButon") != null) {
                    gamerName = request.getParameter("surchGamer");
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
            <br></br>
            <br><table border="3">
                <thead>                    
                <td><%=gamer.getGamerName()%> &nbsp;<input type="submit" value="Minimize" name="minimizeButton" />&nbsp;<input type="submit" value="Close" name="closeGamerButton" />
                    <br><img src="C:\Users\AlexT\Desktop\simple pics\download.png"/>&nbsp;<img src="C:\Users\AlexT\Desktop\simple pics\images (2).jpg"/>
                    </br>

                    <br>Please note that window.open is JavaScript function but not JSP,</br> 
                    <br>JSP is for server side and JavaScript</br>   
                    <br>is for client side.</br><br>For popping up a new window in chrome,</br> 
                    <br>you have to specify the "specs" of the new window.</br><br> Here is an example.</br>
                    <br><textarea name="addNote" rows="4" cols="20"></textarea>
                    </br><br><input type="submit" value="Add note" name="addNoteButton" /></br>
                    <br><label>Add picture:</label>&nbsp;<input type="file" name="addNewPicture" value="" />&nbsp;<input type="submit" value="Add picture" name="addNewPictureButton" /></br>
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
                    note = request.getParameter("addNote");
                    Class.forName("com.mysql.jdbc.Driver");
                    gamerId = gamer.getGamerId();
                    MySqlGamer mySqlGamer = new MySqlGamer(dbmsConnString, userName, password);
                    mySqlGamer.insertNewNote(gamerId, note);
                }%>

        </form>   
    </body>
</html>
