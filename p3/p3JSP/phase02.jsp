<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="p3.Phase02bean" %>

<%
    Phase02bean p02bean = new Phase02bean();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <link href='p2/p2.css' rel='stylesheet' type='text/css' >
    <title>Error Files</title>
</head>
<body>
    <h1>Error Files</h1>
    <%
    ArrayList<String> errorsFile = p02bean.getErrors();
    for (int a = 0; a < errorsFile.size(); a++) {
    %>
        <h3><%= errorsFile.get(a) %></h3>
    <%
    }
    %>

    <h1>Fatal Error Files</h1>
    <%
    ArrayList<String> fatalerrorsFile =  p02bean.getFatalErrors();
    for (int a = 0; a < fatalerrorsFile.size(); a++) {
    %>
        <h3><%= fatalerrorsFile.get(a) %></h3>
    <%
    }
    %>

    <button type='button' name="home" onClick="location.href='?p=<%= (String)request.getAttribute("passwd") %>'">HOME</button>
    <button type="button" name="back" onClick="location.href='?p=<%= (String)request.getAttribute("passwd") %>&pphase=01'">BACK</button>
    <h4>Rubén Castro González</h4>
</body>
</html>
