<%-- 
    Document   : newEducation
    Created on : Jan 7, 2017, 9:19:45 PM
    Author     : AlexT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавяне на образование</title>
    </head>
    <body>
        <form>
            Учебно заведение:<br></br> <input type="text" name="institutionName" value="" />
            <br></br>
            Начална дата:<br></br> <input type="text" name="enrollnentDate" value="" />
            <br></br>
            Крайна дата: <br></br><input type="text" name="graduationDate" value="" />
            <br></br>
            Среден успех: <br></br><input type="text" name="finalGrade" value="" />
        <br></br>
        Вид образование: <br></br>
        <select name="educationDegree">
            <option>None</option>
            <option>Primary</option>
            <option>Secondary</option>
            <option>Bechelor</option>
            <option>Master</option>
            <option>Doctorate</option>
        </select>
        </form>
        <br></br>
        <form action="userInfo.jsp"><input type="submit" value="Начало" />
        </form>
    </body>
</html>
