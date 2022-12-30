package p2;

import java.io.PrintWriter;
import java.util.ArrayList;




public class FrontEnd {

//NO PASSWORDS
public void autoNoPassWord(PrintWriter out) { //automode no password
        out.println("<?xml version='1.0' encoding='utf-8' ?>");
        out.println("<wrongRequest>no passwd</wrongRequest>");
        
    }

public void noPassword(PrintWriter out) { //browser mode no password
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><head>");
    out.println("<link href='p2/p2.css' rel='stylesheet' type='text/css' >");
    out.println("<title>Error</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h5>There is no Password</h5>");
    out.println("<h4>Rubén Castro González</h4>");
    out.println("</body>");
    out.println("</html>");
    
}    

//WRONG PASSWORDS

public void autoWrongPassword(PrintWriter out) { //automode wrong password
    out.println("<?xml version='1.0' encoding='utf-8' ?>");
    out.println("<wrongRequest>bad passwd</wrongRequest>");
}
public void wrongPassword(PrintWriter out) { //browser mode wrong password
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><head>");
    out.println("<link href='p2.css' rel='stylesheet' type='text/css' >");
    out.println("<title>Error</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h5>Wrong Password</h5>");
    out.println("<h4>Rubén Castro González</h4>");
    out.println("</body>");
    out.println("</html>");
    
}    

//NO PARAM

public void autoNoParam(PrintWriter out, String a) { //automode no parameter
    out.println("<?xml version='1.0' encoding='utf-8' ?>");
    out.println("<wrongRequest>no param:"+a+"</wrongRequest>");
}

public void NoParam(PrintWriter out, String a){ //browser mode no parameter
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><head>");
    out.println("<link href='p2.css' rel='stylesheet' type='text/css' >");
    out.println("<title>No param</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h5>No param: "+a+"</h5>");
    out.println("<h4>Rubén Castro González</h4>");
    out.println("</body>");
    out.println("</html>");
    
}    



//PHASE 01
public void autoPphase01(PrintWriter out, String thepassword) { //automode phase 01
    out.println("<?xml version='1.0' encoding='utf-8' ?>");
    out.println("<service>");
    out.println("   <status>OK</status>");
    out.println("</service>");
}

public void pPhase01(PrintWriter out, String thepassword){ //browser mode phase 01
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><head>");
    out.println("<link href='p2.css' rel='stylesheet' type='text/css' >");
    out.println("<title>Practice 2</title>");
    out.println("</head>");

    out.println("<h1>Music List Service</h1>");
    out.println("<h1>Welcome to this service</h1>");
    out.println("<input type=\"hidden\" name=\"p\" value=\"" + thepassword + "\">");
    out.println("<input type=\"hidden\" name=\"pphase\" value=\"11\">");
    out.println("<p><a href='?p="+ thepassword + "&pphase=02'>Show error files</a><p>");
    out.println("<p><a href='?p="+ thepassword + "&pphase=" + 11 + "'>Query 1: Pop songs of an album country</a><p>");
    out.println("<h1>______________________________________________________________________________________________________________</h1>");
    out.println("<h4>Rubén Castro González</h4>");

    
}

//PHASE 02

public void autoPphase02(ArrayList<String> errorsFile,
        ArrayList<String> fatalerrorsFile, ArrayList<String> errors,
        ArrayList<String> fatalerrors, PrintWriter out, String thepassword) { //automode phase 02

            out.println("<wrongDocs>");
            out.println("<errors>");
            for (int a = 0; a < errorsFile.size(); a++) {
                String[] splited = errorsFile.get(a).split("/");
            out.println("<error><file>"+splited[5]+"</file></error>");
                
            
            }

            out.println("</errors>");
            out.println("<fatalerrors>");

            for (int a = 0; a < fatalerrorsFile.size(); a++) {
                String[] splited = fatalerrorsFile.get(a).split("/");
            out.println("<fatalerror><file>"+splited[5]+"</file></fatalerror>");
                
            
            }
            out.println("</fatalerrors>");
            out.println("</wrongDocs>");


        }
public void pPhase02(ArrayList<String> errorsFile,
        ArrayList<String> fatalerrorsFile, ArrayList<String> errors,
        ArrayList<String> fatalerrors, PrintWriter out, String thepassword) { //browser mode phase 02
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><head>");
            out.println("<link href='p2.css' rel='stylesheet' type='text/css' >");
            out.println("<title>Error Files</title>");
            out.println("</head>");
            out.println("<h1>Error Files</h1>");
            for (int a = 0; a < errorsFile.size(); a++) {
            out.println("<h3>"+errorsFile.get(a)+"</h3>");
           // out.println("<h3>La vida:"+errorsFile.size()+"</h3>");
            }
            
            out.println("<h1>Fatal Error Files</h1>");
            for (int a = 0; a < fatalerrorsFile.size(); a++) {
            out.println("<h3>"+fatalerrorsFile.get(a)+"</h3>");
            }
            out.println("<button type=\"button\" name=\"home\" onClick=\"location.href='?p="+thepassword+"&pphase=01'\">HOME</button>");
            out.println("<button type=\"button\" name=\"back\" onClick=\"location.href='?p="+thepassword+"&pphase=01'\">BACK</button>");
            out.println("<h1>______________________________________________________________________________________________________________</h1>");
            out.println("<h4>Rubén Castro González</h4>");

        }


//PHASE 11
public void autoPphase11(PrintWriter out, String thepassword, ArrayList<String> country) { //automode phase 11
    out.println("<?xml version='1.0' encoding='utf-8' ?>");
    out.println("<countries>");

    for (int i = 0; i < country.size(); i++) {
        out.println("<country>" + country.get(i) + "</country>");
    }

    out.println("</countries>");
}

public void pPhase11(PrintWriter out, String thepassword, ArrayList<String> country){ //browser mode phase 11
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><head>");
            out.println("<link href='p2.css' rel='stylesheet' type='text/css' >");
            out.println("<title>Music List Service</title>");
            out.println("</head>");
            out.println("<h2>Query 1 : Phase 1</h2>");
            out.println("<h3>This is the query result:</h3>");

            for (int i = 0; i < country.size(); i++) {
                
                out.println("<p><a href='?p="+ thepassword + "&pphase=" + 12 + "&pcountry="+country.get(i)+"'>"+country.get(i)+"</a><p>");
                
            }

            out.println("<button type=\"button\" name=\"home\" onClick=\"location.href='?p="+thepassword+"&pphase=01'\">HOME</button>");
            out.println("<button type=\"button\" name=\"back\" onClick=\"location.href='?p="+thepassword+"&pphase=01'\">BACK</button>");
            out.println("<h1>______________________________________________________________________________________________________________</h1>");
            out.println("<h4>Rubén Castro González</h4>");
                }

//PHASE 12

public void autoPphase12 (PrintWriter out, String thepassword, String thisCountry, ArrayList<Album> albums) { //automode phase 12
    out.println("<?xml version='1.0' encoding='utf-8' ?>");
    out.println("<albums>");

    for (int i = 0; i < albums.size(); i++) {
        
        out.println("<album year='" + albums.get(i).getYear() + "' performer='" + albums.get(i).getPerformer()
                + "' review='"+albums.get(i).getReview()+"'>" + albums.get(i).getName() + "</album>");
           
    }

    out.println("</albums>");
}

public void pPhase12(PrintWriter out, String thepassword, String thisCountry, ArrayList<Album> albums) { //browser mode phase 12
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><head>");
            out.println("<link href='p2.css' rel='stylesheet' type='text/css' >");
            out.println("<title>Music List Service</title>");
            out.println("</head>");
           
            out.println("<h2>Query 1 : Phase 2 (Country = "+thisCountry+")</h2>");
            out.println("<h3>This is the query result:</h3>");
        
            for (int i = 0; i < albums.size(); i++) {
                
                    out.println("<p><a href='?p="+ thepassword + "&pphase=" + 13 + "&pcountry="+albums.get(i).getCountry()+"&paid="+albums.get(i).getId()+"'>"
                    +"ID: "+albums.get(i).getId()+" - Name: "+albums.get(i).getName()+" - Country: "+albums.get(i).getCountry()+" - Performer: "+albums.get(i).getPerformer()
                    +" - ISBN: "+albums.get(i).getIsbn()+" - Company: "+albums.get(i).getCompany()+" - Year: "+albums.get(i).getYear()+" - Review: "+albums.get(i).getReview()+"</a><p>");
             

             }
            out.println("<button type=\"button\" name=\"home\" onClick=\"location.href='?p="+thepassword+"&pphase=01'\">HOME</button>");
            out.println("<button type=\"button\" name=\"back\" onClick=\"location.href='?p="+thepassword+"&pphase=11'\">BACK</button>");
            out.println("<h1>______________________________________________________________________________________________________________</h1>");
            out.println("<h4>Rubén Castro González</h4>");
            
        }

//PHASE 13
public void autoPphase13 (PrintWriter out, String thepassword, String country, String album, ArrayList<Song> songs) { //automode phase 13
    out.println("<?xml version='1.0' encoding='utf-8' ?>");
    out.println("<songs>");

    for (int i = 0; i < songs.size(); i++) {
        out.println("<song lang='" + songs.get(i).getLang() + "' genres='" + songs.get(i).getGenreXML() + "' composer='"+ songs.get(i).getComposer() + "'>"
        +songs.get(i).getTittle()+" </song>");
    }

    out.println("</songs>");

}

public void pPhase13(PrintWriter out, String thepassword, String country, String album, ArrayList<Song> songs) { //browser mode phase 13
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><head>");
    out.println("<link href='p2.css' rel='stylesheet' type='text/css' >");
    out.println("<title>Music List Service</title>");
    out.println("</head>");
   
    out.println("<h2>Query 1 : Phase 2 (Country = "+country+", Album = "+album+") </h2>");
    out.println("<h3>This is the query result:</h3>");
    for (int i = 0; i < songs.size(); i++) {
            out.println("<p>" +"ID: "+songs.get(i).getId()+" - Title: "+songs.get(i).getTittle()+" - Duration: "+songs.get(i).getDuration()
            +" - Composer: "+songs.get(i).getComposer() +" - Language: "+songs.get(i).getLang()+" - Genre: "
            +songs.get(i).getGenreXML()+"<p>");
            
     }

    out.println("<button type=\"button\" name=\"home\" onClick=\"location.href='?p="+thepassword+"&pphase=01'\">HOME</button>");
    out.println("<button type=\"button\" name=\"back\" onClick=\"location.href='?p="+thepassword+"&pphase=12&pcountry="+country+"&paid="+album+"'\">BACK</button>");
    out.println("<h1>______________________________________________________________________________________________________________</h1>");
    out.println("<h4>Rubén Castro González</h4>");
}

}

