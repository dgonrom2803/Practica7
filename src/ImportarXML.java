import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ImportarXML {

    public static void importaXML() throws ParserConfigurationException, TransformerException, IOException, SAXException {
        Scanner importa = new Scanner(System.in);
        System.out.println("Escriba la ruta de importación");
        String rutaImportacion = importa.nextLine();
        File inputFile = new File(rutaImportacion); //Ruta al archivo XML

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

//Ejemplo de obtener el nombre de una etiqueta
        System.out.println("Elemento raiz :" + doc.getDocumentElement().

                getNodeName());
        //Se buscan todos los nodos con la etiqueta "alumno"
        NodeList nList = doc.getElementsByTagName("alumno");

//Se itera por cada nodo para extraer los datos
        for (
                int i = 0; i < nList.getLength(); i++) {
            System.out.println("----------------------------");
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                //Obtener el contenido de una etiqueta
                System.out.println("Nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("NºIntervenciones : " + eElement.getElementsByTagName("intervenciones").item(0).getTextContent());
            }
        }


        }
    }
