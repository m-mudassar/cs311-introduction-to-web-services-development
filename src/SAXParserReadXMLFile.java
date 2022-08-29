import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*
* Topic 178 SAX-API demo */
public class SAXParserReadXMLFile {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            saxParser.parse("company.xml", handler);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler{
    boolean bfname = false;
    boolean blname = false;
    boolean bnname = false;
    boolean bsalray = false;

    public void startElement(String uri, String loacalName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element : " + qName);

        if (qName.equalsIgnoreCase("FIRSTNAME")){
            bfname = true;
        }
        if (qName.equalsIgnoreCase("LASTNAME")){
            blname = true;
        }
        if (qName.equalsIgnoreCase("NICKNAME")){
            bnname = true;
        }
        if (qName.equalsIgnoreCase("SALARY")){
            bsalray = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        System.out.println("End Element:" + qName);
    }

    public void characters(char ch[], int start, int length) throws SAXException{
        System.out.println(new String(ch, start, length));

        if (bfname){
            System.out.println("First Name : " + new String(ch, start, length));
            bfname = false;
        }
        if (blname){
            System.out.println("Last Name : " + new String(ch, start, length));
            blname = false;
        }
        if (bnname){
            System.out.println("Nick Name : " + new String(ch, start, length));
            bnname = false;
        }
        if (bsalray){
            System.out.println("Salary : " + new String(ch, start, length));
            bsalray = false;
        }
    }
}