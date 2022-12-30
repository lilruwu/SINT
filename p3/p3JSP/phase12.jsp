<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="p3.Phase12bean" %>
<%@ page import="p3.Album" %>

<%
    Phase12bean p12bean = new Phase12bean();
    
    String thisCountry = request.getParameter("pcountry");
    String thepassword = request.getParameter("p");
    ArrayList<Album> albums = p12bean.getAlbums(thisCountry);
%>
<!DOCTYPE html>
<html>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><head>
<link href='p2/p2.css' rel='stylesheet' type='text/css' >
<title>Music List Service</title>
</head>
           
<h2>Query 1 : Phase 2 (Country = <%= thisCountry %>)</h2>
<h3>This is the query result:</h3>

<%    
    for (int i = 0; i < albums.size(); i++) {
        
          %>
            <p><a href='?p=<%= thepassword %>&pphase=13&pcountry=<%= albums.get(i).getCountry() %>&paid=<%= albums.get(i).getId() %>'>
            ID: <%= albums.get(i).getId() %> - Name: <%= albums.get(i).getName() %> - Country: <%= albums.get(i).getCountry() %> - Performer: <%= albums.get(i).getPerformer() %>
            - ISBN: <%= albums.get(i).getIsbn() %> - Company: <%= albums.get(i).getCompany() %> - Year: <%= albums.get(i).getYear() %> - Review: <%= albums.get(i).getReview() %></a></p>
    <%   
    }
%>

<button type="button" name="home" onClick="location.href='?p=<%= thepassword %>&pphase=01'">HOME</button>
<button type="button" name="back" onClick="location.href='?p=<%= thepassword %>&pphase=11'">BACK</button>
<h4>Rubén Castro González</h4>
