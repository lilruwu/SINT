package p4;

import org.w3c.dom.Element;



import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import java.io.PrintWriter;
import java.net.*;
import java.io.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

//import javafx.scene.NodeBuilder;
//import javafx.scene.chart.PieChart.Data;

public class DataModel {

   


    public static ArrayList<String> countryList = new ArrayList<>();
    public static ArrayList<String> years = new ArrayList<>();
    public static ArrayList<Album> albumList = new ArrayList<>();
    public static ArrayList<Album> albumListAux = new ArrayList<>();
    public static ArrayList<Song> songList = new ArrayList<>();
    public static ArrayList<String> errors = new ArrayList<String>();
    public static ArrayList<String> fatalErrors = new ArrayList<String>();
    public static ArrayList<String> errorsFile = new ArrayList<String>();
    public static ArrayList<String> fatalerrorsFile = new ArrayList<String>();
    public static ArrayList<String> muMLGlobal = new ArrayList<String>();
    public static String yearGlobal = null;
    public static boolean truerGlob = true;
  


    static boolean wellformed = true;
    /*public static void main(String args[]) throws Exception {
        parseFunction();
        getQ1Countries();
    }*/

  /*  public static void main(String args[]) throws XPathExpressionException, ParserConfigurationException, Exception{
        parseFunction();
        //System.out.println(albumList.get(8).toString());
       // System.out.println(getQ1Countries());
        //System.out.println(yearGlobal);
        //System.out.println(fatalerrorsFile);
        //System.out.println(errorsFile);
        //getQ1Albums("UK");
        //getQ1Songs("011btr");
        //getQ1Albums("USA");
        System.out.println(albumList);
        //System.out.println(albumList.get(0).toString());
        getQ1Albums("USA");
        //System.out.println(songList.get(1).toString());
        
    }
*/
 public static void init() throws XPathExpressionException, ParserConfigurationException, Exception{
      parseFunction();
        
}

    
public static ArrayList<String> getQ1Countries () throws XPathExpressionException { //this is the method which gets the countries
            
    ArrayList<String> listCountryNames = new ArrayList<String>();          
    ArrayList<String> listCountryNamesAux = new ArrayList<String>();  
            
          
            for (int co=0; co < countryList.size(); co++)  { //here I go through the nodeList taking the countries
                
                String countryName = countryList.get(co).trim();
                listCountryNamesAux.add(countryName);
                
            }
            
        
        
        Collections.sort(listCountryNamesAux, Collections.reverseOrder()); //here I sort with the countries in reverse alphabetic order
        for (int i = 0; i < listCountryNamesAux.size(); i++) {
            if ((i>0)&&(listCountryNamesAux.get(i-1).equals(listCountryNamesAux.get(i)))) {
                continue;
            } else {
                listCountryNames.add(listCountryNamesAux.get(i));
            }
        }
       // System.out.println(listCountryNames);
        return listCountryNames;
    }

    

public static ArrayList<Album> getQ1Albums(String country) throws XPathExpressionException {

    ArrayList<Album> listAlbums = new ArrayList<Album>(); 
       
   
 //here i sort the albums with name and year using the compartator on the botom
//System.out.println(albumList.get(0).getYear());
for (int i = 0; i < albumList.size(); i++) {
    if (country.equals(albumList.get(i).getCountry())==true) {
        listAlbums.add(albumList.get(i));
   }
}
listAlbums.sort(new AlbumComparator());
return listAlbums;
}
    

public static ArrayList<Song> getQ1Songs(String albumID) throws XPathExpressionException {
        
        ArrayList<Song> listSongs = new ArrayList<Song>(); 
        //Set<Song> listSongsAux = new HashSet<>(listSongs);
    
       
        for (int i=0; i< songList.size(); i++)  {
        
        
        if (songList.get(i).getAlbumID().equals(albumID)){
         if (songList.get(i).getGenre().contains("Pop")){ //here I discard all songs which are not pop
            listSongs.add(songList.get(i));
            } 
        }
       

           
            
        }

        //BUG SOLUTION FOR FIRST SONG THAT IS DUPLICATED WITH NO REASON
        if (listSongs.get(0).getTittle().equals(listSongs.get(1).getTittle())) {
            
            listSongs.remove(0);
        }
    
    listSongs.sort(new SongComparator()); //here I sort the song list using the comparator at the botom
    //System.out.println(listSongsAux.toString());
    //Set<Song> listSongsAux = new HashSet<>(listSongs);
    //listSongs = new ArrayList<>(listSongsAux);
    return listSongs;
}

public static void parseFunction() throws Exception{ //this method is in charge of parse all documents at the start of the program

    final String initialLink = "http://alberto.gil.webs.uvigo.es/SINT/22-23/muml2001.xml"; //here we declare the document from we will start to parse
    final String mainLink = "http://alberto.gil.webs.uvigo.es/SINT/22-23/";

    LinkedList<String> notParsed = new LinkedList<String>();
    LinkedList<String> Parsed = new LinkedList<String>();

    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = saxParserFactory.newSAXParser();
    DefaultHandler handler = new DefaultHandler() {
    private StringBuilder buffer = new StringBuilder();
    private String year = new String();
    private int x = 0;
    private Album album;
    private Song song;
    private String aid = new String();
    private boolean truer = true;



    public void characters(char[] ch, int start, int length) {
        switch(x) {

            case 0: //review
            //buffer.append(ch,start,length);
            //System.out.println(new String(ch,);
            String str = new String(ch,start,length);
            if (!str.trim().isEmpty()) {
            album.setReview(str.trim()); 
            //System.out.println(str.trim());
            }
 
            break;

            case 1: //todos los otros casos
            buffer.append(ch,start,length);
            break;
        }
        

    }

    public void endElement(String uri, String localName, String qName) {

        switch(qName) {
        
            case "Music":
            break;
    
            case "Year":
            year = buffer.toString();
            if ((1980>Integer.valueOf(year))||(Integer.valueOf(year)>2021)) {
                truer = false;
                truerGlob = false;
            } else {
            yearGlobal = buffer.toString();
            x=0;
            }
            break;
            //ALBUM ELEMNTS
            case "Album":
            if (truer==true) {
            	 album.setYear(yearGlobal);
                albumList.add(album); 
            }        
                break;
            case "Name":
            if (truer==true) {
                album.setName(buffer.toString());
                x=0;
            }
                break;
            case "Country":
            if (truer==true) {
               countryList.add(buffer.toString());
                album.setCountry(buffer.toString());
               x=0;
            }
                break;
            case "Singer":
            if (truer==true) {
                album.setPerformer(buffer.toString());
                x=0;
            }
                break;
            case "Group":
            if (truer==true) {
                album.setPerformer(buffer.toString());
               x=0;
            }
                break;
            case "ISBN":
            if (truer==true) {
                album.setIsbn(buffer.toString());
                x=0;
            }
                break;
            case "Company":
            if (truer==true) {
                album.setCompany(buffer.toString());
                x=0;
            }
                break;

            //SONG ELEMNTS
            case "Song":
            if (truer==true) {
            	song.setAlbumID(aid);
                songList.add(song);  
               x=0;
            }
                break;
            case "Title":
            if (truer==true) {
                song.setTittle(buffer.toString());
            }
                break;
            case "Duration":
            if (truer==true) {
                song.setDuration(buffer.toString());
            }
                break;
            case "Genre":
            if (truer==true) {
                song.setGenre(buffer.toString());
            }
                break;
            case "Composer":
            if (truer==true) {
                song.setComposer(buffer.toString());
            }
                break;
            case "MuML":
            if (truer==true) {
                muMLGlobal.add(buffer.toString());
            }
                break;
        }

    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch(qName) {
        
        case "Music":
        break;

        case "Year":
            truer = true;
            truerGlob = true;
            x=1;
            buffer.delete(0, buffer.length());
            break;

        case "Album":
            album = new Album();
            album.setId(attributes.getValue("aid"));
            aid = attributes.getValue("aid");
            //album.setFormat(attributes.getValue("format"));
            break;
        case "Name":
            x=1;
            buffer.delete(0, buffer.length());
            break;
        case "Country":
            x=1;
            buffer.delete(0, buffer.length());
            break;
        case "Singer":
            x=1;
            buffer.delete(0, buffer.length());
            break;
        case "Group":
            x=1;
            buffer.delete(0, buffer.length());
            break;
        case "ISBN":
            x=1;
            buffer.delete(0, buffer.length());
            break;
        case "Company":
            x=1;
            buffer.delete(0, buffer.length());
            break;
        case "Song":
            song = new Song();
            song.setId(attributes.getValue("sid"));
            song.setLang(attributes.getValue("lang"));
            break;
        case "Title":
             x=1;
             buffer.delete(0, buffer.length());
            break;
        case "Duration":
            x=1; 
            buffer.delete(0, buffer.length());
            break;
        case "Genre":
            x=1;
            buffer.delete(0, buffer.length());
            break;
        case "Composer":
            x=1;
            buffer.delete(0, buffer.length());
            break;
        case "MuML":
             x=1;
             buffer.delete(0, buffer.length());
            break;
    }

    }
    
    //GETTERS
      

      
     
      
    
    };
    

    /*DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); //here we create the dom
    /DocumentBuilder db = dbf.newDocumentBuilder();
    XPathFactory xpathFactory = XPathFactory.newInstance();
    XPath xpath = xpathFactory.newXPath();

    db.setErrorHandler(new XML_ErrorHandler()); //we assign the ErrorHandeler to the documentBuilder just for the xml that are wrong and will
                                                //throw an exception
                                                */
    notParsed.add(initialLink);

    String documenty = null;

    while(notParsed.isEmpty()==false) {
            //NodeList nlDocument = null;
            //Document doc = null;
            String year = null;

            wellformed=false; //we put wellformed variable to false because we assume all xml are wellformed at first

            try {
                documenty = notParsed.pop(); //in this 3 lines
                //URL url = new URL(documenty); //we parse the incoming xml
                //InputStream url = new ByteArrayInputStream(documenty.getBytes());
                
                saxParser.parse(documenty, handler);

               
                //doc = db.parse(url.openStream()); //every iteration is a new one

               Parsed.add(documenty); //we add the xml we have parsed into a Parsed list to count
               
               year = yearGlobal;
               years.add(year);
               // year = (String) xpath.evaluate("/Music/Year/text()", doc, XPathConstants.STRING); //here we get the year               
                //nlDocument = (NodeList) xpath.evaluate("/Music/Album/Song/MuML", doc, XPathConstants.NODESET); //here we create a nodelist with the MuMls
               
                

                } catch (SAXParseException e) {
                    
                    if (!wellformed) { //if some of the xpath evaluations fail we will have an exeption that we catch here
                        fatalerrorsFile.add(documenty); //we add the url that causes the FatalError to the fatal errors file list
                        fatalErrors.add(e.toString());
                    }
                    Parsed.add(documenty); //we add it to the parsed list

                    continue; //we repeat the loop because there is nothing more to do with this file
                

                }
                //System.out.println(year);
                

                if ((truerGlob==true)){ //we check if the file is between the range of year
                    
                    
                    
                    
                }
                else {
                    errorsFile.add(documenty); //if it is not we add it to the list of errors
                    Parsed.add(documenty);
                    continue;
                }
             
            

            for (int i = 0; i < muMLGlobal.size(); i++) { //this method is just for taking the all the mumls and concatenating with the link
                String newMuMLFound = null;
                String newMuML = null;
                try {
                
                newMuML = mainLink + muMLGlobal.get(i);
                //System.out.println(fatalerrorsFile.get(i));
                //System.out.println(newMuML);
            } catch (Exception e) {
                e.printStackTrace();
                }
                if ((Parsed.contains(newMuML)==false)&&(notParsed.contains(newMuML)==false)) { //if the muml is not parsed and it is not in the not parsed list we add it to the non parsed list
                    notParsed.add(newMuML);
                }
            }
    }
    }


    
static class AlbumComparator implements Comparator<Album>{ //this is the comparator for the albums


      public int compare(Album o1, Album o2){
      if(Integer.valueOf(o1.year)<Integer.valueOf(o2.year)){ //if one year is higher
          return -1;
      }
      if (Integer.valueOf(o1.getYear())>Integer.valueOf(o2.getYear())) { //if one year is lower
      return 1;

     } else{
          return o1.name.compareTo(o2.name); //if the year are equals it will compare the names of the albums
      }
    }


}

static class SongComparator implements Comparator<Song>{ //this is the comparator for the songs


    public int compare(Song o1, Song o2){
    if((o1.getGenre().size())<(o2.getGenre().size())){ //if one year is higher
        return -1;
    }
    if ((o1.getGenre().size())>(o2.getGenre().size())) { //if one year is lower
    return 1;

   } else{
        return o1.tittle.compareTo(o2.tittle); //if the year are equals it will compare the names of the albums
    }
  }



}

}




