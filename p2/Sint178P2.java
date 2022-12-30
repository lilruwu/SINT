package p2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
  
    FrontEnd fronty = new FrontEnd();

    PrintWriter out = null;
    out=res.getWriter();

        ArrayList<String> countryList = new ArrayList<String>();
        ArrayList<Album> albums = new ArrayList<Album>();       
        ArrayList<Song> songs = new ArrayList<Song>();
        

        //temporales para que funcione pPhase02     
        ArrayList<String> errorsFile = DataModel.errorsFile;
        ArrayList<String> fatalerrorsFile = DataModel.fatalerrorsFile;
        ArrayList<String> errors = DataModel.errors;
        ArrayList<String> fatalerrors = DataModel.fatalErrors;

        boolean automode = false;


       
        if ((req.getParameter("auto")!=null)&&(req.getParameter("auto").equals("true"))){ //this method detects if automode is active

            automode = true;
    

        } else {
            automode = false;
        }

       
        if (req.getParameter("p")==null) { //this method detects if there is no password

            if (automode){
                fronty.autoNoPassWord(out);
            } else {
                fronty.noPassword(out);
            }
        } else {

            
        if (req.getParameter("p").equals(password)!=true) { //this method detects if the password is wrong
            if (automode){
                fronty.autoWrongPassword(out);
            }else {
            fronty.wrongPassword(out);
                }
        
            } else {

        String thePassword = req.getParameter("p");
            

        //PASSWORD CORRECT

        

        if (req.getParameter("pphase")==null) { //this method detects if there is no phase
            if (automode){
            fronty.autoPphase01(out, thePassword);
            } else {
            fronty.pPhase01(out, thePassword);
            }
        }

        if ((req.getParameter("pphase")!=null)&&(req.getParameter("pphase").equals("01"))) { //this method detects if the phase is 01
            if (automode){
                fronty.autoPphase01(out, thePassword);
                } else {
                fronty.pPhase01(out, thePassword);
                }
        }

        if ((req.getParameter("pphase")!=null)&&(req.getParameter("pphase").equals("02"))) { //this method detects if the phase is 02
            if (automode){
           fronty.autoPphase02(errorsFile,fatalerrorsFile,errors,fatalerrors,out,thePassword);
        } else {
            fronty.pPhase02(errorsFile,fatalerrorsFile,errors,fatalerrors,out,thePassword);
        }
        }


        if ((req.getParameter("pphase")!=null)&&(req.getParameter("pphase").equals("11"))) {//this method detects if the phase is 11
            try {
                countryList = DataModel.getQ1Countries();
                if (automode) {
                    fronty.autoPphase11(out, thePassword, countryList);
                } else{
                    fronty.pPhase11(out, thePassword, countryList);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        if ((req.getParameter("pphase")!=null)&&(req.getParameter("pphase").equals("12"))) {//this method detects if the phase is 12
           
            if ((req.getParameter("pcountry")==null)){ //this detects if there is no pcountry
    
                if (automode){
                    fronty.autoNoParam(out, "pcountry");
                } else {
                    fronty.NoParam(out, "pcountry");
                }
            
        
    } else {

            try {
                String thisCountry = req.getParameter("pcountry");
                albums = DataModel.getQ1Albums(thisCountry);
                if (automode) {
                    fronty.autoPphase12(out, thePassword, thisCountry, albums);
                } else {
                fronty.pPhase12(out, thePassword, thisCountry, albums);
                }
                } catch (Exception e) {
                 e.printStackTrace();
                }

        } }

        

        if ((req.getParameter("pphase")!=null)&&(req.getParameter("pphase").equals("13"))) {//this method detects if the phase is 13
            if ((req.getParameter("pcountry")==null)||(req.getParameter("paid")==null)){
                if ((req.getParameter("pcountry")==null)) {//this detects if there is no pcountry
                    if (automode){
                        fronty.autoNoParam(out, "pcountry");
                    } else {
                        fronty.NoParam(out, "pcountry");
                    }
                } else {//this detects if there is no paid
                    if (automode){
                        fronty.autoNoParam(out, "paid");
                    } else {
                        fronty.NoParam(out, "paid");
                    }
                }
                
            } else {
        
            try { String thisCountry = req.getParameter("pcountry");
            String thisAlbumID = req.getParameter("paid");
            songs = DataModel.getQ1Songs(thisAlbumID);
            if (automode){
                fronty.autoPphase13(out, thePassword, thisCountry, thisAlbumID, songs);
            } else {
            fronty.pPhase13(out, thePassword,thisCountry, thisAlbumID,songs);
            }
        } catch (Exception e) {
            e.printStackTrace();
           }
        } }
        }

}
   }
        
    
}
   

