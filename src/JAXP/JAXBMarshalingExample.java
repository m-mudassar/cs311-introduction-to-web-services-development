package JAXP;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

// Not able to compile because of context error
public class JAXBMarshalingExample {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setId(100);
        customer.setName("Ahmad");
        customer.setAge(35);
        try {
            File file = new File("newXMLData.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customer, System.out);
        } catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
