<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="p3.Phase11bean" %>

<%
    Phase11bean p11bean = new Phase11bean();
%>

<!DOCTYPE html>
<html>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<head>
<link href='p2/p2.css' rel='stylesheet' type='text/css' >
<title>Music List Service</title>
</head>
<body>
<h2>Query 1 : Phase 1</h2>
<h3>This is the query result:</h3>



<%
ArrayList<String> countries = p11bean.getCountries();
for (int i = 0; i < countries.size(); i++) {
    String country = countries.get(i);
%>
    <p><a href='?p=<%= (String)request.getAttribute("passwd") %>&pphase=12&pcountry=<%= country %>'><%= country %></a></p>
<%
}
%>

 <button type='button' name="home" onClick="location.href='?p=<%= (String)request.getAttribute("passwd") %>'">HOME</button>
    <button type="button" name="back" onClick="location.href='?p=<%= (String)request.getAttribute("passwd") %>&pphase=01'">BACK</button>
<h4>Rubén Castro González</h4>
</body>
</html>
