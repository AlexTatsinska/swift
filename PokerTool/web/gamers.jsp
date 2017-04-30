<%-- 
    Document   : user
    Created on : Apr 30, 2017, 12:59:10 PM
    Author     : AlexT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gamers</title>
    </head>
    <body>
        <form action="addGamer">
            <label>Gamer name </label><input type="text" name="addGamerName" value="" /><label>  </label><input type="submit" value="Add gamer" name="addNewGamerButton" />
            <br></br>
            <label>Add new pic: </label><input type="file" name="addPicturePath" value="" /><label>  </label>
        </form>        
    </body>
</html>
