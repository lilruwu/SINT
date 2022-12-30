package p3;

import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import javafx.scene.chart.PieChart.Data;

public class Phase11bean {
    private ArrayList<String> countries;

    public Phase11bean() {

    }

    public ArrayList<String> getCountries() throws XPathExpressionException {
        return DataModel.getQ1Countries();
    }

    public ArrayList<String> setCountries() throws XPathExpressionException {
        return countries;
    }
}
