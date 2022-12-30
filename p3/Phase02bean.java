package p3;

import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

public class Phase02bean {
    private ArrayList<String> errors;
    private ArrayList<String> fatalErrors;

    public Phase02bean() {

    }

    public ArrayList<String> getErrors() throws XPathExpressionException {
        return DataModel.errorsFile;
    }

    public ArrayList<String> setErrors() throws XPathExpressionException {
        return errors;
    }

    public ArrayList<String> getFatalErrors() throws XPathExpressionException {
        return DataModel.fatalerrorsFile;
    }

    public ArrayList<String> setFatalErrors() throws XPathExpressionException {
        return fatalErrors;
    }
}