<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="p3.Phase13bean" %>
<%@ page import="p3.Song" %>

<%
    Phase13bean p13bean = new Phase13bean();

    String country = request.getParameter("pcountry");
    String albumID = request.getParameter("paid");
    String thepassword = request.getParameter("p");
    ArrayList<Song> songs = p13bean.getSongs(albumID);
%>

<!DOCTYPE html>
<html>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><head>
<link href='p2/p2.css' rel='stylesheet' type='text/css' >
<title>Music List Service</title>
</head>
   
<h2>Query 1 : Phase 2 (Country = <%= country %>, Album = <%= albumID %>) </h2>
<h3>This is the query result:</h3>

<%
    for (int i = 0; i < songs.size(); i++) {

%>
            <p> ID: <%= songs.get(i).getId() %> - Title: <%= songs.get(i).getTittle() %> - Duration: <%= songs.get(i).getDuration() %>
            - Composer: <%= songs.get(i).getComposer() %> - Language: <%= songs.get(i).getLang() %> - Genre: <%= songs.get(i).getGenreXML() %></p>
            
<%
     }
%>

<button type="button" name="home" onClick="location.href='?p=<%= thepassword %>&pphase=01'">HOME</button>
<button type="button" name="back" onClick="location.href='?p=<%= thepassword %>&pphase=12&pcountry=<%= country %>&paid=<%= albumID %>'">BACK</button> 
<h4>Rubén Castro González</h4>
