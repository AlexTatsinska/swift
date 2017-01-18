<%-- 
    Document   : userInfo
    Created on : Jan 7, 2017, 9:01:16 PM
    Author     : AlexT
--%>

<%@page import="java.time.LocalDate"%>
<%@page import="education.*"%>
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

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Начало</title>
    </head>
    
        <form action="userInfo.jsp">
            <input type="text" name="personId" value="" />
        </form>

        <%
            Class.forName("com.mysql.jdbc.Driver");
            if (request.getParameter("personId") != null && !request.getParameter("personId").equals("") && Integer.parseInt(request.getParameter("personId")) > 0) {
                int person_id = Integer.parseInt(request.getParameter("personId"));
                MySqlPersonStorage getPerson = new MySqlPersonStorage(dbmsConnString, userName, password);
                Citizen person = getPerson.getPresonById(person_id);
        %>
        <br></br>
        <table border="0">

            <tbody>
                <tr>
                    <td>Име</td>
                    <td><%=person.getFirstName()+" "+person.getMiddleName()+" "+person.getLastName()%></td>
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
                <br></br>  
                Образование:
                <table border="2">                   
                    <tbody>
                        <tr>            
                            <%for (Education education : person.getEducations()) {%>
                            <td>Вид образование: <%=education.getDegree().toString()%>
                                <br>Учебно заведение: <%=education.getInstitutionName()%></br>                               
                                Начална дата: <%=education.getEnrollmentDate()%>                              
                                <br>Дата на завършване: <%=education.getGraduationDate()%></br>                                
                                Статус: <%=education.isGraduated()%>   
                                <%if (education instanceof GradedEducation && education.getGraduationDate().isBefore(LocalDate.now())) {%>
                                <br>Среден успех: <%=((GradedEducation) education).getFinalGrade()%></br> 
                                <%}%>
                            </td>                  
                
                            <% } %>
                        </tr>
                    </tbody>
                </table>
                        <br></br>
                        <form name="addEducation" action="newEducation.jsp">
                            <input type="submit" value="Добави образование" name="addEducationButton" /> 
                        </form>
        <%} else if ((request.getParameter("personId") == null) || (request.getParameter("personId").equals(""))) {
        %>
        <h1>Проверка за социално подпомагане</h1>        
        <%
        } else if (!request.getParameter("personId").equals("") && Integer.parseInt(request.getParameter("personId")) <= 0) {
        %>
        <h1>Невалидно Person ID, опитайте отново</h1>
        <%
            }
        %>
    
