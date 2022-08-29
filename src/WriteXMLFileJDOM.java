import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteXMLFileJDOM {
    public static void main(String[] args) {
try {
    Element company1 = new Element("company");
    Document document = new Document(company1);
//    document.setRootElement(company1);

    Element staff = new Element("staff");
    staff.setAttribute(new Attribute("id", "1"));
    staff.addContent(new Element("firstname").setText("Zahid"));
    staff.addContent(new Element("lastname").setText("Hussain"));
    staff.addContent(new Element("nickname").setText("Zahid"));
    staff.addContent(new Element("salary").setText("1999999"));

    document.getRootElement().addContent(staff);


    Element staff2 = new Element("staff");
    staff.setAttribute(new Attribute("id", "2"));
    staff.addContent(new Element("firstname").setText("Haider"));
    staff.addContent(new Element("lastname").setText("Ali"));
    staff.addContent(new Element("nickname").setText("Ali"));
    staff.addContent(new Element("salary").setText("18888888"));

document.getRootElement().addContent(staff2);

    // new XMLOutputter().output(doc, System.out);
    XMLOutputter xmlOutputter = new XMLOutputter();

    // display nice nice
    xmlOutputter.setFormat(Format.getPrettyFormat());
    xmlOutputter.output(document, new FileWriter("CompayNew.xml"));

    System.out.println("File Saved!");
} catch (IOException io){
    io.getMessage();
}
    }
}
