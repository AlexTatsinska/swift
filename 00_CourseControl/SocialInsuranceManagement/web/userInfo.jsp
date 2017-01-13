<%-- 
    Document   : userInfo
    Created on : Jan 7, 2017, 9:01:16 PM
    Author     : AlexT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="userInfo.jsp">
            <input type="text" name="personId" value="" />
        </form>
        <%
            if (request.getParameter("personId") != null && Integer.parseInt(request.getParameter("personId")) > 0) {
        %>
        <h1>ID = <%=request.getParameter("personId")%></h1>
        <%
        } else if (request.getParameter("personId") == null){
        %>
        <h1>Въведете Person ID</h1>
        <%
            } else {
%>
<h1>Невалидно Person ID, опитайте отново</h1>
<%
}
        %>
    </body>
</html>
