package p3;

import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import javafx.scene.chart.PieChart.Data;

public class Phase12bean {
    private ArrayList<Album> albums;

    public Phase12bean() {

    }
    public ArrayList<Album> getAlbums(String kountry) throws XPathExpressionException {
        return DataModel.getQ1Albums(kountry);
    }

    public ArrayList<Album> setAlbums() throws XPathExpressionException {
        return albums;
    }
}
