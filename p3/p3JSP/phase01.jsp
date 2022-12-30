<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <link href='p2/p2.css' rel='stylesheet' type='text/css' >
    <title>Practice 3</title>
</head>
<body>
    <h1>Music List Service</h1>
    <input type="hidden" name="p" value='<%= request.getAttribute("passwd") %>'>
    <input type="hidden" name="pphase" value="11">
    <p><a href='?p=<%= (String)request.getAttribute("passwd") %>&pphase=02'>Show error files</a></p>
    <p><a href='?p=<%= (String)request.getAttribute("passwd") %>&pphase=11'>Query 1: Pop songs of an album country</a></p>
    <h4>Rubén Castro González</h4>
</body>
</html>
