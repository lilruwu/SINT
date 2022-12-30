package p3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedList;
import org.w3c.dom.Element;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import java.io.PrintWriter;
import java.net.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javafx.scene.NodeBuilder;
import javafx.scene.chart.PieChart.Data;

public class DataModel {

   

    private static Map<String, Document> correctXML = new TreeMap<String, Document>();
    public static ArrayList<String> errors = new ArrayList<String>();
    public static ArrayList<String> fatalErrors = new ArrayList<String>();
    public static ArrayList<String> errorsFile = new ArrayList<String>();
    public static ArrayList<String> fatalerrorsFile = new ArrayList<String>();


    static boolean wellformed = true;
    /*public static void main(String args[]) throws Exception {
        parseFunction();
        getQ1Countries();
    }*/

 public static void init() throws XPathExpressionException, ParserConfigurationException, Exception{
      parseFunction();
        
}

    
public static ArrayList<String> getQ1Countries () throws XPathExpressionException { //this is the method which gets the countries
            
    ArrayList<String> listCountryNames = new ArrayList<String>();          
    ArrayList<String> listCountryNamesAux = new ArrayList<String>();  
            
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            String xpathTarget = "/Music/Album/Country";
    for (String a : correctXML.keySet()) {
            NodeList nlCountryNames = (NodeList)xpath.evaluate(xpathTarget, correctXML.get(a), XPathConstants.NODESET); //here I create a node list of the countries of every album
            
            for (int co=0; co < nlCountryNames.getLength(); co++)  { //here I go through the nodeList taking the countries
                Node elemCountryName = nlCountryNames.item(co); 
                String countryName = ((Node) elemCountryName).getTextContent().trim();
                listCountryNamesAux.add(countryName);
                
            }
            
        }
        
        Collections.sort(listCountryNamesAux, Collections.reverseOrder()); //here I sort with the countries in reverse alphabetic order
        for (int i = 0; i < listCountryNamesAux.size(); i++) {
            if ((i>0)&&(listCountryNamesAux.get(i-1).equals(listCountryNamesAux.get(i)))) {
                continue;
            } else {
                listCountryNames.add(listCountryNamesAux.get(i));
            }
        }
        System.out.println(listCountryNames);
        return listCountryNames;
    }
    

public static ArrayList<Album> getQ1Albums(String country) throws XPathExpressionException {
    ArrayList<Album> listAlbums = new ArrayList<Album>(); 
    ArrayList<Album> listAlbumsAux = new ArrayList<Album>(); 
        
    XPathFactory xpathFactory = XPathFactory.newInstance();
    XPath xpath = xpathFactory.newXPath();
    
    String xpathTarget = "/Music/Album";
   
   
    
for (String a : correctXML.keySet()) {

    NodeList nlAlbumList = (NodeList)xpath.evaluate(xpathTarget, correctXML.get(a), XPathConstants.NODESET); //here i get a nodelist with all albums      
    String year = (String) xpath.evaluate("/Music/Year", correctXML.get(a), XPathConstants.STRING); //here i get the year of the xml

    for (int i=0; i< nlAlbumList.getLength(); i++)  { //here i go through all the list of albums

        String albumCountry = (String) xpath.evaluate("Country", nlAlbumList.item(i), XPathConstants.STRING);
        String id = (String) xpath.evaluate("@aid", nlAlbumList.item(i), XPathConstants.STRING);
        String name = (String) xpath.evaluate("Name", nlAlbumList.item(i), XPathConstants.STRING);
        String singer = (String) xpath.evaluate("Singer", nlAlbumList.item(i), XPathConstants.STRING);
        String group = (String) xpath.evaluate("Group", nlAlbumList.item(i), XPathConstants.STRING);
        String isbn = (String) xpath.evaluate("ISBN", nlAlbumList.item(i), XPathConstants.STRING);
        String company = (String) xpath.evaluate("Company", nlAlbumList.item(i), XPathConstants.STRING);
        String review = getReview(nlAlbumList.item(i)).trim();
   
        if (singer.equals("")) { //if there is no singer there will be a group so we add the group
            
            listAlbums.add(new Album(id,name,albumCountry,group,isbn,company,review,year));
        } else { //if there is singer we add the singer
        
        listAlbums.add(new Album(id,name,albumCountry,singer,isbn,company,review,year));
    }
}
}
for (int i = 0; i < listAlbums.size(); i++) {
if (country.equals(listAlbums.get(i).getCountry())==true) {
    listAlbumsAux.add(listAlbums.get(i));
}
}
listAlbumsAux.sort(new AlbumComparator()); //here i sort the albums with name and year using the compartator on the botom
return listAlbumsAux;
}
    

