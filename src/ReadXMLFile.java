import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadXMLFile {
    public static void main(String[] args) {
        try {
            File fXmlFile = new File("employee.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fXmlFile);
            List<Employee> employeeList = new ArrayList<>();

            // Iterating through the nodes and extracting the data
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            for (int i = 0; i<nodeList.getLength(); i++){
                // We have encountered and <employee> tag.
                Node node = nodeList.item(i);
                if (node instanceof Element){
                    Employee emp = new Employee();
                    emp.id = node.getAttributes().getNamedItem("id").getNodeValue();
                    NodeList childNodes = node.getChildNodes();
                    for (int j=0; j<childNodes.getLength(); j++){
                        Node cNode = childNodes.item(j);
                        if (cNode instanceof Element){
                            String content = cNode.getLastChild().getTextContent().trim();
                            switch (cNode.getNodeName()){
                                case "firstName":
                                    emp.firstName = content;
                                    break;
                                case "lastName":
                                    emp.lastName = content;
                                    break;
                                case "location":
                                    emp.location = content;
                                    break;
                            }
                        }
                    }
                    employeeList.add(emp);
                }
            }
            // Printing the Employee list populated
            for (Employee emp : employeeList){
                System.out.println(emp);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Employee {
    String id;
    String firstName;
    String lastName;
    String location;

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + "(" + id + ") " + location;
    }
}
