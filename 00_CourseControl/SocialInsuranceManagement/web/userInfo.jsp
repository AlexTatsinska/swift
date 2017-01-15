<%-- 
    Document   : userInfo
    Created on : Jan 7, 2017, 9:01:16 PM
    Author     : AlexT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    static final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/citizen_registrations?useUnicode=true&characterEncoding=UTF-8";
    static final String DBMS_USERNAME = "root";
    static final String DBMS_PASSWORD = "SwiftTraining1";
    //int daysToShow = 5;
%>

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
            if (!request.getParameter("personId").equals("") && Integer.parseInt(request.getParameter("personId")) > 0) {
        %>
        <table border="0">

            <tbody>
                <tr>
                    <td>Име</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Презиме</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Фамилия</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Височиниа</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Пол</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Дата на раждане</td>
                    <td></td>
                </tr>
            </tbody>
        </table>

        <%} else if (request.getParameter("personId").equals("")) {
        %>
        <h1>Проверка за социално подпомагане</h1>        
        <%
        } else if (!request.getParameter("personId").equals("") && Integer.parseInt(request.getParameter("personId")) <= 0) {
        %>
        <h1>Невалидно Person ID, опитайте отново</h1>
        <%
            }
        %>
    </body>
</html>