    public static ArrayList<Song> getQ1Songs(String albumID) throws XPathExpressionException {
        
        ArrayList<Song> listSongs = new ArrayList<Song>(); 
        
    
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        String xpathTarget = "//Album[@aid ='"+albumID+"']/Song"; //here I get an xpath with all the songs of the specific album that the user has selected
        

        for (String a : correctXML.keySet()) { 
        NodeList nlSongList = (NodeList) xpath.evaluate(xpathTarget, correctXML.get(a), XPathConstants.NODESET); //here is the node list of the songs
        
        
        for (int i=0; i< nlSongList.getLength(); i++)  {
            ArrayList<String> listGenres = new ArrayList<String>();
            String id = (String) xpath.evaluate("@sid", nlSongList.item(i), XPathConstants.STRING);
            String tittle = (String) xpath.evaluate("Title", nlSongList.item(i), XPathConstants.STRING);
            String duration = (String) xpath.evaluate("Duration", nlSongList.item(i), XPathConstants.STRING);
            NodeList nlGenres = (NodeList) xpath.evaluate("//Album[@aid ='"+albumID+"']/Song[@sid ='"+id+"']/Genre", correctXML.get(a), XPathConstants.NODESET);
            for (int c = 0; c < nlGenres.getLength(); c++) { //as it can be more than one genre this is a loop for checking all genres of an specific song of an album using the sid
                String genreSingle = (String) xpath.evaluate("text()", nlGenres.item(c), XPathConstants.STRING);
                listGenres.add(genreSingle);
            }
            
            String composer = (String) xpath.evaluate("Composer", nlSongList.item(i), XPathConstants.STRING);
            String lang = (String) xpath.evaluate("@lang", nlSongList.item(i), XPathConstants.STRING);

            if (listGenres.contains("Pop")){ //here I discard all songs which are not pop
            listSongs.add(new Song(id, tittle,  listGenres, duration, composer, lang));
            } 
            
        }
    }
    listSongs.sort(new SongComparator()); //here I sort the song list using the comparator at the botom
    return listSongs;
}

public static String getReview(Node node) { //this method is used for
    NodeList list = node.getChildNodes();   //taking every node of the nodelist of albums
    StringBuilder review = new StringBuilder();
    for (int i = 0; i < list.getLength(); ++i) { //searching throught the xml
        Node child = list.item(i);
        if (child.getNodeType() == Node.TEXT_NODE) //as the review is just text we dont need to apply xpath in this case
            review.append(child.getTextContent()); //and we can just take the text from the node
    }
    return review.toString();
}

public static void parseFunction() throws Exception{ //this method is in charge of parse all documents at the start of the program

    final String initialLink = "http://alberto.gil.webs.uvigo.es/SINT/22-23/muml2001.xml"; //here we declare the document from we will start to parse
    final String mainLink = "http://alberto.gil.webs.uvigo.es/SINT/22-23/";

    LinkedList<String> notParsed = new LinkedList<String>();
    LinkedList<String> Parsed = new LinkedList<String>();

    

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); //here we create the dom
    DocumentBuilder db = dbf.newDocumentBuilder();
    XPathFactory xpathFactory = XPathFactory.newInstance();
    XPath xpath = xpathFactory.newXPath();

    db.setErrorHandler(new XML_ErrorHandler()); //we assign the ErrorHandeler to the documentBuilder just for the xml that are wrong and will
                                                //throw an exception
    notParsed.add(initialLink);

    String documenty = null;

    while(notParsed.isEmpty()==false) {
            NodeList nlDocument = null;
            Document doc = null;
            String year = null;

            wellformed=false; //we put wellformed variable to false because we assume all xml are wellformed at first

            try {
                documenty = notParsed.pop(); //in this 3 lines
                URL url = new URL(documenty); //we parse the incoming xml
                doc = db.parse(url.openStream()); //every iteration is a new one

               Parsed.add(documenty); //we add the xml we have parsed into a Parsed list to count
               
                year = (String) xpath.evaluate("/Music/Year/text()", doc, XPathConstants.STRING); //here we get the year               
                nlDocument = (NodeList) xpath.evaluate("/Music/Album/Song/MuML", doc, XPathConstants.NODESET); //here we create a nodelist with the MuMls
               
                

                } catch (SAXParseException e) {
                    
                    if (!wellformed) { //if some of the xpath evaluations fail we will have an exeption that we catch here
                        fatalerrorsFile.add(documenty); //we add the url that causes the FatalError to the fatal errors file list
                        fatalErrors.add(e.toString());
                    }
                    Parsed.add(documenty); //we add it to the parsed list

                    continue; //we repeat the loop because there is nothing more to do with this file
                }

                if ((1980<=Integer.valueOf(year))&&(Integer.valueOf(year)<=2021)){ //we check if the file is between the range of year
                    correctXML.put(year, doc);
                }
                else {
                    errorsFile.add(documenty); //if it is not we add it to the list of errors
                    Parsed.add(documenty);
                    continue;
                }
             
            

            for (int i = 0; i < nlDocument.getLength();i++) { //this method is just for taking the all the mumls and concatenating with the link
                String newMuMLFound = null;
                String newMuML = null;
                try {
                newMuMLFound = (String) xpath.evaluate("text()", nlDocument.item(i) , XPathConstants.STRING);
                
                newMuML = mainLink + newMuMLFound;
                System.out.println(fatalerrorsFile.get(i));
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
    

public static class XML_ErrorHandler extends DefaultHandler { //this is the error handeler for the documentBuilder
      
        public XML_ErrorHandler() {
        }

    public void error(SAXParseException spe) throws SAXException{ //if there is an error we apply this method

        wellformed = true;
        errorsFile.add(spe.getSystemId()); //we put the wellformed true and throw the exception
        errors.add(spe.toString());
        throw(spe);
    }

    public void fatalerror(SAXParseException spe) throws SAXException{ //if there is a fatal error we apply this method

        wellformed = true;
        fatalerrorsFile.add(spe.getSystemId());//we put the wellformed true and throw the exception
        fatalErrors.add(spe.toString());
        throw(spe);
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


