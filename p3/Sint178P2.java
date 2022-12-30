package p3;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import javax.servlet.*;
//import javax.servlet.http.*;


import javax.xml.xpath.XPathExpressionException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

public class Sint178P2 extends HttpServlet {

    public void init() {
        try {
            DataModel.init();
    } catch (Exception e) {
        System.out.println(e.toString());
    }
}


   public void doGet(HttpServletRequest req, HttpServletResponse res)
   throws IOException, ServletException { 
   
        
    final String password  = "ruwu26ruwu";
    ServletContext context = getServletContext();
    //AuxBean ab;
    
  
   // FrontEnd fronty = new FrontEnd();

        ArrayList<String> countryList = new ArrayList<String>();
        ArrayList<Album> albums = new ArrayList<Album>();       
        ArrayList<Song> songs = new ArrayList<Song>();
        

        //temporales para que funcione pPhase02     
        //ArrayList<String> errorsFile = DataModel.errorsFile;
        //ArrayList<String> fatalerrorsFile = DataModel.fatalerrorsFile;

        boolean automode = false;


       
        if (req.getParameter("p")==null) { //this method detects if there is no password
                //fronty.noPassword(out);
                RequestDispatcher dispatcher = context.getRequestDispatcher("/noPasswd.jsp");
                

                // Redirige la solicitud al JSP
                dispatcher.forward(req, res);
            
        } else {

            
        if (req.getParameter("p").equals(password)!=true) { //this method detects if the password is wrong
            
            //fronty.wrongPassword(out);
            RequestDispatcher dispatcher = context.getRequestDispatcher("/wrongPasswd.jsp");
            
            dispatcher.forward(req, res);
                
        
            } else {

        String thePassword = req.getParameter("p");
            

        //PASSWORD CORRECT

        

        if (req.getParameter("pphase")==null) { //this method detects if there is no phase
            
            //fronty.pPhase01(out, thePassword);
            RequestDispatcher dispatcher = context.getRequestDispatcher("/phase01.jsp");
            req.setAttribute("passwd", thePassword);

            dispatcher.forward(req, res);
            
        }

        if ((req.getParameter("pphase")!=null)&&(req.getParameter("pphase").equals("01"))) { //this method detects if the phase is 01
            
            RequestDispatcher dispatcher = context.getRequestDispatcher("/phase01.jsp");
            req.setAttribute("passwd", thePassword);

            dispatcher.forward(req, res);
                
        }

        if ((req.getParameter("pphase")!=null)&&(req.getParameter("pphase").equals("02"))) { //this method detects if the phase is 02
           
            //fronty.pPhase02(errorsFile,fatalerrorsFile,thePassword);

            RequestDispatcher dispatcher = context.getRequestDispatcher("/phase02.jsp");
            req.setAttribute("passwd", thePassword);

            dispatcher.forward(req, res);

        
        }


        if ((req.getParameter("pphase")!=null)&&(req.getParameter("pphase").equals("11"))) {//this method detects if the phase is 11
            try {
                //countryList = DataModel.getQ1Countries();

                RequestDispatcher dispatcher = context.getRequestDispatcher("/phase11.jsp");
                req.setAttribute("passwd", thePassword);
                
                   // fronty.pPhase11(out, thePassword, countryList);

                dispatcher.forward(req, res);
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        if ((req.getParameter("pphase")!=null)&&(req.getParameter("pphase").equals("12"))) {//this method detects if the phase is 12
           
            if ((req.getParameter("pcountry")==null)){ //this detects if there is no pcountry
    
                RequestDispatcher dispatcher = context.getRequestDispatcher("/noParam.jsp");
                String pcountry = "pcountry";
                req.setAttribute("parameter", pcountry);
                req.setAttribute("passwd", thePassword);
               
                   // fronty.pPhase11(out, thePassword, countryList);

                dispatcher.forward(req, res);
                
            
        
    } else {

            try {
                String thisCountry = req.getParameter("pcountry");
                
                //albums = DataModel.getQ1Albums(thisCountry);
                RequestDispatcher dispatcher = context.getRequestDispatcher("/phase12.jsp");
                //req.setAttribute("country", thisCountry);
                req.setAttribute("passwd", thePassword);
                //req.setAttribute("albums", albums);
                
                dispatcher.forward(req, res);
          
                
                //fronty.pPhase12(out, thePassword, thisCountry, albums);
                
                } catch (Exception e) {
                 e.printStackTrace();
                }

        } }

        

        if ((req.getParameter("pphase")!=null)&&(req.getParameter("pphase").equals("13"))) {//this method detects if the phase is 13
            if ((req.getParameter("pcountry")==null)||(req.getParameter("paid")==null)){
                if ((req.getParameter("pcountry")==null)) {//this detects if there is no pcountry
                    
                    RequestDispatcher dispatcher = context.getRequestDispatcher("/noParam.jsp");
                    String pcountry = "pcountry";
                    req.setAttribute("parameter", pcountry);
                    req.setAttribute("passwd", thePassword);
                   
                       // fronty.pPhase11(out, thePassword, countryList);
    
                    dispatcher.forward(req, res);
                    
                } else {//this detects if there is no paid
                    
                    RequestDispatcher dispatcher = context.getRequestDispatcher("/noParam.jsp");
                    String paid = "pcountry";
                    req.setAttribute("parameter", paid);
                    req.setAttribute("passwd", thePassword);
               
                   // fronty.pPhase11(out, thePassword, countryList);

                    dispatcher.forward(req, res);
                    
                }
                
            } else {
        
            try { 
            
                //String thisCountry = req.getParameter("pcountry");
            //String thisAlbumID = req.getParameter("paid");
            //songs = DataModel.getQ1Songs(thisAlbumID);
            RequestDispatcher dispatcher = context.getRequestDispatcher("/phase13.jsp");
            //req.setAttribute("passwd", thePassword);

            dispatcher.forward(req, res);
            
         //   fronty.pPhase13(out, thePassword,thisCountry, thisAlbumID,songs);
            
        } catch (Exception e) {
            e.printStackTrace();
           }
        } }
        }

}
   }
        
    
}
   

