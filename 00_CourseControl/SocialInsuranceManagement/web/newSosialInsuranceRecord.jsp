<%-- 
    Document   : newSosialInsuranceRecord
    Created on : Jan 7, 2017, 9:20:40 PM
    Author     : AlexT
--%>
<%@page import="interfaces.*"%>
<%@page import="insurance.SocialInsuranceRecord"%>
<%@page import="personaldetails.*"%>
<%@page import="address.*"%>
<%@page import="sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    static final String dbmsConnString = "jdbc:mysql://localhost:3306/citizen_registrations?useUnicode=true&characterEncoding=UTF-8";
    static final String userName = "root";
    static final String password = "SwiftTraining1";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавяне на социална осигуровка</title>
    </head>
    <body>
        <%
            int personId = Integer.parseInt(session.getAttribute("personId").toString());
        %>
        <%
            Class.forName("com.mysql.jdbc.Driver");
            PersonStorage getPerson = new MySqlPersonStorage(dbmsConnString, userName, password);
            Citizen person = getPerson.getPresonById(personId);
        %>
        <% if (request.getParameter("addSocialInsurance") != null &&request.getParameter("year")!=null&&request.getParameter("month")!=null&&request.getParameter("amount")!=null) {
                int year = Integer.parseInt(request.getParameter("year"));
                int month = Integer.parseInt(request.getParameter("month"));
                double amount = Double.parseDouble(request.getParameter("amount"));
                SocialInsuranceRecordStorage addSocialInsurance = new MySqlSocialInsuranceRecordStorage(dbmsConnString, userName, password);
                SocialInsuranceRecord insurance = new SocialInsuranceRecord(year, month, amount);
                addSocialInsurance.insertSocialInsuranceFromWebPage(insurance, personId);
                person.addSocialInsuranceRecord(insurance);
            }
        %>
        <a href="userInfo.jsp">Начало</a>  
        <br></br>
        <form name="addSocialInsurance" action="newSosialInsuranceRecord.jsp" method="POST">
            <label>Година:</label><input type="text" name="year" value="" /> <label>Месец:</label><input type="text" name="month" value="" /> <label>Внесена сума:</label><input type="text" name="amount" value="" />
            <input type="submit" value="Добави социална осигуровка" name="addSocialInsurance" />            
        </form>
        <br></br>
        <table border="0">

            <tbody>
                <tr>
                    <td>Име</td>
                    <td><%=person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName()%></td>
                </tr>                
                <tr>
                    <td>Височина</td>
                    <td><%=person.getHeight()%></td>
                </tr>
                <tr>
                    <td>Пол</td>
                    <td><%=person.getGender()%></td>
                </tr>
                <tr>
                    <td>Дата на раждане</td>
                    <td><%=person.getDateOfBirth()%></td>
                </tr>
                <tr>
                    <td>Адрес</td>
                    <td><%=person.getAddress().toString()%></td>
                </tr>
            </tbody>
        </table> 
        <br>
        <table border="2">
            <thead>
                <tr>
                    <th>година</th>
                    <th>месец</th>
                    <th>сума</th>
                </tr>
            </thead>
            <tbody>
                <%for (SocialInsuranceRecord socialInsurance : person.getSocialInsuranceRecords()) {%>
                <tr>                   
                    <td><%=socialInsurance.getYear()%> </td>
                    <td><%=socialInsurance.getMonth()%></td>
                    <td><%=socialInsurance.getAmount()%></td>              
                </tr>
                <%}%>
            </tbody>
        </table>
        </br>
    </body>
</html>
