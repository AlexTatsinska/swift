<%-- 
    Document   : gamerBeta
    Created on : May 1, 2017, 5:30:11 PM
    Author     : AlexT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    static final String dbmsConnString = "jdbc:mysql://localhost:3306/poker_tool_database";
    static final String userName = "root";
    static final String password = "SwiftTraining1";
    String gamerName = null;
%>
<!DOCTYPE html>
<html xmlns:h="http://java.sun.com/jsf/html" xmlns:f="http://java.sun.com/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="gamersForm" action="gamerBeta.jsp">          
            <br><label>Gamer name:</label>&nbsp;<input type="text" name="surchGamer" value="" />&nbsp;<input type="submit" value="Surch gamer" name="surchGamerButon" /></br>       
            
			<% if (request.getParameter("surchGamerButon") != null) {
                    gamerName = request.getParameter("surchGamer");
                    session.setAttribute("surchGamerName", gamerName);%>            
            <%}%>
            <% if(session.getAttribute("surchGamerName")!= null){
             gamerName = session.getAttribute("surchGamerName").toString();%>
             <br></br>
             <br><table border="3">
                <thead>                    
                    <td><%=gamerName%> &nbsp;<input type="submit" value="Minimize" name="minimizeButton" />&nbsp;<input type="submit" value="Close" name="closeGamerButton" />
                        <br><img src="C:\Users\AlexT\Desktop\simple pics\download.png"/>&nbsp;<img src="C:\Users\AlexT\Desktop\simple pics\images (2).jpg"/>
                        </br>
                        
                        <br>Please note that window.open is JavaScript function but not JSP,</br> 
                        <br>JSP is for server side and JavaScript</br>   
                        <br>is for client side.</br><br>For popping up a new window in chrome,</br> 
                        <br>you have to specify the "specs" of the new window.</br><br> Here is an example.</br>
                        <br><textarea name="addNote" rows="4" cols="20"></textarea>
                        </br><br><input type="submit" value="Add note" name="addNoteButton" /></br>
                        <br><label>Add picture:</label>&nbsp;<input type="file" name="addNewPicture" value="" /></br>
                    </td>  
                </thead>                
             </table>
            </br>
            
            <%}%>

        </form>   
    </body>
</html>
