import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExportarXML {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root element
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("company");
        doc.appendChild(rootElement);

        // staff element
        Element staff = doc.createElement("staff");
        rootElement.appendChild(staff);

        // set attribute to staff element
        staff.setAttribute("id", "1");

        // firstname element
        Element firstname = doc.createElement("firstname");
        firstname.appendChild(doc.createTextNode("John"));
        staff.appendChild(firstname);

        // lastname element
        Element lastname = doc.createElement("lastname");
        lastname.appendChild(doc.createTextNode("Doe"));
        staff.appendChild(lastname);

        // write the content into XML file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream(new File("staff.xml")));

        // Output to console for testing
        // StreamResult result = new StreamResult(System.out);

        transformer.transform(source, result);
    }
}
