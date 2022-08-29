import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CountXMLElement {
    public static void main(String[] args) {
        try {
            String filePath = "StaffData.xml";
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(filePath);

            NodeList list = document.getElementsByTagName("Staff");

            System.out.println("Total no of Staff elements : " + list.getLength());

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        } catch (SAXException sae){
            sae.printStackTrace();
        }
    }
}
