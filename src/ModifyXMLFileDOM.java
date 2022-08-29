import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ModifyXMLFileDOM {
    public static void main(String[] args) {
        try {
            String filePath = "staff.xml";
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(filePath);

            // Get the root element
            Node company = document.getFirstChild();

            // Get the staff element, it may not working if tag has spaces, or
            // whatever weird characters in front...it's better to user
            // getElementByTagName() to get it directly
            // Node staff = company.getFirstChild();

            // Get the staff element by tag name directly
            Node staff = document.getElementsByTagName("Staff").item(0);

            // update staff attribute
            NamedNodeMap attr = staff.getAttributes();
            Node nodeAttr = attr.getNamedItem("id");
            nodeAttr.setTextContent("2");

            // append a new node to staff
            Element age = document.createElement("age");
            age.appendChild(document.createTextNode("28"));
            staff.appendChild(age);

            // loop the staff child node
            NodeList list = staff.getChildNodes();
            for (int i=0; i<list.getLength(); i++){
                Node node = list.item(i);
                // get the salary element, and update the value
                if ("salary".equals(node.getNodeName())){
                    node.setTextContent("2000000");
                }

                // remove firstname
                if ("firstname".equals(node.getNodeName())){
                    staff.removeChild(node);
                }
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

            System.out.println("Done");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe){
            tfe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        } catch (SAXException sae){
            sae.printStackTrace();
        }
    }
}
