package p3;

import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

public class Phase13bean {
    private ArrayList<Song> songs;

    public Phase13bean() {
        
    }
    public ArrayList<Song> getSongs(String paid) throws XPathExpressionException {
        return DataModel.getQ1Songs(paid);
    }

    public ArrayList<Song> setSongs() throws XPathExpressionException {
        return songs;
    }
    
}
