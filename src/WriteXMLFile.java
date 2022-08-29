import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class WriteXMLFile {
    /*
     * This file represents how you can
     * generate XML with java */
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            // root elements
            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("company");
            document.appendChild(rootElement);

            // staff elements
            Element staff = document.createElement("Staff");
            rootElement.appendChild(staff);

            // set attribute to staff element
            Attr attr = document.createAttribute("id");
            attr.setValue("1");
            staff.setAttributeNode(attr);

            // shorten way
            // staff.setAttribute("id", "1");

            // firstname elements
            Element firstname = document.createElement("firstname");
            firstname.appendChild(document.createTextNode("Kashif"));
            staff.appendChild(firstname);

            // lastname elements
            Element lastname = document.createElement("lastname");
            lastname.appendChild(document.createTextNode("Kashif"));
            staff.appendChild(lastname);

            // nickname elements
            Element nickname = document.createElement("nickname");
            nickname.appendChild(document.createTextNode("kashi"));
            staff.appendChild(nickname);

            // salary elements
            Element salary = document.createElement("salary");
            salary.appendChild(document.createTextNode("500000"));
            staff.appendChild(salary);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("staff.xml"));

            // Output to console for testing
//            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
            System.out.println("File saved!");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
