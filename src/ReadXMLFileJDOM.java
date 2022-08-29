import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

// SAXBuilder is the class provided by jdom api
// which you have to manually add to your class path
// if you are using intellij idea
// Go to
// File -> Project Structure -> Modules
// Then on right side click on dependencies
// and click on add and click JARs and directories
// then select the directory where you have jdom api installed
public class ReadXMLFileJDOM {
    public static void main(String[] args) {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("company.xml");

        try {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("staff");
            for (int i=0; i<list.size(); i++){
                Element node = (Element) list.get(i);
                System.out.println("First Name : " + node.getChildText("firstname"));
                System.out.println("Last Name : " + node.getChildText("lastname"));
                System.out.println("Nick Name : " + node.getChildText("nickname"));
                System.out.println("Salary : " + node.getChildText("salary"));
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JDOMException e) {
            throw new RuntimeException(e);
        }
    }
}
